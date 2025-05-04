class ListNode {  // Odd Linked List
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        // If the list is empty or has only one node, return it as is
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize the pointers for odd and even nodes
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Keep a reference to the head of even list

        // Traverse the list and rearrange the odd and even nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Skip the even node
            even.next = even.next.next; // Skip the next odd node

            odd = odd.next; // Move the odd pointer to the next odd node
            even = even.next; // Move the even pointer to the next even node
        }

        // Connect the end of the odd list to the head of the even list
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original list
        System.out.println("Original List:");
        printList(head);

        // Call the oddEvenList method
        Solution solution = new Solution();
        ListNode newHead = solution.oddEvenList(head);

        // Print the reordered list
        System.out.println("\nReordered List:");
        printList(newHead);
    }

    // Utility method to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
