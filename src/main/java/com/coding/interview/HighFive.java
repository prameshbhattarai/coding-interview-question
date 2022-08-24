package com.coding.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *  Given a list of scores of different students,
 *  return the average score of each student's top five scores in the order of each student's id.
 *
 *  Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.
 *  The average score is calculated using integer division.
 *
 *
 *  Example 1:
 *
 *  Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 *  Output: [[1,87],[2,88]]
 *  Explanation:
 *      The average of the student with id = 1 is 87.
 *      The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 *
 *
 *  Note:
 *
 *      1 <= items.length <= 1000
 *      items[i].length == 2
 *      The IDs of the students is between 1 to 1000
 *      The score of the students is between 1 to 100
 *      For each student, there are at least 5 scores
 */
public class HighFive {

    /*
        Create map of student id and priority queue
        priority queue will be size 5
        then iterate the array list and insert it into the map
        and finally iterate the map, and create average score of the student

     */
    public int[][] highFive(int[][] items) {

        // create map of student id and priority queue
        Map<Integer, PriorityQueue<Integer>> lookup = new HashMap<>();

        for (int[] item : items) {
            int studentId = item[0];
            int score = item[1];

            PriorityQueue<Integer> queue = lookup.get(studentId);

            if (queue == null) {
                queue = new PriorityQueue<>(5);
                lookup.put(studentId, queue);
            }
            queue.add(score);

            // priority queue should be always less than or equal to 5
            // as we are getting average of top 5 highest score
            if (queue.size() > 5) {
                queue.poll(); // remove the item from the queue
            }
        }

        // now iterate the map and find the average score of the student
        int[][] result = new int[lookup.size()][2];

        int index = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> eachSet : lookup.entrySet()) {
            int studentId = eachSet.getKey();
            PriorityQueue<Integer> queue = eachSet.getValue();
            int size = queue.size();
            int sum = 0;
            while (!queue.isEmpty()) {
                sum += queue.poll();
            }
            int average = sum / size;

            result[index][0] = studentId;
            result[index][1] = average;
            index++;
        }

        return result;
    }
}
