package Strings;
class ReverseWordsInString {
    public String reverseWords(String s) {
        String a[] = s.trim().split("\\s+");
        StringBuilder b = new StringBuilder();
        for(int i = a.length-1;i>=0;i--){
            b.append(a[i]);
            if(i>0) b.append(" ");
        }
        return b.toString();
    }
}