package application.GUI;

import application.Daten.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class DrawPane extends Pane{
	
	private Canvas canvas;
	private GraphicsContext gc;
	
	public void kreisMalen(Player player) {
        gc.setFill(player.getColor());
        System.out.println(player.getColor());
        gc.fillOval(player.getPosX(), player.getPosY(), player.getSize(), player.getSize());
        //Paint p = gc.getFill();
        //if (p instanceof Color) {
        //	System.out.println(p);
        //}
        System.out.println(canvas.getLayoutX());
	}
	
	public void init() {
		canvas = new Canvas(getWidth(), getHeight());
		gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);
	}
}
