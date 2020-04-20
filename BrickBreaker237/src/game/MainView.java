package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView{

	private JFrame frmBrickBreak;
	private static final int screenDim = 500;
	private static final int screenTopLeftCornerDim = 100;
	private static final int brickRow = 10;
	private static final int brickCol = 16;
	
	Paddle userPaddle = new Paddle();
	Ball userBall = new Ball();
    
	/**
	 * Sets up and launches the application.
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
		springLayout.putConstraint(SpringLayout.EAST, btnScoreboard, -170, SpringLayout.EAST, frmBrickBreak.getContentPane());
		frmBrickBreak.getContentPane().add(btnScoreboard);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openOptions();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnOptions, 76, SpringLayout.SOUTH, btnPlay);
		springLayout.putConstraint(SpringLayout.EAST, btnOptions, -180, SpringLayout.EAST, frmBrickBreak.getContentPane());
		frmBrickBreak.getContentPane().add(btnOptions);
	}
	
	/**
	 * Initialize game instance and run game
	 */
	public void openGame() {
        JFrame gameView = new JFrame();
        GameBoard gameBoard = new GameBoard(screenDim, brickRow, brickCol, userPaddle, userBall);
        gameView.setTitle("Brick Breaker");
        gameView.setBounds(screenTopLeftCornerDim, screenTopLeftCornerDim, screenDim, screenDim);
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
		scoreboardView.setBounds(screenTopLeftCornerDim, screenTopLeftCornerDim, screenDim, screenDim);
        	scoreboardView.setResizable(false);
		scoreboardView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		scoreboardView.add(scoreboard);
		
		scoreboardView.setVisible(true);
	}
	
	//converts String to Color and returns default(old) color if impossible
	public Color findColor(String newColor, Color oldColor)
	{
		Color objectColor;
		switch (newColor) {
	    case "black":
	    	objectColor = Color.BLACK;
	        break;
	    case "blue":
	    	objectColor = Color.BLUE;
	        break;
	    case "cyan":
	    	objectColor = Color.CYAN;
	        break;
	    case "gray":
	    	objectColor = Color.GRAY;
	        break;
	    case "green":
	    	objectColor = Color.GREEN;
	        break;
	    case "magenta":
	    	objectColor = Color.MAGENTA;
	    	break;
	    case "orange":
	    	objectColor = Color.ORANGE;
	        break;
	    case "red":
	    	objectColor = Color.RED;
	        break;
	    default:
	    	objectColor = oldColor;
		}
	    return objectColor;
	}
	
	//Creates options to change the Paddle and Ball Colors
	//Allows for other custom options to be created easily
	public void openOptions()
	{
		JFrame optionView = new JFrame();
		JPanel optionPanel = new JPanel();
		JButton paddleButton =new JButton("Paddle Color");
	    	JButton ballButton = new JButton("Ball Color");
	    
		String[] paddleAndBallColors = new String[] {"red", "black", "blue", "cyan", "gray", "green", "magenta", "orange"};
		JComboBox<String> paddleColors = new JComboBox<>(paddleAndBallColors);
		JComboBox<String> ballColors = new JComboBox<>(paddleAndBallColors);
		
		optionView.setSize(screenDim/2,screenDim/2);
        	optionView.setResizable(false);
		optionView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		optionPanel.add(paddleColors);
		optionPanel.add(paddleButton);
		optionPanel.add(ballColors);
		optionPanel.add(ballButton);
		
		paddleButton.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				String paddleNewColor = paddleColors.getItemAt(paddleColors.getSelectedIndex());
				userPaddle.changeColor(findColor(paddleNewColor, Color.black));
			}  
		}); 
		
		ballButton.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				String ballNewColor = ballColors.getItemAt(ballColors.getSelectedIndex());
				userBall.changeColor(findColor(ballNewColor, Color.red));
			}  
		});
		
		optionView.add(optionPanel);
		optionView.setVisible(true);
	}
}
