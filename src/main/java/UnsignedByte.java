public class UnsignedByte {
    private final short number;

    public UnsignedByte(int number) {
        if (number < 0 || number > 255) {
            throw new IllegalArgumentException("Number of UnsignedByte should between [0,255]");
        }
        //int between 0 and 255 can be safely cast to short
        this.number = (short) number;
    }

    public byte getNumberInByte() {
        return (byte) number;
    }
}
