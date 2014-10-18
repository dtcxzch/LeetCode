public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0)
            return b;
        if (b.length() == 0)
            return a;
        int m = a.length();
        int n = b.length();
        int pa = m - 1;
        int pb = n - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (pa >= 0 || pb >= 0) {
            int sum = (pa >= 0 ? a.charAt(pa--) - '0' : 0) + (pb >= 0 ? b.charAt(pb--) - '0' : 0) + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        if (carry == 1)
            sb.insert(0, 1);
        return sb.toString();
    }
}