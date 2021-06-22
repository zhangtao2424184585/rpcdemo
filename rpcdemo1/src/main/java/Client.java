import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Sub sub = new Sub();
        User byId = sub.findById("123");
        System.out.println(byId);
    }
}
