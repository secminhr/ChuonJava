package secminhr.typing.chuontype;

import secminhr.typing.javatype.Decimal;

import static secminhr.typing.ByteArrayHelper.boxingByteArray;

public class DecimalType implements ChuonType<Decimal> {
    @Override
    public Byte[] convertToByteArray(Decimal number) {
        return boxingByteArray(number.toByteArray());
    }

    @Override
    public byte getTypeInByte() {
        return 0x1A;
    }
}
