package secminhr.typing;

public interface ChuonType<JavaType> {
    java.lang.Byte[] convertToByteArray(JavaType number);
    byte getTypeInByte();
}