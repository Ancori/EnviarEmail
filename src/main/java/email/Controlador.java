package email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class Controlador implements Initializable {
	Modelo model=new Modelo();
	@FXML
	private GridPane view;

	@FXML
	private TextArea mensajearea;

	@FXML
	private TextField servernametext;

	@FXML
	private TextField puertotext;

	@FXML
	private TextField emailfromtext;

	@FXML
	private TextField asuntotext;

	@FXML
	private Button enviar;

	@FXML
	private Button vaciar;

	@FXML
	private Button cancelar;

	@FXML
	private CheckBox sslcheck;

	@FXML
	private TextField emailtotext;

	@FXML
	private PasswordField contrasenatext;

	public Controlador() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		model.servidorProperty().bindBidirectional(servernametext.textProperty());
		model.puertoProperty().bindBidirectional(puertotext.textProperty());
		model.emailremitenteProperty().bindBidirectional(emailfromtext.textProperty());
		model.contrasenaProperty().bindBidirectional(contrasenatext.textProperty());
		model.emaildestinatarioProperty().bindBidirectional(emailtotext.textProperty());
		model.asuntoProperty().bindBidirectional(asuntotext.textProperty());
		model.mensajeProperty().bindBidirectional(mensajearea.textProperty());
		sslcheck.selectedProperty().bindBidirectional(model.checkboxProperty());
		

	}

	@FXML
	void oncancelar(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void onenviar(ActionEvent event){
		try {
			Email email = new SimpleEmail();
			email.setHostName(model.getServidor());
			int port=Integer.valueOf(model.getPuerto());
			email.setSmtpPort(port);
			email.setAuthenticator(new DefaultAuthenticator(model.getEmailremitente(), model.getContrasena()));
			if(model.isCheckbox()) {
				email.setSSLOnConnect(true);
			}else {
				email.setSSLOnConnect(false);
			}
			email.setFrom(model.getEmaildestinatario());
			email.setSubject(model.getAsunto());
			email.setMsg(model.getMensaje());
			email.addTo(model.getEmaildestinatario());
			email.send();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Mensaje enviado");
			alert.setHeaderText("Mensaje enviado con exito a "+model.getEmaildestinatario());
			alert.showAndWait();
		} catch ( Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se pudo enviar el email");
			alert.setContentText("Invalid message supplied");
			alert.showAndWait();
		}

	}

	@FXML
	void onvaciar(ActionEvent event) {
     model.setServidor(null);
     model.setPuerto(null);
     model.setCheckbox(false);
     model.setEmailremitente(null);
     model.setContrasena(null);
     model.setEmaildestinatario(null);
     model.setAsunto(null);
     model.setMensaje(null);
	}

	public GridPane getView() {
		return view;
	}

}
