package javase01.t02;

import static java.lang.Math.pow;

@SuppressWarnings("WeakerAccess")
public class MinFinder {

    private double epsilon;

    @SuppressWarnings("WeakerAccess")
    public MinFinder(double epsilon) {
        this.epsilon = epsilon;
    }

    @SuppressWarnings("WeakerAccess")
    public static double getA(int index) {
        return 1/pow(index + 1, 2);
    }

    private boolean filter(double a) {
        return a < epsilon;
    }

    @SuppressWarnings("WeakerAccess")
    public int findMin() {
        double a;
        for (int index = 1;;index++)
            if (filter(a = getA(index)))
                return index;
            else
                System.out.println(a);
    }
}
