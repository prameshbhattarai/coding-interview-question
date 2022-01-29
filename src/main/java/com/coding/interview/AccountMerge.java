package com.coding.interview;

import java.util.*;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 *
 * Explanation:
 * The first and second John's are the same person as they have the common email "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 *
 * Union Find Algorithm
 */
public class AccountMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parents = new int[accounts.size()];

        // assign a parent to each list
        // initially each list is parent of its own
        for (int i = 0; i < accounts.size(); i++) {
            parents[i] = i;
        }

        // find parent of each email
        findParentOfEachEmail(accounts, parents);

        // now all the parents are found
        // merge the list which have same parent
        Map<Integer, TreeSet<String>> parentAndEmails = mergeEmailsWithSameParents(accounts, parents);

        // create a list of accounts with all emails
        List<List<String>> result = new ArrayList<>();
        for (Integer parent : parentAndEmails.keySet()) {
            String user = accounts.get(parent).get(0);
            List<String> emails = new ArrayList<>(parentAndEmails.get(parent));
            emails.add(0, user); // add user in first index
            result.add(emails);
        }

        return result;
    }

    /**
     * Merge emails with same parents
     * @param accounts
     * @param parents
     * @return Map<Integer, TreeSet<String>>
     */
    private Map<Integer, TreeSet<String>> mergeEmailsWithSameParents(List<List<String>> accounts, int[] parents) {
        Map<Integer, TreeSet<String>> parentAndEmails = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            // get the parent of current index
            // if the current index does not have parent, then it will return same index (i)
            // else it will return the index of parent
            int parent = findParent(parents, i);

            // emails of current list
            List<String> emails = accounts.get(i);

            // create TreeSet to sort all the emails for respective parent
            parentAndEmails.putIfAbsent(parent, new TreeSet<String>());

            // add all the emails
            parentAndEmails.get(parent).addAll(emails.subList(1, emails.size()));
        }
        return parentAndEmails;
    }

    /**
     * Finding the actual parent of email, we can have same email in multiple account
     * so we will find the parent of each email.
     * @param accounts
     * @param parents
     */
    private void findParentOfEachEmail(List<List<String>> accounts, int[] parents) {
        Map<String, Integer> emailToParent = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            // first value of account will be the name, so we will iterate from index 1

            List<String> emails = accounts.get(i);
            for (int j = 1; j < emails.size(); j++) {
                if (emailToParent.containsKey(emails.get(j))) {

                    // parent of email
                    int emailParent = emailToParent.get(emails.get(j));

                    // find parent of current list
                    int parentOfCurrentList = findParent(parents, i);

                    // find top parent of current email
                    int parentOfCurrentEmail = findParent(parents, emailParent);

                    // if parent of current email is not linked with parent of current list
                    // then link it
                    if (parentOfCurrentList != parentOfCurrentEmail) {
                        parents[parentOfCurrentEmail] = parentOfCurrentList;
                    }
                } else {
                    // this email parent is not found
                    // so we will assign its index as its parent
                    emailToParent.put(emails.get(j), i);
                }
            }
        }
    }

    private int findParent(int[] parents, int index) {
        // loop until we reach the parent
        // if current index == parent[index], then we will reach parent
        // top parent value and index will be same
        if (parents[index] == index) return index;
        return findParent(parents, parents[index]);
    }
}
