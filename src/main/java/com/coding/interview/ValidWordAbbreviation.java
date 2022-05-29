package com.coding.interview;

/**
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
 * <p>
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * <p>
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
 * <p>
 * Example 1:
 * Given s = "internationalization", abbr = "i12iz4n":
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * Given s = "apple", abbr = "a2e":
 * <p>
 * Return false.
 */
public class ValidWordAbbreviation {

    /*
    Logic:
        iterate each char in abbrev
        if it is digit, skip by that digit number
        if it is alpha, compare it is equal or not
        
        at the end pointer of both word and abbrev should be equal to its respective length
     */
    public boolean isValid(String word, String abbrev) {

        char[] wordArray = word.toCharArray();
        char[] abbrevArray = abbrev.toCharArray();

        int wordLength = word.length();
        int abbrevLength = abbrev.length();

        // pointer of word and abbrev
        int i = 0, j = 0;

        while (i < wordLength && j < abbrevLength) {
        
            if (Character.isDigit(abbrevArray[j])) {
                // increment the pointer of word by abbrevArray[j]
                
                if (abbrevArray[j] == '0') return false;
                
                // skip pointer of i skipper
                int skipper = 0;
                while (j < abbrevLength && Character.isDigit(abbrevArray[j])) {
                    // if we have double digit in the abbrev to skip
                    // a24z then we need to skip 24 character
                    skipper = skipper * 10 + (abbrevArray[j] - '0');
                    j++; // increment abbrev pointer
                }
                // finally increment word pointer by skipper
                i += skipper;
            } else {
                // compare value of wordArray[i] == abbrevArray[j]
                if (wordArray[i] != abbrevArray[j]) return false;
                i++; j++;
            }
        }
        return i == wordLength && j == abbrevLength;
    }
}
