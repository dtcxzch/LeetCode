public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        long shift = 1l << 31;
        long ans = 0;
        while (shift > 0) {
            ans |= shift;
            if (ans * absDivisor > absDividend)
                ans ^= shift;
            shift >>= 1;
        }
        if ((dividend > 0) != (divisor > 0))
            ans = -ans;
        return (int) ans;
    }
}