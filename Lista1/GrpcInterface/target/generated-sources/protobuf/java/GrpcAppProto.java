// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GrpcInterface.proto

public final class GrpcAppProto {
  private GrpcAppProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TheRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TheRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TheResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TheResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TheRecordRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TheRecordRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TheRecord_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TheRecord_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023GrpcInterface.proto\"\'\n\nTheRequest\022\014\n\004n" +
      "ame\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\"\036\n\013TheResponse\022\017\n" +
      "\007message\030\001 \001(\t\"*\n\020TheRecordRequest\022\026\n\016re" +
      "cordPosition\030\001 \001(\005\"D\n\tTheRecord\022\014\n\004name\030" +
      "\001 \001(\t\022\013\n\003age\030\002 \001(\005\022\016\n\006height\030\003 \001(\002\022\014\n\004ma" +
      "le\030\004 \001(\0102\256\002\n\013TestService\022-\n\016unaryProcedu" +
      "re\022\013.TheRequest\032\014.TheResponse\"\000\0220\n\017strea" +
      "mProcedure\022\013.TheRequest\032\014.TheResponse\"\0000" +
      "\001\022,\n\013streamToSrv\022\013.TheRequest\032\014.TheRespo" +
      "nse\"\000(\001\022+\n\013sendRecords\022\n.TheRecord\032\014.The" +
      "Response\"\000(\001\0222\n\rgetAllRecords\022\021.TheRecor" +
      "dRequest\032\n.TheRecord\"\0000\001\022/\n\014getOneRecord" +
      "\022\021.TheRecordRequest\032\n.TheRecord\"\000B\026B\014Grp" +
      "cAppProtoP\001\242\002\003GAPb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_TheRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_TheRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TheRequest_descriptor,
        new java.lang.String[] { "Name", "Age", });
    internal_static_TheResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_TheResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TheResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_TheRecordRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_TheRecordRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TheRecordRequest_descriptor,
        new java.lang.String[] { "RecordPosition", });
    internal_static_TheRecord_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_TheRecord_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TheRecord_descriptor,
        new java.lang.String[] { "Name", "Age", "Height", "Male", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
