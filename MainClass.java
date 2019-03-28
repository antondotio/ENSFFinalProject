import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainClass extends JFrame{
    JButton insert, find, browse, create;

    public MainClass(int width, int height){
        setTitle("Main Window");
        setSize(width, height);

        JPanel p = new JPanel();
        JPanel options = new JPanel();
        p.setLayout(new BorderLayout());
        options.setLayout(new FlowLayout());

        p.add("South", options);
        p.add("Center", new JEditorPane());
        JLabel title = new JLabel("An Application to Maintain Student Records");
        title.setHorizontalAlignment(JLabel.CENTER);
        p.add("North", title);

        insert =  new JButton("Insert");
        find = new JButton("Find");
        browse = new JButton("Browse");
        create = new JButton("Create Tree From File");

        options.add(insert);
        insert.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                Insert ins = new Insert(500, 200);
            }
        }
        );

        options.add(find);
        options.add(browse);
        options.add(create);

        setContentPane(p);
        setVisible(true);
    }

    public static void main(String[] args){
        MainClass main = new MainClass(600, 400);
    }
}