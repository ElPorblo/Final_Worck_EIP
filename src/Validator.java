
public class Validator {
    public static boolean isValidData(String string){
         return string.matches("\\d{2}.\\d{2}.\\d{4}");
    }
    public static boolean isValidTelefon(String string){
        try {
            Long.parseLong(string);
            return true;
        } catch(NumberFormatException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean isValidGender(String string){
        return string.equals("f") || string.equals("m");
    }

}
