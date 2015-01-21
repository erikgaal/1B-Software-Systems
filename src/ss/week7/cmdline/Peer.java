package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Peer for a simple client-server application
 *
 * @author Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;
    protected boolean closed;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */

    /**
     * Constructor. creates a peer object based in the given parameters.
     *
     * @param nameArg name of the Peer-proces
     * @param sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException {
        name = nameArg;
        sock = sockArg;
    }

    /**
     * Reads strings of the stream of the socket-connection and writes the characters to the default output
     */
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner network = new Scanner(in);
        while (!closed) {
            while (network.hasNextLine()) {
                String msg = network.nextLine();
                if (msg.equalsIgnoreCase("EXIT")) {
                    System.exit(0);
                }
                System.out.println(msg);
            }
        }
    }


    /**
     * Reads a string from the console and sends this string over the socket-connection to the Peer proces. On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine() && !closed) {
            String input = in.nextLine();

            if (input.equalsIgnoreCase("EXIT")) {
                try {
                    out.write("EXIT");
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            } else {
                try {
                    out.write(String.format("%s: %s \n", name, input));
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
        try {
            in.close();
            out.close();;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * returns name of the peer object
     */
    public String getName() {
        return name;
    }

    /**
     * read a line from the default input
     */
    static public String readString(String tekst) {
        System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
