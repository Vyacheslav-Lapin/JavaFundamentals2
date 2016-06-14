package unicode;

import com.epam.courses.jf.common.Wrapper;

@FunctionalInterface
public interface CharSequenceWrapper extends CharSequence, Wrapper<CharSequence> {
    @Override
    default int length() {
        return toSrc().length();
    }

    @Override
    default char charAt(int index) {
        return toSrc().charAt(index);
    }

    @Override
    default CharSequence subSequence(int start, int end) {
        return toSrc().subSequence(start, end);
    }
}
