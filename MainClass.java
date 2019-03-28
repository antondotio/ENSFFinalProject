import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

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
        options.add(find);
        options.add(browse);
        browse.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
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
    }

    public static void main(String[] args) {
        MainClass main = new MainClass(600, 400);
    }
}