/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

function findFirstOccurence(nums, target) {
    let left = 0;
    let right = nums.length - 1;
    let index = -1;

    while (left <= right) {
        let mid = Math.floor(left + (right - left) / 2);
        if (nums[mid] == target) {
            index = mid;
            right = mid - 1;
        } else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return index;
}

function findLastOccurence(nums, target) {
    let left = 0;
    let right = nums.length - 1;
    let index = -1;

    while (left <= right) {
        let mid = Math.floor(left + (right - left) / 2);
        if (nums[mid] == target) {
            index = mid;
            left = mid + 1;
        } else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return index;
}

var searchRange = function (nums, target) {
    let resultArray = [];
    resultArray[0] = findFirstOccurence(nums, target);
    resultArray[1] = findLastOccurence(nums, target);
    return resultArray;
};
