public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        StringBuilder res = new StringBuilder();
        String[] stubs = path.split("/+");
        for (String s : stubs) {
            if (s.equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            }
            else if (!s.equals(".") && !s.equals(""))
                stack.push(s);
        }
        while (stack.size() > 0) {
            res.insert(0, "/" + stack.pop());
        }
        if (res.length() == 0)
            res.append("/");
        return res.toString();
    }
}