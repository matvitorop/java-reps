import java.util.Objects;

public class Task2 {

    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try{
            if(!login.matches("[A-Za-z0-9_]+") || login.length() >= 20){
                throw new WrongLoginException();
            }
            if(!password.matches("[A-Za-z0-9_]+") || !password.equals(confirmPassword)){
                throw new WrongPasswordException();
            }
            return true;
        }
        catch (WrongLoginException | WrongPasswordException e){
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkCredentials("validLogin", "validPassword1_", "validPassword1_")); // true
        System.out.println(checkCredentials("invalidLogin#", "validPassword1_", "validPassword1_")); // false
        System.out.println(checkCredentials("validLogin", "short", "different")); // false
    }
}