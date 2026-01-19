import java.util.Arrays;

/**
 * Intersection of two sets.Given two arrays a[] and b[],
 * each containingn distinct 2D points in the plane,
 * design a subquadratic algorithm
 * to count the number of points that are contained both in array a[] and array b[].
 * */

public class IntersectionOfSets {

    public static int countIntersection(Point2D[] a, Point2D[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = 0;
        int couter = 0;
        while (i < a.length && j < b.length){
            if (a[i].compareTo(b[j]) == 0){
                couter++;
                i++;
                j++;
            } else if (a[i].compareTo(b[j]) < 0) {
                i++;
            } else {
                j++;
            }
        }
        return couter;
    }

    public static void main(String[] args) {
        Point2D[] a = {new Point2D(1, 2), new Point2D(3, 4), new Point2D(5, 6)};
        Point2D[] b = {new Point2D(3, 4), new Point2D(7, 8)};

        int intersectionCount = countIntersection(a, b);
        System.out.println("Number of points in intersection: " + intersectionCount);
    }

}
