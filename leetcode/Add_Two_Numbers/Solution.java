package leetcode.Add_Two_Numbers;

import java.util.Objects;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(new int[]{9});
        ListNode l2 = new ListNode(new int[]{9,9,9,9});
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(listNode);
        while (true) {
            System.out.println(listNode.val);
            if (Objects.isNull(listNode.next)) break;
            listNode = listNode.next;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return cal(0, l1, l2);
    }

    public ListNode cal(int up, ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val + up;
        ListNode node = new ListNode(sum % 10);
        if (!Objects.isNull(l1.next) && !Objects.isNull(l2.next)) {
            node.next = cal(sum / 10, l1.next, l2.next);
        } else {
            if (Objects.isNull(l1.next) && !Objects.isNull(l2.next)) {
                node.next = cal(sum / 10, l2.next);
            } else if (!Objects.isNull(l1.next)) {
                node.next = cal(sum / 10, l1.next);
            } else if (sum >= 10) {
                node.next = new ListNode(sum / 10);
            }
        }
        return node;
    }

    public ListNode cal(int up, ListNode l) {
        int sum = l.val + up;
        ListNode node = new ListNode(sum % 10);
        if (!Objects.isNull(l.next)) {
            node.next = cal(sum / 10, l.next);
        } else if (sum >= 10) {
            node.next = new ListNode(sum / 10);
        }
        return node;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int[] nums) {
        ListNode temp = this;
        this.val = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = node;
        }
    }

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
