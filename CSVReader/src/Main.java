import java.io.IOException;
import java.util.Locale;

public class Main {
    public static void main (String[]args) throws IOException {
       /* CSVReader reader = null;
        try {
            reader = new CSVReader("with-header.csv",";",true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(reader.next()) {
            String zero = reader.get(0);
            String one = reader.get(1);
            String two = reader.get(2);
            String three = reader.get(3);
            String four = reader.get(4);
            System.out.printf("%s %s %s %s %s\n",zero, one, two, three, four);
        }

        //CSVReader reader1 = new CSVReader("no-header.csv",";",true, "Windows-1250");
        //CSVReader reader2 = new CSVReader("no-header.csv",";",true);

        CSVReader reader1 = new CSVReader("no-header.csv", ";", true);
        CSVReader reader2 = new CSVReader("no-header.csv", ";", true);

        reader1.next();
        int nr1 = reader1.getInt(4);
        reader2.next();
        String name2 = reader2.get(1);

        System.out.printf("%d %s", nr1, name2);*/

        CSVReader reader = null;
        try {
            reader = new CSVReader("admin-units.csv",",", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i=0;
        while(reader.next() || i<=100){
            if(!reader.isMissing("name"))
                System.out.println(reader.get("name"));
            i++;
        }




    }
}