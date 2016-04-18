package Natalman.clara;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by clara. Handles key presses that affect the snake.
 */
public class SnakeControls implements KeyListener {

    Snake snake;

    SnakeControls(Snake s){
        this.snake = s;
    }

    @Override
    public void keyPressed(KeyEvent ev) {

        if (ev.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.snakeDown();
        }
        if (ev.getKeyCode() == KeyEvent.VK_UP) {
            snake.snakeUp();
        }
        if (ev.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.snakeLeft();
        }
        if (ev.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.snakeRight();
        }

    }

    @Override
    public void keyTyped(KeyEvent ev) {
        // This is to create a set up for the user if he needs to customize the snake
        char keyPressed = ev.getKeyChar();
        char o = 's';

        // making the user to customize game settings before starting play.
        if (keyPressed == o ) {
            // If 'o' is typed, present the options menu.

            SnakeGame.setGameStage(SnakeGame.SET_OPTIONS);
            SnakeOption setup = new SnakeOption();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
