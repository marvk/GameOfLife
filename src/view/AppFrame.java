package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Marvin on 19.05.16.
 */
public class AppFrame extends JFrame implements Observer {
    public AppFrame(Controller controller) {
        super("Game of Life");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);


        JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(new AppPanel(controller), BorderLayout.SOUTH);

        JButton playPause = new JButton("Play/Pause");
        playPause.addActionListener(controller::playPause);

        buttonPanel.add(playPause);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
