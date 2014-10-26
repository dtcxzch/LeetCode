public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0)
            return res;
        Arrays.sort(S); 
        List<Integer> subset = new ArrayList<Integer>();
        subsetHelper(S, res, 0, subset);
        return res;
    }
    
    private void subsetHelper(int[] S, List<List<Integer>> res, int start, List<Integer> subset) {
        res.add(new ArrayList<Integer>(subset));
        for (int i = start; i < S.length; i++) {
            subset.add(S[i]);
            subsetHelper(S, res, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}