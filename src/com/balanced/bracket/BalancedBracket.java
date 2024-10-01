package com.balanced.bracket;

import java.util.Stack;

public class BalancedBracket {

public final static char OPEN_PARENTHES = '(', CLOSE_PARENTHES = ')';
	
	public final static char OPEN_SQUARE = '[', CLOSE_SQUARE = ']';
	
	public final static char OPEN_CURLY = '{',  CLOSE_CURLY = '}';
	
	public static boolean isBalanced(String input) {
        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse the input string
        for (char c : input.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == OPEN_PARENTHES || c == OPEN_SQUARE || c == OPEN_CURLY) {
                stack.push(c);
            } 
            // Check for matching closing brackets
            else if (c == CLOSE_PARENTHES || c == CLOSE_SQUARE || c == CLOSE_CURLY) {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                // Check if the popped bracket matches the current closing bracket
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets are balanced
        return stack.isEmpty();
    }

    // Helper method to check if the brackets are a matching pair
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == OPEN_PARENTHES && closing == CLOSE_PARENTHES) ||
        		
               (opening == OPEN_SQUARE && closing == CLOSE_SQUARE) ||
               
               (opening == OPEN_CURLY && closing == CLOSE_CURLY);
    }

    public static void main(String[] args) {
        
        // Test cases  
    	// Parentheses - ()
    	// Square Bracket - []
    	// Curly Bracket - {}
    	
        System.out.println(isBalanced("( )"));            // true
        System.out.println(isBalanced("([{}])"));        // true
        System.out.println(isBalanced("({[}])"));        // false
        System.out.println(isBalanced("[(])"));          // false
        System.out.println(isBalanced(""));              // true
        System.out.println(isBalanced("{[()()]}"));      // true
        System.out.println(isBalanced("{[(])}"));        // false
    }
}
