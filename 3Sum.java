public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0)
            return ans;
        Arrays.sort(num);
        int n = num.length;
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && num[i] == num[i - 1])
                continue;
            int target = -num[i];
            int start = i + 1, end = n - 1;
            while (end > start) {
                int sum = num[start] + num[end];
                if (sum == target) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(num[i]);
                    l.add(num[start++]);
                    l.add(num[end--]);
                    ans.add(l);
                    while (end > start && num[start] == num[start - 1])
                        start++;
                    while (end > start && num[end] == num[end + 1])
                        end--;
                }
                else if (sum < target) {
                    start++;
                }
                else
                    end--;
            }
        }
        return ans;
    }
}