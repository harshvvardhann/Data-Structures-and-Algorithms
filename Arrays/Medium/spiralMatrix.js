// Given an m x n matrix, return all elements of the matrix in spiral order.
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

var spiralOrder = function (matrix) {
    let top = 0;
    let bottom = matrix.length - 1;
    let right = matrix[0].length - 1;
    let left = 0;
    const arr = [];
    while (top <= bottom && left <= right) {
        // left to right - top row
        for (let i = left; i <= right; i++) {
            arr.push(matrix[top][i]);
        }
        top++;
        // right to bottom - right column
        if (top <= bottom) {
            // check needed to avoid duplicates in single row/column cases
            for (let j = top; j <= bottom; j++) {
                arr.push(matrix[j][right]);
            }
        }
        right--;

        // right to left - bottom row
        if (left <= right && top <= bottom) {
            // top <= bottom in case of single row remaining
            for (let k = right; k >= left; k--) {
                arr.push(matrix[bottom][k]);
            }
        }
        bottom--;

        // bottom to top - left column
        if (top <= bottom && left <= right) {
            // left <= right in case of single column remaining
            for (let l = bottom; l >= top; l--) {
                arr.push(matrix[l][left]);
            }
        }
        left++;
    }

    return arr;
};
