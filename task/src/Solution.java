import javax.imageio.IIOException;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            TreeMap<String, Double> map = new TreeMap<String, Double>();
            int count = 0;
            Pattern pattern1 = Pattern.compile("\\D");
            Pattern pattern2 = Pattern.compile("\\d.+");
            while (reader.ready()) {
                String s = reader.readLine().trim();
                StringBuilder name = new StringBuilder();
                StringBuilder date = new StringBuilder();
                Matcher matcher = pattern1.matcher(s);
                while (matcher.find()) {
                    name.append(matcher.group());
                }
                Matcher matcher1 = pattern2.matcher(s);
                while (matcher1.find()) {
                    date.append(matcher1.group());
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd M yyyy");
                try {
                    PEOPLE.add(count, new Person(name.toString().trim(), dateFormat.parse(date.toString().trim())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                count++;

            }
            System.out.println(PEOPLE.get(0).getName() + " " + PEOPLE.get(0).getBirthDate());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}