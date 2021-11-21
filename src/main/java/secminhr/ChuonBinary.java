package secminhr;

import secminhr.typing.ChuonType;
import secminhr.typing.Types;

import java.util.stream.Stream;

public class ChuonBinary {

    private final ChuonType type;
    private final Byte[] array;

    public ChuonBinary(UnsignedByte number) {
        type = Types.Byte;
        array = Types.Byte.convertToByteArray(number);
    }

    public ChuonBinary(byte number) {
        type = Types.SByte;
        array = Types.SByte.convertToByteArray(number);
    }

    public ChuonBinary(short number) {
        type = Types.Short;
        array = Types.Short.convertToByteArray(number);
    }

    public ChuonBinary(int number) {
        type = Types.Int;
        array = Types.Int.convertToByteArray(number);
    }

    public ChuonBinary(long number) {
        type = Types.Long;
        array = Types.Long.convertToByteArray(number);
    }

    public ChuonBinary(UnsignedShort number) {
        type = Types.UShort;
        array = Types.UShort.convertToByteArray(number);
    }

    public Byte[] getBytes() {
        return Stream
                .concat(Stream.of(type.getTypeInByte()), Stream.of(array))
                .toArray(Byte[]::new);
    }
}
