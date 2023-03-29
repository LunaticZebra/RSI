import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GrpcClient {
    public static void main(String[] args) {
        String address = "localhost"; //here we use service on the same host
        int port = 50001;
        TestServiceGrpc.TestServiceBlockingStub bStub;
        System.out.println("Running gRPC client...");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
//        bStub = TestServiceGrpc.newBlockingStub(channel);
//        TheRequest request = TheRequest.newBuilder().setName("Maciej")
//                .setAge(21).build();
//        System.out.println("...calling unaryProcedure");
//        TheResponse response = bStub.unaryProcedure(request);
//        System.out.println("...after calling unaryProcedure");
//        System.out.println("--> Response: " + response);
//
//        TestServiceGrpc.TestServiceStub nStub;
//        nStub = TestServiceGrpc.newStub(channel);
//        System.out.println("...async calling unaryProcedure");
//
//        nStub.unaryProcedure(request, new UnaryOrbs());
//        System.out.println("....after async calling unaryProcedure");
//        Scanner scanner = new Scanner(System.in);
//
//        String input = scanner.next();
//        while(!input.equals("stop")) {
//            input = scanner.next();
//        }
//
//        Iterator<TheResponse> respIterator;
//        System.out.println("...calling streamProcedure");
//        bStub = TestServiceGrpc.newBlockingStub(channel);
//        respIterator = bStub.streamProcedure(TheRequest.newBuilder().build());
//        TheResponse strResponse;
//
//        while(respIterator.hasNext()) {
//            strResponse = respIterator.next();
//            System.out.println("-->" + strResponse.getMessage());
//        }
//        System.out.println("...after calling streamProcedure");
//
//        TestServiceGrpc.TestServiceStub nStub;
//        nStub = TestServiceGrpc.newStub(channel);
//        System.out.println("...async calling streamProcedure");
//        nStub.streamProcedure(TheRequest.newBuilder().build(), new UnaryOrbs());
//        System.out.println("...after async calling streamProcedure");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//        while(!input.equals("stop")) {
//            input = scanner.next();
//        }

//        TheRequest r1 = TheRequest.newBuilder().setAge(15).setName("Ala").build();
//        TheRequest r2 = TheRequest.newBuilder().setAge(25).setName("Olek").build();
//        TheRequest r3 = TheRequest.newBuilder().setAge(51).setName("Maciek").build();
//        TheRequest r4 = TheRequest.newBuilder().setAge(23).setName("Kuba").build();
//        strReqObserver.onNext(r1);
//        strReqObserver.onNext(r2);
//        strReqObserver.onNext(r3);
//        strReqObserver.onNext(r4);
//        strReqObserver.onCompleted();
        TestServiceGrpc.TestServiceStub nStub;
        nStub = TestServiceGrpc.newStub(channel);
        StreamObserver<TheRecord> strReqObserver = nStub.sendRecords(new RecordObs());

        ArrayList<TheRecord> records = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            TheRecord r = TheRecord.newBuilder().setAge(20 + i).
                    setName("Olek" + i).setHeight(1.8f + (i * 0.05f)).setMale(i%2==0).build();
            records.add(r);
        }
        for(TheRecord r: records){
            strReqObserver.onNext(r);
        }
        strReqObserver.onCompleted();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while(!input.equals("stop")) {
            input = scanner.next();
        }
        channel.shutdown();
    }

    private static class UnaryOrbs implements StreamObserver<TheResponse> {

        @Override
        public void onNext(TheResponse theResponse) {
            System.out.println("-->async unary onNext: " + theResponse.getMessage());
        }

        @Override
        public void onError(Throwable throwable){
            System.out.println("-->async unary onError");
        }

        @Override
        public void onCompleted(){
            System.out.println("-->async unary onCompleted");
        }
    }

    private static class RecordObs implements StreamObserver<TheResponse> {

        @Override
        public void onNext(TheResponse theResponse) {
            System.out.println("--> async record onNext: " + theResponse.getMessage());
        }

        @Override
        public void onError(Throwable throwable){
            System.out.println("-->async record onError");
        }

        @Override
        public void onCompleted(){
            System.out.println("-->async record onCompleted");
        }
    }
}
