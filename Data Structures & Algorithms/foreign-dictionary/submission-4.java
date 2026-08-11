class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;

        Set<Character> unique = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < words[i].length(); j++){
                unique.add(words[i].charAt(j));
            }
        }

        Map<Character,Set<Character>> graph = new HashMap<>();

        for(int i = 0; i < n-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(),w2.length());

            if(w1.length() > w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))){
                return "";
            }

            for(int j = 0; j < minLen; j++){
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);

                if(ch1 != ch2){
                    if(graph.containsKey(ch1)){
                        graph.get(ch1).add(ch2);
                    }
                    else{
                        Set<Character> set = new HashSet<>();
                        set.add(ch2);
                        graph.put(ch1,set);
                    }
                    break;
                }
            }
        }

        Map<Character,Boolean> visited = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        for(Map.Entry<Character,Set<Character>> map : graph.entrySet()){
            char key = map.getKey();
            if(dfs(key,graph,visited,ans)){
                return "";
            }
        }

        for(char ch : unique){
            if(ans.toString().indexOf(ch) == -1){
                ans.append(ch);
            }
        }

        return ans.toString();


    }

    private boolean dfs(char ch, Map<Character,Set<Character>> graph, Map<Character,Boolean> visited, StringBuilder ans){
        if(visited.containsKey(ch)){
            return visited.get(ch);
        }

        visited.put(ch,true);

        Set<Character> set = graph.get(ch);

        if(set != null){
            for(char c : set){
                if(dfs(c,graph,visited,ans)){
                    return true;
                }
            }
        }

        visited.put(ch,false);
        ans.insert(0,ch);
        return false;
    }
}
