package ss.testing;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2000);

            System.out.println(socket.getInputStream().read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
