import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream outputStream1 = new DataOutputStream(outputStream);
        outputStream1.writeUTF("123");
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String s = dataInputStream.readUTF();
        String s1 = dataInputStream.readUTF();
        System.out.println(s);
        System.out.println(s1);
    }
}
