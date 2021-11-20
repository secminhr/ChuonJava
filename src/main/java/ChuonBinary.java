import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.stream.Stream;

public class ChuonBinary {
    private final byte type;
    private final Byte[] array;

    public ChuonBinary(UnsignedByte number) {
        type = 0x10;
        array = new Byte[] { number.getNumberInByte() };
    }

    public ChuonBinary(byte number) {
        type = 0x11;
        array = new Byte[] { number };
    }

    public ChuonBinary(short number) {
        type = 0x12;
        byte[] byteArray =  ByteBuffer
                .allocate(Short.BYTES)
                .order(ByteOrder.LITTLE_ENDIAN)
                .putShort(number)
                .array();
        array = new Byte[byteArray.length];

        for(int i = 0; i < byteArray.length; i++) {
            array[i] = byteArray[i]; //boxing
        }
    }

    public Byte[] getBytes() {
        return Stream
                .concat(Stream.of(type), Stream.of(array))
                .toArray(Byte[]::new);
    }
}
