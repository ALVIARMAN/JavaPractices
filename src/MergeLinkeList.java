public class MergeLinkeList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head=null;

    static void InsertFirst(int data){
        Node nn= new Node(data);
        nn.next=head;
        head=nn;
    }

    static Node Merge(Node head){
        if(head==null || head.next==null)return head;
        Node mid=GetMiddle(head);
        Node rightHead=mid.next;
        mid.next=null;

        Node left=Merge(head);
        Node right=Merge(rightHead);

        return MergeSort(left,right);
    }
    static Node GetMiddle(Node head){
        if(head==null)return null;
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node MergeSort(Node left,Node right){
        Node dummy=new Node(-1);
        Node curr=dummy;
        while(left!=null && right!=null){
            if(left.data<= right.data){
                curr.next=left;
                left=left.next;
            }else{
                curr.next=right;
                right=right.next;
            }curr=curr.next;
        }
        curr.next=(left!=null)?left:right;
        return dummy.next;
    }

    static void Display(Node head){
        if(head==null)return;
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" > ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        InsertFirst(4);
        InsertFirst(3);
        InsertFirst(9);
        InsertFirst(7);
        InsertFirst(6);
        Display(head);
        Node n= Merge(head);
        Display(n);
    }
}