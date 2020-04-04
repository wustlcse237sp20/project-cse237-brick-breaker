package game;

import javax.swing.JPanel;

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
    
}
