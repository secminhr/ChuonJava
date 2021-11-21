package secminhr.typing.javatype;

import static secminhr.typing.ByteArrayHelper.LEByteBuffer;

public class UnsignedInt {
    private final long number;
    public UnsignedInt(long number) {
        if (number < 0 || number > 4294967295L) {
            throw new IllegalArgumentException("Number of UnsignedInt must between [0, 4294967295]");
        }
        this.number = number;
    }

    public byte[] toByteArray() {
        return LEByteBuffer(Integer.BYTES)
                .putInt((int) number)
                .array();
    }
}
