public class TestMAIN {
    public static void main(String[] args) {
        Stud stud = new Stud();
        UserService userService = stud.getUserService();
        User uerBy = userService.findUerBy("123");
        System.out.println(uerBy);

    }
}
