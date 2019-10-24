package com.qcc.linkedtable;

/**
 * @Description 707. 设计链表
 * @Author qianchaochen
 * @Date 2019年10月10日 15:25
 */
public class Solution707 {


}

class MyLinkedList {

    /**
     * 节点类的定义
     */
    class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    int size;
    Node first;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    public Node find(int index) {
        if (index < 0 || index >= size) return null;
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = find(index);
        return node == null ? -1 : node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            first = new Node(val, first);
        } else {
            Node pre = find(index - 1);
            if (pre == null) return;
            pre.next = new Node(val, pre.next);
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            Node node = find(index - 1);
            if (node == null) {
                first = first.next;
            } else {
//                if(node == null) return;
                node.next = node.next.next;
            }
            size--;
        }
    }
}
