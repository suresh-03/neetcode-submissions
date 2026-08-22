class Solution {
    public int maxProduct(int[] nums) {
        int product = Integer.MIN_VALUE;
        int prefixProduct = 1;
        int suffixProduct = 1;

        for(int i = 0; i < nums.length; i++){
            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length-i-1];

            product = Math.max(product,Math.max(prefixProduct,suffixProduct));

            if(prefixProduct == 0){
                prefixProduct = 1;
            }
            if(suffixProduct == 0){
                suffixProduct = 1;
            }
        }

        return product;
    }
}
