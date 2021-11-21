import org.junit.jupiter.api.Test;
import secminhr.ChuonBinary;

import static org.junit.jupiter.api.Assertions.*;

public class LongChuonBinaryTest {
    @Test
    public void TestLong0() {
        long number = 0;
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] {0x14, 0, 0, 0, 0, 0, 0, 0, 0},
            binary.getBytes()
        );
    }
}
