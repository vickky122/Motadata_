class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addLast(10);
        dll.addLast(20);
        dll.addFirst(5);
        dll.printList(); // 5 -> 10 -> 20 -> null
        dll.printReverseList(); // 20 -> 10 -> 5 -> null
        dll.deleteFirst();
        dll.printList(); // 10 -> 20 -> null
        dll.deleteLast();
        dll.printList(); // 10 -> null
        System.out.println("Size: " + dll.getSize()); // Size: 1
    }
}
    class DoublyLinkedList {
    private DLLNode head;
    private DLLNode tail;
    private int size;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public void addFirst(int data) {
        DLLNode newNode = new DLLNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(int data) {
        DLLNode newNode = new DLLNode(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
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
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // List became empty
        }
        size--;
    }
    public void deleteLast() {
        if (tail == null) {
            System.out.println("List is empty. Cannot delete element.");
            return;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // List became empty
        }
        size--;
    }
    public int getSize() {
        return size;
    }
    public void printList() {
        DLLNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public void printReverseList() {
        DLLNode current = tail;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.prev;
        }
        System.out.println("null");
    
    }
    
}
