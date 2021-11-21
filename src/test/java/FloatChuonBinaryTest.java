import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import secminhr.ChuonBinary;

public class FloatChuonBinaryTest {
    @Test
    public void TestFloat0() {
        float number = 0f;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] { 0x18, 0, 0, 0, 0},
            binary.getBytes()
        );
    }

    @Test
    public void TestFloat3_125() {
        float number = 3.125f;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
                new Byte[] { 0x18, 0, 0, 0x48, 0x40},
                binary.getBytes()
        );
    }

    @Test
    public void TestNegative2_75() {
        float number = -2.75f;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
                new Byte[] { 0x18, 0, 0, 0x30, (byte) 0xc0},
                binary.getBytes()
        );
    }
}
