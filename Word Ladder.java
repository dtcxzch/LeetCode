// BFS

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0)
            return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int length = 1; 
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j = 0; j < start.length(); j++) {
                        String tmp = replace(current, j, c);
                        if (tmp.equals(start))
                            continue;
                        if (tmp.equals(end))
                            return length + 1;
                        if (dict.contains(tmp)) {
                            queue.offer(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
    
    public String replace(String current, int index, char c) {
        char[] chars = current.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}