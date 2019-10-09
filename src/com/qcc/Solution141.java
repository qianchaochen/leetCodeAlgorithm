package com.qcc;

import com.qcc.common.ListNode;

/**
 * @Description 141.环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * @Author qianchaochen
 * @Date 2019年10月09日 11:28
 */
public class Solution141 {

    /**
     * @Description 使用快慢双指针，慢指针一次走一步，快指针一次走两步，如果快指针指向null，则说明无环；
     * 如果有环，则快指针必然能再次追上慢指针
     * create by qianchaochen at 2019/10/9 11:30
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}
