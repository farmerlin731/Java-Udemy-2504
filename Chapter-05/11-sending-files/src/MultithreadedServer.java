
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

class HandleCient implements Runnable {
    private Socket socket;

    public HandleCient(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            DataInputStream inputFromClient = new DataInputStream(this.socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(this.socket.getOutputStream());

            while (true) {
                String filename = "";
                char i = ' ';
                while ((int) i != 10) {
                    i = inputFromClient.readChar();
                    if ((int) i != 10) {
                        filename += i;
                    }
                }

                File f = new File(filename);
                try {
                    byte[] fileContent = Files.readAllBytes(f.toPath());
                    outputToClient.writeInt(fileContent.length);
                    for (int j = 0; j < fileContent.length; j++) {
                        outputToClient.writeByte(fileContent[j]);
                    }
                } catch (NoSuchFileException e) {
                   String message = "File not found. Please try again.\n";
                   outputToClient.writeInt(message.length());
                   outputToClient.writeBytes(message);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class MultithreadedServer {
    private int client_number = 0;

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket socket = serverSocket.accept();
                client_number++;
                System.out.println("Client #" + client_number + " connecting...");
                new Thread(new HandleCient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MultithreadedServer().start();
    }
}
