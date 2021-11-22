package secminhr.typing.chuontype;

import secminhr.typing.javatype.UnsignedLong;

import static secminhr.typing.ByteArrayHelper.boxingByteArray;

public class ULongType implements ChuonType<UnsignedLong> {
    @Override
    public Byte[] convertToByteArray(UnsignedLong number) {
        return boxingByteArray(number.toByteArray());
    }

    @Override
    public byte getTypeInByte() {
        return 0x17;
    }
}
