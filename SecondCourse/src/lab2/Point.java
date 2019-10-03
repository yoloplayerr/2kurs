package lab2;

public class Point {
	private float x,y;
	
	public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	public double getDistance(Point d){
        return Math.sqrt(Math.pow(this.x - d.getX(), 2) + Math.pow(this.y - d.getY(),2));
    }
}
