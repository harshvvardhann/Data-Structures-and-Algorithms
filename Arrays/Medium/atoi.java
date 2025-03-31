package Arrays.Medium;
class atoi {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int ans = 0;
        while(i<s.length() && s.charAt(i) == ' ') i++;
        if(i<s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        //while(i<s.length() && s.charAt(i) == '0') i++; without this line also, it will work

        while(i<s.length() && s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9){
            int digit = s.charAt(i) - '0';
            if(ans>max/10 || (ans == max/10 && digit>max%10)){
                return sign == 1? max:min;
            }
            ans = ans * 10 + digit;
            i++;
        }
        return ans*sign;
    }
}