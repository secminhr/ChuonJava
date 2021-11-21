package secminhr;

import secminhr.typing.chuontype.ChuonType;
import secminhr.typing.chuontype.Types;
import secminhr.typing.javatype.UnsignedByte;
import secminhr.typing.javatype.UnsignedInt;
import secminhr.typing.javatype.UnsignedLong;
import secminhr.typing.javatype.UnsignedShort;

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

    public ChuonBinary(UnsignedInt number) {
        type = Types.UInt;
        array = Types.UInt.convertToByteArray(number);
    }

    public ChuonBinary(UnsignedLong number) {
        type = Types.ULong;
        array = Types.ULong.convertToByteArray(number);
    }

    public ChuonBinary(float number) {
        type = Types.Float;
        array = Types.Float.convertToByteArray(number);

    }

    public ChuonBinary(double number) {
        type = Types.Double;
        array = Types.Double.convertToByteArray(number);
    }

    public Byte[] getBytes() {
        return Stream
                .concat(Stream.of(type.getTypeInByte()), Stream.of(array))
                .toArray(Byte[]::new);
    }
}
