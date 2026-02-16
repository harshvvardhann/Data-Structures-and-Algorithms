/**
 * Finds the single non-duplicate element in a sorted array
 * where every other element appears exactly twice.
 *
 * Time Complexity: O(log n)  -> Binary Search
 * Space Complexity: O(1)
 *
 * @param {number[]} nums - Sorted array of integers
 * @return {number} - The single non-duplicate element
 */
var singleNonDuplicate = function (nums) {
    // -------------------------
    // 🔹 Edge Case Handling
    // -------------------------

    // If array contains only one element,
    // that element is the answer.
    if (nums.length === 1) return nums[0];

    // If first element is not equal to second,
    // then first element is the single element.
    if (nums[0] !== nums[1]) return nums[0];

    // If last element is not equal to second-last,
    // then last element is the single element.
    if (nums[nums.length - 1] !== nums[nums.length - 2]) return nums[nums.length - 1];

    // -------------------------
    // 🔹 Binary Search Setup
    // -------------------------

    let left = 0;
    let right = nums.length - 1;

    // We use binary search because:
    // In a sorted array where elements appear twice,
    // pairs follow a pattern:
    //
    // BEFORE the single element:
    //   even index -> first of pair
    //   odd index  -> second of pair
    //
    // AFTER the single element:
    //   pattern shifts (even/odd pairing breaks)
    //
    // We use this pattern to decide which half to search.

    while (left <= right) {
        // Calculate mid safely
        let mid = Math.floor(left + (right - left) / 2);

        // -------------------------
        // 🔹 Check if mid is answer
        // -------------------------
        // If nums[mid] is not equal to its neighbors,
        // it must be the single element.
        if (nums[mid] !== nums[mid - 1] && nums[mid] !== nums[mid + 1]) {
            return nums[mid];
        }

        // -------------------------
        // 🔹 Decide Search Direction
        // -------------------------
        //
        // If we are on the LEFT side of the single element,
        // the pairing pattern is correct:
        //
        //  - If mid is odd and equals previous → correct pair
        //  - If mid is even and equals next → correct pair
        //
        // This means single element is on the RIGHT side.
        //
        // Otherwise, pattern is broken,
        // meaning single element is on the LEFT side.

        if ((mid % 2 === 1 && nums[mid] === nums[mid - 1]) || (mid % 2 === 0 && nums[mid] === nums[mid + 1])) {
            // Pattern is correct → move right
            left = mid + 1;
        } else {
            // Pattern is broken → move left
            right = mid - 1;
        }
    }

    // This should never happen if input constraints are valid
    return -1;
};
