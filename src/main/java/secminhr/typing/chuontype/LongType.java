package secminhr.typing.chuontype;

import static secminhr.typing.ByteArrayHelper.LEByteBuffer;
import static secminhr.typing.ByteArrayHelper.boxingByteArray;

public class LongType implements ChuonType<java.lang.Long> {
    @Override
    public Byte[] convertToByteArray(java.lang.Long number) {
        return boxingByteArray(
            LEByteBuffer(java.lang.Long.BYTES).putLong(number).array()
        );
    }

    @Override
    public byte getTypeInByte() {
        return 0x14;
    }
}
