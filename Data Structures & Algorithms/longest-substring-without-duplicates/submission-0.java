class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int longSubstringLength = 0;
        int l = 0;

        for(int r = 0; r < n; r++){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch) > 1){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }

            longSubstringLength = Math.max(r-l+1,longSubstringLength);
        }
        return longSubstringLength;

    }
}
