class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<Integer> skipIndex = new HashSet<>();

        for(int i = 0; i < strs.length; i++){
            if(skipIndex.contains(i)){
                continue;
            }
            char[] firstArray = strs[i].toCharArray();
            Arrays.sort(firstArray);
            boolean firstAdded = false;
            List<String> list = new ArrayList<>();
            for(int j = i+1; j < strs.length; j++){
                if(skipIndex.contains(j)){
                    continue;
                }
                char[] secondArray = strs[j].toCharArray();
                Arrays.sort(secondArray);
                if(Arrays.equals(firstArray,secondArray)){
                    list.add(strs[j]);
                    skipIndex.add(j);
                }
            }
            if(!skipIndex.contains(i)){
                list.add(strs[i]);
            }
            if(list.size() != 0){
                ans.add(list);
            }
        }
        return ans;
    }
}
