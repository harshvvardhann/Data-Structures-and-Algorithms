var findPeakElement = function (nums) {
    let n = nums.length;

    // If only one element exists, it is automatically a peak
    if (n == 1) return 0;

    // Check if first element is a peak
    // We assume nums[-1] = -∞, so only need to compare with right neighbor
    if (nums[0] > nums[1]) return 0;

    // Check if last element is a peak
    // We assume nums[n] = -∞, so only need to compare with left neighbor
    if (nums[n - 1] > nums[n - 2]) return n - 1;

    // Now we only search in the safe range: 1 to n-2
    // Because boundaries are already handled
    let left = 1;
    let right = n - 2;

    // Binary Search on the "slope"
    while (left <= right) {
        // Prevent overflow (standard binary search template)
        let mid = Math.floor(left + (right - left) / 2);

        // Case 1: If mid is greater than both neighbors → peak found
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        /*
            Core Intuition:
            We move toward the direction where the slope is rising.
            
            Why?
            Because if we are on an increasing slope,
            a peak MUST exist on that side.
        */

        // Case 2: We are on an ascending slope (going up)
        // nums[mid] > nums[mid-1] means slope is increasing
        // So peak must exist on the right side
        if (nums[mid] > nums[mid - 1]) {
            left = mid + 1;
        }
        // Case 3: We are on a descending slope
        // nums[mid] < nums[mid-1]
        // So peak must exist on the left side
        else {
            right = mid - 1;
        }
    }

    // This line will never execute because
    // problem guarantees at least one peak exists
    return -1;
};
