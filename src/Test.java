import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println(" ");
        System.out.println("REGISTER: ");
        System.out.println(" ");
        System.out.println("---------------------------------------------------------------  ");
        System.out.println(" ");
        User testUser = new User();
        testUser.setUserId(random.nextInt(99999999));
        System.out.print("Type your e-mail: ");
        String userEmail = sc.next();
        testUser.setUserEmail(userEmail);
        System.out.print("Type an password: ");
        String userPass = sc.next();
        testUser.setUserPassword(userPass);
        System.out.print("Type your name: ");
        String userName = sc.next();
        sc.nextLine();
        testUser.setUserName(userName);
        System.out.print("Type your birthdate (yyyy-mm-dd): ");
        String birth = sc.next();
        testUser.setUserBirthdate(birth);
        System.out.print("Type your height (cm): ");
        short height = sc.nextShort();
        testUser.setUserHeight(height);
        System.out.print("Type your gender M/W: ");
        char gender = sc.next().charAt(0);
        testUser.setUserGender(gender);
        System.out.print("Type your phone number: ");
        long phone = sc.nextLong();
        testUser.setUserPhone(phone);


        System.out.println(" ");
        System.out.println("---------------------------------------------------------------  ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("LOGIN: ");

        byte c = 0;
        boolean validLogin = false;
        while (c < 4) {
            System.out.println(" ");
            System.out.println("---------------------------------------------------------------  ");
            System.out.println(" ");
            System.out.print("E-mail: ");
            String userEmailLogin = sc.next();
            System.out.print("Password: ");
            String userPassLogin = sc.next();
            if (testUser.login(userEmailLogin, userPassLogin) == true && c < 4) {
                System.out.print("Login Sucessful :)");
                c =+ 5;
                validLogin = true;
            } else {
                c++;
                System.out.print(String.format("Login Failed. (%s chances remaining).",4-c));
                System.out.println(" ");
            }
        }

        if (validLogin == true) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("---------------------------------------------------------------  ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("YOUR INFORMATION: ");
            System.out.println(" ");
            System.out.println("---------------------------------------------------------------  ");
            System.out.println(" ");
            System.out.println("Your user ID: " + testUser.getUserId());
            System.out.println("Your e-mail: " + testUser.getUserEmail());
            System.out.println("Your name: " + testUser.getUserName());
            System.out.println("Your birthdate: " + testUser.getUserBirthdate());
            System.out.println("Your height: " + testUser.getUserHeight());
            System.out.println("Your gender: " + testUser.getUserGender());
            System.out.println("Your phone number: " + testUser.getUserPhone());
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Welcome to Health Track!");
        } else {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Bye.");
            System.out.println(" ");
        }



    }
}
