class Solution {
    public List<Integer> partitionLabels(String s) {
        LinkedHashMap<Character,Pair> map = new LinkedHashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,new Pair(i,Integer.MAX_VALUE));
            }
        }

        for(int i = s.length()-1; i >= 0; i--){
            char ch = s.charAt(i);
            Pair p = map.get(ch);

            if(p.end == Integer.MAX_VALUE){
                p.end = i;
            }
        }

        // System.out.println(map);

        int min = 0;
        int max = 0;

        for(Map.Entry<Character,Pair> set : map.entrySet()){
            Pair p = set.getValue();
            int start = p.start;
            int end = p.end;

            if(start > max){
                ans.add(max-min+1);
                min = start;
                max = end;
            }
            else{
                max = Math.max(max,end);
            }
            
        }

        ans.add(max-min+1);

        return ans;




    }
}

class Pair{
    int start;
    int end;

    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }

    public String toString(){
        return "("+start+", "+end+")";
    }
}
