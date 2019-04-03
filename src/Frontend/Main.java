package Frontend;

import Frontend.GUI.*;
import Frontend.Controller.*;

public class Main{
    public static void main(String[] args){
        Client client = new Client("localhost", 9788);
        Frame mainFrame = new Frame(600, 400);
        mainFrame.setListener(new Listener(client));
    }
}

