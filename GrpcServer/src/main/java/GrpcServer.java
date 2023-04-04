import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Record{
    String name;
    int age;
    float height;
    boolean male;
    String photoPath;

    public Record(String name, int age, float height, boolean male, String photoPath) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.male = male;
        this.photoPath = photoPath;
    }
}

public class GrpcServer {
    static HashMap<String, Record> records = new HashMap<>();
    static String directoryName = "GrpcServer/src/photos/";
    public static void main(String[] args) {
        int port = 50001;
        System.out.println("Starting gRPC server...");
        Server server  = ServerBuilder.forPort(port).addService(new MyServiceImpl()).build();
        Record record1 = new Record("Maciej", 21, 180.5f, true, "KrasnoludInzynier.jpg");
        Record record2 = new Record("Jakub", 25, 185.31f, true, "KrasnoludSkryba.jpg");
        Record record3 = new Record("Julia", 27, 179.0f, false, "KrasnoludZwiadowca.jpg");
        records.put("1", record1);
        records.put("2", record2);
        records.put("3", record3);

        try{
            server.start();
            System.out.println("...Server started");
            server.awaitTermination();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    static class MyServiceImpl extends TestServiceGrpc.TestServiceImplBase {

        public static String imagesFolder = "GrpcServer/files/";
        public void saveRecord(TheRecord request, StreamObserver<TheRecordResponse> responseObserver){
            Record record = new Record(request.getName(), request.getAge(), request.getHeight(), request.getMale(),
                    request.getPhotoPath());
            records.put(request.getId(), record);

            StringBuilder responseMessage = new StringBuilder();
            if(records.containsKey(request.getId()))  responseMessage.append("Updated ");
            else responseMessage.append("Created ");

            responseMessage.append("following record:")
                    .append("\nId: ").append(request.getId())
                    .append("\nName: ").append(record.name)
                    .append("\nAge: ").append(record.age)
                    .append("\nHeight: ").append(record.height)
                    .append("\nMale: ").append(record.male)
                    .append("\nPhotoPath: ").append(record.photoPath);

            var builder = TheRecordResponse.newBuilder()
                    .setMessage(responseMessage.toString());

            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }

        public void readRecord(TheRecordRequest request, StreamObserver<TheRecord> responseObserver){

            Record record = records.get(request.getRecordId());

            var builder = TheRecord.newBuilder();
            if(record != null) {
                builder.setAge(record.age).setHeight(record.height).setId(request.getRecordId()).
                        setMale(record.male).setPhotoPath(record.photoPath).setName(record.name);
            }
            else
            {
                builder.setAge(0).setHeight(0).setId("None").
                        setMale(false).setPhotoPath("None").setName("None");
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();

        }

        public void readAllRecordsIds(AllRecordsRequest request, StreamObserver<TheRecordResponse> responseObserver){
            var builder = TheRecordResponse.newBuilder().setMessage(records.keySet().toString());
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }

        public void deleteRecord(TheRecordRequest request, StreamObserver<TheRecordResponse> response){
            StringBuilder message = new StringBuilder();
            if(records.remove(request.getRecordId()) != null){
                message.append("Deleted record with id = ");
            }
            else {
                message.append("Could not find record with id of ");
            }
            message.append(request.getRecordId());
            var builder = TheRecordResponse.newBuilder().setMessage(message.toString());
            response.onNext(builder.build());
            response.onCompleted();
        }

        public void getPhoto(ThePhotoRequest request, StreamObserver<ThePhotoResponse> response){
            int bufferSize = 10000;
            String fileName = directoryName + request.getFilename();
            File file = new File(fileName);

            if(file.exists() && !file.isDirectory()){
                try{
                    FileInputStream fis = new FileInputStream(file);

                    byte[] buffer = new byte[bufferSize];
                    int sentBytes = 0;

                    while ((sentBytes = fis.read(buffer)) > 0) {
                        response.onNext(ThePhotoResponse.newBuilder()
                                .setChunk(ByteString.copyFrom(buffer))
                                .setNumOfBytes(sentBytes)
                                .build());
                    }
                    response.onCompleted();
                }
                catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                response.onError(new Exception("File not found"));
            }


        }
    }
}
