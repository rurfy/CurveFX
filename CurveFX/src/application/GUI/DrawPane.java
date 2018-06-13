package application.GUI;

import java.util.Collection;

import application.Daten.Player;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DrawPane extends Pane {

	private Canvas canvas;
	private GraphicsContext gc;
	private WritableImage img;

	public void kreisMalen(Player player) {
		gc.setFill(player.getColor());
		gc.fillOval(player.getPosX(), player.getPosY(), player.getSize(), player.getSize());
	}

	public void init() {
		img = new WritableImage((int) getWidth(), (int) getHeight());
		getChildren().add(new ImageView(img));
		canvas = new Canvas(getWidth(), getHeight());
		gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);

	}

	public void kreisZeichnen(Player player) {
        PixelWriter pixelWriter = img.getPixelWriter();
        int x0 = (int) player.getPosX();
        int y0 = (int) player.getPosY();
        int radius = player.getSize()/2;
        int discriminant = (3 - radius<<2)>>2;
        int i = 0, j = radius;
        while(i<=j){
            geradeLinieZeichnen(pixelWriter, player.getColor(), x0+i, y0-j, x0-i, y0-j);
            geradeLinieZeichnen(pixelWriter, player.getColor(), x0+j, y0-i, x0-j, y0-i);
            geradeLinieZeichnen(pixelWriter, player.getColor(), x0+i, y0+j, x0-i, y0+j);
            geradeLinieZeichnen(pixelWriter, player.getColor(), x0+j, y0+i, x0-j, y0+i);
            i++;
            if(discriminant<0) {
                discriminant += (i<<1) + 1;
            }else {
                j--;
                discriminant += (1 + i - j)<<1;
            }
        }
    }

    public void geradeLinieZeichnen(PixelWriter pixelWriter, Color color, int x1, int y1, int x2, int y2){
        if(x1==x2) {
            if(y1>y2) {
                for(int i=y2;i<=y1;i++) {
                    pixelWriter.setColor(x1, i, color);
                }
            } else {
                for(int i=y1;i<=y2;i++) {
                    pixelWriter.setColor(x1, i, color);
                }
            }
        } else if(y1==y2) {
            if(x1>x2) {
                for(int i=x2;i<=x1;i++) {
                    pixelWriter.setColor(i, y1, color);
                }
            } else {
                for(int i=x1;i<=x2;i++) {
                    pixelWriter.setColor(i, y1, color);
                }
            }
        }
    }
}
