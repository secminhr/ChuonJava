package secminhr.typing.chuontype;

public class BooleanType implements ChuonType<Boolean> {
    @Override
    public Byte[] convertToByteArray(Boolean bool) {
        if (bool) {
            return new Byte[] {0x01};
        } else {
            return new Byte[] {0x00};
        }
    }

    @Override
    public byte getTypeInByte() {
        return 0x1d;
    }
}
