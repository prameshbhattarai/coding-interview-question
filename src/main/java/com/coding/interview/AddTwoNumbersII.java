package com.coding.interview;

import java.util.Objects;
import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 */
public class AddTwoNumbersII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this(val);
            this.next = next;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }
    }

    public ListNode addTwoNumberUsingStack(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode prev = new ListNode(0);

        int sum = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            sum = sum / 10;

            if (!stack1.isEmpty()) {
                sum = sum + stack1.pop();
            }

            if (!stack2.isEmpty()) {
                sum = sum + stack2.pop();
            }

            prev.val = sum % 10;

            ListNode head = new ListNode(sum / 10); // carry over
            head.next = prev;

            prev = head;
        }

        return prev.val == 0 ? prev.next : prev;
    }

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode result = add(l1, l2);
        return reverse(result);
    }

    private ListNode add(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum = sum / 10;

            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            result.next = new ListNode(sum % 10);
            result = result.next;
        }

        if (sum / 10 == 1) {
            result.next = new ListNode(1);
        }
        return head.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = prev; // reverse the next to prev

            prev = head; // current node is prev node
            head = next; // move the head to next node
        }
        return prev;
    }

}
