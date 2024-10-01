package com.balanced.bracket;

public class Parentheses {
	
	public static boolean isValidParentheses2(String input) {
        // Counter to keep track of the balance of parentheses
        int balance = 0;

        // Iterate over each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Increment balance for an opening parenthesis
            if (currentChar == '(') {
                balance++;
            } 
            // Decrement balance for a closing parenthesis
            else if (currentChar == ')') {
                balance--;

                // If balance is negative, we have more closing than opening
                if (balance < 0) {
                    return false;
                }
            }
            // Ignore any other characters
        }

        // If balance is zero, all parentheses are matched
        return balance == 0;
    }
	
	public static boolean isValidParentheses3(String input) {
		int balance = 0;
		for(char ch : input.toCharArray()) {
		 	if(ch == '(') {
				balance ++;
			} else if(ch == ')') {
				balance --;
				if(balance < 0) {
					return false;
				}
			}
		}
		return balance == 0;
	}

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidParentheses("()"));              // true
        System.out.println(isValidParentheses("((())))("));          // false
        System.out.println(isValidParentheses("("));               // false
        System.out.println(isValidParentheses("(())((()())())"));  // true
        System.out.println(isValidParentheses(""));                // true
        System.out.println(isValidParentheses("abc(def)ghi"));     // true
        System.out.println(isValidParentheses(")a(b)c("));         // false
    }
    
    public static boolean isValidParentheses(String value) {
    	int balance = 0;
    	
    	for (char ch : value.toCharArray()) {
    		if(ch == '{'){
    			balance++;
    		}else if(ch == '}') {
    			balance--;
    			if(balance < 0){
    				return false;
    			}
    		}
    	}
    	
    	return balance == 0;
    }

}
