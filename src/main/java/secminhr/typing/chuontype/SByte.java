package secminhr.typing.chuontype;

class SByte implements ChuonType<Byte> {

    @Override
    public Byte[] convertToByteArray(Byte number) {
        return new Byte[] { number };
    }

    @Override
    public byte getTypeInByte() {
        return 0x11;
    }
}