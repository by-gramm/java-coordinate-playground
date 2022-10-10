package domain;

import java.util.List;

public class Triangle extends AbstractShape {

    private Triangle(List<Point> points) {
        super(points);
    }

    public static Triangle of(List<Point> points) {
        checkColinear(points);
        return new Triangle(points);
    }

    private static void checkColinear(List<Point> points) {
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        Point pointC = points.get(2);

        pointA.checkColinear(pointB, pointC);
    }

    @Override
    public double getArea() {
        Point pointA = getPoints().get(0);
        Point pointB = getPoints().get(1);
        Point pointC = getPoints().get(2);

        double distanceA = pointA.getDistance(pointB);
        double distanceB = pointB.getDistance(pointC);
        double distanceC = pointC.getDistance(pointA);

        return calculateArea(distanceA, distanceB, distanceC);
    }

    private double calculateArea(double distanceA, double distanceB, double distanceC) {
        double s = (distanceA + distanceB + distanceC) / 2;

        return Math.sqrt(s * (s - distanceA) * (s - distanceB) * (s - distanceC));
    }

    @Override
    public String getType() {
        return "삼각형";
    }
}
