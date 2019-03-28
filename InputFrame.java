import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InputFrame extends JFrame {
    private JButton cancel, ok;

    public InputFrame(int width, int height) {
        setTitle("Input");
        setSize(width, height);

        JPanel p = new JPanel();
        JPanel options = new JPanel();
        JPanel inputs = new JPanel();
        p.setLayout(new BorderLayout());
        options.setLayout(new FlowLayout());
        inputs.setLayout(new FlowLayout());

        p.add("South", options);
        p.add("Center", inputs);
        JLabel inputLabel = new JLabel("Enter the file name:");
        inputLabel.setHorizontalAlignment(JLabel.CENTER);
        p.add("North", inputLabel);

        cancel = new JButton("Cancel");
        ok = new JButton("OK");

        options.add(cancel);
        options.add(ok);

        JTextArea inputText = new JTextArea(1, 30);

        inputs.add(inputText);

        setContentPane(p);
        setVisible(true);
    }
}