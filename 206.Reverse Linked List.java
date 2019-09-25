//solution 1
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}

Complexity analysis

Time complexity : O(n)O(n). Assume that nn is the list length,
the time complexity is O(n)O(n).

Space complexity : O(n)O(n). The extra space comes from implicit
stack space due to recursion. The recursion could go up to nn levels deep.


//solution 2, Java iterative and recursive
public ListNode reverseList1(ListNode head) {
    ListNode node = null;
    while (head != null) {
        ListNode nxt = head.next;
        head.next = node;
        node = head;
        head = nxt;
    }
    return node;
}

public ListNode reverseList2(ListNode head) {
    return helper(head, null);
}

private ListNode helper(ListNode head, ListNode node) {
    if (head == null) {
        return node;
    }
    ListNode nxt = head.next;
    head.next = node;
    return helper(nxt, head);
}

public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}


//solution 3
public class Solution {
public ListNode reverseList(ListNode head) {
    if (head == null) {
        return null;
    }

    ListNode node = head,
            prev = null,
            reversed = null;

    while (node != null) {
        final ListNode next = node.next;
        if (node.next == null) {
            reversed = node;
        }
        node.next = prev;
        prev = node;
        node = next;
    }
    return reversed;
}
}


//中文教程 solution
//https://outlook.office.com/mail/inbox/id/AAQkAGQ5ZWFmODkzLTg3MDMtNDc1OS05ZTkxLTI5MmIzNDU1Y2RhMgAQAJNK0RvnC0xOuf%2FHduVlCT8%3D
2. 反转链表　　
    本题的要求是输入一个链表，反转链表后，输出链表的所有元素。这道题的实现也比较直接，如以下代码所示：

复制代码
public ListNode ReverseList(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode current = head;
    //原head的next node为null
    ListNode prevNode = null;
    ListNode newHead = null;

    while (current != null) {
        ListNode nextNode = current.next;
        current.next = prevNode;
        if (nextNode == null) {
            newHead = current;
        }
        prevNode = current;
        current = nextNode;
    }
    return newHead;
}
