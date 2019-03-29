import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class open a new window and asks the user to input the information to inserts a new node into the binary search tree given
 */
public class Insert extends JFrame{
    /**
     * buttons to insert and cancel the inserstion of a new node to the binary tree given
     */
    private JButton insert, returnMain;
    private BinSearchTree tree;

    /**
     * Creates the window for the user to input the information that will create a new node for the tree
     * @param width width of window
     * @param height height of window
     * @param tree Binary tree that the node is added to
     */
    public Insert(int width, int height, BinSearchTree tree){
        this.tree = tree;
        setTitle("New Student");
        setSize(width, height);

        //window element creation
        JPanel p = new JPanel();
        JPanel options = new JPanel();
        JPanel inputs = new JPanel();
        p.setLayout(new BorderLayout());
        options.setLayout(new FlowLayout());
        inputs.setLayout(new GridLayout(4, 2, 0, 1));

        //organize window
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

        /**
         * using anonymous listener to add new node to binary tree
         */
        insert.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                String id = inputID.getText();
                String faculty = inputFac.getText();
                String major = inputMaj.getText();
                String year = inputYr.getText();
                if(id.compareTo("") == 0 || faculty.compareTo("") == 0 || major.compareTo("") == 0 || year.compareTo("") == 0){
                    JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    dispose();
                    return;
                }
                insertInTree(id, faculty, major, year);
                dispose();
            }
        });

        /**
         * uses anonymous listener to cancel the creation of a new node in the binary tree
         */
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

    /**
     * 
     * @param id id number of student
     * @param faculty facuilty of student
     * @param major major of student
     * @param year year student is in
      */
    public void insertInTree(String id, String faculty, String major, String year){
        boolean inserted = tree.insert(id, faculty, major, year);
        if(inserted)
            JOptionPane.showMessageDialog(null, "Student added!", "New Student", JOptionPane.PLAIN_MESSAGE);
    }
}