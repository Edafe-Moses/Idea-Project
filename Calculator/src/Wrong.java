import java.util.Stack;

public class Wrong {
    public static void main(String[] args) {
        String equation = "3 * (4 + 5) / 2 - 7"; // Example equation

        // Convert infix expression to postfix (RPN)
        String postfix = infixToPostfix(equation);

        // Evaluate the postfix expression
        double result = evaluatePostfix(postfix);

        // Print the result
        System.out.println("Result: " + result);
    }

    // Method to convert infix notation to postfix (Reverse Polish Notation)
    public static String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Discard '('
            } else { // Operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push (c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Method to evaluate postfix expression
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    // Method to determine precedence of operators
    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
}
