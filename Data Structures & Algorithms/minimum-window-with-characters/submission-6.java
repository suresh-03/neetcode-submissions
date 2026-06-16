class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        if(s.equals(t)){
            return s;
        }

        int start = -1;
        int end = -1;
        int minLength = s.length();
        int count = 0;
        int l = 0;

        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }

        // System.out.println("tmap: "+tMap.toString());

        for(int r = 0; r < s.length(); r++){
            sMap.put(s.charAt(r),sMap.getOrDefault(s.charAt(r),0)+1);

            if(tMap.containsKey(s.charAt(r))){
                if(tMap.get(s.charAt(r)) == sMap.get(s.charAt(r))){
                    count++;
                }
            }


            if(count == tMap.size()){
                if((r-l+1) <= minLength){
                    minLength = r-l+1;
                    start = l;
                    end = r;
                }
            }

            // System.out.println("r="+r+", sMap="+sMap.toString()+", count="+count+", start="+start+", end="+end);

            

            while(l < s.length() && count == tMap.size()){
                sMap.put(s.charAt(l),sMap.get(s.charAt(l))-1);
                if(tMap.containsKey(s.charAt(l))){
                    if(tMap.get(s.charAt(l)) > sMap.get(s.charAt(l))){
                        count--;
                    }
                }
                l++;
                if(count == tMap.size()){
                    if((r-l+1) <= minLength){
                        minLength = r-l+1;
                        start = l;
                        end = r;
                    }
                }
            }

         
        }

        if(start == -1 && end == -1){
            return "";
        }
        return s.substring(start,end+1);

    }
}
