package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainMenuController {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuController window = new MainMenuController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenuController() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblBrickBreaker = new JLabel("Brick Breaker!");
		springLayout.putConstraint(SpringLayout.NORTH, lblBrickBreaker, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblBrickBreaker, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblBrickBreaker, 0, SpringLayout.EAST, frame.getContentPane());
		lblBrickBreaker.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblBrickBreaker);
		
		JButton btnPlay = new JButton("Play!");
		springLayout.putConstraint(SpringLayout.NORTH, btnPlay, 36, SpringLayout.SOUTH, lblBrickBreaker);
		springLayout.putConstraint(SpringLayout.WEST, btnPlay, -321, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnPlay, -126, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnPlay, -126, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnPlay);
		
		JButton btnScoreboard = new JButton("Scoreboard");
		springLayout.putConstraint(SpringLayout.NORTH, btnScoreboard, 26, SpringLayout.SOUTH, btnPlay);
		springLayout.putConstraint(SpringLayout.EAST, btnScoreboard, -164, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnScoreboard);
	}
}
