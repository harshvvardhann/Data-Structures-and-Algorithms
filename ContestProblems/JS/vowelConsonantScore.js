// Given a string s consisting of lowercase English letters, return the integer part of the division of the number of vowels by the number of consonants in s. If there are no consonants in s, return 0.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and the consonants are all other letters.
/**
 * @param {string} s
 * @return {number}
 */
var vowelConsonantScore = function (s) {
    const vowelSet = new Set(['a', 'e', 'i', 'o', 'u']);
    let c = 0;
    let v = 0;
    for (let ch of s) {
        if (ch >= 'a' && ch <= 'z') {
            // if(ch === 'a' || ch === 'e' || ch === 'i' || ch === 'o' || ch === 'u') v++;
            if (vowelSet.has(ch)) v++;
            else c++;
        }
    }

    return c > 0 ? Math.floor(v / c) : 0;
};
