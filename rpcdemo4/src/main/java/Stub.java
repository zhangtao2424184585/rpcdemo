import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {
    public static Object get(final Class clazz){
        Object o1 = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(clazz);
            oos.writeObject(method.getParameterTypes());
            oos.writeUTF(method.getName());
            oos.writeObject(args);
            oos.flush();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object o = ois.readObject();
            return o;
        });
        return o1;
    }
}
