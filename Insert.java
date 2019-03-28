import javax.swing.*;
import java.awt.*;

public class Insert extends JFrame{
    private JButton insert, returnMain;

    public Insert(int width, int height){
        setTitle("New Student");
        setSize(width, height);
        
        JPanel p = new JPanel();
        JPanel options = new JPanel();
        JPanel inputs = new JPanel();
        p.setLayout(new BorderLayout());
        options.setLayout(new FlowLayout());
        inputs.setLayout(new GridLayout(4, 2, 0, 1));

        p.add("South", options);
        p.add("Center", inputs);
        JLabel title = new JLabel("Add a new student");
        title.setHorizontalAlignment(JLabel.CENTER);
        p.add("North", title);

        insert = new JButton("Insert");
        returnMain = new JButton("Return to Main Window");

        options.add(insert);
        options.add(returnMain);

        JLabel enterID = new JLabel("Enter Student ID");
        JTextArea inputID = new JTextArea(1, 15);

        JLabel enterFac = new JLabel("Enter Faculty");
        JTextArea inputFac = new JTextArea(1, 15);

        JLabel enterMaj = new JLabel("Enter Student Major");
        JTextArea inputMaj = new JTextArea(1, 15);

        JLabel enterYr = new JLabel("Enter year");
        JTextArea inputYr = new JTextArea(1, 15);

        inputs.add(enterID);
        inputs.add(inputID);
        inputs.add(enterFac);
        inputs.add(inputFac);
        inputs.add(enterMaj);
        inputs.add(inputMaj);
        inputs.add(enterYr);
        inputs.add(inputYr);

        setContentPane(p);
        setVisible(true);
    }

}