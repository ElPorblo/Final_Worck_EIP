import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Введите данные в следующем формате через пробел:");
        System.out.println("Фамилия Имя Отчество дата_рождения(ДД.ММ.ГГГГ) номер_телефона пол");
        System.out.println("Например:");
        System.out.println("Иванов Иван Иванович 01.01.1997 89115558881 m");
        System.out.println("Пол указываем одной буквой: m - муж, f - женский");

        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        if(next.isEmpty()){
            System.out.println("Введена пустая строка. Повторите попытку!");
            return;
        }

        String[] split = next.split(" ");

        if(split.length != 6) {
            System.out.println("Неверное количество параметров в строке. Повторите попытку!");
            return;
        }
        String family = split[0];
        String name = split[1];
        String patronymic = split[2];
        String date = split[3];
        String telefon = split[4];
        String gender = split[5];

        if(!Validator.isValidData(date)) {
            System.out.println("Дата указана неверно. Введите дату в формате: ДД.ММ.ГГГГ");
            return;
        }
        if(!Validator.isValidTelefon(telefon)) {
            System.out.println("Телефон указан неверно. Повторите попытку!");
            return;
        }
        if(!Validator.isValidGender(gender)) {
            System.out.println("Пол указан неверно. Пол указываем одной буквой: m - муж, f - женский");
            return;
        }

        String fn = split[0] + ".txt";
        Human human = new Human(family, name, patronymic, date, telefon, gender);

        try (FileWriter writer = new FileWriter(fn, true)) {
            writer.write(human.toString());
            writer.append('\n');
            writer.flush();
            System.out.println("Данные успешно сохранены в файл " + fn);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }




    }
}