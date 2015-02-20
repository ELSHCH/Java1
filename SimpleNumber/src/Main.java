import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws IOException {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите размер последовательности чисел n");
                int n = scanner.nextInt();
                boolean simplenumber = false;
                for (int i = 0; i < n + 1; i++) {
                    if (i == 1) {
                        simplenumber = true;
                    } else if (i == 2) {
                        simplenumber = true;
                    } else if (i % 2 == 0) {
                        simplenumber=false;
                    } else {
                        for (int j = 2; j < n; j++) {
                            if ((i % j == 0) && (i != j)) {
                                simplenumber = false;
                                break;
                            }else simplenumber=true;
                        }
                    }
                    if (simplenumber == true) {System.out.println(i + " ");}
                }
    }
}// write your code here
