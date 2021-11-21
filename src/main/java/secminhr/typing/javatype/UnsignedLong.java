package secminhr.typing.javatype;

import java.math.BigInteger;

import static secminhr.typing.ByteArrayHelper.LEByteBuffer;

public class UnsignedLong {
    //will be treated as unsigned
    private final long number;
    public UnsignedLong(long number) {
        this.number = number;
    }

    public byte[] toByteArray() {
        return LEByteBuffer(Long.BYTES)
                .putLong(number)
                .array();
    }
}
