import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class JV {
     public static void main(String[] args) {

          class INPUT {
               public String[] enterData() {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                         System.out.println(
                                   "Введите данные через ПРОБЕЛ (строка должна содержать Ф.И.О, дату рождения - ddmmyyyy, номер телефона - целое беззнаковое число , пол - f/m ) : ");
                         String data = scanner.nextLine();
                         String[] arrayData = data.split(" ");
                         if (arrayData.length == 6) {
                              return arrayData;
                         } else if (arrayData.length < 6) {
                              System.out.println("Ошибка! Вы ввели меньше данных, чем требуется");
                         } else
                              System.out.println("Ошибка! Вы ввели больше данных, чем требуется");
                    }

               }

          }

          class WRITE {
               public void writeData(String data, String path) {
                    System.out.println(path);
                    System.out.println(path.getClass().getSimpleName());
                    try (FileWriter fw = new FileWriter(path, true)) {
                         fw.append(data);
                         fw.append("\n");
                    } catch (IOException e) {
                         e.printStackTrace();
                    }
               }
          }

          class SexException extends Exception {
               public SexException() {
               }

               public void sexException(String i) {
                    System.out.println("Exception: SexNotCorrectData");
                    System.out.printf("Не корректный формат введения пола", i);
                    System.out.println();
               }
          }
          class DateException extends Exception {
               public DateException() {
               }

               public void dateException(String i) {
                    System.out.println("Exception: DateNotCorrectFormat");
                    System.out.printf("Не корректный формат введения даты", i);
                    System.out.println();
               }
          }
          class DataException extends Exception {
               public DataException() {
               }

               public void dataException(String i) {
                    System.out.println("Exception: DataNotCorrectFormat");
                    System.out.printf("Не корректный формат введения данных", i);
                    System.out.println();
               }
          }
          class PARS {

               public HashMap<String, Object> parsINPUT() {
                    INPUT INPUT = new INPUT();
                    String[] data = INPUT.enterData();
                    HashMap<String, Object> dataDic = new HashMap<>();
                    StringBuilder sb = new StringBuilder();
                    for (String i : data) {
                         if (i.length() == 1) {
                              if (i.equals("f") || i.equals("m")) {
                                   dataDic.put("sex", i);
                              } else {
                                   try {
                                        throw new SexException();
                                   } catch (SexException e) {
                                        e.sexException(i);
                                   }
                              }
                         } else if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                              String[] arrayDate = i.split("\\.");
                              boolean flag = true;
                              if (Integer.parseInt(arrayDate[0]) < 0 ||
                                        Integer.parseInt(arrayDate[0]) > 31 || Integer.parseInt(arrayDate[1]) < 0 ||
                                        Integer.parseInt(arrayDate[1]) > 12 || Integer.parseInt(arrayDate[2]) < 0 ||
                                        Integer.parseInt(arrayDate[1]) > 2023) {
                                   try {
                                        throw new DateException();
                                   } catch (DateException e) {
                                        e.dataException(i);
                                   }
                              } else {
                                   if (Integer.parseInt(arrayDate[2]) % 4 == 0) {
                                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                                  Integer.parseInt(arrayDate[1]) == 3 ||
                                                  Integer.parseInt(arrayDate[1]) == 5 ||
                                                  Integer.parseInt(arrayDate[1]) == 7 ||
                                                  Integer.parseInt(arrayDate[1]) == 9 ||
                                                  Integer.parseInt(arrayDate[1]) == 10 ||
                                                  Integer.parseInt(arrayDate[1]) == 12) {
                                             if (Integer.parseInt(arrayDate[0]) < 32) {
                                                  flag = false;
                                             }
                                        } else if (Integer.parseInt(arrayDate[1]) == 2) {
                                             if (Integer.parseInt(arrayDate[0]) < 30) {
                                                  flag = false;
                                             }
                                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                                  Integer.parseInt(arrayDate[1]) == 6 ||
                                                  Integer.parseInt(arrayDate[1]) == 8 ||
                                                  Integer.parseInt(arrayDate[1]) == 11) {
                                             if (Integer.parseInt(arrayDate[0]) < 31) {
                                                  flag = false;
                                             }
                                        }
                                   } else {
                                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                                  Integer.parseInt(arrayDate[1]) == 3 ||
                                                  Integer.parseInt(arrayDate[1]) == 5 ||
                                                  Integer.parseInt(arrayDate[1]) == 7 ||
                                                  Integer.parseInt(arrayDate[1]) == 9 ||
                                                  Integer.parseInt(arrayDate[1]) == 10 ||
                                                  Integer.parseInt(arrayDate[1]) == 12) {
                                             if (Integer.parseInt(arrayDate[0]) < 32) {
                                                  flag = false;
                                             }
                                        } else if (Integer.parseInt(arrayDate[2]) == 2) {
                                             if (Integer.parseInt(arrayDate[0]) < 29) {
                                                  flag = false;
                                             }
                                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                                  Integer.parseInt(arrayDate[1]) == 6 ||
                                                  Integer.parseInt(arrayDate[1]) == 8 ||
                                                  Integer.parseInt(arrayDate[1]) == 11) {
                                             if (Integer.parseInt(arrayDate[0]) < 31) {
                                                  flag = false;
                                             }
                                        }

                                   }
                                   if (!flag) {
                                        dataDic.put("date", i);
                                   } else
                                        try {
                                             throw new DataException();
                                        } catch (DataException e) {
                                             e.dataException(i);
                                        }
                              }

                         } else if (i.matches("[0-9]+")) {
                              dataDic.put("tel", i);
                         } else if (i.matches("[A-Za-z]+")) {
                              sb.append(i + " ");
                         } else {
                              try {
                                   throw new DataException();
                              } catch (DataException e) {
                                   e.dataException(i);
                              }
                         }
                    }
                    String[] fullName = String.valueOf(sb).split(" ");
                    if (fullName.length == 3) {
                         dataDic.put("Имя", fullName[1]);
                         dataDic.put("Фамилия", fullName[0]);
                         dataDic.put("Отчество", fullName[2]);
                    }
                    return dataDic;
               }

          }
          PARS PARS = new PARS();
          String newFileName = null;
          WRITE WRITE = new WRITE();

          HashMap<String, Object> data = PARS.parsINPUT();
          while (data.size() != 6) {
               try {
                    throw new DataException();
               } catch (DataException e) {
                    data = PARS.parsINPUT();
               }
          }

          newFileName = data.get("Фамилия") + ".txt";
          StringBuilder sb = new StringBuilder();
          for (String str : data.keySet()) {
               sb.append(data.get(str));
               sb.append(" ");
          }

          System.out.println(data);
          String filePath = newFileName;
          System.out.println(filePath);
          WRITE.writeData(String.valueOf(sb), filePath);

     }
}
