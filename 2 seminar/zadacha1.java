// Если необходимо, исправьте данный код (задание 1 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
import java.util.*;
public class Main {
    public static void main(String[] args) {
         try {
           
           //создала и проинициализировала массив
           
             int[] intArray = {6,2,1,4,5,7,9,8,9};
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }

 }
