class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,ans,0,0,new StringBuilder());
        return ans;
    }

    public void generate(int n, List<String> list,int open, int close, StringBuilder str) {
        if (str.length() == n * 2) {
            if (isValid(str.toString())) {
                list.add(str.toString());
            }
            return;
        }

        if(open < n){
        str.append('(');
        generate(n,list,open+1,close,str);
        str.deleteCharAt(str.length()-1);
        }
        if(close < n){
        str.append(')');
        generate(n,list,open,close+1,str);
        str.deleteCharAt(str.length()-1);
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!stk.isEmpty()) {
                if (ch == '(') {
                    stk.push(ch);
                } else {
                    if (!stk.isEmpty()) {
                        stk.pop();
                    } else {
                        return false;
                    }
                }
            } else {
                if (ch == '(') {
                    stk.push(ch);
                } else {
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }
}