package Backend.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private BufferedReader socketIn;
	private PrintWriter socketOut;
	private ServerSocket serverSocket;
	private Socket socket;

	public Server(int serv) {
		try {
			serverSocket = new ServerSocket(serv);
			System.out.println("Shop is running");
			socket = serverSocket.accept();
			socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			socketOut = new PrintWriter(socket.getOutputStream(), true);

		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	private ArrayList<Item> readItems(ArrayList<Supplier> suppliers) {

		ArrayList<Item> items = new ArrayList<Item>();

		try {
			FileReader fr = new FileReader("items.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(";");
				int supplierId = Integer.parseInt(temp[4]);

				Supplier theSupplier = findSupplier(supplierId, suppliers);
				if (theSupplier != null) {
					Item myItem = new Item(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]),
							Double.parseDouble(temp[3]), theSupplier);
					items.add(myItem);
					theSupplier.getItemList().add(myItem);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return items;
	}

	private Supplier findSupplier(int supplierId, ArrayList<Supplier> suppliers) {
		Supplier theSupplier = null;
		for (Supplier s : suppliers) {
			if (s.getSupId() == supplierId) {
				theSupplier = s;
				break;
			}
		}
		return theSupplier;
	}

	private ArrayList<Supplier> readSuppliers(ArrayList<Supplier> suppliers) {

		try {
			FileReader fr = new FileReader("suppliers.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(";");
				suppliers.add(new Supplier(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return suppliers;
	}

	private void communicate(Shop theShop) {
		String input = "";
		while (true) {
			try {
				input = socketIn.readLine();
				if (input.equals("GET/TOOL/LIST")) {
					String output = theShop.listAllItems();
					socketOut.println(output);
					socketOut.println("DONE");
				}
				
				else if (input.equals("GET/TOOL/SEARCH")) {
					String search = socketIn.readLine();
					String output;
					if(searchByID(search)) {
						output = theShop.getItem(Integer.parseInt(search));
					} else {
						System.out.println(search);
						output = theShop.getItem(search);
					}
					socketOut.println(output);
					socketOut.println("DONE");
				}

				else if (input.equals("TOOL/DECREASE")) {
					String itemName = socketIn.readLine();
					String output = theShop.decreaseItem(itemName);
					socketOut.println(output);
					socketOut.println("DONE");
				}

				else if (input.equals("GET/TOOL/ORDERS")) {
					String output = theShop.printOrder();
					socketOut.println(output);
					socketOut.println("DONE");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean searchByID(String in) {
		try {
			Integer.parseInt(in);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		Server shopServer = new Server(9788);
		ArrayList<Supplier> suppliers = new ArrayList<>();
		suppliers = shopServer.readSuppliers(suppliers);
		Inventory theInventory = new Inventory(shopServer.readItems(suppliers));
		Shop theShop = new Shop(theInventory, suppliers);

		shopServer.communicate(theShop);
	}
}