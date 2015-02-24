import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер последовательности чисел n");
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList();
        arr.add(1);
        arr.add(2);
        boolean simplenumber = false;
        for (int i = 1; i < n + 1; i++) {
            for ( int j = 1; j < arr.size();++j) {
                if (i == arr.get(j)) {
                      simplenumber = true;
                } else{
                    if ((i % arr.get(j) == 0)&&(i != arr.get(j))) {
                        break;
                    }else if (j==arr.size()-1){
                        simplenumber = true;
                    }
                }
            }
            if ((simplenumber==true)&&(i != 2)&&(i != 1)) arr.add(i);
            simplenumber=false;
        }
        System.out.println("Последовательность простых чисел :");
        System.out.println(arr);
    }
}// write your code here
