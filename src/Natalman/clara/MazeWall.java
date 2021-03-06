package Natalman.clara;

import java.awt.*;
import java.util.Random;

/**
 * Created by TheKingNat on 4/14/16.
 */
public class MazeWall {

    //Creating a mazewall that

    private int gridX;
    private int gridY;
    private char v_or_h;  // char that is either 'v' or 'h'
    private int linelength = SnakeGame.getSquareSize();

    // Constructor
    public MazeWall() {
        Random position = new Random();
        int xLines = SnakeGame.getxSquares() - 2;
        this.gridX = position.nextInt(xLines) + 1;  // second offset, so walls appear inside game board
        int yLines = SnakeGame.getySquares() - 2;
        this.gridY = position.nextInt(yLines) + 1;
        int pickHorV = position.nextInt(2);
        if (pickHorV == 0) { this.v_or_h = 'v'; }
        else { this.v_or_h = 'h'; }
    }

    // getters for attributes
    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public char getV_or_h() {
        return v_or_h;
    }
    // end getters

    @Override
    public String toString() {
        // for now, just a debugging tool to output the values
        return "(" + this.gridX + ", " + this.gridY + ", " + this.v_or_h + ")";
    }

    // and a method to draw the wall
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        // gridX and gridY correspond to grid positions, not pixel positions.
        int xPos = this.gridX * linelength;
        int yPos = this.gridY * linelength;
        // two possibilities: a vertical wall and horizontal wall
        if (v_or_h == 'v') {
            // if vertical, x is 3px wide and y changes
            g.fillRect(xPos-1, yPos, 3, linelength);
        } else {
            // if horizontal, y is 3px wide and x changes
            g.fillRect(xPos, yPos-1, linelength, 3);
        }
    }
}
