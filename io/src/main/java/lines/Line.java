package lines;

import java.io.*;

public class Line implements java.io.Serializable {
    private Point point1;
    private Point point2;
    private int index;

    public Line() {
        System.out.println("Constructing empty line");
    }

    public Line(Point p1, Point p2, int index) {
        System.out.println("Constructing line: "
                + index);
        this.point1 = p1;
        this.point2 = p2;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int newIndex) {
        index = newIndex;
    }
    public void printInfo() {
        System.out.println("Line: " + index);
        System.out.println(" Object reference: "
                + super.toString());
        System.out.println(" from point "
                + point1);
        System.out.println(" to point "
                + point2);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(2.0, 2.0);
        Point p3 = new Point(3.0, 3.0);
        Line line1 = new Line(p1, p2, 1);
        Line line2 = new Line(p2, p3, 2);

        System.out.println("line 1 = " + line1);
        System.out.println("line 2 = " + line2);
        String fileName = "file";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(line1);
        oos.reset();
        line1.setIndex(3);
        oos.writeObject(line1);
        oos.close();

        System.out.println("Read objects:");
        FileInputStream is = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(is);

        while (is.available() > 0) {
            Line line = (Line) ois.readObject();
            line.printInfo();
        }
    }
}

