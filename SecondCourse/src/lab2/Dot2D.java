package lab2;

public class Dot2D {
	private float x,y;

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
	public double getDistance(Dot2D d){
        return Math.sqrt(Math.pow(this.x - d.getX(), 2) + Math.pow(this.y - d.getY(),2));
    }
}
