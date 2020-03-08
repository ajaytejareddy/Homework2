import java.util.Scanner;
import java.util.Stack;

public class inf2pos {


    //precedence returns value that corresponds to precedence of operator
    private int precedence(char op){
        switch (op)
        {
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


    //Postfix evaluates infix expr to postfix expr
    public String PostFix(String inf){
        StringBuilder postfix = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        char c;

        //looping through infix expression
        for(int i=0;i<inf.length();i++) {
            //System.out.println(stack);
            //checking for whether infix[i] is operator
            if (inf.charAt(i) == '(' || inf.charAt(i) == '+' || inf.charAt(i) == '-' || inf.charAt(i) == '/' || inf.charAt(i) == '*' || inf.charAt(i) == ')') {
                postfix.append(' ');
                //'(' is pushed into stack
                if (inf.charAt(i) == '(')
                    stack.push(inf.charAt(i));
                //if ')' occurs then stack must be poped and add it to postfixExpr untill '(' occurs
                else if (inf.charAt(i) == ')'){
                    while (!stack.isEmpty() && stack.peek() != '('){
                        postfix.append(' ');
                        postfix.append(stack.pop());
                    }
                    //if there is ")" operator without "(" operator preceding to it
                    if (stack.isEmpty() || stack.peek() != '(')
                        return "Expression is invalid (an operator '(' is missing)";
                    else
                        stack.pop();
                }

                //if operator is +,-,*,/ then control enters else part
                else {
                    //if precedence of infix[i] is less than or equals to stack(top)
                    while (!stack.isEmpty() && precedence(inf.charAt(i)) <= precedence(stack.peek())){
                        if(stack.peek()=='('){
                            return "invalid expression Encountered '(' without ')'";
                        }
                        //every element is add to postfix string
                        postfix.append(stack.pop());
                        postfix.append(' ');
                    }
                    //if precedence of infix[i] is greater to stack(top)
                    stack.push(inf.charAt(i));
                    }
            }
            //if inf[i] is operand
            else {

                postfix.append(inf.charAt(i));
            }
        }
        //remaining elements of stack are pushed into postfix string
        while (!stack.isEmpty()){
            char pop = stack.pop();
            if(pop=='('){
                return "invalid expression Encountered '(' without ')'";

            }
            postfix.append(' ');
            postfix.append(pop);
        }

        //result is returned
        return String.valueOf(postfix);
    }


    //operation() method do the specific operation based upon the operator it received in character
    private int operation(String c,int a,int b){

        switch (c){
            case "+": return a+b;
            case "-":return b-a;
            case "*":return b*a;
            case "/":return b/a;

            default:
                return 0;
        }

    }


    //poseval() will evaluate the postfix string and return interger result as output
    public int poseval(String pos){
        //Stack used to store operands
        Stack<Integer> stack = new Stack<>();
        StringBuilder num = new StringBuilder();

        String[] posArray = pos.split(" ");
        //System.out.println(Arrays.toString(posArray));
        for (String i : posArray) {
            if (i.equals(" ")){
                continue;
            }
            //if there  is an operator found then 2 elements from stack are poped and arithmetic operation is done
            if ((i.equals("+")) || (i.equals("-")) || (i.equals("/")) || (i.equals("*")) ){
                int a = stack.pop();

                int b = stack.pop();

                int res = operation(i,a,b);

                stack.push(res);
            }
            //else char is an operand then its pushed into stack
            else {
                stack.push(Integer.parseInt(i));
            }

        }


        //for loop loops through postfix expression
  /*      for (int i=0;i<pos.length();i++) {
            //if there  is an operator found then 2 elements from stack are poped and arithmetic operation is done
            if (pos.charAt(i) == '+' || pos.charAt(i) == '-' || pos.charAt(i) == '/' || pos.charAt(i) == '*') {

                int a = stack.pop();

                int b = stack.pop();

                int res = operation(pos.charAt(i),a,b);

                stack.push(res);
            }

            //else char is an operand then its pushed into stack
            else {
                 stack.push(Character.getNumericValue(pos.charAt(i)));
            }
        }

   */

        return stack.peek();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infixExpr,posExpr;

        System.out.print("Enter the mathematical expression: ");
        infixExpr = sc.nextLine();

        inf2pos i2p = new inf2pos();
        posExpr = i2p.PostFix(infixExpr);

        System.out.println("The postfix expression: "+posExpr);
        System.out.println("result : "+i2p.poseval(posExpr));
    }
}
