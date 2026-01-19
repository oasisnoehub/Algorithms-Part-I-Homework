
public class Point2D implements Comparable<Point2D>{
    int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point2D that) {
        if (this.x == that.x){
            return this.y - that.y;
        }
        return this.x - that.x;
    }
}
