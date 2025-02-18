package Strings;
class RotateString {
    public boolean rotateString(String s, String goal) {
        // If lengths are not equal, return false
        if (s.length() != goal.length()) return false;
        
        // Concatenate s with itself to cover all possible rotations
        String doubled = s + s;
        
        // Check if goal is a substring of the doubled string
        return doubled.contains(goal);
    }
}