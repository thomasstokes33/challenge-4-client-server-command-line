import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

  public static void main(String[] args) {
    String hostName = args[0];
    int portNum = Integer.parseInt(args[1]);
    try (Socket socket = new Socket(hostName, portNum);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //writing to stream/server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) //for reading from stream
    ) {
      out.println("hi");
    } catch (UnknownHostException e) {
      e.printStackTrace();
      System.out.println("host unknown");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
