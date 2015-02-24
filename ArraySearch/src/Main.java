
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void searchNumber(int[]ar, int q){
        for (int i = 0; i < ar.length ; i++) {
            if (ar[i] == q){
                System.out.println("Число найдено в позиции "+i);
                break;
            }
        }
    }
    public static void binarySearch(int[]ar, int q){
        int i1 = 0;
        int i2 = ar.length;
        int im=0;
        while (i1 < i2){
            im = (int)((i1+i2)/2);
            if (ar[im]<q) {
                i1=im+1;
            }
            else i2=im;
        }
        im++;
        System.out.println("Число найдено в позиции "+im);
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        int []arr= new int[100000];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        System.out.println("Введите число для поиска в массиве от "+arr[0]+" до "+arr[99999]);
        int num=scanner.nextInt();
        long t0=System.currentTimeMillis();
        searchNumber(arr,num);
        long t1=System.currentTimeMillis();
        System.out.println("Общее время линейного поиска в ms:");
        System.out.println((t1 - t0) + " ms");
        t0=System.currentTimeMillis();
        binarySearch(arr, num);
        t1=System.currentTimeMillis();
        System.out.println("Общее время бинарного поиска в ms:");
        System.out.println((t1 - t0) + " ms");
    }
}

