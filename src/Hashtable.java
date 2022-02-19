public class Hashtable {
    private int size = 4435236;
    private LinkedListBooks[] table;

    public Hashtable(){
        table = new LinkedListBooks[size];
        for (int i = 0; i < size; i++){
            table[i] = null;
        }
    }
    public Book GetBook(String id){
        int hash = id.hashCode();
        if (table[hash] == null){
            return null;
        }
        else {
            Book book = table[hash].getBook(id);
            return book;
        }
    }
    public int hash(String code){
        String str = code.substring(0,2).toLowerCase();;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int res = 0;
        res += (alphabet.indexOf(str.charAt(0))+1)*(Math.pow(10,5));
        res += (alphabet.indexOf(str.charAt(1))+1)*(Math.pow(10,4));
        res += Integer.parseInt(code.substring(2,6));
        return(res);
    }
    public void add(Book book) {
        int hash = hash(book.getCode());
        if (table[hash] == null) {
            table[hash] = new LinkedListBooks(new LinkedListBooks.Node(book));
        } else {
            table[hash].insert(book);
        }
    }
}
