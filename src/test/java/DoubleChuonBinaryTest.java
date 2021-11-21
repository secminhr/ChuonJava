import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import secminhr.ChuonBinary;

public class DoubleChuonBinaryTest {
    @Test
    public void TestDouble0() {
        double number = 0.0;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] { 0x19, 0, 0, 0, 0, 0, 0, 0, 0},
            binary.getBytes()
        );
    }

    @Test
    public void TestDouble10_93() {
        double number = 10.93;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] { 0x19, 0x5C, (byte)0x8F, (byte)0xC2, (byte)0xF5, 0x28, (byte)0xDC, 0x25 ,0x40 },
            binary.getBytes()
        );
    }
}
