var reverseByType = function (s) {
    let arr = s.split('');
    let i = 0;
    let j = arr.length - 1;

    const isLetter = (ch) => ch >= 'a' && ch <= 'z';

    while (i < j) {
        // move i until it finds a letter
        while (i < j && !isLetter(arr[i])) i++;

        // move j until it finds a letter
        while (i < j && !isLetter(arr[j])) j--;

        if (i < j) {
            [arr[i], arr[j]] = [arr[j], arr[i]];
            i++;
            j--;
        }
    }

    // now reverse non-letters
    i = 0;
    j = arr.length - 1;

    while (i < j) {
        // move i until it finds a non-letter
        while (i < j && isLetter(arr[i])) i++;

        // move j until it finds a non-letter
        while (i < j && isLetter(arr[j])) j--;

        if (i < j) {
            [arr[i], arr[j]] = [arr[j], arr[i]];
            i++;
            j--;
        }
    }

    return arr.join('');
};
