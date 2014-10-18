public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if (strs.length <= 1)
            return res;
        Map<Map<Character, Integer>, List<String>> map = new HashMap<Map<Character, Integer>, List<String>>();
        for (String s : strs) {
            Map<Character, Integer> m = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!m.containsKey(c))
                    m.put(c, 0);
                m.put(c, m.get(c) + 1);
            }
            if (!map.containsKey(m)) 
                map.put(m, new ArrayList<String>());
            map.get(m).add(s);
        }
        
        for (List<String> l : map.values()) {
            if (l.size() >= 2)
                res.addAll(l);
        }
        return res;
    }
}