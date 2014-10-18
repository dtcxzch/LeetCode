public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0)
            return false;
        int indexOfE = s.indexOf("e");
        if (indexOfE != -1) {
            String left = s.substring(0, indexOfE);
            String right = s.substring(indexOfE + 1);
            return isNumber1(left) && right.matches("[+-]?[0-9]+");
        }
        return isNumber1(s);
    }
    
    // judge left part of s or original s
    public boolean isNumber1(String s) {
        if (s.length() == 0 || s.indexOf("e") != -1)
            return false;
        int indexOfDot = s.indexOf(".");
        if (indexOfDot != -1) {
            if (s.length() == 1 || s.length() == 2 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
                return false;
            String left = s.substring(0, indexOfDot);
            String right = s.substring(indexOfDot + 1);
            return left.matches("[+-]?[0-9]*") && right.matches("[0-9]*");
        }
        return s.matches("[+-]?[0-9]+");
    }
    
}