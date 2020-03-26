import java.util.*;

public class SortedLinkedList {

    public static void main(String[] args) {
        /*ListNode x1 = new ListNode(-1);
        ListNode x2 = new ListNode(5);
        ListNode x3 = new ListNode(3);
        ListNode x4 = new ListNode(4);
        ListNode x5 = new ListNode(0);
        x1.next = x2;
        x2.next = x3;
        x3.next = x4;
        x4.next = x5;*/
        int i = 5000;
        ListNode x = new ListNode(i);
        ListNode head = x;
        while(i > 0) {
            x.next = new ListNode(--i);
            x = x.next;
        }
        ListNode listNode = insertionSortList(head);
        while (listNode.next != null) {
            System.out.print(listNode.val + "-->");
            listNode = listNode.next;
        }
        System.out.print(listNode.val);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode insertionSortList(ListNode head) {
        /*if (head == null) {
            return null;
        }
        int i = 1;
        boolean run = true;
        while(run) {
            ListNode key = head;
            for (int m = 0; m < i; m++) {
                if (key.next != null) {
                    key = key.next;
                } else {
                    run = false;
                    break;
                }
            }
            if(!run) {
                break;
            }
            int j = i - 1;

            while (j >= 0) {
                ListNode comp = head;
                ListNode prev = head;
                for (int n = 0; n < j; n++) {
                    prev = comp;
                    comp = comp.next;
                }
                if (key.val < comp.val) {
                    comp.next = key.next;
                    key.next = comp;
                    if(!comp.equals(prev)) {
                        prev.next = key;
                    }
                    if (j == 0) {
                        head = key;
                    }
                    j--;
                } else {
                    j = -1;
                }
            }
            i++;
        }
        return head;
    }*/
        if (head == null) return head;
        ListNode pivot = new ListNode(Integer.MIN_VALUE), toInsert, preInsert;
        pivot.next = head;
        ListNode p = head;
        while (p.next != null) {
            if (p.val <= p.next.val) p = p.next;
            else {
                preInsert = pivot;
                toInsert = p.next;
                p.next = toInsert.next;
                while (preInsert.next.val <= toInsert.val) {
                    preInsert = preInsert.next;
                }
                toInsert.next = preInsert.next;
                preInsert.next = toInsert;
            }
        }
        return pivot.next;
    }
}
