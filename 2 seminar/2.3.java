import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
  
     //Метод создания строки и запроса данных
  
    public static void main(String[] args) {
      String str = in.nextLine();
      
      //Выброс исключения пустые строки
      
    if(str.isEmpty())
      throw new IllegalArgumentException("Строку нельзя оставлять пустой!");
      System.out.println("Повторите попытку ввода.");
      scanner.nextLine();
    else
      System.out.println(str);
    return str;
  }
}
