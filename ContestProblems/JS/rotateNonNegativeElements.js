/**
 * Problem: Rotate all non-negative elements in an array by k positions
 *
 * Example:
 * Input: nums = [3, -2, 5, -4, 1], k = 2
 * Non-negative elements: [3, 5, 1]
 * After rotating by 2 positions (right rotation): [5, 1, 3]
 * Output: [5, -2, 1, -4, 3] (negative elements stay in original positions)
 *
 * Algorithm: Reversal method - reverse 3 times
 * 1. Reverse first k elements
 * 2. Reverse remaining elements
 * 3. Reverse entire array
 * Time Complexity: O(n), Space Complexity: O(m) where m is count of non-negative elements
 * @param {number[]} nums - Input array with positive and negative numbers
 * @param {number} k - Number of positions to rotate
 * @return {number[]} - Array with non-negative elements rotated by k positions
 */

/**
 * Helper function to reverse array elements between two indices
 * @param {number[]} nums - Array to reverse
 * @param {number} left - Starting index (inclusive)
 * @param {number} right - Ending index (inclusive)
 * @return {number[]} - Array with reversed elements
 */
function reverse(nums, left, right) {
    // Swap elements from both ends moving towards center
    while (left < right) {
        [nums[left], nums[right]] = [nums[right], nums[left]];
        left++;
        right--;
    }
    return nums;
}

var rotateElements = function (nums, k) {
    // Step 1: Extract all non-negative elements while maintaining their order
    let nonNegativeElements = [];
    for (let num of nums) if (num >= 0) nonNegativeElements.push(num);
    console.log(nonNegativeElements);

    // Edge case: if no non-negative elements exist, return original array
    if (nonNegativeElements.length === 0) return nums;

    // Step 2: Optimize k using modulo (k % n avoids unnecessary full rotations)
    let n = nonNegativeElements.length;
    let newK = k % n;
    if (newK === 0 || newK === n) return nums; // No rotation needed
    console.log(newK);

    // Step 3: Apply reversal method to rotate non-negative elements
    // Reverse first k elements
    reverse(nonNegativeElements, 0, newK - 1);
    console.log(nonNegativeElements);

    // Reverse remaining elements after position k
    reverse(nonNegativeElements, newK, n - 1);
    console.log(nonNegativeElements);

    // Reverse entire array to complete rotation
    reverse(nonNegativeElements, 0, n - 1);
    console.log(nonNegativeElements);

    // Step 4: Place rotated non-negative elements back to their original positions
    let index = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] >= 0) nums[i] = nonNegativeElements[index++];
    }

    return nums;
};
