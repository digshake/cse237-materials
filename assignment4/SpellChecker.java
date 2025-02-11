import java.util.*;
import java.util.stream.Collectors;

public class SpellChecker {
    private Set<String> dictionary;
    private Map<String, Integer> wordFrequency;

    public SpellChecker() {
        this.dictionary = new HashSet<>();
        this.wordFrequency = new HashMap<>();
    }

    // Adds a word to the dictionary
    public void add(String word) {
        if (word != null && !word.trim().isEmpty()) {
            dictionary.add(word.toLowerCase());
            wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
        }
    }

    // Returns the number of unique words in the dictionary
    public int getWordCount() {
        return dictionary.size();
    }

    // Finds duplicate words by frequency count
    public Set<String> findDuplicates() {
        return wordFrequency.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    // Checks if a word is spelled correctly (exists in the dictionary)
    public boolean spellCheck(String word) {
        if (word == null) return false;
        return dictionary.contains(word.toLowerCase());
    }

    // Finds the closest word by simple edit distance (Levenshtein distance)
    public String getClosest(String word) {
        if (word == null || dictionary.isEmpty()) return null;
        String closestWord = null;
        int minDistance = Integer.MAX_VALUE;

        for (String dictWord : dictionary) {
            int distance = computeEditDistance(word.toLowerCase(), dictWord);
            if (distance < minDistance) {
                minDistance = distance;
                closestWord = dictWord;
            }
        }
        return closestWord;
    }

    // Computes the Levenshtein distance between two words
    private int computeEditDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}