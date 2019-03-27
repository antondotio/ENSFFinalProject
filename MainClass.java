import java.awt.*;
import javax.swing.*;

public class MainClass extends JFrame{
    JButton insert, find, browse, create;

    public MainClass(int width, int height){
        setTitle("Main Window");
        setSize(width, height);
        setLayout(new BorderLayout());

        JPanel p = new JPanel();
        JPanel options = new JPanel();
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