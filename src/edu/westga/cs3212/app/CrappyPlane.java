package edu.westga.cs3212.app;

import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.westga.cs3212.app.model.Level;

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

	public CrappyPlane() {
		initUI();
	}

	private void initUI() {
		Level level = new Level();
		add(level);

		setSize(level.getWidth(), level.getHeight());
		System.out.println(this.getSize());
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//setUndecorated(true);

		setResizable(false);
		// pack(); not quite sure what this does yet, seems to ignore size settings
		setTitle("CrappyPlane v0.01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

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
