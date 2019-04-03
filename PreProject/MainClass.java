
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 * this class creates the user interface for the user to use the program
 * @author Julian Pinto, Antonio Santos
 * @version 1.0
 * @since March 29, 2019
 */
public class MainClass extends JFrame{
    JButton insert, find, browse, create;
    BinSearchTree tree;

    public MainClass(int width, int height) {
        tree = new BinSearchTree();
        setTitle("Main Window");
        setSize(width, height);

        JPanel p = new JPanel();
        JPanel options = new JPanel();
        JPanel center = new JPanel();
        JTextArea textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        center.setLayout(new BorderLayout());
        p.setLayout(new BorderLayout());
        options.setLayout(new FlowLayout());

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
        insert.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                Insert ins = new Insert(500, 200, tree);
            }
        }
        );

        options.add(find);
        find.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                String id = JOptionPane.showInputDialog("Enter the ID of the student you are looking for.");
                Node student = tree.find(tree.root, id);
                if(student != null){
                    JOptionPane.showMessageDialog(null, student.data.toString(), "Student Found", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Could not find student", "Student Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        options.add(browse);
        browse.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(tree.empty()){
                    JOptionPane.showMessageDialog(null, "Tree is empty!", "Invalid", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String treeString = tree.print_tree(tree.root);
                textArea.setText(treeString);
            }
        });

        options.add(create);
        create.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFileName = JOptionPane.showInputDialog("Enter the file name:");
                Input in = new Input(textFileName);
                tree = in.createTree();
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