package lintcode;

import java.util.HashMap;

/**
 * Created by ouakira on 2017/5/19.
 */
public class LinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        printNode(rotateRight(head, 2));
    }

    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void deleteNode(ListNode node) {
        // write your code here
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 96-链表划分
     */
    public static ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode minNode = new ListNode(0);
        ListNode maxNode = new ListNode(0);
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                
            }
        }
        return head;
    }

    /**
     * 170-旋转链表
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode node = head;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            len++;
        }
        k = k % len;
        while (k-- > 0) {
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        return newHead;
    }

    /**
     * 35-翻转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = null;
        ListNode next = head;
        ListNode third = next.next;
        while (true) {
            next.next = node;
            node = next;
            next = third;
            third = next.next;
            if (third == null) {
                break;
            }
        }
        next.next = node;
        return next;
    }

    /**
     * 112-删除排序链表中的重复元素
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next == null) {
                return head;
            }
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    /**
     * 174-删除链表中倒数第n个节点
     *
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

    /**
     * 165-合并两个排序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }
        return head;
    }

    /**
     * 102-带环链表
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode preNode = head;
        ListNode node = head;
        while (node != null && node.next != null) {
            preNode = preNode.next;
            node = node.next.next;
            if (node == preNode) {
                return true;
            }
        }
        return false;
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
