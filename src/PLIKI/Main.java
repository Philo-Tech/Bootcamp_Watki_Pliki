package PLIKI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FileProvider fileProvider = new FileProvider(
                "C:\\Users\\marci\\Downloads\\thymeleaf\\BootcampJava_555_cwiczenia\\src\\PLIKI\\przykladowe_pliki\\");

        //fileProvider.readFile("plik.txt");
        saveMyPasswords();
    }

    // w tej samej ścieżce, więc ten sam plik

    private static void saveMyPasswords(){
        FileProvider fileProvider = new FileProvider(
                "C:\\Users\\marci\\Downloads\\thymeleaf\\BootcampJava_555_cwiczenia\\src\\PLIKI\\przykladowe_pliki\\");
        List<String> passwords = new ArrayList<>();
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku: ");
        String fileName = scanner.next();
        while (flag){
            System.out.println("Podaj swoje hasło");
            String input = scanner.next();
            passwords.add(input);
            System.out.println("Dodać kolejne? N/T");
            input = scanner.next();
            if (input.equalsIgnoreCase("N")){
                flag = false;
            }
        }
        //String fileFinalName = fileName +"_"+ new Date().getTime()+ ".txt";   -> alternatywa z datą
        //String fileFinalName = fileName + "_" + fromUtilDateToString(new Date(), "yyyy-mm-dd") +".txt";

        fileProvider.createFileFromCollectio(fileName + ".txt",passwords);
        // scanner.close(); -> tutaj nie trzeba, ale w webowych trzeba już zamykać Scanner

    }
    // data
    public static String fromUtilDateToString(Date from, String pattern){
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(from);
    }
}
