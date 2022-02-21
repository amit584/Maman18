public class Hashtable {
    private int size = 10000;
    private LinkedListBooks[] table;

    //constructor - set size of table and all to null
    public Hashtable(){
        table = new LinkedListBooks[size];
        for (int i = 0; i < size; i++){
            table[i] = null;
        }
    }
    // Input: id: id of book
    // Output: book with the input id
    // Running Time: O(1) for hash, get object at index in array.
    public Book GetBook(String id){
        int hash = hash(id);
        if (table[hash] == null){
            return null;
        }
        else {
            Book book = table[hash].getBook(id);
            return book;
        }
    }

    // Input: code: id of book
    // Output: returns an integer value for the input id
    // Running Time: O(1)
    public int hash(String id){
        String str = id.substring(0,2).toLowerCase();;
        int place = str.charAt(0)-'a'+1;
        int res = 0;
        if(place >= 10){
            res += (place)*10000;
        }
        else{
           res += (place)*100000;
        }
        place = str.charAt(1)-'a'+1;
        if(place >= 10){
            res += (place)*1000;
        }
        else{
            res += (place)*10000;
        }
        res += Integer.parseInt(id.substring(2,6));
        return(res-110000)%size;
    }

    // Input: book: a book object
    // Output: inserts input book to the hashtable
    // Running Time:  O(1) for hash + O(n) for inserting book in the linked list.
    public void add(Book book) {
        int hash = hash(book.getCode());
        if (table[hash] == null) {
            table[hash] = new LinkedListBooks(new LinkedListBooks.Node(book));
        } else {
            table[hash].insert(book);
        }
    }
}
