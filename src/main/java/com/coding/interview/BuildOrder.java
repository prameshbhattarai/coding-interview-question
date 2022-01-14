package com.coding.interview;

import java.util.Stack;

/**
 * Given a list of packages that need to be built and the dependencies for each
 * package, determine a valid order in which to build the packages.
 *
 * eg.
 *
 * 0:
 * 1: 0
 * 2: 0
 * 3: 1, 2
 * 4: 3
 *
 * output: 0, 1, 2, 3, 4
 */
public class BuildOrder {

    /*
    Implementation done using Topology Sorting, we can only do Topology Sorting on Acyclic Graph.

    Topology sort algorithm takes a directed graph and returns an array of the nodes where each node
    appears before all the nodes it points to.

    We need to do DFS on each adjacent node of each node.

    Graph
       <- 1 <-
    0           3 <- 4
       <- 2 <-

    our input order
    0:
    1: 0
    2: 0
    3: 1, 2
    4: 3

    Step: 1
    we will select index 0, which is not visited so we will traverse all the adjacent node of index 0
    we do not have any adjacent node in index 0, so will mark it as visited node and insert into stack

    Step: 2
    then we will select index 1, which is not visited so we will traverse all the adjacent node of index 1
    index 1 have, index 0 as adjacent node

    now again we will visit index 0 (recursive call)
    we find out index 0 is already visited, we will skip it

    we do not have any other adjacent node in index 1, so will mark it as visited node and insert into stack

    Step: 3
    then we will select index 2, which is not visited so we will traverse all the adjacent node of index 1
    index 1 have, index 0 as adjacent node

    now again we will visit index 0 (recursive call)
    we find out index 0 is already visited, we will skip it

    we do not have any other adjacent node in index 2, so will mark it as visited node and insert into stack

    Step: 4
    then we will select index 3, which is not visited so we will traverse all the adjacent node of index 1
    index 1 have, index 1 and 2 as adjacent node

    now again we will visit index 1 (recursive call)
    we find out index 1 is already visited, we will skip it

    now again we will visit index 2 (recursive call)
    we find out index 2 is already visited, we will skip it

    we do not have any other adjacent node in index 3, so will mark it as visited node and insert into stack

    Step: 5
    then we will select index 4, which is not visited so we will traverse all the adjacent node of index 1
    index 1 have, index 3 as adjacent node

    now again we will visit index 3 (recursive call)
    we find out index 3 is already visited, we will skip it

    we do not have any other adjacent node in index 4, so will mark it as visited node and insert into stack

    finally we will iterate stack and pop each element to result

     */
    private final Stack<Integer> result = new Stack<>();

    public int[] topologySort(int[][] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                traverse(visited, graph, i);
            }
        }

        int[] sorted = new int[result.size()];
        int i = result.size()-1;
        while(!result.isEmpty()) {
            sorted[i--] = result.pop();
        }
        return sorted;
    }

    private void traverse(boolean[] visited, int[][] graph, int currentNode) {
        visited[currentNode] = true;
        for (int i = 0; i < graph[currentNode].length; i++) {
            if (!visited[i]) {
                traverse(visited, graph, i);
            }
        }
        result.push(currentNode);
    }


}
