package com.qcc.linkedtable;

import com.qcc.common.ListNode;

/**
 * @Description 160.相交链表
 * @Author qianchaochen
 * @Date 2019年10月09日 13:49
 */
public class Solution160 {

    /**
     * @Description 分析：使用双指针p和q，分别指向两条链表的headA，headB的头，同时向前进一步，
     * 当链表走到尾端时指向另一条链表，这样最终结果两条指针走的次数都是链表的长度和，
     * 如果相交，在某一时刻两个指针必然同时指向同一个节点；
     * 如果不相交，则在走完长度和之后，p和q同时为null，退出循环
     * create by qianchaochen at 2019/10/9 13:59
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        if (p == null || q == null) return null;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

}
