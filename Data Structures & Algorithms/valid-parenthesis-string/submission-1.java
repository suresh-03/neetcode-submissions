class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            switch(ch){
                case '(':
                    left.push(i);
                    break;
                case '*':
                    star.push(i);
                    break;
                case ')':
                    if(!left.isEmpty()){
                        left.pop();
                    }
                    else if(!star.isEmpty()){
                        star.pop();
                    }
                    else{
                        return false;
                    }
                    break;
            }
        }

        while(!left.isEmpty() && !star.isEmpty()){
            if(left.peek() > star.peek()){
                return false;
            }
            left.pop();
            star.pop();
        }

        return left.isEmpty();
    }
}
