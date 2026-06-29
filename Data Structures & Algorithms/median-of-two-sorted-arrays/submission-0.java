class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                nums[k++] = nums1[i++];
            }
            else{
                nums[k++] = nums2[j++];
            }
        }

        while(i < nums1.length){
            nums[k++] = nums1[i++];
        }
        while(j < nums2.length){
            nums[k++] = nums2[j++];
        }

        if(nums.length % 2 == 0){
            int n1 = nums[(nums.length/2)-1];
            int n2 = nums[nums.length/2];

            return (double)(n1+n2)/2;
        }
        return (double)nums[nums.length/2];
    }
}
