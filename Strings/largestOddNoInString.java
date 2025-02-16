package Strings;
class largestOddNoInString {

    //most optimal
    public String largestOddNumber1(String num) {
        if((int)num.charAt(num.length()-1)%2==1) return num;
         int i=num.length()-1;
         while(i>=0){
             int n=num.charAt(i);
             if(n%2==1) return num.substring(0,i+1);
             i--;
         }
         return "";
     }

    public static String findLargestOdd(String num){
        StringBuilder a = new StringBuilder(num);
        
        for(int i=num.length()-1;i>=0;i--){
            int x = num.charAt(i)-'0';
            if(x%2==1) return a.toString();
            a.delete(i, num.length());
        }

        return "";
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
             if (Character.getNumericValue(num.charAt(i)) % 2 == 1) {
                 return num.substring(0, i + 1);
             }
         }
         return "";  
     }
    public static void main(String[] args) {
        String s = "4206";
        String ans = findLargestOdd(s);
        System.out.println(ans);
    }
}