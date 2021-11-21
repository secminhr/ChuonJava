package secminhr.typing.chuontype;

import secminhr.typing.javatype.UnsignedInt;

import static secminhr.typing.ByteArrayHelper.boxingByteArray;

public class UInt implements ChuonType<UnsignedInt> {
    @Override
    public Byte[] convertToByteArray(UnsignedInt number) {
        return boxingByteArray(number.toByteArray());
    }

    @Override
    public byte getTypeInByte() {
        return 0x16;
    }
}
