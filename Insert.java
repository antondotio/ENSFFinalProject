import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class open a new window and asks the user to input the information to inserts a new node into the binary search tree given
 * @author Julian Pinto, Antonio Santos
 * @version 1.0
 * @since March 29, 2019
 */
public class Insert extends JFrame{
    private JButton insert, returnMain;
    private BinSearchTree tree;

    public Insert(int width, int height, BinSearchTree tree){
        this.tree = tree;
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

        insert.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                String id = inputID.getText();
                String faculty = inputFac.getText();
                String major = inputMaj.getText();
                String year = inputYr.getText();
                insertInTree(id, faculty, major, year);
                dispose();
            }
        });

        returnMain.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
            

        setContentPane(p);
        setVisible(true);
    }

    public void insertInTree(String id, String faculty, String major, String year){
        boolean inserted = tree.insert(id, faculty, major, year);
        if(inserted)
            JOptionPane.showMessageDialog(null, "Student added!", "New Student", JOptionPane.PLAIN_MESSAGE);
    }
}