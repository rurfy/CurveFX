package application.Daten;

public class Player {

	private int size = 10; //Nur Beispielwerte
	private String name = "";
	private double speed = 1;
	private double angle = 0;
	private double turnRadius = 100;

	private double posX = 500;
	private double posY = 500;
	
	public Player() {
		
	}
	
	public double getTurnRadius() {
		return turnRadius;
	}

	public void setTurnRadius(double turnRadius) {
		this.turnRadius = turnRadius;
	}
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void move() {

		if (isLeft()) {
			angle--;
		}
		if (isRight()) {
			angle++;
		}
		posX += Math.sin(Math.toRadians(angle));
		posY += Math.cos(Math.toRadians(angle));
	}
	
	private boolean isLeft() {
		return left;
	}
	
	private boolean isRight() {
		return right;
	}

}
