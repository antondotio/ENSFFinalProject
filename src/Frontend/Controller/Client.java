package Frontend.Controller;

import java.io.*;
import java.net.Socket;

public class Client{
    private Socket socket;
    private BufferedReader socketIn;
    private PrintWriter socketOut;

    public Client(String serverName, int portNumber){
        try{
            socket = new Socket(serverName, portNumber);
            socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOut = new PrintWriter((socket.getOutputStream()), true);
        }catch(IOException ioe){
            System.err.println(ioe.getStackTrace());
        }
    }

    public void communicate(){

    }

    public String displayTools() throws IOException{
        socketOut.println("GET/TOOLS");
        return socketIn.readLine();
    }
}