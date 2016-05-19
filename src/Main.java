import controller.Controller;
import view.AppFrame;

import java.awt.*;

/**
 * Created by Marvin on 19.05.16.
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(40, 40, 10);

        EventQueue.invokeLater(() -> {
            AppFrame frame = new AppFrame(controller);
            frame.setVisible(true);

            controller.addObserver(frame);
        });
    }
}
