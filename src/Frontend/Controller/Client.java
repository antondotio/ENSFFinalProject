package Frontend.Controller;

import java.io.*;
import java.net.Socket;
import java.lang.StringBuilder;

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
        String response = socketIn.readLine();
        StringBuilder list = new StringBuilder();
        while(!response.equals("DONE")){
            list.append(response);
            list.append("\n");
            response = socketIn.readLine();
        }
        return list.toString();
    }
}