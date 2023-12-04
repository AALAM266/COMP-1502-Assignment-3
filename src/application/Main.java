package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * The Main class is the entry point for the application.
 * It extends the Application class and overrides the start method to initialize and display the main UI.
 * 
 * @authors Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class Main extends Application {
	/**
	 * The start method is called when the application is launched.
	 * It loads the FXML file, sets up the scene, and displays the main GUI.
	 *
	 * @param primaryStage the primary stage for the application
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/view/ToyStoreApp.fxml"));
			Scene scene = new Scene(root,1000,600);
			scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The main method is the entry point for the Java application.
	 * It launches the JavaFX application by calling the launch method.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
