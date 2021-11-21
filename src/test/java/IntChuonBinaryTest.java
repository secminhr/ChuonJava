import org.junit.jupiter.api.Test;
import secminhr.ChuonBinary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntChuonBinaryTest {
    @Test
    public void TestInt0() {
        int number = 0;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] {0x13, 0x00, 0x00, 0x00, 0x00},
            binary.getBytes()
        );
    }

    @Test
    public void TestIntMax() {
        int number = Integer.MAX_VALUE;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] {0x13, (byte) 0xFF, (byte)0xFF, (byte)0xFF, 0x7F},
            binary.getBytes()
        );
    }

    @Test
    public void TestIntMin() {
        int number = Integer.MIN_VALUE;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] {0x13, 0x00, 0x00, 0x00, (byte)0x80},
            binary.getBytes()
        );
    }
}
