public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int maxProduct = 1;
        int minProduct = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                maxProduct = Math.max(maxProduct * A[i], A[i]);
                minProduct = Math.min(minProduct * A[i], A[i]);
            }
            else {
                int temp = maxProduct;
                maxProduct = Math.max(minProduct * A[i], A[i]);
                minProduct = Math.min(temp * A[i], A[i]);
            }
            max = Math.max(max, Math.max(maxProduct, minProduct));
        }
        return max;
    }
}