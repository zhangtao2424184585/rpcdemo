import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sub {
    public User findById(String id) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(id);
        dataOutputStream.flush();
        String s = dataInputStream.readUTF();
        String s1 = dataInputStream.readUTF();
        return new User(id,s1);
    }
}
