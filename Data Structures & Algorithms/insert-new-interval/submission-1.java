class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();

        int i = 0;

        int n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]){
            List<Integer> l = new ArrayList<>();

            l.add(intervals[i][0]);
            l.add(intervals[i][1]);
            list.add(l);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(newInterval[0]);
        temp.add(newInterval[1]);
        list.add(temp);

        while(i < n){
            List<Integer> l = new ArrayList<>();
            l.add(intervals[i][0]);
            l.add(intervals[i][1]);
            list.add(l);
            i++;
        }

        int[][] ans = new int[list.size()][2];

        for(int j = 0; j < ans.length; j++){
            ans[j][0] = list.get(j).get(0);
            ans[j][1] = list.get(j).get(1);
        }

        return ans;


    }
}
