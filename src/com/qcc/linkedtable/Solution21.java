package com.qcc.linkedtable;

import com.qcc.common.ListNode;

/**
 * @Description 21合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Author qianchaochen
 * @Date 2019年10月09日 9:15
 */
public class Solution21 {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode second = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        first.next=l2;
        l2.next=l3;

        second.next=l5;
        l5.next=l6;

        ListNode res = mergeTwoLists(first, second);
        while (res != null) {
            System.out.print(res.val + " => ");
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeList = new ListNode(0);
        ListNode curr = mergeList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return mergeList.next;
    }
}
