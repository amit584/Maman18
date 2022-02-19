public class Person {
    private String name;
    private int id;
    private LinkedListBooks books;
    private int numOfBooks;

    //Constructor
    public Person(String name,int id) {
        this.name = name;
        this.id = id;
        this.numOfBooks=0;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }
    public String getName() {
        return name;
    }
    public int getId() {return id; }


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

    public void checkinBook(Book book, Hashtable hashtable) {
        books.remove(book);
        hashtable.GetBook(book.getCode()).setReader(null);
    }

    public void printBooks(){
        LinkedListBooks.Node temp = books.head;
        while (temp!= null){
            System.out.println(temp.data.getCode());
            temp= temp.next;
        }
    }
}
