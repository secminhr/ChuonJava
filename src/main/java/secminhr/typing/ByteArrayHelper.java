package secminhr.typing;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteArrayHelper {
    public static ByteBuffer LEByteBuffer(int bytes) {
        return ByteBuffer
                .allocate(bytes)
                .order(ByteOrder.LITTLE_ENDIAN);
    }

    public static Byte[] boxingByteArray(byte[] array) {
        Byte[] boxedArray = new Byte[array.length];

        for(int i = 0; i < array.length; i++) {
            boxedArray[i] = array[i]; //boxing
        }

        return boxedArray;
    }
}
