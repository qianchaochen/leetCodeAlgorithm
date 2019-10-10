package com.qcc;

import com.qcc.common.ListNode;

/**
 * @Description 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * @Author qianchaochen
 * @Date 2019年10月10日 13:51
 */
public class Solution234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        head.next = l1;
        l1.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        boolean res = isPalindrome(head);
        System.out.println(res);
    }

    /**
     * @Description 分析：使用快慢指针，找到列表中间的节点。然后把后半部分进行反转，然后与前半部分进行比如是否一致。
     *
     * create by qianchaochen at 2019/10/10 13:54
     */
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow.next);

        while (slow != null) {
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre= null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
