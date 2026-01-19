import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
    private List<LineSegment> segmentsList = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Points array is null");
        }

        int n = points.length;
        Point[] pointsCopy = Arrays.copyOf(points, n);

        for (int i = 0; i < n; i++) {
            if (pointsCopy[i] == null) {
                throw new IllegalArgumentException("Point is null");
            }

            Arrays.sort(pointsCopy);
            Arrays.sort(pointsCopy, pointsCopy[i].slopeOrder());

            int collinearCount = 1;
            for (int j = 1; j < n; j++) {
                if (j == n - 1 || pointsCopy[0].slopeTo(pointsCopy[j]) != pointsCopy[0].slopeTo(
                        pointsCopy[j + 1])) {
                    if (collinearCount >= 3
                            && pointsCopy[0].compareTo(pointsCopy[j - collinearCount + 1]) < 0) {
                        segmentsList.add(new LineSegment(pointsCopy[0], pointsCopy[j]));
                    }
                    collinearCount = 1;
                }
                else {
                    collinearCount++;
                }
            }
        }
    }

    public int numberOfSegments() {
        return segmentsList.size();
    }

    public LineSegment[] segments() {
        return segmentsList.toArray(new LineSegment[segmentsList.size()]);
    }
}
