package offer.interviews.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 括号匹配问题
 */
public class Brackets {

    public static Map<String, String> bracketsMap = new HashMap();

    static {
        bracketsMap.put("(", ")");
        bracketsMap.put("[", "]");
        bracketsMap.put("{", "}");
    }


    public static boolean prase(String brackets) {

        Stack<String> stack = new Stack();
        for (int i = 0; i < brackets.length(); i++) {
            String bracket = String.valueOf(brackets.charAt(i));
            if (bracketsMap.containsKey(bracket)) {
                stack.push(bracket);
            } else {
                String pop = stack.pop();
                String mapRight = bracketsMap.get(pop);
                if (mapRight == null) {
                    return false;
                }
                if (mapRight.equals(bracket)) {
                    continue;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String bra = "{(([[]]))()}";
        boolean res = prase(bra);
        System.out.println(res);
    }
}
