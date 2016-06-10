package javase01.t02;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MinFinderTest {

    private static final double EPSILON = 0.1;

    @Test
    public void findMin() throws Exception {
        int min = new MinFinder(EPSILON).findMin();

        assertThat(min, is(3));

        System.out.println("Минимальное значение индекса = " + min);
        System.out.println("Минимальное значение, удовлетворяющее условию M = " + MinFinder.getA(min));
    }
}