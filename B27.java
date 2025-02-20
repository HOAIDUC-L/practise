package Exercise1;

class MyLine {
    private MyPoint begin;
    private MyPoint end;

    public MyLine(int x1, int y1, int x2, int y2) {
        this.begin = new MyPoint(x1, y1);
        this.end = new MyPoint(x2, y2);
    }

    public MyLine(MyPoint begin, MyPoint end) {
        this.begin = begin;
        this.end = end;
    }

    public MyPoint getBegin() {
        return begin;
    }

    public void setBegin(MyPoint begin) {
        this.begin = begin;
    }

    public MyPoint getEnd() {
        return end;
    }

    public void setEnd(MyPoint end) {
        this.end = end;
    }

    public int getBeginX() {
        return begin.getX();
    }

    public void setBeginX(int x) {
        begin.setX(x);
    }

    public int getBeginY() {
        return begin.getY();
    }

    public void setBeginY(int y) {
        begin.setY(y);
    }

    public int getEndX() {
        return end.getX();
    }

    public void setEndX(int x) {
        end.setX(x);
    }

    public int getEndY() {
        return end.getY();
    }

    public void setEndY(int y) {
        end.setY(y);
    }

    public int[] getBeginXY() {
        return begin.getXY();
    }

    public void setBeginXY(int x, int y) {
        begin.setXY(x, y);
    }

    public int[] getEndXY() {
        return end.getXY();
    }

    public void setEndXY(int x, int y) {
        end.setXY(x, y);
    }

    public double getLength() {
        return begin.distance(end);
    }

    public double getGradient() {
        int xDiff = end.getX() - begin.getX();
        int yDiff = end.getY() - begin.getY();
        return Math.atan2(yDiff, xDiff);
    }

    @Override
    public String toString() {
        return "MyLine[begin=" + begin + ",end=" + end + "]";
    }
}

public class B27 {
    public static void main(String[] args) {
        
        MyLine line1 = new MyLine(1, 2, 3, 4);
        System.out.println(line1);

        MyPoint p1 = new MyPoint(5, 6);
        MyPoint p2 = new MyPoint(7, 8);
        MyLine line2 = new MyLine(p1, p2);
        System.out.println(line2);

       
        System.out.println("Begin: " + line1.getBegin());
        System.out.println("End: " + line1.getEnd());

        line1.setBegin(new MyPoint(9, 10));
        line1.setEnd(new MyPoint(11, 12));
        System.out.println("After set: " + line1);

        System.out.println("BeginX: " + line1.getBeginX());
        System.out.println("BeginY: " + line1.getBeginY());
        System.out.println("EndX: " + line1.getEndX());
        System.out.println("EndY: " + line1.getEndY());

        
        System.out.println("Length: " + line1.getLength());
        System.out.println("Gradient: " + line1.getGradient());
    }
}
