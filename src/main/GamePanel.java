package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private KeyboardInputs keyboardInputs;
    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game) {

        this.game = game;

        keyboardInputs = new KeyboardInputs(this);
        mouseInputs = new MouseInputs(this);

        setPanelSize();

        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,720);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.render(g);

        Toolkit.getDefaultToolkit().sync();

    }

    public Game getGame() {
        return game;
    }
}
