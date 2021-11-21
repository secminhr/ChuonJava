package secminhr.typing.chuontype;

public interface ChuonType<JavaType> {
    java.lang.Byte[] convertToByteArray(JavaType number);
    byte getTypeInByte();
}