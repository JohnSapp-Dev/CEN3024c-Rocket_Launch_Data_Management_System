import javax.swing.*;

/**
 * The GUIThread.java class holds the logic to start the GUI in its own processor thread. This allows
 * the logic to run concurrently with the GUI.
 */
public class GUIThread extends Thread {
/**
 * Calls the constructGUI to start the GUI
* */
    public void run(){
        System.out.println("GUI thread started");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            //runs the GUI on its own thread
            public void run() {
                RocketGUI.constructGUI();
            }
        });
    }
}
