public class LinkedListBooks {
    Node head; // head of list

    // Linked list Node.
    static class Node {

        Book data;
        Node next;
        Node prev;

        // Constructor to create a new node - Next, prev initialized to null
        Node(Book b) {
            data = b;
            next = null;
            prev = null;
        }
    }

    // Constructor to create a new linked list with given node as head of list
    public LinkedListBooks(Node n){
        head = n;
    }

    // Input: data: data for new node
    // Output: creat and insert the new node to the list
    // Running Time: O(n) where n current size of list (O(1) for an empty list)
    public void insert(Book data)
    {
        Node new_node = new Node(data);

        // If the Linked List is empty, make the new node as head
        if (this.head != null) {
            // insert the new node at the start
            new_node.next = this.head;
            this.head.prev = new_node;
        }
        this.head = new_node;
    }

    // Input: data: data for removed node
    // Output: search and removes the input node
    // Running Time: O(n) where n current size of list
    public void remove(Book data) {
        Node temp = this.head;
        //if first node
        if (temp.data.equals(data)) {
            if (temp.next == null) {
                this.head = null;
            }
            temp.next.prev = temp.prev;
            this.head = temp.next;
        } else {
            temp = temp.next;
            while (temp != null) {
                if (temp.data.equals(data)) {
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                    temp = temp.next;
                }
            }
        }
    }

    // Method to print the LinkedList.
    public static void printList(LinkedListBooks list)
    {
        Node currNode = list.head;
        // go through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public Book getBook(String id) {
        Node temp = this.head;

        //2. create two variables: found - to track
        //   search, idx - to track current index
        int found = 0;
        int i = 0;

        //3. if the temp node is not null check the
        //   node value with searchValue, if found
        //   update variables and break the loop, else
        //   continue searching till temp node is not null
        while (temp != null) {
            if (temp.data.getCode().equals(id)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return temp.data;
    }
}
