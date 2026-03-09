
class Test {
    public static void main(String[] args) {
        int l = 30;
        String str = "aaaaaaaaaaaaaaaaabbbbbbbbbbbbbbcjdjcdjbcjdckdnkdnckdckdknkaaa";
        int count = 0;
        int ans = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a') {
                if(count == l) {
                    count = 0;
                }else{
                    count++;
                    ans = Math.max(ans, count);
                }
            }
        }
        System.out.println(ans);
    }
}