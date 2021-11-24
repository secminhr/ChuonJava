import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import secminhr.ChuonBinary;

public class CharChuonBinaryTest {
    @Test
    public void Test_a() {
        char c = 'a';
        ChuonBinary binary = new ChuonBinary(c);
        assertArrayEquals(
            new Byte[] { 0x1B, 0x61 },
            binary.getBytes()
        );
    }

    @Test
    public void Test_B() {
        char c = 'B';
        ChuonBinary binary = new ChuonBinary(c);
        assertArrayEquals(
            new Byte[] { 0x1B, 0x42 },
            binary.getBytes()
        );
    }
}
