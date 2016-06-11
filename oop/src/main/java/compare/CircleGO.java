package compare;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

class CircleGO extends GeometricObject {
    private double radius;

    public double getArea() {
        return PI * pow(radius, 2);
    }
}

