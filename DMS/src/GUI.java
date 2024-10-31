/*
* The GUI.java class hold the logic for the Graphical User Interface (GUI).
*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    //public JList rocketList;

    public GUI() {
        super();
        init();
    }

    private void init() {
        int frameWidth = 500;
        int frameHeight = 300;
        int BtnWidth = 15;
        int BtnHeight = 30;

        setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rocket Launch Data Management System");

        // layout
        JPanel MainPanel = new JPanel(new GridLayout(1, 3));
        this.setLayout(MainPanel.getLayout());
        //grid 1,1
        JPanel LabelPanel = new JPanel(new GridLayout(8, 1));
        LabelPanel.add(new JLabel("Launch ID"));
        LabelPanel.add(new JLabel("Launch Provider"));
        LabelPanel.add(new JLabel("Launch Location"));
        LabelPanel.add(new JLabel("Launch Vehicle"));
        LabelPanel.add(new JLabel("Launch Date"));
        LabelPanel.add(new JLabel("Number of Crew"));
        LabelPanel.add(new JLabel("Payload"));
        LabelPanel.add(new JLabel("Tonnage to Orbit"));
        MainPanel.add(LabelPanel);

        //grid 1,2
        JPanel TextPanel = new JPanel(new GridLayout(8,1));
        TextPanel.add(new JTextField());
        TextPanel.add(new JTextField());
        TextPanel.add(new JTextField());
        TextPanel.add(new JTextField());
        TextPanel.add(new JTextField());
        TextPanel.add(new JTextField());
        TextPanel.add(new JTextField());
        TextPanel.add(new JTextField());
        MainPanel.add(TextPanel);

        //grid 1,3
        // ArrayList<RocketDataObject> rocketlist = RocketDataObject.getData();
        JPanel DataPanel = new JPanel(new GridLayout(2,1));

        String[] columnNames = {"L-ID", "L-Provider", "L-Location", "L-Vehicle","Date",
                "Crew","Payload", "Tonnage"};
        Object[][] data = new Object[RocketDataObject.launchList.size()][8];

        for (int i = 0; i < RocketDataObject.launchList.size(); i++) {
            data[i][0] = RocketDataObject.launchList.get(i).getLaunch_ID();
            data[i][1] = RocketDataObject.launchList.get(i).getLaunch_Provider();
            data[i][2] = RocketDataObject.launchList.get(i).getLaunch_Location();
            data[i][3] = RocketDataObject.launchList.get(i).getLaunch_Vehicle();
            data[i][4] = RocketDataObject.launchList.get(i).getLaunch_date();
            data[i][5] = RocketDataObject.launchList.get(i).getNumber_of_Crew();
            data[i][6] = RocketDataObject.launchList.get(i).getPayload();
            data[i][7] = RocketDataObject.launchList.get(i).getTonnage_to_Orbit();
        }

        DefaultTableModel DataTable = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(DataTable);

        JScrollPane TableScrollPane = new JScrollPane(table);

        JPanel ButtonPanel = new JPanel(new GridLayout(1,2));
        ButtonPanel.add(new JButton("Sort by Date"));
        ButtonPanel.add(new JButton("Sort by ID"));
        DataPanel.add(TableScrollPane);
        DataPanel.add(ButtonPanel);
        MainPanel.add(DataPanel);

       // JLabel Label = new JLabel("Hello");
        this.add(MainPanel);
       // this.add(Label);
        this.pack();
        this.setVisible(true);

    }

    public static void constructGUI(){
        GUI RocketDataBaseGUI = new GUI();
    }
}
