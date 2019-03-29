import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Input {
    private Scanner inStream;

    public Input(String fileName)
    {
        try{
            FileReader reader = new FileReader(new File(fileName));
            inStream = new Scanner(reader);
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
        while(inStream.hasNext())
        {
            String in = "";
            for(int i = 0; i < 4; i++)
            {
                in += inStream.next() + " ";
               }
            String[] stud = in.split(" ");
            tree.insert(stud[0], stud[1], stud[2], stud[3]);
        }
        inStream.close();
        return tree;
    }
}