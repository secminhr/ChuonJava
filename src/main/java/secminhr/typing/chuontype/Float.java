package secminhr.typing.chuontype;

import static secminhr.typing.ByteArrayHelper.LEByteBuffer;
import static secminhr.typing.ByteArrayHelper.boxingByteArray;

public class Float implements ChuonType<java.lang.Float> {
    @Override
    public Byte[] convertToByteArray(java.lang.Float number) {
        return boxingByteArray(
            LEByteBuffer(java.lang.Float.BYTES)
                .putFloat(number)
                .array()
        );
    }

    @Override
    public byte getTypeInByte() {
        return 0x18;
    }
}
