package game;

import javax.swing.JPanel;
import java.awt.Graphics2D;

public class GameBoard extends JPanel{
    // init ball
    // init paddle
    // init breakable bricks
    // init powerups
    public BreakableBrick breakableBricks[][];
    public int initalBrickHealth =3;

    public void initBricks(int x, int y){
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                breakableBricks[i][j] = new BreakableBrick(i, j, initalBrickHealth);
            }
        }
    }

    public void placeBricks(Graphics2D g){
        for(int i=0; i<breakableBricks.length; i++){
            for(int j=0; j<breakableBricks[0].length; j++){
                breakableBricks[i][j] = new BreakableBrick(i, j, initalBrickHealth);
                // g.draw here
            }
        }
    }
    
}
