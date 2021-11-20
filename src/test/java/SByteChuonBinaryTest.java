import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SByteChuonBinaryTest {
    @Test
    public void TestSByte0() {
        byte number = 0;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[] {0x11, 0x00}, binary.getBytes());
    }

    @Test
    public void TestSByte10() {
        byte number = 10;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[] {0x11, 0x0A}, binary.getBytes());
    }

    @Test
    public void TestSByte127() {
        byte number = 127;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[] {0x11, 0x7F}, binary.getBytes());
    }

    @Test
    public void TestSByteNegative128() {
        byte number = -128;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[] {0x11, (byte) 0x80}, binary.getBytes());
    }
}
