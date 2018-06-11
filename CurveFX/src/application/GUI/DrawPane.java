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
		PixelReader pixelReader = img.getPixelReader();
		Point2D center = new Point2D((double) player.getSize() / 2, (double) player.getSize() / 2);
		for (int y = 0; y < player.getSize(); y++) {
			for (int x = 0; x < player.getSize(); x++) {
				double dx = x - center.getX();
				double dy = y - center.getY();
				double distance = Math.sqrt((dx * dx) + (dy * dy));
				if (distance <= player.getSize() / 2) {
					pixelWriter.setColor(x + (int) player.getPosX(), y + (int) player.getPosY(), player.getColor());

				} else if (distance > player.getSize() / 2 && distance <= player.getSize() / 2 + 0.2 && pixelReader.getColor(x + (int) player.getPosX(), y + (int) player.getPosY()) != Color.BLUE) {
					pixelWriter.setColor(x + (int) player.getPosX(), y + (int) player.getPosY(), new Color(player.getColor().getRed(),
							player.getColor().getGreen(), player.getColor().getBlue(), player.getColor().getOpacity() - 0.2));

				} else if (distance > player.getSize() / 2 + 0.2 && distance <= player.getSize() / 2 + 0.4 && pixelReader.getColor(x + (int) player.getPosX(), y + (int) player.getPosY()) != Color.BLUE) {
					pixelWriter.setColor(x + (int) player.getPosX(), y + (int) player.getPosY(), new Color(player.getColor().getRed(),
							player.getColor().getGreen(), player.getColor().getBlue(), player.getColor().getOpacity() - 0.4));

				} else if (distance > player.getSize() / 2 + 0.4 && distance <= player.getSize() / 2 + 0.6 && pixelReader.getColor(x + (int) player.getPosX(), y + (int) player.getPosY()) != Color.BLUE) {
					pixelWriter.setColor(x + (int) player.getPosX(), y + (int) player.getPosY(), new Color(player.getColor().getRed(),
							player.getColor().getGreen(), player.getColor().getBlue(), player.getColor().getOpacity() - 0.6));

				} else if (distance > player.getSize() / 2 + 0.6 && distance <= player.getSize() / 2 + 0.8 && pixelReader.getColor(x + (int) player.getPosX(), y + (int) player.getPosY()) != Color.BLUE) {
					pixelWriter.setColor(x + (int) player.getPosX(), y + (int) player.getPosY(), new Color(player.getColor().getRed(),
							player.getColor().getGreen(), player.getColor().getBlue(), player.getColor().getOpacity() - 0.8));
				}
			}
		}
	}
}
