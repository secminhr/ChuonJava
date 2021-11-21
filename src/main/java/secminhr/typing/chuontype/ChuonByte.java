package secminhr.typing.chuontype;

import secminhr.typing.javatype.UnsignedByte;

//Add Chuon prefix to distinguish from java.lang.Byte
class ChuonByte implements ChuonType<UnsignedByte> {
    @Override
    public Byte[] convertToByteArray(UnsignedByte number) {
        return new Byte[]{number.getNumberInByte()};
    }

    @Override
    public byte getTypeInByte() {
        return 0x10;
    }
}
