package com.coding.interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Moving Average from Data Stream
 *
 *  Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 *  For example,
 *
 *  MovingAverage m = new MovingAverage(3);
 *  m.next(1) = 1
 *  m.next(10) = (1 + 10) / 2
 *  m.next(3) = (1 + 10 + 3) / 3
 *  m.next(5) = (10 + 3 + 5) / 3
 *
 *  @tag-design
 *  @tag-stream
 */
public class MovingAverageFromDataStream {

    public double average(int size, int[] values) {

        MovingAverage average = new MovingAverage(size);
        double avg = 0;
        for (int i : values) {
            avg = average.currentAvg(i);
        }
        return avg;
    }

    private static class MovingAverage {

        private double avg = 0.0;
        private final int size;
        private final Queue<Integer> queue;

        public MovingAverage(int size) {
            this.size = size;
            this.queue = new LinkedList<>();
        }

        public double currentAvg(int value) {
            // if the queue size is less than window size
            // then return avg of all the values from queue
            if (queue.size() < this.size) {
                queue.offer(value);
                int sum = 0;
                for (int i : this.queue) {
                    sum += i;
                }
                avg = (double) sum / queue.size();
            } else {
                int polledValue = queue.remove();

                // deduct from avg
                double minus = (double) polledValue / this.size;
                double add = (double) value / this.size;

                avg += (add - minus);
            }
            return avg;
        }

    }

}
