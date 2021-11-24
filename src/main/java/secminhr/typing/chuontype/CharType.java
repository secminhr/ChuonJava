package secminhr.typing.chuontype;

public class CharType implements ChuonType<Character> {
    @Override
    public Byte[] convertToByteArray(Character number) {
        return new Byte[] { (byte) number.charValue() };
    }

    @Override
    public byte getTypeInByte() {
        return 0x1B;
    }
}
