package lab2;

import java.util.ArrayList;

public class Line {
    private ArrayList<Point> list;
    private int countOfpoints;

    Line(Point point){
        list = new ArrayList<>();
        list.add(point);
        countOfpoints = 1;
    }

   Line(Point[] points){
        list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            list.add(points[i]);
        }
        countOfpoints = points.length;
    }

    public void addpoint(Point point)
    {
        list.add(point);
        countOfpoints++;
    }

    public double length(){
        double res = 0;
        for (int i = 0; i < countOfpoints-1; i++) {
            res+= list.get(i).getDistance(list.get(i+1));
        }
        return res;
    }

    public int getCountOfpoints(){
        return countOfpoints;
    }
}
