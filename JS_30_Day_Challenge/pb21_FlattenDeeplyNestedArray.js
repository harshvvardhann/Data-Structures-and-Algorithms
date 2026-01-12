/**
 * @param {Array} arr   // Input array that may contain nested arrays or objects
 * @param {number} n    // Maximum depth to flatten
 * @return {Array}      // Flattened array up to depth n
 */
var flat = function (arr, n) {
    // This array will store the final flattened result
    const result = [];

    // Depth-first search helper
    // item  → current array being processed
    // depth → current flattening depth
    function dfs(item, depth) {
        // Iterate over each element in the current array
        for (let i = 0; i < item.length; i++) {
            // If the element is an array AND we have not reached max depth,
            // recursively flatten it
            if (Array.isArray(item[i]) && depth < n) {
                dfs(item[i], depth + 1);
            }
            // Otherwise, push the element directly into result
            // (either it is not an array or depth limit is reached)
            else {
                result.push(item[i]);
            }
        }
    }

    // Start DFS from the root array with depth 0
    dfs(arr, 0);

    // Return the flattened result
    return result;
};
