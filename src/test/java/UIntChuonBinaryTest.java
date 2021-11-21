import org.junit.jupiter.api.Test;
import secminhr.ChuonBinary;
import secminhr.typing.javatype.UnsignedInt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UIntChuonBinaryTest {
    @Test
    public void TestUInt0() {
        UnsignedInt number = new UnsignedInt(0);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] { 0x16, 0x00, 0x00, 0x00, 0x00 },
            binary.getBytes()
        );
    }

    @Test
    public void TestUInt10() {
        UnsignedInt number = new UnsignedInt(10);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] { 0x16, 0x0A, 0x00, 0x00, 0x00},
            binary.getBytes()
        );
    }

    @Test
    public void TestUIntMax() {
        UnsignedInt number = new UnsignedInt(4294967295L);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
            new Byte[] { 0x16, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF},
            binary.getBytes()
        );
    }

    @Test
    public void TestUIntNegative1_Exception() {
        assertThrows(IllegalArgumentException.class, () -> new UnsignedInt(-1));
    }

    @Test
    public void TestUIntTooBig_Exception() {
        assertThrows(IllegalArgumentException.class, () -> new UnsignedInt(4294967296L));
    }

}
