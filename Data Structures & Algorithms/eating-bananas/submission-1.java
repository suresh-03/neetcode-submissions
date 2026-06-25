class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);

        int s = 1;
        int e = piles[n-1];

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
}
