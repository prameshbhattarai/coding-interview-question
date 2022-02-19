package com.coding.interview;

import java.util.*;

/**
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag
 * <b> and </b>
 * to wrap the substrings in s that exist in dict.
 * If two such substrings overlap, you need to wrap them together by only one pair of closed
 * bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * <p>
 * <p>
 * Input:
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"Input:
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * <p>
 * <p>
 * Input:
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 */
public class AddBoldTagInString {

    /*
        Solution:
        1. First find all interval (start and end index) of dict in provided string
        2. Merge all the overlapping interval of the dict
        3. Append bold tag in start and end of merged interval
     */

    private List<int[]> createIndexes(String[] dict, String s) {

        List<int[]> indexes = new ArrayList<>();

        for (String eachDict : dict) {
            int startIndex = 0;
            while (startIndex < s.length()) {

                int startIndexOfDict = s.indexOf(eachDict, startIndex);

                if (startIndexOfDict >= 0) {
                    int end = eachDict.length() + startIndexOfDict;
                    indexes.add(new int[]{startIndexOfDict, end});
                    startIndex = end;
                } else break;
            }
        }

        return indexes;
    }

    private List<int[]> mergeOverlappingIndexes(List<int[]> indexes) {
        // sort indexes by first value of each index
        indexes.sort(Comparator.comparingInt(i -> i[0]));

        /*
            [0, 3]
            [1, 4]
            [4, 6]
         */

        List<int[]> mergedIndexes = new ArrayList<>();

        int start = indexes.get(0)[0];
        int end = indexes.get(0)[1];

        for (int[] index : indexes) {

            if (index[0] <= end) {
                // merge the index
                end = index[1];
            } else {
                mergedIndexes.add(new int[]{start, end});
                start = index[0];
                end = index[1];
            }

        }
        mergedIndexes.add(new int[]{start, end});
        return mergedIndexes;
    }

    private String appendTag(String s, List<int[]> mergedIndexes) {
        int pre = 0;
        StringBuilder sb = new StringBuilder();

        // append tag in string
        for (int[] interval : mergedIndexes) {
            sb.append(s, pre, interval[0]);
            sb.append("<b>").append(s, interval[0], interval[1]).append("</b>");
            pre = interval[1];
        }

        // append remaining part of the string
        if (pre < s.length()) {
            sb.append(s.substring(pre));
        }
        return sb.toString();
    }

    public String apply(String[] dict, String s) {
        List<int[]> indexes = createIndexes(dict, s);
//        indexes.forEach(ints -> System.out.println(Arrays.toString(ints)));

        List<int[]> merged = mergeOverlappingIndexes(indexes);
//        merged.forEach(ints -> System.out.println(Arrays.toString(ints)));

        return appendTag(s, merged);
    }

}
