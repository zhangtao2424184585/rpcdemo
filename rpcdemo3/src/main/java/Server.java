import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            System.out.println("等待链接");
            Socket accept = serverSocket.accept();
            System.out.println("连接上了");

            InputStream inputStream = accept.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            String methodname = (String) objectInputStream.readObject();
            Class[] classes = (Class[]) objectInputStream.readObject();
            Object[] objects = (Object[]) objectInputStream.readObject();
            UserServiceImpl userService = new UserServiceImpl();
            Method declaredMethod = userService.getClass().getDeclaredMethod(methodname, classes);
            OutputStream outputStream = accept.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            Object invoke = declaredMethod.invoke(userService, objects);
            objectOutputStream.writeObject(invoke);
        }
    }
}
