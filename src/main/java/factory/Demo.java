package factory;

class Point {
    private final double x;
    private final double y;
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static class Factory {
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        Point point = Point.Factory.newCartesianPoint(2, 3);
        System.out.println(point);

        Point point1 = Point.Factory.newPolarPoint(2, 3);
        System.out.println(point1);
    }
}
