public class Solution {
    public int sqrt(int x) {
        if (x <= 1)
            return x;
        long low = 0;
        long high = x;
        while (high - low > 1) {
            long mid = (low + high) / 2;
            long multiple = mid * mid;
            if (multiple == x)
                return (int)mid;
            if (multiple > x)
                high = mid;
            else
                low = mid;
        }
        return (int)low;
    }
}