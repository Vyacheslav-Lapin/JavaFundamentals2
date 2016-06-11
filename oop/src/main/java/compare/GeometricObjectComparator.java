package compare;

import java.util.Comparator;

public class GeometricObjectComparator implements Comparator<GeometricObject> {

    public int compare(GeometricObject o1, GeometricObject o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        return area1 < area2 ? -1 : area1 == area2 ? 0 : 1;
    }

}
