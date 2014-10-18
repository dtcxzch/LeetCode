// binary search

public class Solution {
    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }
    
    public int findMin(int[] num, int start, int end) {
        if (start == end || num[start] < num[end])
            return num[start];
        int mid = (start + end) / 2;
        if (num[mid] > num[mid + 1])
            return num[mid + 1];
        if (num[start]  > num[mid])
            return findMin(num, start, mid);
        return findMin(num, mid + 1, end);
    }
}