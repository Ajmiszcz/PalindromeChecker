import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> palindromes = new ArrayList<>();
        List<String> nonPalindromes = new ArrayList<>();

        while (true) {
            System.out.println("Enter a word (or type 'exit' to finish):");
            String word = scanner.nextLine();

            if (word.equalsIgnoreCase("exit")) {
                break;
            }

            if (isPalindrome(word)) {
                palindromes.add(word);
            } else {
                nonPalindromes.add(word);
            }
        }

        writeToFile("palindromes.txt", palindromes);
        writeToFile("non_palindromes.txt", nonPalindromes);

        System.out.println("Palindromes: " + palindromes);
        System.out.println("Non-Palindromes: " + nonPalindromes);
    }

    public static boolean isPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reversed);
    }

    public static void writeToFile(String fileName, List<String> words) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String word : words) {
                writer.write(word + ",");
            }
            System.out.println("Data saved to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error while saving to the file.");
        }
    }
}
