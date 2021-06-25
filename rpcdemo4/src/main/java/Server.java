import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("等带链接");
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        System.out.println("连接上了");
        InputStream inputStream = accept.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        Class aClass = (Class) ois.readObject();
        Class[] parameterizedTypes = (Class[]) ois.readObject();
        String s = ois.readUTF();
        Object[] objects = (Object[]) ois.readObject();
        //从注册表里找到具体的类
        aClass = UserServiceImpl.class;
        Object o = aClass.newInstance();

        Method declaredMethod = aClass.getDeclaredMethod(s, parameterizedTypes);
        Object invoke = declaredMethod.invoke(o, objects);
        ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
        oos.writeObject(invoke);


    }
}
