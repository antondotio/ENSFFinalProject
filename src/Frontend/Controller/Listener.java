package Frontend.Controller;

import java.io.IOException;

public class Listener{
    private Client client;

    public Listener(Client c){
        client = c;
    }

    public String actionPerformed(String s){
        if(s.equals("GET/TOOLS")){
            try{
                return client.displayTools();
            } catch(IOException ioe){
                return "Error getting list of tools";
            }
        }
        return "";
    }

}