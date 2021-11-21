import org.junit.jupiter.api.Test;
import secminhr.ChuonBinary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShortChuonBinaryTest {
    @Test
    public void TestShort0() {
        short number = 0;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[] {0x12, 0x00, 0x00}, binary.getBytes());
    }

    @Test
    public void TestShortMax() {
        short number = Short.MAX_VALUE;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[] {0x12, (byte) 0xFF, 0x7F}, binary.getBytes());
    }

    @Test
    public void TestShortMin() {
        short number = Short.MIN_VALUE;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[] {0x12, 0x00, (byte) 0x80}, binary.getBytes());
    }
}
