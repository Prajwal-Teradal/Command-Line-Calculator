import java.util.*;
import java.lang.Exception;

public class CommandLineCalculator {

    //define operator precedence
    private static int precedence(char op){
        switch (op){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    //apply operation between two numbers
    private static double applyOp(double a, double b, char op){
        switch (op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;

        }
        return 0;
    }

    //Evaluate infix expression
    public static double evaluate(String expression) throws Exception{
        Stack<Double> values=new Stack<>();
        Stack<Character> ops=new Stack<>();

        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);

            if(ch==' ')
                continue;

            if(Character.isDigit(ch)){
                StringBuilder sb=new StringBuilder();
                while(i<expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i)=='.')){
                    sb.append(expression.charAt(i++));
                }
                values.push(Double.parseDouble(sb.toString()));
                i--;
            }

            else if (ch=='(') {
                ops.push(ch);
            }

            else if(ch==')'){
                while(!ops.isEmpty() && ops.peek()!='('){
                    if(values.size()<2)
                        throw new Exception("Invalid expression: missing operand before ')'");
                    double b=values.pop();
                    double a=values.pop();
                    char op=ops.pop();

                    values.push(applyOp(a,b,op));
                }
                if(!ops.isEmpty())
                    throw new Exception("Invalid expression: mismatched parentheses");
                ops.pop();
            }

            else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                while (!ops.isEmpty() && precedence(ops.peek())>=precedence(ch)){
                    if(values.size()<2)
                        throw new Exception("Invalid expression: missing operand for operator " + ops.peek());
                    double b=values.pop();
                    double a=values.pop();
                    char op=ops.pop();
                    values.push(applyOp(a,b,op));
                }

                ops.push(ch);
            }else {
                throw new Exception("Invalid character: "+ch);
            }
        }

        while (!ops.isEmpty()){
            if (values.size() < 2)
                throw new Exception("Invalid expression: missing operand for operator " + ops.peek());
            double b=values.pop();
            double a=values.pop();
            char op=ops.pop();
            values.push(applyOp(a,b,op));
        }

        if (values.size() != 1)
            throw new Exception("Invalid expression: operands/operators mismatch");
        return values.pop();
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter mathematical expression:");
        String expr=sc.nextLine();
        try {
            double result=evaluate(expr);
            System.out.println("Result:"+result);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}