package dad.email;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	private Controlador controller;

	public void start(Stage primaryStage) throws Exception {
		controller = new Controlador();
		Scene scene = new Scene(controller.getView());
		primaryStage.setTitle("Enviar Email");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("file:email-send-icon-32x32.png"));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}