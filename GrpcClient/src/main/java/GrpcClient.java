import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class GrpcClient {
    public static void main(String[] args) {
        String address = "localhost"; //here we use service on the same host
        int port = 50001;
        System.out.println("Running gRPC client...");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();

        //Blocking stub
        TestServiceGrpc.TestServiceBlockingStub bStub;
        TestServiceGrpc.TestServiceStub nStub;
        bStub = TestServiceGrpc.newBlockingStub(channel);
        nStub = TestServiceGrpc.newStub(channel);
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while(option != 0) {

            printMenu();
            option = scanner.nextInt();
            optionChosen(option, scanner, bStub, nStub);
        }
        channel.shutdown();
    }

    private static class PhotoObs implements StreamObserver<ThePhotoResponse> {

        static String downloadFolder = "GrpcClient/src/downloadFolder/";
        FileOutputStream fos;
        File fileToSave;
        public PhotoObs(String filename){
            try{
                fileToSave = new File(downloadFolder + filename);
                fileToSave.createNewFile();
                fos = new FileOutputStream(fileToSave);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                System.out.println();
                System.out.println(fileToSave.toString());
                throw new RuntimeException(e);
            }
        }
        @Override
        public void onNext(ThePhotoResponse thePhotoResponse) {
            try{
                fos.write(thePhotoResponse.getChunk().toByteArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void onError(Throwable throwable) {
            fileToSave.delete();
            System.out.println("Could not find image with path: " + fileToSave.toString());
        }

        @Override
        public void onCompleted() {
            try{
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finished downloading image!");
        }
    }

    private static void printMenu(){
        System.out.println("--------MENU--------");
        System.out.println("1.Send record");
        System.out.println("2.Read record");
        System.out.println("3.Read all records ids");
        System.out.println("4.Delete record");
        System.out.println("5.Download photo");
        System.out.println("0.Exit");
    }

    private static void optionChosen(int option, Scanner input, TestServiceGrpc.TestServiceBlockingStub bStub,
                                     TestServiceGrpc.TestServiceStub nStub){
        switch(option){
            case 1:
                sendRecord(input, bStub);
                break;
            case 2:
                readRecord(input, bStub);
                break;
            case 3:
                readAllRecordsIds(bStub);
            case 4:
                deleteRecord(input, bStub);
                break;
            case 5:
                getPhoto(input, nStub);
                break;
            default:
                break;
        }
    }

    private static void sendRecord(Scanner input, TestServiceGrpc.TestServiceBlockingStub bStub){
        var requestBuilder = TheRecord.newBuilder();
        System.out.println("Provide id");
        requestBuilder.setId(input.next());
        System.out.println("Provide name");
        requestBuilder.setName(input.next());

        try {
            System.out.println("Provide age");
            requestBuilder.setAge(input.nextInt());
            System.out.println("Provide height");
            requestBuilder.setHeight(input.nextFloat());
            System.out.println("Is it male?");
            requestBuilder.setMale(input.nextBoolean());
            System.out.println("Provide path to photo");
            requestBuilder.setPhotoPath(input.next());
            TheRecordResponse response = bStub.saveRecord(requestBuilder.build());
            System.out.println("Response from the server -> " + response);
        }
        catch(InputMismatchException e){
            System.out.println("---------Incorrect value!---------");
        }
    }

    private static void readRecord(Scanner input, TestServiceGrpc.TestServiceBlockingStub bStub){
        var requestBuilder = TheRecordRequest.newBuilder();
        System.out.println("Provide id");
        requestBuilder.setRecordId(input.next());
        TheRecord response = bStub.readRecord(requestBuilder.build());
        System.out.println("The response -> " + response);
    }

    private static void readAllRecordsIds(TestServiceGrpc.TestServiceBlockingStub bStub){
        var request = AllRecordsRequest.newBuilder().build();
        TheRecordResponse response = bStub.readAllRecordsIds(request);
        System.out.println("All ids -> " + response);
    }

    private static void deleteRecord(Scanner input, TestServiceGrpc.TestServiceBlockingStub bStub){
        var requestBuilder = TheRecordRequest.newBuilder();
        System.out.println("Provide id");
        requestBuilder.setRecordId(input.next());
        TheRecordResponse response = bStub.deleteRecord(requestBuilder.build());
        System.out.println("Response -> " + response);
    }

    private static void getPhoto(Scanner input, TestServiceGrpc.TestServiceStub nStub){
        System.out.println("Provide filename");
        String filename = input.next().trim();

        nStub.getPhoto(ThePhotoRequest.newBuilder().setFilename(filename).build(), new PhotoObs(filename));
    }
}
