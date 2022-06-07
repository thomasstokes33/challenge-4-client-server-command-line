import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server implements Runnable {


  private PrintWriter output;
  private BufferedReader reader;
  Socket clientSocket;
  private String name;

  public Server(Socket theclient) {
    clientSocket = theclient;
    try {
      output = new PrintWriter(clientSocket.getOutputStream(),
          true); //writing to socket
      reader = new BufferedReader(
          new InputStreamReader(clientSocket.getInputStream())); //reading from socket
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("thread creation error");
    }
  }

  public void setName(String name) {
    this.name = name;

  }

  @Override
  public void run() {
    String input;
    try {
      while ((input = reader.readLine()) != null) {

        System.out.println(name + " " + input);
        if (input.equals("")) {
          break;
        }
      }
      System.out.println(name + " exit");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
