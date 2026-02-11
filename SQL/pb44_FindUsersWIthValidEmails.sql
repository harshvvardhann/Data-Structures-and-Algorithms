-- Problem: Find users with valid emails
-- A valid email must:
-- 1. Start with a letter.
-- 2. Contain only letters, digits, underscores, periods, or dashes in the prefix.
-- 3. End with '@leetcode.com'.

SELECT *
FROM Users
WHERE mail COLLATE utf8mb3_bin
      -- Regex explanation:
      -- ^[A-Za-z]       -> Starts with a letter
      -- [A-Za-z0-9_.-]* -> Followed by allowed characters (letters, digits, _, ., -)
      -- @leetcode\\.com$ -> Ends strictly with @leetcode.com
      REGEXP '^[A-Za-z][A-Za-z0-9_.-]*@leetcode\\.com$';