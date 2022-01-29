package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountMergeTest {

    private final static AccountMerge accountMerge = new AccountMerge();

    @Test
    public void testAccountMerge1() {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));

        List<List<String>> expectedMergedAccounts = new ArrayList<>();
        expectedMergedAccounts.add(Arrays.asList("John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"));
        expectedMergedAccounts.add(Arrays.asList("Mary","mary@mail.com"));
        expectedMergedAccounts.add(Arrays.asList("John","johnnybravo@mail.com"));

        List<List<String>> mergedAccounts = accountMerge.accountsMerge(accounts);

        Assertions.assertEquals(expectedMergedAccounts, mergedAccounts);
    }

    @Test
    public void testAccountMerge2() {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"));
        accounts.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"));
        accounts.add(Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"));
        accounts.add(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"));

        List<List<String>> expectedMergedAccounts = new ArrayList<>();
        expectedMergedAccounts.add(Arrays.asList("Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"));
        expectedMergedAccounts.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"));
        expectedMergedAccounts.add(Arrays.asList("Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"));
        expectedMergedAccounts.add(Arrays.asList("Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"));
        expectedMergedAccounts.add(Arrays.asList("Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"));

        List<List<String>> mergedAccounts = accountMerge.accountsMerge(accounts);

        Assertions.assertEquals(expectedMergedAccounts, mergedAccounts);
    }
}
