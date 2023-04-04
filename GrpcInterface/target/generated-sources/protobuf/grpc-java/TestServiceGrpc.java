import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: GrpcInterface.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TestServiceGrpc {

  private TestServiceGrpc() {}

  public static final String SERVICE_NAME = "TestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<TheRequest,
      TheResponse> getUnaryProcedureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unaryProcedure",
      requestType = TheRequest.class,
      responseType = TheResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TheRequest,
      TheResponse> getUnaryProcedureMethod() {
    io.grpc.MethodDescriptor<TheRequest, TheResponse> getUnaryProcedureMethod;
    if ((getUnaryProcedureMethod = TestServiceGrpc.getUnaryProcedureMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getUnaryProcedureMethod = TestServiceGrpc.getUnaryProcedureMethod) == null) {
          TestServiceGrpc.getUnaryProcedureMethod = getUnaryProcedureMethod =
              io.grpc.MethodDescriptor.<TheRequest, TheResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "unaryProcedure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("unaryProcedure"))
              .build();
        }
      }
    }
    return getUnaryProcedureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TheRequest,
      TheResponse> getStreamProcedureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamProcedure",
      requestType = TheRequest.class,
      responseType = TheResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<TheRequest,
      TheResponse> getStreamProcedureMethod() {
    io.grpc.MethodDescriptor<TheRequest, TheResponse> getStreamProcedureMethod;
    if ((getStreamProcedureMethod = TestServiceGrpc.getStreamProcedureMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getStreamProcedureMethod = TestServiceGrpc.getStreamProcedureMethod) == null) {
          TestServiceGrpc.getStreamProcedureMethod = getStreamProcedureMethod =
              io.grpc.MethodDescriptor.<TheRequest, TheResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamProcedure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("streamProcedure"))
              .build();
        }
      }
    }
    return getStreamProcedureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TheRequest,
      TheResponse> getStreamToSrvMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamToSrv",
      requestType = TheRequest.class,
      responseType = TheResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<TheRequest,
      TheResponse> getStreamToSrvMethod() {
    io.grpc.MethodDescriptor<TheRequest, TheResponse> getStreamToSrvMethod;
    if ((getStreamToSrvMethod = TestServiceGrpc.getStreamToSrvMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getStreamToSrvMethod = TestServiceGrpc.getStreamToSrvMethod) == null) {
          TestServiceGrpc.getStreamToSrvMethod = getStreamToSrvMethod =
              io.grpc.MethodDescriptor.<TheRequest, TheResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamToSrv"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("streamToSrv"))
              .build();
        }
      }
    }
    return getStreamToSrvMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TheRecord,
      TheRecordResponse> getSaveRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveRecord",
      requestType = TheRecord.class,
      responseType = TheRecordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TheRecord,
      TheRecordResponse> getSaveRecordMethod() {
    io.grpc.MethodDescriptor<TheRecord, TheRecordResponse> getSaveRecordMethod;
    if ((getSaveRecordMethod = TestServiceGrpc.getSaveRecordMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getSaveRecordMethod = TestServiceGrpc.getSaveRecordMethod) == null) {
          TestServiceGrpc.getSaveRecordMethod = getSaveRecordMethod =
              io.grpc.MethodDescriptor.<TheRecord, TheRecordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveRecord"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRecord.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRecordResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("saveRecord"))
              .build();
        }
      }
    }
    return getSaveRecordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TheRecordRequest,
      TheRecord> getReadRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readRecord",
      requestType = TheRecordRequest.class,
      responseType = TheRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TheRecordRequest,
      TheRecord> getReadRecordMethod() {
    io.grpc.MethodDescriptor<TheRecordRequest, TheRecord> getReadRecordMethod;
    if ((getReadRecordMethod = TestServiceGrpc.getReadRecordMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getReadRecordMethod = TestServiceGrpc.getReadRecordMethod) == null) {
          TestServiceGrpc.getReadRecordMethod = getReadRecordMethod =
              io.grpc.MethodDescriptor.<TheRecordRequest, TheRecord>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "readRecord"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRecordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRecord.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("readRecord"))
              .build();
        }
      }
    }
    return getReadRecordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AllRecordsRequest,
      TheRecordResponse> getReadAllRecordsIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readAllRecordsIds",
      requestType = AllRecordsRequest.class,
      responseType = TheRecordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AllRecordsRequest,
      TheRecordResponse> getReadAllRecordsIdsMethod() {
    io.grpc.MethodDescriptor<AllRecordsRequest, TheRecordResponse> getReadAllRecordsIdsMethod;
    if ((getReadAllRecordsIdsMethod = TestServiceGrpc.getReadAllRecordsIdsMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getReadAllRecordsIdsMethod = TestServiceGrpc.getReadAllRecordsIdsMethod) == null) {
          TestServiceGrpc.getReadAllRecordsIdsMethod = getReadAllRecordsIdsMethod =
              io.grpc.MethodDescriptor.<AllRecordsRequest, TheRecordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "readAllRecordsIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AllRecordsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRecordResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("readAllRecordsIds"))
              .build();
        }
      }
    }
    return getReadAllRecordsIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TheRecordRequest,
      TheRecordResponse> getDeleteRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteRecord",
      requestType = TheRecordRequest.class,
      responseType = TheRecordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TheRecordRequest,
      TheRecordResponse> getDeleteRecordMethod() {
    io.grpc.MethodDescriptor<TheRecordRequest, TheRecordResponse> getDeleteRecordMethod;
    if ((getDeleteRecordMethod = TestServiceGrpc.getDeleteRecordMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getDeleteRecordMethod = TestServiceGrpc.getDeleteRecordMethod) == null) {
          TestServiceGrpc.getDeleteRecordMethod = getDeleteRecordMethod =
              io.grpc.MethodDescriptor.<TheRecordRequest, TheRecordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteRecord"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRecordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TheRecordResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("deleteRecord"))
              .build();
        }
      }
    }
    return getDeleteRecordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ThePhotoRequest,
      ThePhotoResponse> getGetPhotoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPhoto",
      requestType = ThePhotoRequest.class,
      responseType = ThePhotoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ThePhotoRequest,
      ThePhotoResponse> getGetPhotoMethod() {
    io.grpc.MethodDescriptor<ThePhotoRequest, ThePhotoResponse> getGetPhotoMethod;
    if ((getGetPhotoMethod = TestServiceGrpc.getGetPhotoMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getGetPhotoMethod = TestServiceGrpc.getGetPhotoMethod) == null) {
          TestServiceGrpc.getGetPhotoMethod = getGetPhotoMethod =
              io.grpc.MethodDescriptor.<ThePhotoRequest, ThePhotoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getPhoto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ThePhotoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ThePhotoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("getPhoto"))
              .build();
        }
      }
    }
    return getGetPhotoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceStub>() {
        @java.lang.Override
        public TestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceStub(channel, callOptions);
        }
      };
    return TestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub>() {
        @java.lang.Override
        public TestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceBlockingStub(channel, callOptions);
        }
      };
    return TestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub>() {
        @java.lang.Override
        public TestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceFutureStub(channel, callOptions);
        }
      };
    return TestServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The service definition.
   * </pre>
   */
  public static abstract class TestServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Remote procedures:
     * </pre>
     */
    public void unaryProcedure(TheRequest request,
        io.grpc.stub.StreamObserver<TheResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnaryProcedureMethod(), responseObserver);
    }

    /**
     */
    public void streamProcedure(TheRequest request,
        io.grpc.stub.StreamObserver<TheResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamProcedureMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<TheRequest> streamToSrv(
        io.grpc.stub.StreamObserver<TheResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamToSrvMethod(), responseObserver);
    }

    /**
     */
    public void saveRecord(TheRecord request,
        io.grpc.stub.StreamObserver<TheRecordResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveRecordMethod(), responseObserver);
    }

    /**
     */
    public void readRecord(TheRecordRequest request,
        io.grpc.stub.StreamObserver<TheRecord> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadRecordMethod(), responseObserver);
    }

    /**
     */
    public void readAllRecordsIds(AllRecordsRequest request,
        io.grpc.stub.StreamObserver<TheRecordResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadAllRecordsIdsMethod(), responseObserver);
    }

    /**
     */
    public void deleteRecord(TheRecordRequest request,
        io.grpc.stub.StreamObserver<TheRecordResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRecordMethod(), responseObserver);
    }

    /**
     */
    public void getPhoto(ThePhotoRequest request,
        io.grpc.stub.StreamObserver<ThePhotoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPhotoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUnaryProcedureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                TheRequest,
                TheResponse>(
                  this, METHODID_UNARY_PROCEDURE)))
          .addMethod(
            getStreamProcedureMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                TheRequest,
                TheResponse>(
                  this, METHODID_STREAM_PROCEDURE)))
          .addMethod(
            getStreamToSrvMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                TheRequest,
                TheResponse>(
                  this, METHODID_STREAM_TO_SRV)))
          .addMethod(
            getSaveRecordMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                TheRecord,
                TheRecordResponse>(
                  this, METHODID_SAVE_RECORD)))
          .addMethod(
            getReadRecordMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                TheRecordRequest,
                TheRecord>(
                  this, METHODID_READ_RECORD)))
          .addMethod(
            getReadAllRecordsIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                AllRecordsRequest,
                TheRecordResponse>(
                  this, METHODID_READ_ALL_RECORDS_IDS)))
          .addMethod(
            getDeleteRecordMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                TheRecordRequest,
                TheRecordResponse>(
                  this, METHODID_DELETE_RECORD)))
          .addMethod(
            getGetPhotoMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ThePhotoRequest,
                ThePhotoResponse>(
                  this, METHODID_GET_PHOTO)))
          .build();
    }
  }

  /**
   * <pre>
   * The service definition.
   * </pre>
   */
  public static final class TestServiceStub extends io.grpc.stub.AbstractAsyncStub<TestServiceStub> {
    private TestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Remote procedures:
     * </pre>
     */
    public void unaryProcedure(TheRequest request,
        io.grpc.stub.StreamObserver<TheResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnaryProcedureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamProcedure(TheRequest request,
        io.grpc.stub.StreamObserver<TheResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamProcedureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<TheRequest> streamToSrv(
        io.grpc.stub.StreamObserver<TheResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getStreamToSrvMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void saveRecord(TheRecord request,
        io.grpc.stub.StreamObserver<TheRecordResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveRecordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readRecord(TheRecordRequest request,
        io.grpc.stub.StreamObserver<TheRecord> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadRecordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readAllRecordsIds(AllRecordsRequest request,
        io.grpc.stub.StreamObserver<TheRecordResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadAllRecordsIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRecord(TheRecordRequest request,
        io.grpc.stub.StreamObserver<TheRecordResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRecordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPhoto(ThePhotoRequest request,
        io.grpc.stub.StreamObserver<ThePhotoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetPhotoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service definition.
   * </pre>
   */
  public static final class TestServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TestServiceBlockingStub> {
    private TestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Remote procedures:
     * </pre>
     */
    public TheResponse unaryProcedure(TheRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnaryProcedureMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<TheResponse> streamProcedure(
        TheRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamProcedureMethod(), getCallOptions(), request);
    }

    /**
     */
    public TheRecordResponse saveRecord(TheRecord request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveRecordMethod(), getCallOptions(), request);
    }

    /**
     */
    public TheRecord readRecord(TheRecordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadRecordMethod(), getCallOptions(), request);
    }

    /**
     */
    public TheRecordResponse readAllRecordsIds(AllRecordsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadAllRecordsIdsMethod(), getCallOptions(), request);
    }

    /**
     */
    public TheRecordResponse deleteRecord(TheRecordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRecordMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ThePhotoResponse> getPhoto(
        ThePhotoRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetPhotoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service definition.
   * </pre>
   */
  public static final class TestServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TestServiceFutureStub> {
    private TestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Remote procedures:
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<TheResponse> unaryProcedure(
        TheRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnaryProcedureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TheRecordResponse> saveRecord(
        TheRecord request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveRecordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TheRecord> readRecord(
        TheRecordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadRecordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TheRecordResponse> readAllRecordsIds(
        AllRecordsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadAllRecordsIdsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TheRecordResponse> deleteRecord(
        TheRecordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRecordMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNARY_PROCEDURE = 0;
  private static final int METHODID_STREAM_PROCEDURE = 1;
  private static final int METHODID_SAVE_RECORD = 2;
  private static final int METHODID_READ_RECORD = 3;
  private static final int METHODID_READ_ALL_RECORDS_IDS = 4;
  private static final int METHODID_DELETE_RECORD = 5;
  private static final int METHODID_GET_PHOTO = 6;
  private static final int METHODID_STREAM_TO_SRV = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNARY_PROCEDURE:
          serviceImpl.unaryProcedure((TheRequest) request,
              (io.grpc.stub.StreamObserver<TheResponse>) responseObserver);
          break;
        case METHODID_STREAM_PROCEDURE:
          serviceImpl.streamProcedure((TheRequest) request,
              (io.grpc.stub.StreamObserver<TheResponse>) responseObserver);
          break;
        case METHODID_SAVE_RECORD:
          serviceImpl.saveRecord((TheRecord) request,
              (io.grpc.stub.StreamObserver<TheRecordResponse>) responseObserver);
          break;
        case METHODID_READ_RECORD:
          serviceImpl.readRecord((TheRecordRequest) request,
              (io.grpc.stub.StreamObserver<TheRecord>) responseObserver);
          break;
        case METHODID_READ_ALL_RECORDS_IDS:
          serviceImpl.readAllRecordsIds((AllRecordsRequest) request,
              (io.grpc.stub.StreamObserver<TheRecordResponse>) responseObserver);
          break;
        case METHODID_DELETE_RECORD:
          serviceImpl.deleteRecord((TheRecordRequest) request,
              (io.grpc.stub.StreamObserver<TheRecordResponse>) responseObserver);
          break;
        case METHODID_GET_PHOTO:
          serviceImpl.getPhoto((ThePhotoRequest) request,
              (io.grpc.stub.StreamObserver<ThePhotoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_TO_SRV:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamToSrv(
              (io.grpc.stub.StreamObserver<TheResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GrpcAppProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestService");
    }
  }

  private static final class TestServiceFileDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier {
    TestServiceFileDescriptorSupplier() {}
  }

  private static final class TestServiceMethodDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestServiceFileDescriptorSupplier())
              .addMethod(getUnaryProcedureMethod())
              .addMethod(getStreamProcedureMethod())
              .addMethod(getStreamToSrvMethod())
              .addMethod(getSaveRecordMethod())
              .addMethod(getReadRecordMethod())
              .addMethod(getReadAllRecordsIdsMethod())
              .addMethod(getDeleteRecordMethod())
              .addMethod(getGetPhotoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
