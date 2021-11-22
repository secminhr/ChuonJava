package secminhr.typing.chuontype;

import secminhr.ChuonBinary;

import static secminhr.typing.ByteArrayHelper.LEByteBuffer;
import static secminhr.typing.ByteArrayHelper.boxingByteArray;

public class DoubleType implements ChuonType<java.lang.Double> {
    @Override
    public Byte[] convertToByteArray(java.lang.Double number) {
        return boxingByteArray(
            LEByteBuffer(java.lang.Double.BYTES)
                .putDouble(number)
                .array()
        );
    }

    @Override
    public byte getTypeInByte() {
        return 0x19;
    }
}
