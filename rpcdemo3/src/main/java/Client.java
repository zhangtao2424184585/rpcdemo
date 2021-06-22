import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        UserService userService = Stub.get();
        User uerBy = userService.findUerBy("123");
        System.out.println(uerBy);
    }
}
