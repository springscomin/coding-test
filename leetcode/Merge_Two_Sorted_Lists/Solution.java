package leetcode.Merge_Two_Sorted_Lists;

import java.util.Objects;

class ListNode {
    int val;
    ListNode next;

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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer;

        if (Objects.isNull(list1) && Objects.isNull(list2)) return null;
        else if (Objects.isNull(list1)) return list2;
        else if (Objects.isNull(list2)) return list1;
        else {
            answer = new ListNode();
            if (list1.val > list2.val) {
                answer.val = list2.val;
                list2 = list2.next;
            } else {
                answer.val = list1.val;
                list1 = list1.next;
            }
            sort(list1, list2, answer);
        }
        return answer;
    }

    public void sort(ListNode list1, ListNode list2, ListNode node) {
        if (Objects.isNull(list1)) node.next = list2;
        else if (Objects.isNull(list2)) node.next = list1;
        else {
            if (list1.val > list2.val) {
                node.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                node.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            sort(list1, list2, node.next);
        }
    }
}
