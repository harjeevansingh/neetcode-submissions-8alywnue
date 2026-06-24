class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> charMap = new HashMap<>();
        charMap.put( ')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(charMap.containsValue(c)){
                stack.push(c);
            } else {
                if(stack.empty() || stack.pop() != charMap.get(c)){
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
