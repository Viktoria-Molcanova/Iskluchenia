// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
//каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
package HomeWork1;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
private static int i;


//Метод создания массивов
    public static void main(String[] args) { 
        int[] Array1 = getFilledArray(5);
        int[] Array2 = getFilledArray(5);

        int[] divArray = divArrays(Array1, Array2);
        int[] badArray = divArrays(null, Array2);
        
    }

//Метод заполнения массива числами
public static int[] getFilledArray(int length){
    int[] array = new int[length];
    Random rnd = new Random();
    for (int i = 0; i < length; i++) {
        array[i] = rnd.nextInt(20);
    }
    return array;
}


//Метод выброса исключений
    public static int[] divArrays(int[] Array1, int[] Array2) { 
        if(Array1.length != Array2.length) throw new RuntimeException("Длины массивов не равны");
        System.out.println("\nПовторите попытку.");
        
       
        if (Array1 == null || Array2 == null)
        throw new NullPointerException("Искомый элемент не найден");
        System.out.println("\nПовторите попытку.");
       

        int[] resultArr = new int[Array1.length];

        try {
    
        resultArr[i] = Array1[i]/Array2[i];
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя.");
            System.out.println("\nПовторите попытку.");
        
        }

        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = Array1[i]/Array2[i];
        }
        return resultArr;

       
    }

    }
 
    
