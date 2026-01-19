public class OrientationCheck {

    public static int orientation(Point2D a, Point2D b, Point2D c){

        int crossProduct = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);

        if (crossProduct > 0){
            return 1; // clockwise (CW)
        }else if (crossProduct < 0){
            return -1; // counter-clockwise (CCW)
        }else {
            return 0; // collinear
        }
    }


    public static void main(String[] args) {
        Point2D a = new Point2D(4, 4);
        Point2D b = new Point2D(1, 3);
        Point2D c = new Point2D(3, 2);
        Point2D d = new Point2D(4, 3);

//        int result = orientation(a, b, c);
        int result = orientation(a, d, c);

        if (result > 0) {
            System.out.println("CCW (Counter-clockwise)");
        } else if (result < 0) {
            System.out.println("CW (Clockwise)");
        } else {
            System.out.println("Collinear");
        }
    }

}
