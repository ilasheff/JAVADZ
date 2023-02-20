// 1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
// 2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
// 3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
// 4.Отсортировать по возрасту используя дополнительный список индексов.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException;
import java.util.ArrayList;

public class HomeWork4 {
  public static void main(String[] args) {

    // 1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
    FileWriter filewriter = null;       
    try {
      filewriter = new FileWriter("home_work_4.txt");
      filewriter.append("ТЕСТОВАЯ СТРОКА");
      filewriter.flush();
      filewriter.close();
        } 
        catch (IOException e) {
        throw new RuntimeException(e);
        } 

    FileReader filereader = null;
    String text = "";
    try {
      filereader = new FileReader("home_work_4.txt");
      while (filereader.ready()) { text = text + (char)filereader.read();}
      filereader.close();
      }
      catch (IOException e) {
      throw new RuntimeException(e);
      }
      System.out.println("Выводим в консоль тестовую строку: " + text);
      System.out.println();

    // 2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
        FileWriter fw = null; 
    try {
        fw = new FileWriter("bd.sql");
        fw.append("Иванов И.И.\n22\nмуж\nПетров П.П.\n43\nмуж\nСмирнов С.С.\n50\nмуж\nСмирнова С.С.\n20\nжен\nФедоров Ф.Ф.\n32\nмуж\nВасильева В.В.\n26\nжен");
        fw.flush();
        fw.close();
        } 
        catch (IOException e) {
        throw new RuntimeException(e);
        } 
        ArrayList<String> temporary_var = new ArrayList<>();
    try {
        BufferedReader filereader1 = new BufferedReader(new FileReader("bd.sql")); 
        String str;        
        while ((str = filereader1.readLine()) != null) {   
          temporary_var.add(str);         
        } 
        System.out.print("Вывести в консоль в формате 'Иванов И.И. 32 М': " + temporary_var);
        System.out.println();
        filereader1.close();          
        }
        catch (IOException e) {
        throw new RuntimeException(e);
        }

    // 3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках. 
        ArrayList<String> fio = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> sex = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
    try {
        BufferedReader fr = new BufferedReader(new FileReader("bd.sql"));        
        String str; 
        String a = " ";      
        while ((str = fr.readLine()) != null) { temp.add(str); }
        for (int i = 0; i < temp.size(); i = i + 3) {fio.add(temp.get(i));}
        for (int i = 1; i < temp.size(); i = i + 3) {age.add(Integer.parseInt(temp.get(i)));}
        for (int i = 2; i < temp.size(); i = i + 3) { a = temp.get(i);
            if (a.equals("жен")) {sex.add(false);} 
            else {sex.add(true);}               }
        fr.close();
        }
        catch (IOException e) {
        throw new RuntimeException(e);
        }
    System.out.println();
    System.out.println("Перечень ФИО до сортировки: " + fio);
    System.out.println();
    System.out.println("Возроста до сортировки: " + age);
    System.out.println();
    System.out.println("Пол до сортировки: " + sex);

    // 4.Отсортировать по возрасту используя дополнительный список индексов.
    String temp1;
    int temp2;
    boolean temp3;

    for (int j = 0; j < (age.size() - 1); j++) {
    for (int i = 0; i < (age.size() - 1); i++) {
        if (age.get(i) < age.get(i + 1)) {
            temp2 = age.get(i + 1);
            age.set((i + 1), age.get(i));
            age.set(i, temp2);

            temp1 = fio.get(i + 1);
            fio.set(i + 1, fio.get(i));
            fio.set(i, temp1);

            temp3 = sex.get(i + 1);
            sex.set(i + 1, sex.get(i));
            sex.set(i, temp3);
        }
    }
    }
  System.out.println();
  System.out.println("Отсортированные по возрасту ФИО: " + fio);
  System.out.println();
  System.out.println("Отсортированный возраст: " + age);
  System.out.println();
  System.out.println("Отсортированный по возрасту пол: " + sex);
    }
  }
