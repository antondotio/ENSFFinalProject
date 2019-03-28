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
        JEditorPane textArea = new JEditorPane();
        p.setLayout(new BorderLayout());
        options.setLayout(new FlowLayout());

        p.add("South", options);
        p.add("Center", textArea);
        JLabel title = new JLabel("An Application to Maintain Student Records");
        title.setHorizontalAlignment(JLabel.CENTER);
        p.add("North", title);

        insert =  new JButton("Insert");
        find = new JButton("Find");
        browse = new JButton("Browse");
        create = new JButton("Create Tree From File");

        options.add(insert);
        options.add(find);
        options.add(browse);
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

        browse.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                StringWriter strWrite = new StringWriter();
                PrintWriter writer = new PrintWriter(strWrite);
                tree.print_tree(tree.root, writer);
                textArea.setText(strWrite.toString());
            }
        });

        setContentPane(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainClass main = new MainClass(600, 400);
    }
}