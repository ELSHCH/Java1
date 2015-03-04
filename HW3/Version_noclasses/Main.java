import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Stack st = new Stack();
        int StackSize = 10;
        for (int i = 0; i < StackSize; i++) {
            st.push(new Double(i));
        }
        System.out.println("Stack: " + st);
        System.out.println("Задайте команду калькулятора (Div, Add, Mul, Push, Pop, Print):");
        while (true) {
            String cmd = scanner.nextLine();
            System.out.println(cmd);
            if (!st.empty()) {
                if (cmd.equals("Div")) {
                    Double s1 = (Double) st.pop();
                    Double s2 = (Double) st.pop();
                    Double s3 = s2;
                    if (s2 != 0) {
                        s3 = s1 / s2;
                    }
                    st.push(new Double(s3));
                    System.out.println("Stack: " + st);
                } else if (cmd.equals("Add")) {
                    Double s1 = (Double) st.pop();
                    Double s2 = (Double) st.pop();
                    Double s3 = s1 + s2;
                    st.push(new Double(s3));
                    System.out.println("Stack: " + st);
                } else if (cmd.equals("Mul")) {
                    Double s1 = (Double) st.pop();
                    Double s2 = (Double) st.pop();
                    Double s3 = s1 * s2;
                    st.push(new Double(s3));
                    System.out.println("Stack: " + st);
                } else if (cmd.equals("Pop")) {
                    Double s = (Double) st.pop();
                    System.out.println("Stack: " + st);
                } else if (cmd.equals("Push")) {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Введите элемент стэка для добавления:");
                    Double a = in.nextDouble();
                    st.push(new Double(a));
                    System.out.println("Stack: " + st);
                } else if (cmd.equals("Print")) {
                    System.out.println("Stack: " + st);
                }
            } else {
                System.out.println("Stack is empty");
            }
        }
    }
}
