package secminhr.typing.chuontype;

import secminhr.typing.javatype.UnsignedShort;

import static secminhr.typing.ByteArrayHelper.boxingByteArray;

public class UShortType implements ChuonType<UnsignedShort> {
    @Override
    public Byte[] convertToByteArray(UnsignedShort number) {
        return boxingByteArray(number.toByteArray());
    }

    @Override
    public byte getTypeInByte() {
        return 0x15;
    }
}
