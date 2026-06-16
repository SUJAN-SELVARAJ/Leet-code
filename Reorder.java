import java.util.Arrays;
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            int split1 = log1.indexOf(' ');
            int split2 = log2.indexOf(' ');
            String id1 = log1.substring(0, split1);
            String id2 = log2.substring(0, split2);
            String content1 = log1.substring(split1 + 1);
            String content2 = log2.substring(split2 + 1);
            boolean isDigit1 = Character.isDigit(content1.charAt(0));
            boolean isDigit2 = Character.isDigit(content2.charAt(0));
            if (!isDigit1 && !isDigit2) {
                int compareContent = content1.compareTo(content2);
                if (compareContent != 0) {
                    return compareContent; 
                }
                return id1.compareTo(id2); 
            }
            if (!isDigit1 && isDigit2) {
                return -1; 
            }
            if (isDigit1 && !isDigit2) {
                return 1; 
            }
            return 0;
        });
        return logs;
    }
}
