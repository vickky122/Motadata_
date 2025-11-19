class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Compare Node to a value WITHOUT using .data externally
    boolean isEqual(int value) {
        return this.data == value;
    }
}

class SinglyLinkedList {
    Node head;
    Node tail;
    int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete element.");
            return;
        }
        head = head.next;
        if (head == null) tail = null;
        size--;
    }

    // Delete a node with given value
    public void delete(int value) {

        if (head == null) return;

        // Case 1: Delete at head
        if (head.isEqual(value)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return;
        }

        // Case 2: Delete in middle or end
        Node prev = null, curr = head;

        while (curr != null) {

            if (curr.isEqual(value)) {
                prev.next = curr.next;

                if (curr == tail) tail = prev;

                size--;
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);
        list.printList(); // 5 -> 10 -> 20 -> null

        list.delete(10);
        list.printList(); // 5 -> 20 -> null

        list.deleteFirst();
        list.printList(); // 20 -> null
    }
}

