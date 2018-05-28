package application;
	
import application.GUI.DrawPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("GUI/Frame.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("GUI/application.css").toExternalForm());
			primaryStage.setScene(scene);
			Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
			primaryStage.setHeight(screenSize.getHeight());
			primaryStage.setWidth(screenSize.getWidth());
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
