import java.io.*;
import java.util.Arrays;

public class q1_Yuan_Bo {
    public static void main(String[] args) throws IOException {
        File file = new File("test_1.txt");
        BufferedReader input = new BufferedReader(new FileReader(file));
        String firstLine = input.readLine();
        String result = BWT(firstLine);
        FileWriter writer = new FileWriter("output_q1_Yuan_Bo.txt");
        writer.write(result);
        writer.close();
    }

    public static String BWT(String input) {
        String result = "";
        String[] table = new String[input.length()];
        for (int i = 0; i < table.length; i++) {
            String save = input.substring(i);
            table[i] = save;
        }
        Arrays.sort(table);

        for (int i = 0; i < table.length; i++) {
            if (table.length == table[i].length()) {
                result += "$";
            }
            else {
                result += input.charAt(input.length() - table[i].length() - 1);
            }
        }
        return result;
    }
}
