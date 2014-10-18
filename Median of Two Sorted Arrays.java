public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if ((m + n) % 2 == 1)
            return findKth(A, 0, B, 0, (m + n) / 2 + 1);
        return (findKth(A, 0, B, 0, (m + n) / 2 + 1) + findKth(A, 0, B, 0, (m + n) / 2)) / 2.0;
    }
    
    public double findKth(int[] A, int sa, int[] B, int sb, int k) {
        if (sa >= A.length)
            return B[sb + k - 1];
        if (sb >= B.length)
            return A[sa + k - 1];
        if (k == 1)
            return Math.min(A[sa], B[sb]);
        int a = sa + k / 2 - 1 < A.length ? A[sa + k / 2 - 1] : Integer.MAX_VALUE;
        int b = sb + k - k / 2 - 1 < B.length ? B[sb + k - k / 2 - 1] : Integer.MAX_VALUE;
        if (a == b)
            return a;
        if (a < b)
            return findKth(A, sa + k / 2, B, sb, k - k / 2);
        return findKth(A, sa, B, sb + k - k / 2, k / 2);
    } 
}