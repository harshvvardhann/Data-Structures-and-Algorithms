/**
 * Search Insert Position
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
    // Initialize pointers for binary search
    let left = 0;
    let right = nums.length - 1;

    while (left <= right) {
        // Calculate mid index to avoid potential overflow
        let mid = Math.floor(left + (right - left) / 2);

        if (nums[mid] == target)
            return mid; // Target found
        else if (nums[mid] < target)
            left = mid + 1; // Target is in the right half
        else right = mid - 1; // Target is in the left half
    }
    // If target is not found, 'left' represents the index where it should be inserted
    return left;
};
