/*
* The GUIThread.java class holds the logic to start the GUI in its own processor thread. This allows
* The logic to run concurrently with the GUI.
*/

import javax.swing.*;

public class GUIThread extends Thread {

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
