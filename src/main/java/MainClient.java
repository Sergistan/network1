import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8085;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String response1 = in.readLine();
            System.out.println(response1);

            out.println("Sergey");
            out.flush();

            String response2 = in.readLine();
            System.out.println(response2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
