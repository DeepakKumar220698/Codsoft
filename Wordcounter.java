import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Wordcounter {
    private static final List<String> STOP_WORDS = Arrays.asList("the", "is", "a", "and", "in", "of", "to");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1
        System.out.println("Enter 'T' for text input or 'F' for file input: ");
        String inputType = scanner.nextLine().trim().toLowerCase();

        String text = "";

        // Step 2: Read the input 
        if (inputType.equals("t")) {
            System.out.println("Enter your text:");
            text = scanner.nextLine();
        } else if (inputType.equals("f")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                text = readFromFile(filePath);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
                return;
            }
        } else {
            System.err.println("Invalid input type. Please choose 'T' or 'F'.");
            return;
        }

        // Step 3: Split the string into an array 
        String[] words = text.split("[\\p{Punct}\\s]+");

        // Step 4: Initialize a counter variable 
        int wordCount = 0;

        // Step 8: Providing statistics like the number of unique words
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Step 5: Iterate through the array of words and increment the counter for each word encountered.
        for (String word : words) {
            // Step 7: Ignoring common words or stop words.
            if (!STOP_WORDS.contains(word.toLowerCase())) {
                wordCount++;

                // Step 8: Update word frequency.
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }

        // Step 6: Display the total count of words to the user.
        System.out.println("Total number of words: " + wordCount);

        // Step 8: Display the number of unique words and their frequency.
        System.out.println("Number of unique words: " + wordFrequency.size());
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString();
    }
}