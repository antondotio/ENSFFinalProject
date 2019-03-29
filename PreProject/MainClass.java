import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 * this class creates the user interface for the user to use the program
 */
public class MainClass extends JFrame{
    /**
     * buttons that run the functions of the program and the binary tree where the students information will be stored
     */
    JButton insert, find, browse, create;
    BinSearchTree tree;

    /**
     * Creates main window of the user interface
     * @param width width of window 
     * @param height height of window
     */
    public MainClass(int width, int height) {
        tree = new BinSearchTree();
        setTitle("Main Window");
        setSize(width, height);

        //creating sections in the main frame 
        JPanel p = new JPanel();
        JPanel options = new JPanel();
        JPanel center = new JPanel();
        JTextArea textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        center.setLayout(new BorderLayout());
        p.setLayout(new BorderLayout());
        options.setLayout(new FlowLayout());

        //adds elements to sections created
        p.add("South", options);
        p.add("Center", center);
        JLabel title = new JLabel("An Application to Maintain Student Records");
        title.setHorizontalAlignment(JLabel.CENTER);
        p.add("North", title);

        center.add("Center", scroll);

        insert =  new JButton("Insert");
        find = new JButton("Find");
        browse = new JButton("Browse");
        create = new JButton("Create Tree From File");

        options.add(insert);
        //uses anonymous listener to assign action to insert button
        insert.addActionListener(new ActionListener()
        {
            
            /**
             * creates insert class to add node to the binary tree
             * @param e anonymous actionlistener
             */
            @Override
            public void actionPerformed(ActionEvent e){
                Insert ins = new Insert(500, 200, tree);
            }
        }
        );

        options.add(find);
        //uses anonymous listener to assign action to find button
        find.addActionListener(new ActionListener()
        {
            /**
             * finds student in the binary search tree based on id number and creates a window with said students information
             * @param e anonymous actionlistener
             */
            @Override
            public void actionPerformed(ActionEvent e){
                String id = JOptionPane.showInputDialog("Enter the ID of the student you are looking for.");
                if(id == null)
                    return;

                Node student = tree.find(tree.root, id);
                if(student != null) {
                    JOptionPane.showMessageDialog(null, student.data.toString(), "Student Found", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Could not find student", "Student Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        options.add(browse);
        //uses anonymous listener to assign action to browse button
        browse.addActionListener(new ActionListener()
        {
            /**
             * displays binary search tree to text area of the main frame
             * @param e anonymous actionlistener
             */
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String treeString = tree.print_tree(tree.root);
                textArea.setText(treeString);
            }
        });

        options.add(create);
        //uses anonymous Listener to assign an action to the create tree from file
        create.addActionListener(new ActionListener() 
        {
            /**
             * creates a binary search tree from an input file given 
             * @param e anonymous actionlistener
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFileName = JOptionPane.showInputDialog("Enter the file name:");
                Input in = new Input(textFileName);
                tree = in.createTree();
                JOptionPane.showMessageDialog(null, "Binary Tree Created!", "Accepted", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setContentPane(p);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MainClass main = new MainClass(600, 400);
    }
}