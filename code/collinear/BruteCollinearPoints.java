/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private List<LineSegment> segmentsList = new ArrayList<>();

    // finds all line segments containing 4 points in a bunch of points
    // collinear condition: slop equals in
    public BruteCollinearPoints(Point[] points) {

        if (points == null) {
            throw new IllegalArgumentException("Point[] points is Empty !");
        }

        int size = points.length;
        for (int i = 0; i < size; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("Point is null");
            }
            for (int j = i + 1; j < size; j++) {
                if (points[j] == null) {
                    throw new IllegalArgumentException("Point is null");
                }
                for (int k = j + 1; k < size; k++) {
                    if (points[k] == null) {
                        throw new IllegalArgumentException("Point is null");
                    }
                    for (int l = k + 1; l < size; l++) {
                        double slope1 = points[i].slopeTo(points[j]);
                        double slope2 = points[i].slopeTo(points[k]);
                        double slope3 = points[i].slopeTo(points[l]);

                        if (Double.compare(slope1, slope2) == 0
                                && Double.compare(slope1, slope3) == 0) {
                            Point[] collinearPoints = {
                                    points[i], points[j], points[k], points[l]
                            };
                            Arrays.sort(collinearPoints);
                            segmentsList.add(
                                    new LineSegment(collinearPoints[0], collinearPoints[3]));
                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segmentsList.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return segmentsList.toArray(new LineSegment[segmentsList.size()]);
    }
    
}
