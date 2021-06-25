public class Client {
    public static void main(String[] args) {
        UserService o = (UserService)Stub.get(UserService.class);
        User uerBy = o.findUerBy("123");
        System.out.println(uerBy);

    }
}
