import java.io.*;
import java.util.Arrays;

public class q2_Yuan_Bo {
    public static void main(String[] args) throws IOException {
        File file = new File("test_1.txt");
        BufferedReader input = new BufferedReader(new FileReader(file));
        String firstLine = input.readLine();
        String result = BWT_Compute_back(firstLine);
        FileWriter writer = new FileWriter("output_q2_Yuan_Bo.txt");
        writer.write(result);
        writer.close();
    }
    public static String BWT_Compute_back(String input) {
        String result = "";
        int line = -1;

        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        String sortedString = new String(chars);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '$') {
                line = i;
            }
        }
        int[] move = new int[input.length()];
        String copy = input;
        for (int i = 0; i < input.length() - 1; i++) {
            char currentChar = sortedString.charAt(line);
            int nextLine = -1;

            int counter = -1;
            for (int k = 0; k <= line; k++) {
                if (sortedString.charAt(k) == currentChar) {
                    counter++;
                }
            }
            for (int j = 0; j < copy.length(); j++) {
                if (copy.charAt(j) == currentChar) {
                    if (counter == 0) {
                        nextLine = j;
                        counter--;
                    }
                    else {
                        counter--;
                    }
                }
            }
            move[i] = line;
            line = nextLine;

        }
        for (int i = 0; i < input.length(); i++) {
            result += sortedString.charAt(move[i]);
        }
            return result;
    }
}
