class TimeMap {

    Map<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new Pair(value, timestamp));
        }
        else{
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(value, timestamp));
            map.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair> list = map.get(key);
        int s = 0;
        int e = list.size()-1;

        while(s <= e){
            int m = (s+e)/2;
            Pair p = list.get(m);
            if(p.timestamp == timestamp){
                return p.value;
            }

            if(p.timestamp < timestamp){
                s = m + 1;
            }
            else{
                e = m - 1;
            }
        }

        return  e >= 0 ? list.get(e).value : "";
    }
}

class Pair{
    String value;
    int timestamp;

    public Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
