package Natalman.clara;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by TheKingNat on 4/16/16.
 */
public class SnakeOption extends JFrame {
    private JPanel root;
    private JLabel setLabel;
    private JLabel sizeLabel;
    private JLabel speedLabel;
    private JLabel mazeLabel;
    private JLabel wrapLabel;
    private JRadioButton smallSizeRadioButton;
    private JRadioButton meduimSizeRadioButton;
    private JRadioButton largeSizeRadioButton;
    private JRadioButton slowRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton fastRadioButton;
    private JCheckBox wrapOnOffCheckBox;
    private JCheckBox mazeOnOffCheckBox;
    private JButton SubmitButton;

    // I have used this to create my buttonGroup
    //http://docs.oracle.com/javase/tutorial/uiswing/components/button.html#radiobutton
    //https://docs.oracle.com/javase/8/docs/api/javax/swing/ButtonGroup.html#ButtonGroup--

    private ButtonGroup SnakeSpeedBGRP = new ButtonGroup();
    private ButtonGroup ScreenSizeBGRP = new ButtonGroup();

    public SnakeOption() {
        super("Set game options");
        setContentPane(root);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        setupForm();

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                resetGameVariables();
                // to close the option window
                closeWindow();
            }
        });
    }

    private void setupForm() {

        // Establish our button groups and set default options

        // Group button for the snake speed
        SnakeOption.this.SnakeSpeedBGRP.add(slowRadioButton);
        SnakeOption.this.SnakeSpeedBGRP.add(mediumRadioButton);
        SnakeOption.this.SnakeSpeedBGRP.add(fastRadioButton);
        SnakeOption.this.SnakeSpeedBGRP.setSelected(mediumRadioButton.getModel(), true);


        //Group button for the size of the screen
        SnakeOption.this.ScreenSizeBGRP.add(smallSizeRadioButton);
        SnakeOption.this.ScreenSizeBGRP.add(meduimSizeRadioButton);
        SnakeOption.this.ScreenSizeBGRP.add(largeSizeRadioButton);
        SnakeOption.this.ScreenSizeBGRP.setSelected(smallSizeRadioButton.getModel(), true);


    }
    public void resetGameVariables() {
        // resets game variables after options have been updated
        int game_speed = Integer.parseInt(SnakeOption.this.SnakeSpeedBGRP.getSelection().getActionCommand());
        double sizeRatio = Double.parseDouble(SnakeOption.this.ScreenSizeBGRP.getSelection().getActionCommand());

        int ScreenSize = (int) ((SnakeGame. getyPixelMaxDimension() -1) * sizeRatio) + 1; // for this game, x = y
        //FINDBUGS: used setters to modify static global vars
        SnakeGame.setClockInterval(game_speed);

        SnakeGame.setxPixelMaxDimension(ScreenSize);
        SnakeGame.setyPixelMaxDimension(ScreenSize);

        SnakeGame.setWrapWall(SnakeOption.this.wrapOnOffCheckBox.isSelected());

        SnakeGame.setMazeWalls(SnakeOption.this.mazeOnOffCheckBox.isSelected());

        // and don't forget to resize the game screen, too!  Done here to take advantage of local variables.
        SnakeGame.getSnakeFrame().setSize(ScreenSize, ScreenSize);

    }

    public void closeWindow() {
        // snagged from stack overflow: http://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        SnakeGame.setGameStage(SnakeGame.BEFORE_GAME);
    }

}