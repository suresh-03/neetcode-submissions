class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int n = s.length();
        int[] sChars = new int[26];

        for(int i = 0; i < n; i++){
            sChars[s.charAt(i)-'a']++;
            sChars[t.charAt(i)-'a']--;
        }

        for(int num : sChars){
            if(num != 0){
                return false;
            }
        }
        return true;

    }
}
