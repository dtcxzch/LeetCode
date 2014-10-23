// dynamic programming

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0)
            return null;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return wordBreakHelper(s, dict, map);
    }
    
    private List<String> wordBreakHelper(String s, Set<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        List<String> res = new ArrayList<String>();
        int n = s.length();
        if (n == 0)
            return res;
        for (int i = 0; i < n; i++) {
            String prefix  = s.substring(0, i + 1);
            if (dict.contains(prefix)) {
                if (i == n - 1)
                    res.add(prefix);
                else {
                    for (String item : wordBreakHelper(s.substring(i + 1), dict, map)) {
                        res.add(prefix + " " + item);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}