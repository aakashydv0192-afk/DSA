class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the shorter array to minimize the binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        
        while (left <= right) {
            // Partition nums1
            int partition1 = left + (right - left) / 2;
            // Partition nums2 symmetrically to balance both halves
            int partition2 = (m + n + 1) / 2 - partition1;
            
            // Boundary conditions: if partition is at the edge, use infinity equivalents
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            // Check if we have partitioned the arrays correctly
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If the total number of elements is odd
                if ((m + n) % 2 != 0) {
                    return Math.max(maxLeft1, maxLeft2);
                } 
                // If the total number of elements is even
                else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } 
            // We are too far right in nums1, move left
            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } 
            // We are too far left in nums1, move right
            else {
                left = partition1 + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
