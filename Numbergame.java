import java.util.*;
import java.util.Scanner;
public class Numbergame {
    public static void main(String[] args) {
        int count;
        boolean b = false;
        int value = 0;
        int attempts = 1;
        String ans;
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - welcome to guess number game.");
        System.out.println("2 - you will be asked to guess a number to win the game.");
        System.out.println("3 - You have maximum 3 attempts.");


        if (value < 3)
        {
            for (int j = 1; j <= 3; j++) {
                if (b == false) {
                    count = 1;
                    Random r = new Random();
                    int dis_num = r.nextInt(200);
                    do {
                        for (int i = 1; i <= 10; i++) {
                            System.out.println("Enter a guess number between 1 - 200: ");
                            int user_no = sc.nextInt();
                            if (user_no == dis_num) {
                                System.out.println("hey !! you guessed it right!!!");
                                break;
                            } else if (user_no > dis_num) {
                                System.out.println("The number is High!!");
                                count++;
                            } else if (user_no < dis_num) {
                                System.out.println("The number is low!!");
                                count++;
                            } else
                                System.out.println("Can't Guess!!");
                        }
                        attempts++;
                        System.out.println("want to play again??-yes or no");
                        ans = sc.next().toLowerCase();
                    } while (ans == "yes");

                    if (!ans.equals("yes")) {
                        b = true;
                        System.out.println("Thank you!");
                    }
                }
                value++;
            }
            if(attempts>3)
               System.out.println("Attempts over! \nThank you for playing the game!!");
        }
    }
}
