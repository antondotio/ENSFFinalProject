import java.awt.*;
import javax.swing.*;

public class MainClass{
    
    public static void main(String[] args){
        JFrame main = new JFrame("Main Window");
        JPanel p = new JPanel();
        JPanel options = new JPanel();
        BorderLayout bl = new BorderLayout();

        main.setSize(600, 400);
        p.setLayout(bl);
        options.setLayout(new FlowLayout());
        p.add("South", options);  
        p.add("Center", new JEditorPane());
        JLabel title = new JLabel("An Application to Maintain Student Records");
        title.setHorizontalAlignment(JLabel.CENTER);
        p.add("North", title);

        options.add(new Button("Insert"));
        options.add(new Button("Find"));
        options.add(new Button("Browse"));
        options.add(new Button("Create Tree From File"));

        main.setContentPane(p);
        main.setVisible(true);

    }
}