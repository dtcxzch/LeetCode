// dp, O(n^2) time, O(n) space

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minTotal = new int[n];
        for (int i = 0; i < n; i++)
            minTotal[i] = triangle.get(n-1).get(i);
        for (int row = n - 2; row >= 0; row--) {
            for (int i = 0; i <= row; i++) {
                minTotal[i] = Math.min(minTotal[i], minTotal[i+1]) + triangle.get(row).get(i);
            }
        }
        return minTotal[0];
    }
}