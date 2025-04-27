package Stack;
import java.util.Stack;
public class InfixToPostfix {
    public int Prec(char c){
        if(c == '^'){
            return 3;
        }else if(c == '*' || c == '/'){
            return 2;
        }else if(c == '+' || c == '-'){
            return 1;
        }else{
            return -1;
        }
    }

    public String infixToPostfix(String exp){
        String newstr = new String();

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);

            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                newstr += c;
            }else if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    newstr += stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    newstr += stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            newstr += stack.pop();
        }

        return newstr;
    }
    public static void main(String[] args) {
        InfixToPostfix obj = new InfixToPostfix();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(obj.infixToPostfix(exp));
        // Output: abcd^e-fgh*+^*+i-
    }
}
