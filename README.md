# BrickBreaker #

## Description ##

BrickBreaker is a 2D game where the player must deflect a bouncing ball with a paddle to hit and break bricks. The paddle moves horizontally, and the player loses if the ball slips past the paddle. When all the bricks have been broken, the player can advance to a harder level. The bricks get progressively harder to break.

## Iteration 1 ##

What user stories were completed this iteration?

	In this iteration, we completed the basic functionality of BrickBreaker by setting up a game board, paddle, ball, and bricks. In addition, we also have a menu and highscore. The bricks can be colorized so the game aesthetic is appealing, and the menu/high score serves the purpose of easing the user into the game and giving them a goal to keep track of/surpass, respectively.

What user stories do you intend to complete next iteration?

	In the next iteration, we would like to satisfy users by introducing levels and special bricks. These bricks will have special abilities (such as requiring more hits before it breaks), so the user will feel challenged and entertained. They will be introduced in harder levels that the user can reach so that the user feels a sense of accomplishment. We may also plan to allow the user to customize the game, so that the bricks/ball/paddle will respond more sensitively and/or be given the user's color of choice.

Is there anything that you implemented but doesn't currently work?

	Special brick types. We also implemented the ability for the player to chose his paddle color but there is currently no prompt for them to do so.

What commands are needed to compile and run your code from the command line?

	From the project folder, run the script runBrickBreaker.sh by typing ./runBrickBreaker.sh in the command line. This should compile and launch the game (assuming java is installed).

## Iteration 2 ##

What user stories were completed this iteration?

	For this iteration, we continued to implement functionality of the game. The paddle is now able to move and the ball reacts with its surroundings accordingly. We've implmented bricks that will break upon multiple hits, and introduced a color scheme to represent how many hits are required. There is also a power up that can be hit by the bowl which will grant 2x damage on the next brick hit. We also allowed the user the ability to change the color of the ball and paddle.

What user stories do you intend to complete next iteration?

	By the next iteration, we hope to completely set up a level system with increasing difficulty. In addition, we would like to add UI features and options to make the game more comfortable to interact with. The paddle controls will be changed to become more responsive, and the ball reflected more accurately. Also remove the brick outline after it's destroyed
	
Is there anything that you implemented but doesn't currently work?

	Yes, the game does not end when the ball is missed by the paddle. It merely bounces back and keeps going. We intend to finish this after implmenting levels
