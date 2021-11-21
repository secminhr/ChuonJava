import org.junit.jupiter.api.Test;
import secminhr.ChuonBinary;
import secminhr.typing.javatype.UnsignedByte;

import static org.junit.jupiter.api.Assertions.*;

public class ByteChuonBinaryTest {
    @Test
    public void TestSingleByte0() {
        UnsignedByte number = new UnsignedByte(0);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[]{0x10, 0x00}, binary.getBytes());
    }

    @Test
    public void TestSingleByte10() {
        UnsignedByte number = new UnsignedByte(10);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[]{0x10, 0x0A}, binary.getBytes());
    }

    @Test
    public void TestSingleByte50() {
        UnsignedByte number = new UnsignedByte(50);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[]{0x10, 0x32}, binary.getBytes());
    }

    @Test
    public void TestSingleByte255() {
        UnsignedByte number = new UnsignedByte(255);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(new Byte[]{0x10, (byte) 0xFF}, binary.getBytes());
    }

    @Test
    public void TestInvalidValueNegative1() {
        assertThrows(IllegalArgumentException.class, () -> new UnsignedByte(-1));
    }

    @Test
    public void TestInvalidNegative65536() {
        assertThrows(IllegalArgumentException.class, () -> new UnsignedByte(-65536));
    }

    @Test
    public void TestInvalid256() {
        assertThrows(IllegalArgumentException.class, () -> new UnsignedByte(256));
    }
}
