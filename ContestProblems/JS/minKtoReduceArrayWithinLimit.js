/**
 * Utility: compute how many "chunks" or operations are required
 * if each operation can reduce an element by at most `k` (i.e. split
 * each nums[i] into ceil(nums[i]/k) pieces).
 *
 * Here `k` is treated as the maximum size of a piece. For each value
 * in `nums` we count ceil(nums[i] / k) and sum those counts.
 *
 * @param {number[]} nums - array of positive integers
 * @param {number} k - maximum allowed size per chunk/operation
 * @return {number} total number of chunks/operations needed
 */
function nonPositive(nums, k) {
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        // each element contributes this many chunks when chunk size = k
        count += Math.ceil(nums[i] / k);
    }
    return count;
}

/**
 * Find a minimal integer `k` (via binary search) that satisfies the
 * condition used by the original algorithm. The function performs a
 * binary search over possible `k` values and uses `nonPositive` to
 * compute the number of chunks required for a candidate `k`.
 *
 * Notes about bounds and checks (left as in original code):
 * - `left` starts at 1 because k=0 is invalid (division by zero).
 * - `right` is set to Math.max(...nums) * nums.length as a safe
 *   (over-)estimate upper bound for the binary search.
 * - `reduceCount` is the total number of chunks for candidate `mid`.
 * - The condition `reduceCount <= mid * mid` is the original
 *   threshold check used by this implementation; keep it if the
 *   algorithm's higher-level reasoning depends on this inequality.
 *
 * @param {number[]} nums - array of positive integers
 * @return {number} the chosen minimal `k` (or -1 if none found)
 */
var minimumK = function (nums) {
    // search space for k
    let left = 1;
    // a conservative upper bound for k (guaranteed to be >= needed k)
    let right = Math.max(...nums) * nums.length;
    let ans = -1;

    while (left <= right) {
        // try the middle candidate
        let mid = Math.floor((left + right) / 2);
        // how many chunks/operations would be needed with chunk size = mid
        let reduceCount = nonPositive(nums, mid);

        // original check: if total chunks fits within mid*mid threshold
        // then mid is a possible answer; try smaller k on the left
        if (reduceCount <= mid * mid) {
            right = mid - 1;
            ans = mid;
        } else {
            // otherwise increase k
            left = mid + 1;
        }
    }

    return ans;
};
