package com.qcc;

import com.qcc.common.ListNode;

/**
 * @Description 203.移除链表中指定的元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @Author qianchaochen
 * @Date 2019年10月09日 14:05
 */
public class Solution203 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode res = removeElements(head, 6);
        while (res != null) {
            System.out.print(res.val + " => ");
            res = res.next;
        }
    }

    /**
     * @Description
     * 思路：此题删除链表中元素是很简单的，只需要让待删节点之前一个节点指向待删节点之后一个节点即可。
     * 此题最大的问题就是，题目要求我们要返回新链表中的头结点，如果我们就采用仅仅复制头结点的方式(用H=head)然后用H进行操作，最后返回head。
     * 这样就会导致如果头结点也是我们需要删除的节点就会导致错误。当然我们可以采用循环操作判断第一个不是我们要删除的节点，但是这样有些麻烦。
     * 最好的方式就是我们创建一个新节点来作为整个链表的头结点，该节点中的值没有意义，只是用该节点来方便我们的操作。
     * 如果用pre->next=head; 此时 我们操作pre的话就把原先的头结点当做了一个普通节点来操作，此时原先的头结点就可以被删除了。
     * 最后返回pre->next就满足条件了。
     * create by qianchaochen at 2019/10/9 15:02
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode curr = pre;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return pre.next;
    }

}
