/**
 * @param {Object|Array} obj   // Input can be an object or an array (valid JSON)
 * @return {Object|Array}      // Returns a compacted object/array
 */
var compactObject = function (obj) {
    // Base Case 1:
    // If obj is falsy (null, false, 0, etc.), return null.
    // This ensures falsy values are removed at higher levels.
    if (!obj) return null;

    // Case 2: If obj is an array
    if (Array.isArray(obj)) {
        // 1. filter(Boolean) removes falsy values at the current array level
        // 2. map(compactObject) recursively compacts nested elements
        return obj.filter(Boolean).map(compactObject);
    }

    // Case 3: If obj is a primitive value (number, string, boolean)
    // At this point, it is guaranteed to be truthy
    if (typeof obj !== 'object') return obj;

    // Case 4: If obj is a plain object
    // Create a new object to store compacted key-value pairs
    const compacted = {};

    // Iterate over each key in the object
    for (let x in obj) {
        // Recursively compact the value
        const value = compactObject(obj[x]);

        // Only keep the key if the compacted value is not null
        // (null represents a falsy value that should be removed)
        if (value !== null) {
            compacted[x] = value;
        }
    }

    // Return the fully compacted object
    return compacted;
};
