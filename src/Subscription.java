public class Subscription {
    private String name;
    private int id;
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


    //methods
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

    public void checkinBook(Book book, Hashtable hashtable, Heap heap) {
        books.remove(book);
        numOfBooks -= 1;
        heap.heapify(heap.getIndex(id));
        hashtable.GetBook(book.getCode()).setReader(null);
    }

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
