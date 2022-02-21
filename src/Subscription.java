public class Subscription {
    private final String name;
    private final int id;
    private LinkedListBooks books;
    private int numOfBooks;

    //Constructor
    public Subscription(String name, int id) {
        this.name = name;
        this.id = id;
        this.numOfBooks=0;
    }
    //O(1)
    public int getNumOfBooks() {
        return numOfBooks;
    }
    //O(1)
    public String getName() {
        return name;
    }
    //O(1)
    public int getId() {
        return id;
    }


    // Input: book, hashtable, heap
    // Output: if no more than 10 books, book is added to list of books, corrects heap. else - error message
    // Running Time: O(1) insert book in start of list, set reader for book, change numOfBooks + O(log n) for
    //heapIncreaseKey
    public void checkoutBook (Book book, Hashtable table, Heap heap){
        if(numOfBooks < 10){
            if(books == null){
                LinkedListBooks.Node new_node = new LinkedListBooks.Node(book);
                books = new LinkedListBooks(new_node);
            }else{
                books.insert(book);
            }
            numOfBooks += 1;
            heap.heapIncreaseKey(heap.getIndex(id));
            book.setReader(this);
            table.add(book);
        }
        else {
            System.out.println("cant check out more than 10 books");
        }
    }

    // Input: book, hashtable, heap
    // Output: removes input book from list of books, corrects heap if needed and set reader of book to null
    // Running Time: O(n) to remove book from list + O(1) change numOfBooks, set reader for book + O(log n) for heapify
    public void checkinBook(Book book, Hashtable hashtable, Heap heap) {
        books.remove(book);
        numOfBooks -= 1;
        heap.heapify(heap.getIndex(id));
        hashtable.GetBook(book.getCode()).setReader(null);
    }

    // Input:
    // Output: list of books for this subscription
    // Running Time: O(n) where n is length of list (numberOfBooks)
    public void printBooks(){
        if(numOfBooks == 0 ){
            System.out.println("There are no books for this subscription");
        }
        else {
            System.out.println("Books for this subscription: ");
            LinkedListBooks.Node temp = books.head;
            while (temp != null) {
                System.out.print(temp.data.getCode() + ", ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
