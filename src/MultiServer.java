import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

  public static void main(String[] args) {
    String serverName = args[0];
    int port = Integer.parseInt(args[1]);
    try {

      ServerSocket serverSocket = new ServerSocket(port, 5, InetAddress.getByName(serverName));
      System.out.println(InetAddress.getByName(serverName));
      System.out.println(InetAddress.getByName("localhost"));
      System.out.println("multiserver running");
      while (true) {
        Socket client = serverSocket.accept();
        Server server = new Server(client);
        Thread thread = new Thread(server);
        server.setName(thread.getName());
        thread.start();

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
