public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length == 0)    
            return res;
        List<Integer> perm = new ArrayList<Integer>();
        int n = num.length;
        permute(n, num, perm, res);
        return res;
    }
    
    public void permute(int n, int[] num, List<Integer> perm, List<List<Integer>> res) {
        if (perm.size() == n) {
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i : num) {
            if (!perm.contains(i)) {
                perm.add(i);
                permute(n, num, perm, res);
                perm.remove(perm.size() - 1);
            }
        }
    }
    
}