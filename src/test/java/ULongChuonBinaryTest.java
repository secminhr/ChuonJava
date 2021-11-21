import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import secminhr.ChuonBinary;
import secminhr.typing.javatype.UnsignedLong;

import java.util.Arrays;

public class ULongChuonBinaryTest {
    @Test
    public void TestULong0() {
        UnsignedLong number = new UnsignedLong(0);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
                new Byte[] {0x17, 0, 0, 0, 0, 0, 0, 0, 0},
                binary.getBytes()
        );
    }

    @Test
    public void TestULong10() {
        UnsignedLong number = new UnsignedLong(10);
        ChuonBinary binary = new ChuonBinary(number);
        assertArrayEquals(
                new Byte[] { 0x17, 0xA, 0, 0, 0, 0, 0, 0, 0},
                binary.getBytes()
        );
    }

    @Test
    public void TestULongMax() {
        UnsignedLong number = new UnsignedLong(
            Long.parseUnsignedLong("18446744073709551615")
        );
        ChuonBinary binary = new ChuonBinary(number);
        Byte[] expect = new Byte[9];
        Arrays.fill(expect, (byte) 0xFF);
        expect[0] = 0x17;

        assertArrayEquals(expect, binary.getBytes());
    }

    @Test
    public void TestULongNegative1() {
        //will be seen as unsigned, which is max, but the usage is not encouraged
        UnsignedLong number = new UnsignedLong(-1);
        ChuonBinary binary = new ChuonBinary(number);
        Byte[] expect = new Byte[9];
        Arrays.fill(expect, (byte) 0xFF);
        expect[0] = 0x17;

        assertArrayEquals(expect, binary.getBytes());
    }
}
