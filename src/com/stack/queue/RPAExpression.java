package com.stack.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by bahubali.n on 24/03/19.
 */
public class RPAExpression {

    public static void main(String[] args) throws Exception {
        String expression = "3,4,+,2,*,1,+,20,-";
        System.out.println("Amount :"+eval(expression));

    }

    public static int eval(String expression) throws Exception {
        Deque<Integer> interResults = new LinkedList<>();

        String delimeter = ",";
        String[] symbols = expression.split(delimeter);
        for (String token : symbols) {
            if (token.length() == 1 && "+-*/".contains(token)) {
                final int y = interResults.removeFirst();
                final int x = interResults.removeFirst();
                switch (token.charAt(0)) {
                    case '+':
                        interResults.addFirst(x+y); break;
                    case '-':
                        interResults.addFirst(x-y); break;
                    case '*':
                        interResults.addFirst(x*y); break;
                    case '/':
                        interResults.addFirst(x/y); break;
                    default:
                        throw new Exception("Malformed token: "+token);
                }

            } else {
                interResults.addFirst(Integer.parseInt(token));
            }
        }
        return interResults.removeFirst();
    }
}
