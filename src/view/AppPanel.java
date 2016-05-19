package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Marvin on 19.05.16.
 */
public class AppPanel extends JPanel {
    private final Controller controller;

    public AppPanel(Controller controller) {
        this.controller = controller;

        MouseAdapter mouseAdapter = new MouseAdapter() {
            private boolean action;

            @Override
            public void mousePressed(MouseEvent e) {
                action = !controller.get(e.getX()/controller.SCALE, e.getY()/controller.SCALE);
                mouseDragged(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                controller.set(e.getX()/controller.SCALE, e.getY()/controller.SCALE, action);
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(controller.WIDTH * controller.SCALE, controller.HEIGHT * controller.SCALE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < controller.HEIGHT; i++) {
            for (int j = 0; j < controller.WIDTH; j++) {
                int x = j*controller.SCALE;
                int y = i*controller.SCALE;

                g2.setColor(controller.get(j, i) ? Color.GREEN : Color.LIGHT_GRAY);
                g2.fillRect(x, y, controller.SCALE, controller.SCALE);
                g2.setColor(Color.BLACK);
                g2.drawRect(x, y, controller.SCALE, controller.SCALE);
            }
        }
    }
}
