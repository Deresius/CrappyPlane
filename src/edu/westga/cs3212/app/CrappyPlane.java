package edu.westga.cs3212.app;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Driver for the Crappy Plane
 * 
 * @author Team 4
 */
public class CrappyPlane extends JFrame {

	/**
	 * Generated serial for warning suppression.
	 */
	private static final long serialVersionUID = 7132358525741523930L;

	public static final String MAIN_WINDOW = "view/MainMenuView.fxml";

	public static int horizontalPixelCount = 1280;
	public static int verticalPixelCount = 720;

	public CrappyPlane() {
		initUI();
	}

	private void initUI() {
		add(new Level());

		setSize(horizontalPixelCount, verticalPixelCount);

		setResizable(false);
		// pack(); not quite sure what this does yet, seems to ignore size settings
		setTitle("CrappyPlane v0.01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	// Previous Game start code *May use later
	/*
	 * public void start(Stage primaryStage) { try { FXMLLoader loader = new
	 * FXMLLoader(); loader.setLocation(Main.class.getResource(Main.MAIN_WINDOW));
	 * loader.load(); Parent parent = loader.getRoot(); Scene scene = new
	 * Scene(parent); primaryStage.setScene(scene); primaryStage.show(); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				CrappyPlane applicationThread = new CrappyPlane();
				applicationThread.setVisible(true);
			}
		});
	}
}
