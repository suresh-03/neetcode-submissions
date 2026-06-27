class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        if (minIndex != -1 && nums[minIndex] == target) {
            return minIndex;
        }
        int s = 0;
        int e = nums.length - 1;
        int leftSearch = binarySearch(nums, s, minIndex - 1, target);
        if (leftSearch != -1) {
            return leftSearch;
        }
        return binarySearch(nums, minIndex + 1, e, target);
    }

    public int binarySearch(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int m = (s + e) / 2;

            if (nums[m] == target) {
                return m;
            }

            if (nums[m] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }

    public int findMin(int[] nums) {
        int minimum = Integer.MAX_VALUE;
        int minIndex = -1;

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = (s + e) / 2;

            if (nums[s] <= nums[m]) {
                if (minimum > nums[s]) {
                    minIndex = s;
                    minimum = nums[s];
                }
                s = m + 1;
            } else {
                if (minimum > nums[m]) {
                    minIndex = m;
                    minimum = nums[m];
                }
                e = m - 1;
            }
        }
        return minIndex;
    }
}
