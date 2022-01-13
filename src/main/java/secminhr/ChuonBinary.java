package secminhr;

import secminhr.typing.chuontype.ChuonType;
import secminhr.typing.chuontype.Types;
import secminhr.typing.javatype.*;

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

    public ChuonBinary(Decimal number) {
        type = Types.Decimal;
        array = Types.Decimal.convertToByteArray(number);
    }

    public ChuonBinary(char c) {
        type = Types.Char;
        array = Types.Char.convertToByteArray(c);
    }

    public ChuonBinary(String s) {
        type = Types.String;
        array = Types.String.convertToByteArray(s);
    }

    public ChuonBinary(boolean b) {
        type = Types.Boolean;
        array = Types.Boolean.convertToByteArray(b);
    }

    public Byte[] getBytes() {
        return Stream
                .concat(Stream.of(type.getTypeInByte()), Stream.of(array))
                .toArray(Byte[]::new);
    }
}
