class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i < n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost){
            return -1;
        }

        int resultIndex = 0;
        int total = 0;

        for(int i = 0; i < n; i++){
            total += gas[i] - cost[i];
            if(total < 0){
                total = 0;
                resultIndex = i + 1;
            }
        }

        return resultIndex;
    }
}
