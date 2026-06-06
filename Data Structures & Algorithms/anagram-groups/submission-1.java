class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            int[] charCount = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                charCount[strs[i].charAt(j)-'a']++;
            }
            String key = Arrays.toString(charCount);

            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> set : map.entrySet()){
            ans.add(set.getValue());
        }
        return ans;
    }
}
