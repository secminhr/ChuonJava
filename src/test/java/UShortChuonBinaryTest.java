import org.junit.jupiter.api.Test;
import secminhr.ChuonBinary;
import secminhr.typing.javatype.UnsignedShort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UShortChuonBinaryTest {
    @Test
    public void TestUShort0() {
        UnsignedShort number = new UnsignedShort(0);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
                new Byte[] {0x15, 0x00, 0x00},
                binary.getBytes()
        );
    }

    @Test
    public void TestUShortMax() {
        UnsignedShort number = new UnsignedShort(65535);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
                new Byte[] { 0x15, (byte)0xFF, (byte)0xFF},
                binary.getBytes()
        );
    }

    @Test
    public void TestUShort10() {
        UnsignedShort number = new UnsignedShort(10);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
                new Byte[] { 0x15, 0x0A, 0x00},
                binary.getBytes()
        );
    }

    @Test
    public void TestUShortNegative1_Exception() {
        assertThrows(IllegalArgumentException.class, () -> new UnsignedShort(-1));
    }

    @Test
    public void TestUShort65536_Exception() {
        assertThrows(IllegalArgumentException.class, () -> new UnsignedShort(65536));
    }
}
