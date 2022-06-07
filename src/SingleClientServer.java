import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleClientServer {

  public static void main(String[] args) {
    int port = Integer.parseInt(args[0]);
    try (
        ServerSocket serverSocket = new ServerSocket(port, 5,
            InetAddress.getByName("192.168.86.38"));
        Socket clientSocket = serverSocket.accept();
        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),
            true); //writing to socket
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()))) //reading from socket
    {
      String input;
      while ((input = reader.readLine()) != null) {
        System.out.println(input);
        if (input.equals("")) {
          break;
        }
      }
      System.out.println("exit");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
