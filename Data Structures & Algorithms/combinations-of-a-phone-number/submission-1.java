class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<String>();
        }
        List<String> ans = new ArrayList<>();
        char[][] characters = {
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'},
        };

        generate(digits,characters,ans,"",0);
        return ans;
    }

    public void generate(String digits, char[][] characters, List<String> ans, String str, int index){
        if(digits.length() == str.length() || index == digits.length()){
            ans.add(str);
            return;
        }

        char[] charArray = characters[digits.charAt(index)-'0'];

        for(int i = 0; i < charArray.length; i++){
            char ch = charArray[i];
            generate(digits,characters,ans,str+ch,index+1);
        }
    }
}
