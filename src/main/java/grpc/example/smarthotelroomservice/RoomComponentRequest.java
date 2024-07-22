// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SmartHotelroomserive.proto

package grpc.example.smarthotelroomservice;

/**
 * Protobuf type {@code RoomComponentRequest}
 */
public  final class RoomComponentRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:RoomComponentRequest)
    RoomComponentRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RoomComponentRequest.newBuilder() to construct.
  private RoomComponentRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RoomComponentRequest() {
    roomid_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RoomComponentRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            roomid_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.example.smarthotelroomservice.RoomService2.internal_static_RoomComponentRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.example.smarthotelroomservice.RoomService2.internal_static_RoomComponentRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.example.smarthotelroomservice.RoomComponentRequest.class, grpc.example.smarthotelroomservice.RoomComponentRequest.Builder.class);
  }

  public static final int ROOMID_FIELD_NUMBER = 1;
  private volatile java.lang.Object roomid_;
  /**
   * <code>string roomid = 1;</code>
   */
  public java.lang.String getRoomid() {
    java.lang.Object ref = roomid_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      roomid_ = s;
      return s;
    }
  }
  /**
   * <code>string roomid = 1;</code>
   */
  public com.google.protobuf.ByteString
      getRoomidBytes() {
    java.lang.Object ref = roomid_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      roomid_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getRoomidBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, roomid_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getRoomidBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, roomid_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.example.smarthotelroomservice.RoomComponentRequest)) {
      return super.equals(obj);
    }
    grpc.example.smarthotelroomservice.RoomComponentRequest other = (grpc.example.smarthotelroomservice.RoomComponentRequest) obj;

    boolean result = true;
    result = result && getRoomid()
        .equals(other.getRoomid());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ROOMID_FIELD_NUMBER;
    hash = (53 * hash) + getRoomid().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.smarthotelroomservice.RoomComponentRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.example.smarthotelroomservice.RoomComponentRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code RoomComponentRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:RoomComponentRequest)
      grpc.example.smarthotelroomservice.RoomComponentRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.example.smarthotelroomservice.RoomService2.internal_static_RoomComponentRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.example.smarthotelroomservice.RoomService2.internal_static_RoomComponentRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.example.smarthotelroomservice.RoomComponentRequest.class, grpc.example.smarthotelroomservice.RoomComponentRequest.Builder.class);
    }

    // Construct using grpc.example.smarthotelroomservice.RoomComponentRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      roomid_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.example.smarthotelroomservice.RoomService2.internal_static_RoomComponentRequest_descriptor;
    }

    @java.lang.Override
    public grpc.example.smarthotelroomservice.RoomComponentRequest getDefaultInstanceForType() {
      return grpc.example.smarthotelroomservice.RoomComponentRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.example.smarthotelroomservice.RoomComponentRequest build() {
      grpc.example.smarthotelroomservice.RoomComponentRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.example.smarthotelroomservice.RoomComponentRequest buildPartial() {
      grpc.example.smarthotelroomservice.RoomComponentRequest result = new grpc.example.smarthotelroomservice.RoomComponentRequest(this);
      result.roomid_ = roomid_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.example.smarthotelroomservice.RoomComponentRequest) {
        return mergeFrom((grpc.example.smarthotelroomservice.RoomComponentRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.example.smarthotelroomservice.RoomComponentRequest other) {
      if (other == grpc.example.smarthotelroomservice.RoomComponentRequest.getDefaultInstance()) return this;
      if (!other.getRoomid().isEmpty()) {
        roomid_ = other.roomid_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.example.smarthotelroomservice.RoomComponentRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.example.smarthotelroomservice.RoomComponentRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object roomid_ = "";
    /**
     * <code>string roomid = 1;</code>
     */
    public java.lang.String getRoomid() {
      java.lang.Object ref = roomid_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        roomid_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string roomid = 1;</code>
     */
    public com.google.protobuf.ByteString
        getRoomidBytes() {
      java.lang.Object ref = roomid_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        roomid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string roomid = 1;</code>
     */
    public Builder setRoomid(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      roomid_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string roomid = 1;</code>
     */
    public Builder clearRoomid() {
      
      roomid_ = getDefaultInstance().getRoomid();
      onChanged();
      return this;
    }
    /**
     * <code>string roomid = 1;</code>
     */
    public Builder setRoomidBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      roomid_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:RoomComponentRequest)
  }

  // @@protoc_insertion_point(class_scope:RoomComponentRequest)
  private static final grpc.example.smarthotelroomservice.RoomComponentRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.example.smarthotelroomservice.RoomComponentRequest();
  }

  public static grpc.example.smarthotelroomservice.RoomComponentRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RoomComponentRequest>
      PARSER = new com.google.protobuf.AbstractParser<RoomComponentRequest>() {
    @java.lang.Override
    public RoomComponentRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RoomComponentRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RoomComponentRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RoomComponentRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.example.smarthotelroomservice.RoomComponentRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
