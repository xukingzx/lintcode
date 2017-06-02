package lintcode;

/**
 * Created by ouakira on 2017/5/19.
 */
public class LinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node = head.next.next = new ListNode(3);
        node.next = null;
        node = removeElements(head, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void deleteNode(ListNode node) {
        // write your code here
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 174-删除链表中倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    static ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1;
        ListNode node = head;
        ListNode preNode = head;
        while (node != null) {
            if (i > n + 1) {
                preNode = preNode.next;
            }
            node = node.next;
            i++;
        }
        if (i <= n) {
            return head;
        }
        if (i - 1 == n) {
            if (preNode.next == null) {
                return null;
            }
            preNode.val = preNode.next.val;
            preNode.next = preNode.next.next;
            return head;
        }
        preNode.next = preNode.next.next;
        return head;
    }

    public static ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return head;
        }
        ListNode node = head;
        ListNode next = head.next;
        while (node.next != null) {
            if (next.val == val) {
                node.next = next.next;
                next = node.next;
            } else {
                node = node.next;
                next = node.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}


// Definition for ListNode.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
