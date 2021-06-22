import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            System.out.println("等待链接·····");
            Socket accept = serverSocket.accept();
            System.out.println("连接上了");
            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();
            DataInputStream dis = new DataInputStream(inputStream);
            String s = dis.readUTF();
            UserServiceImpl userService = new UserServiceImpl();
            User uerBy = userService.findUerBy(s);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(s);
            dataOutputStream.writeUTF(uerBy.getName());
            dataOutputStream.flush();
        }

    }
}
