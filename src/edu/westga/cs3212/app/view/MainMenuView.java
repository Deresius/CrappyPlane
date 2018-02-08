package edu.westga.cs3212.app.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuView {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button quickStartButton;

	@FXML
	private Button loadButton;

	@FXML
	private Button startButton;

	@FXML
	private Button exitButton;

	@FXML
	void initialize() {
		assert quickStartButton != null : "fx:id=\"quickStartButton\" was not injected: check your FXML file 'MainMenuView.fxml'.";
		assert loadButton != null : "fx:id=\"loadButton\" was not injected: check your FXML file 'MainMenuView.fxml'.";
		assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'MainMenuView.fxml'.";
		assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'MainMenuView.fxml'.";

	}
}
