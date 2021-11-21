package secminhr;

import static secminhr.typing.ByteArrayHelper.LEByteBuffer;

public class UnsignedShort {
    private final int number;
    public UnsignedShort(int number) {
        if (number < 0 || number > 65535) {
            throw new IllegalArgumentException("Number of UnsignedShort must between [0,65535]");
        }
        this.number = number;
    }

    public byte[] toByteArray() {
        return LEByteBuffer(Short.BYTES).putShort((short) number).array();
    }
}
