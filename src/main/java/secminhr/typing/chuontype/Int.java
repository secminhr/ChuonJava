package secminhr.typing.chuontype;

import static secminhr.typing.ByteArrayHelper.LEByteBuffer;
import static secminhr.typing.ByteArrayHelper.boxingByteArray;

public class Int implements ChuonType<Integer> {

    @Override
    public Byte[] convertToByteArray(Integer number) {
        return boxingByteArray(
            LEByteBuffer(Integer.BYTES).putInt(number).array()
        );
    }

    @Override
    public byte getTypeInByte() {
        return 0x13;
    }
}
