import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String str1="Привет, какая сегодня погода? Погода сегодня будет замечательная!";
        String str2="сегодня";
        String str3="завтра";
        int j = 0;
        System.out.println("Первоначальная строка ");
        System.out.println(str1);
        if (str1.contains(str2)) {
            str1=str1.replace(str2,str3);
        }
        System.out.println("Измененная строка ");
        System.out.println(str1);
    }
}