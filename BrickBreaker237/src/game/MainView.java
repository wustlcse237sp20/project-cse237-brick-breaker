package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView {

	private JFrame frmBrickBreak;
    private static final int screenDim = 500;
    private static final int brickRow = 4;
    private static final int brickCol = 10;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frmBrickBreak.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrickBreak = new JFrame();
		frmBrickBreak.setTitle("Brick Breaker");
		frmBrickBreak.setBounds(100, 100, 450, 300);
		frmBrickBreak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmBrickBreak.getContentPane().setLayout(springLayout);
		
		JLabel lblBrickBreaker = new JLabel("Brick Breaker!");
		springLayout.putConstraint(SpringLayout.NORTH, lblBrickBreaker, 0, SpringLayout.NORTH, frmBrickBreak.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblBrickBreaker, 0, SpringLayout.WEST, frmBrickBreak.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblBrickBreaker, 0, SpringLayout.EAST, frmBrickBreak.getContentPane());
		lblBrickBreaker.setHorizontalAlignment(SwingConstants.CENTER);
		frmBrickBreak.getContentPane().add(lblBrickBreaker);
		
		JButton btnPlay = new JButton("Play!");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openGame();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnPlay, 36, SpringLayout.SOUTH, lblBrickBreaker);
		springLayout.putConstraint(SpringLayout.WEST, btnPlay, -321, SpringLayout.EAST, frmBrickBreak.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnPlay, -126, SpringLayout.SOUTH, frmBrickBreak.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnPlay, -126, SpringLayout.EAST, frmBrickBreak.getContentPane());
		frmBrickBreak.getContentPane().add(btnPlay);
		
		JButton btnScoreboard = new JButton("Scoreboard");
		btnScoreboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openScoreboard();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnScoreboard, 26, SpringLayout.SOUTH, btnPlay);
		springLayout.putConstraint(SpringLayout.EAST, btnScoreboard, -164, SpringLayout.EAST, frmBrickBreak.getContentPane());
		frmBrickBreak.getContentPane().add(btnScoreboard);
	}
	
	public void openGame() {
        JFrame gameView = new JFrame();
        GameBoard gameBoard = new GameBoard(screenDim, brickRow, brickCol);
        gameView.setTitle("Brick Breaker");
        gameView.setBounds(0, 0, 500, 500);
		gameView.setResizable(false);
        gameView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        gameView.getContentPane().add(gameBoard);

        gameView.setVisible(true);
        
        gameBoard.runGame();
	}
	
	public void openScoreboard() {
		// TODO: Replace current content with scoreboard
		JFrame scoreboardView = new JFrame();
		ScoreboardView scoreboard = new ScoreboardView();
		scoreboardView.setTitle("Brick Breaker");
		scoreboardView.setBounds(0, 0, 500, 500);
        scoreboardView.setResizable(false);
		scoreboardView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		scoreboardView.add(scoreboard);
		
		scoreboardView.setVisible(true);
	}
}
