class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2){
                if(a1[0] < a2[0]){
                    return -1;
                }
                else if(a1[0] > a2[0]){
                    return 1;
                }
                else{
                    if(a1[1] < a2[1]){
                        return -1;
                    }
                    else if(a1[1] > a2[1]){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        });

        int s = intervals[0][0];
        int e = intervals[0][1];

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++){
            if(e >= intervals[i][0]){
                e = Math.max(e,intervals[i][1]);
            }
            else{
                List<Integer> l = new ArrayList<>();
                l.add(s);
                l.add(e);
                list.add(l);
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }

        List<Integer> l = new ArrayList<>();
        l.add(s);
        l.add(e);
        list.add(l);

        int[][] ans = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }

        return ans;
    }
}
