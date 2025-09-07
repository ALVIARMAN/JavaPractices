// Java program for Quick Sort on Singly Linked List

class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {

    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    static Node getTail(Node cur) {
        while (cur != null && cur.next != null)
            cur = cur.next;
        return cur;
    }

    // Partitions the list taking the first element as the pivot
    static Node partition(Node head, Node tail) {

        Node pivot = head;

        // 'pre' and 'curr' are used to shift all
        // smaller nodes' data to the left side of the pivot node
        Node pre = head;
        Node curr = head;

        while (curr != tail.next) {
            if (curr.data < pivot.data) {

                int temp = curr.data;
                curr.data = pre.next.data;
                pre.next.data = temp;
                pre = pre.next;
            }
            curr = curr.next;
        }

        // Swap the pivot's data with 'pre' data
        int currData = pivot.data;
        pivot.data = pre.data;
        pre.data = currData;
        return pre;
    }

    static void Helper(Node head, Node tail) {
        if (head == null || head == tail) return;
        Node pivot = partition(head, tail);

        Helper(head, pivot);
        Helper(pivot.next, tail);
    }
    static Node quickSort(Node head) {
        Node tail = getTail(head);
        Helper(head, tail);
        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(30);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(5);

        head = quickSort(head);
        printList(head);
    }
}
