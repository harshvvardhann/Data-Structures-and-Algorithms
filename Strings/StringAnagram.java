package Strings;
class StringAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int sArray[] = new int[26];
        for(int i=0;i<s.length();i++){
            sArray[Character.toLowerCase(s.charAt(i)) - 'a']++;
        }
        for(int i=0;i<t.length();i++){
            sArray[Character.toLowerCase(t.charAt(i)) - 'a']--;
        }
        for(int i=0;i<sArray.length;i++){
            if(sArray[i]!=0) return false;
        }
        return true;
    }
}