package edu.westga.cs3212.app;

import javax.swing.JFrame;

public class Main /*extends Application*/ {

	public static final String MAIN_WINDOW = "view/MainMenuView.fxml";

	
	
	//Display Resolution / Window Boundaries
	public static Display f = new Display();
	public static int horizontalPixelCount = 1280;
	public static int verticalPixelCount = 720;
	
		
	//Previous Game start code *May use later
	/*public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.MAIN_WINDOW));
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public static void main(String[] args) {
		//launch(args);
		
		f.setSize(horizontalPixelCount, verticalPixelCount);
		f.setResizable(false); //Resizing screens mid game can cause game-play anomalies. 
		f.setVisible(true);
		
		//TODO: Set Full-screen
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Crappy Plane v0.01");
		f.setLocationRelativeTo(null); //Centers the screen on start.
	}

}
