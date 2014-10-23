// dp, O(n^2)

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0)
            return false;
        int n = s.length();
        boolean[] a = new boolean[n+1];
        a[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (a[j] && dict.contains(s.substring(j, i + 1))) {
                    a[i+1] = true;
                    break;
                }
            }
        }
        return a[n];
    }
}