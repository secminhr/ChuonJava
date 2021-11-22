import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import secminhr.ChuonBinary;
import secminhr.typing.javatype.Decimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class DecimalChuonBinaryTest {
    @Test
    public void TestDecimal0() {
        Decimal number = new Decimal(0);
        ChuonBinary binary = new ChuonBinary(number);
        Byte[] expect = new Byte[17];
        Arrays.fill(expect, (byte) 0);
        expect[0] = 0x1A;

        assertArrayEquals(expect, binary.getBytes());
    }

    @Test
    public void TestDecimal1e14() {
        Decimal number = new Decimal(new BigInteger("100000000000000"));
        ChuonBinary binary = new ChuonBinary(number);
        Byte[] expect = new Byte[] {
                0x1A,
                0x00, 0x40, 0x7A, 0x10,
                (byte)0xF3, 0x5A, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00
        };
        assertArrayEquals(expect, binary.getBytes());

    }

    @Test
    public void TestDecimal1e28() {
        Decimal number = new Decimal(new BigInteger("10000000000000000000000000000"));
        ChuonBinary binary = new ChuonBinary(number);
        Byte[] expect = new Byte[] {
                0x1A,
                0x00, 0x00, 0x00, 0x10,
                0x61, 0x02, 0x25, 0x3E,
                0x5E, (byte) 0xCE, 0x4F, 0x20,
                0x00, 0x00, 0x00, 0x00
        };
        assertArrayEquals(expect, binary.getBytes());
    }

    @Test
    public void TestDecimalNegative1() {
        Decimal number = new Decimal(-1);
        ChuonBinary binary = new ChuonBinary(number);
        Byte[] expect = new Byte[] {
                0x1A,
                0x01, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0x0,  0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, (byte) 0x80
        };
        assertArrayEquals(expect, binary.getBytes());
    }

    @Test
    public void TestDecimalMin() {
        Decimal number = new Decimal(new BigInteger("-79228162514264337593543950335"));
        ChuonBinary binary = new ChuonBinary(number);
        Byte[] expect = new Byte[] {
                0x1A,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                0x00, 0x00, 0x00, (byte) 0x80
        };
        assertArrayEquals(expect, binary.getBytes());
    }

    @Test
    public void TestDecimalMax() {
        Decimal number = new Decimal(new BigInteger("79228162514264337593543950335"));
        ChuonBinary binary = new ChuonBinary(number);
        Byte[] expect = new Byte[] {
                0x1A,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                0x00, 0x00, 0x00, 0x00
        };
        assertArrayEquals(expect, binary.getBytes());
    }

    @Test
    public void TestDecimalWithPoint() {
        Decimal number = new Decimal(new BigDecimal("-7.9228162514264337593543950335"));
        ChuonBinary binary = new ChuonBinary(number);
        Byte[] expect = new Byte[] {
                0x1A,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                0x00, 0x00, 0x1C, (byte) 0x80
        };
        assertArrayEquals(expect, binary.getBytes());
    }

    @Test
    public void TestDecimalTooBig_Exception() {
        assertThrows(IllegalArgumentException.class, () ->  new Decimal(new BigInteger("109228162514264337593543950335")));
    }

    @Test
    public void TestDecimalTooSmall_Exception() {
        assertThrows(IllegalArgumentException.class, () ->  new Decimal(new BigInteger("-109228162514264337593543950335")));
    }
}
