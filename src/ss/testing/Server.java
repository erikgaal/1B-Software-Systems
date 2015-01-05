package ss.testing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ServerSocket server;
    private ArrayList<Socket> clients = new ArrayList<Socket>();
    private boolean execute = true;

    public Server(int portnr) {
        try {
            this.server = new ServerSocket(portnr);
            System.out.println("Started server on port " + portnr);
        } catch (IOException e) {
            e.printStackTrace();
            execute = false;
        }
    }


    public void listen() {
        while (execute) {
            try {
                Socket socket = server.accept();
                clients.add(socket);
                broadcast();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcast() {
        try {
            for (Socket client : clients) {
                client.getOutputStream().write("TESING".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Socket> getClients() {
        return clients;
    }

    public void stopServer() {
        execute = false;
        try {
            for (Socket client : clients) {
                client.close();
            }
            server.close();
        } catch (IOException e) {
            // TODO: do something here
        }
    }

    public static void main(String[] args) {
        Server server = new Server(2000);

        boolean running = true;
        while (running) {
            server.broadcast();
            if (server.getClients().size() > 1) running = false;
        }
        server.stopServer();
    }

}