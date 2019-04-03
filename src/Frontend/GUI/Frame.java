package Frontend.GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Frontend.Controller.*;

public class Frame extends JFrame{
    public static final long serialVersionUID = 1L;
    private JButton listAll;
    private JPanel p, options, center;
    private JTextArea textArea;
    private JScrollPane scroll;
    private JLabel title;
    private Listener listener;

    public Frame(int width, int height){
        setTitle("ToolShop Application");
        setSize(width, height);
        p = new JPanel();
        options = new JPanel();
        center = new JPanel();
        textArea = new JTextArea();
        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        title = new JLabel("Anton and Julian's Toolshop");
    
        setAttributes();
        setPanels();
        createButtons();

        setContentPane(p);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setAttributes(){
        title.setPreferredSize(new Dimension(100, 25));
        title.setHorizontalAlignment(JLabel.CENTER);
        
        p.setLayout(new BorderLayout());
        center.setLayout(new BorderLayout());
        options.setLayout(new FlowLayout());

        textArea.setEditable(false);
    }

    public void setPanels(){
        p.add("South", options);
        p.add("Center", center);
        p.add("North", title);

        center.add("Center", scroll);        
    }

    public void createButtons(){
        listAll = new JButton("List All Items");
        listAll.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String listOfTools = listener.actionPerformed("GET/TOOLS");
                if(listOfTools.equals("") || listOfTools.equals("Error getting list of tools")){
                    System.err.println("Error getting list of tools");
                } else{
                    textArea.setEditable(true);
                    textArea.setText(listOfTools);
                    textArea.setEditable(false);
                }
                
            }
        }
        );
        
        options.add(listAll);
    }

    public void setListener(Listener l){
        listener = l;
    }

}