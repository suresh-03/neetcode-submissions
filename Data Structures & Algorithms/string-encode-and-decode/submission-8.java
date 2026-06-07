class Solution {

    List<Integer> index = new ArrayList<>();
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        for(int i = 0; i < strs.size(); i++){
            String str = strs.get(i);
            sb.append(str);
            ind += str.length();
            index.add(ind);
        }
        
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        if(index.size() == 0){
            return ans;
        }
        int ind = 0;

        for(int i = 0; i < index.size()-1; i++){
            ans.add(str.substring(ind,index.get(i)));
            ind = index.get(i);
        }

        ans.add(str.substring(ind,str.length()));
        return ans;
    }
}
