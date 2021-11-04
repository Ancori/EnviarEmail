package dad.email;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Modelo {
	
	private StringProperty servidor=new SimpleStringProperty();
	private StringProperty puerto=new SimpleStringProperty();
	private StringProperty emailremitente=new SimpleStringProperty();
	private StringProperty contrasena=new SimpleStringProperty();
	private StringProperty emaildestinatario=new SimpleStringProperty();
	private StringProperty asunto=new SimpleStringProperty();
	private StringProperty mensaje=new SimpleStringProperty();
	private BooleanProperty checkbox = new SimpleBooleanProperty();
	
	public StringProperty servidorProperty() {
		return this.servidor;
	}
	
	public String getServidor() {
		return this.servidorProperty().get();
	}
	
	public void setServidor(final String servidor) {
		this.servidorProperty().set(servidor);
	}
	
	public StringProperty puertoProperty() {
		return this.puerto;
	}
	
	public String getPuerto() {
		return this.puertoProperty().get();
	}
	
	public void setPuerto(final String puerto) {
		this.puertoProperty().set(puerto);
	}
	
	public StringProperty emailremitenteProperty() {
		return this.emailremitente;
	}
	
	public String getEmailremitente() {
		return this.emailremitenteProperty().get();
	}
	
	public void setEmailremitente(final String emailremitente) {
		this.emailremitenteProperty().set(emailremitente);
	}
	
	public StringProperty contrasenaProperty() {
		return this.contrasena;
	}
	
	public String getContrasena() {
		return this.contrasenaProperty().get();
	}
	
	public void setContrasena(final String contrasena) {
		this.contrasenaProperty().set(contrasena);
	}
	
	public StringProperty emaildestinatarioProperty() {
		return this.emaildestinatario;
	}
	
	public String getEmaildestinatario() {
		return this.emaildestinatarioProperty().get();
	}
	
	public void setEmaildestinatario(final String emaildestinatario) {
		this.emaildestinatarioProperty().set(emaildestinatario);
	}
	
	public StringProperty asuntoProperty() {
		return this.asunto;
	}
	
	public String getAsunto() {
		return this.asuntoProperty().get();
	}
	
	public void setAsunto(final String asunto) {
		this.asuntoProperty().set(asunto);
	}
	
	public StringProperty mensajeProperty() {
		return this.mensaje;
	}
	
	public String getMensaje() {
		return this.mensajeProperty().get();
	}
	
	public void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}
	
	public BooleanProperty checkboxProperty() {
		return this.checkbox;
	}
	
	public boolean isCheckbox() {
		return this.checkboxProperty().get();
	}
	
	public void setCheckbox(final boolean checkbox) {
		this.checkboxProperty().set(checkbox);
	}
	
	
	
	

}
