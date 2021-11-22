package secminhr.typing.javatype;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class Decimal {

    private final BigDecimal number;
    private final static BigInteger MIN_INT = new BigInteger("-79228162514264337593543950335");
    private final static BigInteger MAX_INT = new BigInteger("79228162514264337593543950335");
    private final static BigDecimal MIN_DEC = new BigDecimal("-79228162514264337593543950335");
    private final static BigDecimal MAX_DEC = new BigDecimal("79228162514264337593543950335");

    public Decimal(int number) {
        this.number = new BigDecimal(number);
    }

    public Decimal(BigInteger number) {
        if (number.compareTo(MIN_INT) < 0 || number.compareTo(MAX_INT) > 0) {
            throw new IllegalArgumentException("Number of Decimal must between [-79228162514264337593543950335, 79228162514264337593543950335]");
        }

        this.number = new BigDecimal(number);
    }

    public Decimal(BigDecimal number) {
        if (number.compareTo(MIN_DEC) < 0 || number.compareTo(MAX_DEC) > 0) {
            throw new IllegalArgumentException("Number of Decimal must between [-79228162514264337593543950335, 79228162514264337593543950335]");
        }
        this.number = number;
    }


    //binary representation: https://docs.microsoft.com/en-us/dotnet/api/system.decimal.getbits?redirectedfrom=MSDN&view=net-6.0#System_Decimal_GetBits_System_Decimal_
    public byte[] toByteArray() {
        int sign = number.signum();
        int scale = number.scale();
        byte[] unscaled = trimFront(
            sign < 0 ?
                number.unscaledValue().negate().toByteArray() :
                number.unscaledValue().toByteArray()
        );

        byte[] leArray = new byte[16];
        Arrays.fill(leArray, (byte) 0);

        leArray[15] = sign >= 0 ? 0x0: (byte)0x80;
        if (scale < 0 || scale > 28) {
            throw new IllegalStateException("Scale of Decimal must between [0,28]");
        }
        leArray[14] = (byte) scale;

        if (unscaled.length > 12) {
            throw new IllegalStateException("Unscaled value of Decimal must not exceed 12 bytes");
        }

        //unscaled is be, put it in le order
        for (int i = 0; i < unscaled.length; i++) {
            leArray[i] = unscaled[unscaled.length-1-i];
        }

        return leArray;
    }

    private byte[] trimFront(byte[] array) {
        int i = 0;
        while (i < array.length && array[i] == 0x0) {
            i++;
        }
        int trimmedLength = array.length - i;
        byte[] trimmed = new byte[trimmedLength];
        System.arraycopy(array, i, trimmed, 0, trimmedLength);
        return trimmed;
    }
}
