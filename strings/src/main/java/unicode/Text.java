package unicode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Text implements CharSequenceWrapper {

    private final String string;

    public Text(int... codePoints) {
        this(new String(codePoints, 0, codePoints.length));
    }

    public Text(char c) {
        this(new String(new char[]{c}));
    }

    @Override
    public CharSequence toSrc() {
        return string;
    }

    public int codePointsCount() {
        return string.codePointCount(0, string.length());
    }

    public int bytesLength() {
        return string.getBytes().length;
    }

    public String codePointHexCode(int index) {
        return Integer.toHexString(codePointCode(index));
    }

    public int codePointCode(int index) {
        return string.codePointAt(string.offsetByCodePoints(0, index));
    }

    public String codePointString(int i) {
        return new String(new int[]{codePointCode(i)}, 0, 1);
    }

    @Override
    public String toString() {
        return string;
    }

    public String getStatistics() {
        String result = "String: \"" + string + "\"\n"
                + "Length = " + string.length() + "\n"
                + "Length in bytes = " + bytesLength() + "\n";

        int length = codePointsCount();
        for (int i = 0; i < length; i++)
            result += "Symbol №" + i + ": " + codePointHexCode(i) + " " + codePointString(i) + "\n";

        return result;
    }
}