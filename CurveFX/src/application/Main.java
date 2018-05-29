package application;
	
import application.Daten.KeyHandler;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
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
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    @Override
			    public void handle(WindowEvent t) {
			        Platform.exit();
			        System.exit(0);
			    }
			});
			
			KeyHandler keyHandler = new KeyHandler(scene);
			
			
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
