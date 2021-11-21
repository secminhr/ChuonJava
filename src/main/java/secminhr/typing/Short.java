package secminhr.typing;

import static secminhr.typing.ByteArrayHelper.LEByteBuffer;
import static secminhr.typing.ByteArrayHelper.boxingByteArray;

class Short implements ChuonType<java.lang.Short> {

    @Override
    public Byte[] convertToByteArray(java.lang.Short number) {
        return boxingByteArray(
            LEByteBuffer(java.lang.Short.BYTES).putShort(number).array()
        );
    }

    @Override
    public byte getTypeInByte() {
        return 0x12;
    }
}