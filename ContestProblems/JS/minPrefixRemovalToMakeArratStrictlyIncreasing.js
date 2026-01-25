/**
 * Problem: Find minimum number of elements to remove from the beginning (prefix)
 * of an array to make the remaining array strictly increasing
 *
 * Example:
 * Input: nums = [1, 2, 2, 3]
 * - Index 1: nums[1]=2 is NOT > nums[2]=2 (violation at index 1)
 * - Remove first 2 elements (indices 0, 1): [2, 3]
 * - Result: [2, 3] is strictly increasing
 * Output: 2
 *
 * Algorithm:
 * 1. Find the last index where nums[i] >= nums[i+1] (violation of strictly increasing)
 * 2. All elements up to and including that index must be removed
 * 3. Return count of removed elements
 *
 * Time Complexity: O(n), Space Complexity: O(1)
 */
var minimumPrefixLength = function (nums) {
    // Edge case: array with single element is already strictly increasing
    if (nums.length === 1) return 0;

    let index = -1; // Tracks the last index where strictly increasing condition is violated
    let n = nums.length - 1; // Last valid index for comparison

    // Find the rightmost position where nums[i] >= nums[i+1] (not strictly increasing)
    for (let i = 0; i < n; i++) {
        if (nums[i] >= nums[i + 1]) {
            index = i; // Update index to current violation position
        }
    }

    // If no violation found (index still -1), array is already strictly increasing
    if (index === -1) return 0;

    // Calculate how many elements to remove from the prefix
    // We need to remove all elements from index 0 to index (inclusive)
    // So we remove (index + 1) elements
    let prefixCount = n - index; // This calculates index + 1
    return prefixCount;
};
