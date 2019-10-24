package com.qcc.linkedtable;

import com.qcc.common.ListNode;

/**
 * @Description 206.反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author qianchaochen
 * @Date 2019年10月09日 15:10
 */
public class Solution206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        head.next = l1;
        l1.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode res = reverseList(head);
        while (res != null) {
            System.out.print(res.val + " => ");
            res = res.next;
        }
    }

    /**
     * @Description 反转示例图如下：
     *         1 -> 2 -> 3 -> 4 -> 5 -> null
     * null <- 1 <- 2 <- 3 <- 4 <- 5
     * create by qianchaochen at 2019/10/9 17:42
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;//前指针节点
        ListNode cur = head;//当前指针节点

        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (cur != null) {
            ListNode next = cur.next;//临时节点，暂存当前节点的下一节点，用于后移
            cur.next = pre;//将当前节点指向它前面的节点
            pre = cur;//前指针后移
            cur = next;//当前指针后移
        }
        return pre;
    }

}
