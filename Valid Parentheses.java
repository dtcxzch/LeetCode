public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int n = s.length();
        if (n % 2 == 1)
            return false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') 
                stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return false;
                stack.pop();
            }
            else {
                if (stack.isEmpty() || stack.peek() != '{')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}