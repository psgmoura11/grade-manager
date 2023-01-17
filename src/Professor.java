public class Professor {

    private final static String user = "user";
    private final static String password = "123";

    public static boolean authenticate(String user, String password) {

        if (user.equals(Professor.user) && password.equals(Professor.password)) {
            return true;
        } else {
            return false;
        }
    }
}
