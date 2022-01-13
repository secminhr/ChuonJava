import org.junit.jupiter.api.Test;
import secminhr.ChuonBinary;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BooleanChuonBinaryTest {
    @Test
    public void TestTrue() {
        ChuonBinary binary = new ChuonBinary(true);
        assertArrayEquals(
            new Byte[] { 0x1d, 0x01 },
            binary.getBytes()
        );
    }

    @Test
    public void TestFalse() {
        ChuonBinary binary = new ChuonBinary(false);
        assertArrayEquals(
            new Byte[] { 0x1d, 0x00 },
            binary.getBytes()
        );
    }
}
