package com.coding.interview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are N cities numbered from 1 to N.
 * <p>
 * You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.
 * (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
 * <p>
 * Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.
 * The cost is the sum of the connection costs used. If the task is impossible, return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation:
 * There is no way to connect all cities even if all edges are used.
 * <p>
 * Note:
 * 1 <= N <= 10000
 * 1 <= connections.length <= 10000
 * 1 <= connections[i][0], connections[i][1] <= N
 * 0 <= connections[i][2] <= 10^5
 * connections[i][0] != connections[i][1]
 */
public class ConnectingCitiesWithMinCost {

    /*
    Approach:

    Kruskal algorithm:

    The Kruskal algorithm is based on the idea of greed.
    First, we arrange all edges from smallest to largest according to their weights,
    and then select each edge in order. If the two endpoints of this edge do not belong
    to the same set, then merge them until all the points belong to the same set Until the collection.
    As for how to merge into a collection, then here we can use a tool and search collection.

    In other words, the Kruskal algorithm is a greedy algorithm based on union search.
     */
    public int minimumCost(int N, int[][] connections) {
        // first sort the connections by cost, so then select each edge in order
        // we are sorting the connection by cost, cost is at last index of array
        Arrays.sort(connections, Comparator.comparingInt(e -> e[2]));

        int totalCost = 0;

        UnionFind unionFind = new UnionFind(N);
        for (int[] connect : connections) {
            // as we have edge from 1 to N
            // we will merge all the edges into single graph
            if (unionFind.find(connect[0]) != unionFind.find(connect[1])) {
                unionFind.union(connect[0], connect[1]);
                totalCost += connect[2];
            }

            // if count is 1m then we have connected all the edges in the graph
            if (unionFind.count == 1) {
                return totalCost;
            }
        }

//        System.out.println("parent " + Arrays.toString(unionFind.parent));
//        System.out.println("size " + Arrays.toString(unionFind.size));
//        System.out.println("count " + unionFind.count);

        return -1;
    }

    private static class UnionFind {
        private final int[] parent; // parent of the edge
        private final int[] size; // size of the edge
        private int count; // if all the edges are connected then count will be 1

        // as we will have edge from 1 to N
        // first we will assign parent of each edge to itself
        // and size of each connected edges will be 1, as initially no edges are connected
        UnionFind(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i; // initially parent of i will be i
                size[i] = 1; // set of size will be i
            }

            count = n; // initially count will be n
        }

        /*
        find the parent of current edge
         */
        public int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        /*
        connect edge1 with edge2
         */
        public void union(int e1, int e2) {
            int parentOfE1 = find(e1);
            int parentOfE2 = find(e2);

            // connect both edge
            // merge edge into edge collection
            // where size of collection is greater
            if (size[parentOfE1] > size[parentOfE2]) {
                // assign parent of e2 to e1
                parent[parentOfE2] = parentOfE1;

                // increase the size of collection, as we have merge e2 into e1
                size[parentOfE1] += size[parentOfE2];
            } else {
                // assign parent of e1 to e2
                parent[parentOfE1] = parentOfE2;

                // increase the size of collection, as we have merge e1 into e2
                size[parentOfE2] += size[parentOfE1];
            }

            // as we have merge e1 and e2, it means we have created the graph
            count--;
        }
    }
}
