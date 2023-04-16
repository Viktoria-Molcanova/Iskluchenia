
//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
//вместо этого, необходимо повторно запросить у пользователя ввод данных.@return возвращает введённое число

import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
      
 //Метод введения числа .Чтение  и вывод результата
      
 public static float floatnumber() {
 System.out.println("\nВведите дробное число через запятую: ");
 Scanner sc = new Scanner(System.in);
 float num = sc.nextFloat();
 System.out.println("Вы ввели:\n" + (num));
 return num;
         
  //Выброс исключения при введении строки/число через точку
         
  private static float MethodError() {
  try {
  floatnum();
  } catch (InputMismatchException e) {
  System.out.println("Число для поиска указано некорректно.\nПовторите попытку ввода");
  scanner.nextLine();
  }
   
  }        
        
  }
    }
      }
