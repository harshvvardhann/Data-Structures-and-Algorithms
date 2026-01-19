// Helper function to swap two elements in an array.
function swap(nums, start, end) {
    [nums[start], nums[end]] = [nums[end], nums[start]];
}

// Helper function to reverse a portion of an array.
function reverse(nums, start, end) {
    while (start < end) {
        [nums[start], nums[end]] = [nums[end], nums[start]];
        start++;
        end--;
    }
}

var nextPermutation = function (nums) {
    // Find the first element from the right that is smaller than the element to its right (the pivot).
    let index = -1;

    for (let i = nums.length - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
            index = i;
            break;
        }
    }

    // If no pivot is found, the array is the largest permutation; reverse it to get the smallest permutation.
    if (index === -1) reverse(nums, 0, nums.length - 1);
    else {
        // Find the smallest element to the right of the pivot that is just larger than the pivot.
        for (let i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                // Swap the pivot with this larger element.
                swap(nums, index, i);
                break;
            }
        }
        // Reverse the subarray to the right of the pivot's original position to get the next lexicographical permutation.
        reverse(nums, index + 1, nums.length - 1);
    }
};
