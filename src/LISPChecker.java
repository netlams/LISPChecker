import java.util.Stack;

/**
 *  LISPChecker validates the parentheses of a LISP code
 *
 * @author Dau Lam
 * @Date 07/17/2019
 */
public class LISPChecker {

    public boolean validate(String statement) {
        // Unexpected cases
        if (statement == null)
            throw new IllegalArgumentException("Input statement is null!");
        if (statement.length() == 0)
            throw new IllegalArgumentException("Input statement is empty!");

        char opening = '(';
        char closing = ')';
        Stack<Integer> stackOfParentheses = new Stack<>();
        char[] chrArray = statement.toCharArray();

        // Loop and compare each character for opening or closing parenthesis,
        // record each parenthesis pair in a stack data structure
        for (int i = 0; i < chrArray.length; i++)
        {
            if (chrArray[i] == opening)
                stackOfParentheses.push(i);

            if (chrArray[i] == closing) {
                if (stackOfParentheses.size() > 0)
                    stackOfParentheses.pop();
                else
                    return false; // found closing parenthesis, before an opening parentheis, bad LISP syntax
            }
        }
        // all nested parentheses should be closed by now
        if (stackOfParentheses.size() == 0)
            return true;

        // some parentheses are unclosed, bad LISP syntax
        return false;
    }
}
