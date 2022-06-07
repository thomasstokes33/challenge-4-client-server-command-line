import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

  public static void main(String[] args) {
    int port = Integer.parseInt(args[0]);
    try {

      ServerSocket serverSocket = new ServerSocket(port, 5, InetAddress.getByName("192.168.86.38"));
      System.out.println("multiserver running");
      while (true) {
        Socket client = serverSocket.accept();
        Server server = new Server(client);
        Thread thread = new Thread(server);
//        server.setName(thread.getName());
        thread.start();

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
