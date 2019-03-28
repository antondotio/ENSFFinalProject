import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Input {
    private BufferedReader inStream;

    public Input(String fileName)
    {
        try{
            inStream = new BufferedReader(new FileReader(fileName));
        } catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File does not exist.");
        }
    }

    public BinSearchTree createTree()
    {
        if(inStream == null) {
            return null;
        }

        BinSearchTree tree = new BinSearchTree();
        String in;
        try {
            while((in = inStream.readLine()) != null)
            {
                String [] student = in.split(" ");
                tree.insert(student[0], student[1], student[2], student[3]);
            }
            System.out.println("tree made");
            return tree;
        } catch (IOException e){
            return null;
        }
    }
}