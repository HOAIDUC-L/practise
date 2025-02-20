package Exercise1;

class Ball2 {
    private float x, y, z;

    public Ball2(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() { return x; }
    public float getY() { return y; }
    public float getZ() { return z; }

    public void setXYZ(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
class Player {
    private int number;
    private float x, y, z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.setX(x);
        this.setY(y);
    }

    public void move(float xDisp, float yDisp) {
        setX(getX() + xDisp);
        setY(getY() + yDisp);
    }

    public void jump(float zDisp) {
        z += zDisp;
    }

    public boolean near(Ball2 ball) {
        double distance = Math.sqrt(Math.pow(ball.getX() - getX(), 2) + Math.pow(ball.getY() - getY(), 2) + Math.pow(ball.getZ() - z, 2));
        return distance < 8;
    }

    public void kick(Ball2 ball) {
        if (near(ball)) {
            ball.setXYZ(ball.getX() + 5, ball.getY() + 5, ball.getZ()); // Giả định đá bóng đi 5 đơn vị
            System.out.println("Ball kicked!");
        } else {
            System.out.println("Ball too far to kick!");
        }
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
}
public class B37 {
    public static void main(String[] args) {
        Ball2 ball = new Ball2(0, 0, 0);
        Player player1 = new Player(7, 3, 4);
        
        System.out.println("Initial Ball Position: " + ball);
        System.out.println("Player Position: (" + player1.getX() + ", " + player1.getY() + ")");

        System.out.println("Player near ball? " + player1.near(ball));
        player1.kick(ball);
        
        player1.move(2, 3);
        System.out.println("Player moved to: (" + player1.getX() + ", " + player1.getY() + ")");
        System.out.println("Player near ball? " + player1.near(ball));
        player1.kick(ball);

        System.out.println("Final Ball Position: " + ball);
    }
}

