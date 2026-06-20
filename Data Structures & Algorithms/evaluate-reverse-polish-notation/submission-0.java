class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        Set<String> set = new HashSet<>();

        set.add("*");
        set.add("+");
        set.add("-");
        set.add("/");

        for(int i = 0; i < tokens.length; i++){
            String str = tokens[i];

            if(set.contains(str)){
                int n2 = stk.pop();
                int n1 = stk.pop();

                int res = calculate(n1,n2,str);

                stk.push(res);
            }
            else{
                stk.push(Integer.parseInt(str));
            }

        }

        return stk.isEmpty() ? -1 : stk.pop();
    }

    public int calculate(int num1,int num2,String sign){
        switch(sign){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return num1 + num2;
        }
    }
}
