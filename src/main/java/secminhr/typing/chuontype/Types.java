package secminhr.typing.chuontype;

import secminhr.typing.javatype.UnsignedByte;
import secminhr.typing.javatype.UnsignedInt;
import secminhr.typing.javatype.UnsignedShort;

public class Types {
    public final static ChuonType<UnsignedByte> Byte = new ChuonByte();
    public final static ChuonType<java.lang.Byte> SByte = new SByte();
    public final static ChuonType<java.lang.Short> Short = new Short();
    public final static ChuonType<Integer> Int = new Int();
    public final static ChuonType<java.lang.Long> Long = new Long();
    public final static ChuonType<UnsignedShort> UShort = new UShort();
    public final static ChuonType<UnsignedInt> UInt = new UInt();
}