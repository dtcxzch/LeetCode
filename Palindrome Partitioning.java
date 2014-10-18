public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null)
            return res;
        int n = s.length();
        List<String> path = new ArrayList<String>();
        helper(s, n, path, 0, res);
        return res;
    }
    
    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i))
                return false;
        }
        return true;
    }
    
    public void helper(String s, int len, List<String> path, int index, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<String>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            String prefix = s.substring(index, i + 1);
            if (isPalindrome(prefix)) {
                path.add(prefix);
                helper(s, len, path, i + 1, res);
                path.remove(path.size() - 1);
            }
        }
    }
}