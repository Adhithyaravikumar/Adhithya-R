class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class LinkedListAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummyHead.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test cases
        testAddition(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8});
        testAddition(new int[]{0}, new int[]{0}, new int[]{0});
        testAddition(new int[]{9, 9, 9, 9}, new int[]{1}, new int[]{0, 0, 0, 0, 1});
        testAddition(new int[]{}, new int[]{}, new int[]{0});
    }

    private static void testAddition(int[] arr1, int[] arr2, int[] expected) {
        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);
        LinkedListAddition solution = new LinkedListAddition();
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        printList(result);
    }

    private static ListNode createList(int[] arr) {
        if (arr.length == 0) return new ListNode(0);
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
}
