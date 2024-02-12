import java.util.Date;

public class Human {
    private String family;
    private String name;
    private String patronymic;
    private String date;
    private String telefon;
    private String gender;

    public Human(String family, String name, String patronymic, String date, String telefon, String gender) {
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        this.date = date;
        this.telefon = telefon;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format(
                "<%s><%s><%s><%s><%s><%s>",
                family, name, patronymic, date, telefon, gender);
    }
}
