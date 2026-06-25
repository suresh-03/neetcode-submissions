class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        // Arrays.sort(piles);

        int s = 1;
        int e = findMax(piles);

        while(s <= e){
            int k = (s+e)/2;

            int hourToEatKBananas = 0;

            for(int i = 0; i < n; i++){
                int hour = (int)Math.ceil(((double)piles[i]/k));
                // System.out.println(hour+" "+k+" "+piles[i]);
                hourToEatKBananas += hour;
            }

            if(hourToEatKBananas <= h){
                e = k - 1;
            }
            else{
                s = k + 1;
            }
        }

        return s;
    }

    public int findMax(int[] piles){
        int max = piles[0];

        for(int num : piles){
            max = Math.max(max,num);
        }
        return max;
    }
}
