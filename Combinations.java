public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || k > n)
            return res;
        Integer[] comb = new Integer[k];
        for (int i = 0; i < k; i++)
            comb[i] = i + 1;
        boolean hasExtra = true;
        
        while (hasExtra) {
            hasExtra = false;
            res.add(new ArrayList<Integer>(Arrays.asList(comb)));
            for (int i = k - 1; i >= 0; i--) {
                if (comb[i] != n - k + i + 1) {
                    comb[i]++;
                    for (int j = i + 1; j < k; j++) {
                        comb[j] = comb[j-1] + 1;
                    }
                    hasExtra = true;
                    break;
                }
            }
        }
        return res;
    }
}