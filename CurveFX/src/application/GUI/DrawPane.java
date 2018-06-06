package application.GUI;

import java.util.Collection;

import application.Daten.Player;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class DrawPane extends Pane{
	
	private Canvas canvas;
	private GraphicsContext gc;
	private WritableImage img;
	
	public void kreisMalen(Player player) {
        gc.setFill(player.getColor());
        gc.fillOval(player.getPosX(), player.getPosY(), player.getSize(), player.getSize());
        //Paint p = gc.getFill();
        //if (p instanceof Color) {
        //	System.out.println(p);
        //}
	}
	
	public void init() {
		img = new WritableImage((int) getWidth(), (int) getHeight());
		getChildren().add(new ImageView(img));
		//canvas = new Canvas(getWidth(), getHeight());
		//gc = canvas.getGraphicsContext2D();
		//getChildren().addAll(img);
	}
	
	public void kreisErstellen(Player player) {
		
	}
	
	public void getHuesCircle(int width, int height) {
	    PixelWriter pixelWriter = img.getPixelWriter();
	    Point2D center = new Point2D((double) width / 2, (double) height / 2);
	    double rsmall = 0.8 * width / 2;
	    double rbig = (double) width / 2;

	    for (int y = 0; y < height; y++) {
	        for (int x = 0; x < width; x++) {
	            double dx = x - center.getX();
	            double dy = y - center.getY();
	            double distance = Math.sqrt((dx * dx) + (dy * dy));
	            if (distance < rbig) {
	                pixelWriter.setColor(x, y, Color.RED);
	            }
	        }
	    }
	}
}
