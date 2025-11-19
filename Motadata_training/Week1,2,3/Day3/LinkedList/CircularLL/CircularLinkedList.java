public class CircularLinkedList {

    static class CNode {
        String data;
        CNode next;

        CNode(String data) {
            this.data = data;
        }
    }

    CNode head, tail;
    int size;

    public void add(String data) {
        CNode newNode = new CNode(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head; 
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        CNode temp = head;
        do {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to start)");
    }

    public static void main(String[] args) {

        CircularLinkedList cll = new CircularLinkedList();

        cll.add("A");
        cll.add("B");
        cll.add("C");
        cll.add("D");

        cll.printList();
    }
}
