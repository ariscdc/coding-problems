package com.ariscdc.coding.problem.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160130 2030-2050 (20 mins.)
 */
public class PointsWithinRange {

    private PointsWithinRange() {}

    public static List<Point> getPointsWithinRange(List<Point> allPoints, Point source, int distance) {

        List<Point> points = new ArrayList<>();
        if (allPoints == null || allPoints.isEmpty() || distance < 0) return points;

        for (Point point: allPoints) {
            if (point.getDistance(source) <= distance && !point.equals(source)) {
                points.add(point);
            }
        }
        return points;
    }

    public static void main(String[] args) {

        Point point_0_0 = new Point(0, 0);
        Point point_0_5 = new Point(0, 5);
        Point point_2_2 = new Point(2, 2);
        Point point_9_6 = new Point(9, 6);
        Point point_3_4 = new Point(3, 4);

        List<Point> allPoints = Arrays.asList(point_0_0, point_0_5, point_2_2, point_3_4, point_9_6);
        List<Point> distantPoints = getPointsWithinRange(allPoints, point_2_2, 2);

        for (Point point: distantPoints) {
            System.out.println(point);
        }
    }

    private static class Point {

        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance(Point other) {
            return other != null
                    ? (int) Math.sqrt(Math.pow(other.getX() - x, 2) + Math.pow(other.getY() - y, 2))
                    : 0;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point other = (Point) o;
            return x == other.getX() && y == other.getY();
        }

        @Override
        public String toString() {
            return "Point{x=" + x + "," + "y=" + y + "}";
        }
    }
}
