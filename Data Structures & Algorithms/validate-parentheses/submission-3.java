class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put(')', '(' );
        parenthesisMap.put('}', '{');
        parenthesisMap.put(']', '[');

        for(int i=0; i<s.length(); i++){
            if(parenthesisMap.keySet().contains(s.charAt(i))){
                if(stack.empty() || !stack.pop().equals(parenthesisMap.get(s.charAt(i)))){
                    return false;
                }
            } else{
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}
