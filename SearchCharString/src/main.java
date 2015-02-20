import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

        String str1="Искать г в корзине грибов";
        String str2="г";
        for (int i = 0; i < str1.length() ; i++) {
            if (Character.toString(str1.charAt(i)).compareTo(str2) == 0){
                System.out.println("Буква найдена в позиции"+i+1);
            }
        }// write your code here
    }
}