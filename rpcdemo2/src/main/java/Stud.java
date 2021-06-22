import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stud {
    public UserService getUserService() {
        Object o = Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, ((proxy, method, args) -> {
            System.out.println("我调用了：" + method.getName() + " 方法");
            Socket socket = new Socket("127.0.0.1", 8888);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF("123");
            String s = dataInputStream.readUTF();
            String s1 = dataInputStream.readUTF();
            return new User(s, s1);
        }));
        return (UserService) o;
    }
}
