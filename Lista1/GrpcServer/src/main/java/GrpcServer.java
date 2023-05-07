import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrpcServer {
    public static void main(String[] args) {
        int port = 50001;
        System.out.println("Starting gRPC server...");
        Server server  = ServerBuilder.forPort(port).addService(new MyServiceImpl()).build();

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
        ArrayList<TheRecord> records = new ArrayList<>();

//        public void unaryProcedure(TheRequest req, StreamObserver<TheResponse> responseObserver) {
//            String msg;
//            System.out.println("...called UnaryProcedure - start");
//            if(req.getAge() > 18) msg = "Mr/Ms" + req.getName();
//            else msg = "Boy/Girl";
//            TheResponse response = TheResponse.newBuilder().setMessage("Hello " + msg).build();
//
//            try{
//                Thread.sleep(2000);
//            }
//            catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//            System.out.println("...called UnaryProcedure - end");
//        }
//
//        public void streamProcedure(TheRequest req, StreamObserver<TheResponse> responseObserver){
//            final int NUM_OF_CHUNKS = 10;
//            for(int i = 0; i < NUM_OF_CHUNKS; i++) {
//                TheResponse response = TheResponse.newBuilder().setMessage("Stream chunk " + (i+1)).build();
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                responseObserver.onNext(response);
//            }
//            responseObserver.onCompleted();
//        }
//
//        public StreamObserver<TheRequest> streamToSrv(StreamObserver<TheResponse> responseObserver){
//            HashMap<String, Integer> testMap = new HashMap<>();
//            StreamObserver<TheRequest> srvObserver = new StreamObserver<TheRequest>() {
//                @Override
//                public void onNext(TheRequest theRequest) {
//                    System.out.println("Received -" + theRequest.getName() + "- " + theRequest.getAge());
//                    testMap.put(theRequest.getName(), theRequest.getAge());
//                }
//
//                @Override
//                public void onError(Throwable throwable) {
//                    throwable.printStackTrace();
//                }
//
//                @Override
//                public void onCompleted() {
//                    StringBuilder myResp = new StringBuilder();
//                    for(Map.Entry<String, Integer> entry: testMap.entrySet()){
//                        myResp.append(entry.getKey()).append("---").append(entry.getValue()).append("\n");
//                    }
//                    TheResponse response = TheResponse.newBuilder().setMessage(myResp.toString()).build();
//                    responseObserver.onNext(response);
//                    responseObserver.onCompleted();
//                }
//            };
//            return srvObserver;
//        }

        public StreamObserver<TheRecord> sendRecords(StreamObserver<TheResponse> responseObserver){

            StreamObserver<TheRecord> srvObserver = new StreamObserver<>() {
                @Override
                public void onNext(TheRecord record) {
                    System.out.println("Received -" + record.getName() + " " + record.getAge() + " " +
                            record.getHeight() + " " + record.getMale());
                    records.add(record);
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public void onCompleted() {
//                    StringBuilder myResp = new StringBuilder();
//                    for(TheRecord record: records){
//                        myResp.append("Name").append(record.getName())
//                                .append("\nHeight ").append(record.getHeight())
//                                .append("\nAge ").append(record.getAge())
//                                .append("Is male? ").append(record.getMale())
//                    }
//                    TheResponse response = TheResponse.newBuilder().setMessage(myResp.toString()).build();
//                    responseObserver.onNext(response);
//                    responseObserver.onCompleted();
                    responseObserver.onNext(TheResponse.newBuilder().setMessage("Completed adding records").build());
                    responseObserver.onCompleted();
                }
            };
            return srvObserver;
        }
        public void getOneRecord(TheRecordRequest request, StreamObserver<TheRecord> streamObserver){
            if(request.getRecordPosition() >= 0 && request.getRecordPosition() < records.size()){
                streamObserver.onNext(records.get(request.getRecordPosition()));
            }
        }
    }
}
