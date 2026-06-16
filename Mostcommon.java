import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String w : banned) {
            bannedSet.add(w);
        }
        String cleanedParagraph = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");
        String[] words = cleanedParagraph.split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();
        String mostFrequentWord = "";
        int maxCount = 0;
        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }
            int currentCount = wordCounts.getOrDefault(word, 0) + 1;
            wordCounts.put(word, currentCount);
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentWord = word;
            }
        }
        return mostFrequentWord;
    }
}
