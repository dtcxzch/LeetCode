public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        int n = s.length();
        int[] cuts = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            cuts[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j+1][i-1] == true)) {
                    isPalindrome[j][i] = true;
                    if (j == 0) {
                        cuts[i] = 0;
                        break;
                    }
                    if (cuts[j-1] + 1 < cuts[i])
                        cuts[i] = cuts[j-1] + 1;
                }
            }
        }
        return cuts[n-1];
    }
}