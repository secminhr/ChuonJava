package secminhr.typing.chuontype;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static secminhr.typing.ByteArrayHelper.LEByteBuffer;
import static secminhr.typing.ByteArrayHelper.boxingByteArray;

public class StringType implements ChuonType<String> {
    @Override
    public Byte[] convertToByteArray(String string) {
        int length = string.length();
        byte[] lengthBytes = toBase128(length);
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        return boxingByteArray(
            LEByteBuffer(lengthBytes.length + bytes.length)
                .put(lengthBytes)
                .put(bytes)
                .array()
        );
    }

    private byte[] toBase128(int number) {
        if (number < 128) {
            return new byte[] { (byte) number };
        }
        int binaryLength = 32-Integer.numberOfLeadingZeros(number);
        int base128Length = (int) Math.ceil(binaryLength/7.0);
        byte[] bytes = new byte[base128Length];
        int index = 0;
        while (number > 0) {
            bytes[index] = (byte) (number % 128);
            number /= 128;
            index++;
        }
        for (int i = 0; i < base128Length-1; i++) {
            bytes[i] |= 0x80;
        }

        return bytes;
    }

    @Override
    public byte getTypeInByte() {
        return 0x1C;
    }
}
