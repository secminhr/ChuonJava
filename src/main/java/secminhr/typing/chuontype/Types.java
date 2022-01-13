package secminhr.typing.chuontype;

import secminhr.typing.javatype.*;

public class Types {
    public final static ChuonType<UnsignedByte> Byte = new ByteType();
    public final static ChuonType<Byte> SByte = new SByteType();
    public final static ChuonType<Short> Short = new ShortType();
    public final static ChuonType<Integer> Int = new IntType();
    public final static ChuonType<Long> Long = new LongType();
    public final static ChuonType<UnsignedShort> UShort = new UShortType();
    public final static ChuonType<UnsignedInt> UInt = new UIntType();
    public final static ChuonType<UnsignedLong> ULong = new ULongType();
    public final static ChuonType<Float> Float = new FloatType();
    public final static ChuonType<Double> Double = new DoubleType();
    public final static ChuonType<Decimal> Decimal = new DecimalType();
    public final static ChuonType<Character> Char = new CharType();
    public final static ChuonType<String> String = new StringType();
    public final static ChuonType<Boolean> Boolean = new BooleanType();
}