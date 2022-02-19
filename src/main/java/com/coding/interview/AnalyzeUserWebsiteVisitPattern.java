package com.coding.interview;

import java.util.*;

/**
 * Analyze User Website Visit Pattern
 *
 * We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
 *
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.
 * (The websites in a 3-sequence are not necessarily distinct.)
 *
 * Find the 3-sequence visited by the largest number of users. If there is more than one solution,
 * return the lexicographically smallest such 3-sequence.
 *
 *
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 */
public class AnalyzeUserWebsiteVisitPattern {

    private List<List<String>> sortSessionByTimestamp(String[] users, int[] timestamp, String[] websites) {
        List<List<String>> session = new ArrayList<>();
        for (int i = 0; i < users.length; i++) {
            session.add(Arrays.asList(users[i], String.valueOf(timestamp[i]), websites[i]));
        }

        session.sort(Comparator.comparingInt(i -> Integer.parseInt(i.get(1))));
        return session;
    }

    private TreeMap<String, List<String>> userWebsiteMap(List<List<String>> sortedSession) {
        TreeMap<String, List<String>> userWebsiteMap = new TreeMap<>();
        for (List<String> session : sortedSession) {
            String user = session.get(0);
            String website = session.get(2);

            userWebsiteMap.putIfAbsent(user, new ArrayList<>());
            userWebsiteMap.get(user).add(website);
        }
        return userWebsiteMap;
    }

    /*
        For each user, obtain the websites and generate all possible 3-sequences,
        and update the counts of each 3-sequence.
        Note that since the target is to find the 3-sequence visited by the largest number of users,
        for each user, a 3-sequence can be counted at most once. After all users’ 3-sequences are visited,
        obtain the 3-sequence with the maximum count and is the lexicographically smallest, and return the 3-sequence.
     */
    private String find3Sequence(TreeMap<String, List<String>> userWebsiteMap) {
        String maxSequence = "";
        int maxSequenceCount = 0;

        Map<String, Integer> sequenceCount = new HashMap<>();

        for (String user : userWebsiteMap.keySet()) {
            List<String> websiteVisitedByUser = userWebsiteMap.get(user);

            // we are only counting users, who have visited more than 3 websites
            if (websiteVisitedByUser.size() < 3) continue;

            Set<String> sequenceCombination = getCombinationsOfWebsiteVisitedByUser(websiteVisitedByUser);

            for (String sequence : sequenceCombination) {
                int count = sequenceCount.getOrDefault(sequence, 0) + 1;
                sequenceCount.put(sequence, count);

                // if we have two sequence with same count
                // then return the sequence with lexicographically smallest

                // 3-sequence with the maximum count
                if (count > maxSequenceCount) {
                    maxSequenceCount = count;
                    maxSequence = sequence;
                } else if (count == maxSequenceCount && sequence.compareTo(maxSequence) < 0) {
                    // 3-sequence with the maximum count and is the lexicographically smallest
                    maxSequence = sequence;
                }
            }
        }

        return maxSequence;
    }

    private Set<String> getCombinationsOfWebsiteVisitedByUser(List<String> websites) {
        Set<String> sequences = new HashSet<>();

        int size = websites.size();

        // we are creating combination of three websites visited by user
        // so we are using three loops
        // each loop will select one website from respective index
        for (int i = 0; i < size - 2; i++) {

            for (int j = i+1; j < size - 1; j++) {

                for (int k = j+1; k < size; k++) {
                    String combination = websites.get(i) + "," +
                            websites.get(j) + "," +
                            websites.get(k);
                    sequences.add(combination);
                }
            }
        }
        return sequences;
    }

    public String[] mostVisitedPattern(String[] users, int[] timestamp, String[] websites) {
        // sort user visited session by timestamp
        List<List<String>> sortedSession = sortSessionByTimestamp(users, timestamp, websites);

        // user website map
        TreeMap<String, List<String>> userWebsiteMap = userWebsiteMap(sortedSession);

        // 3-sequence with the maximum count and is the lexicographically smallest
        String maxSequence = find3Sequence(userWebsiteMap);

        // return the sequence
        return maxSequence.split(",");
    }
}
