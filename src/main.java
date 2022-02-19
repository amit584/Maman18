import java.util.Scanner;

public class main {
    public static final int checkBook = 4;
    public static final int subscription = 3;
    public static final int query = 2;
    public static final int first = 0;
    public static final int second = 1;
    public static final int third = 2;
    public static final int fourth = 3;




    public static void getReq(String[] reqsplit, Hashtable hashtable, Heap h){
        if(reqsplit.length == checkBook) {
            if (reqsplit[first].equals("+")) {
                Person p1 = new Person(reqsplit[second], Integer.parseInt(reqsplit[third]));
                h.add(p1);
            }
            if (reqsplit[first].equals("-")) {
                int place = h.getIndex(Integer.parseInt(reqsplit[2]));
                h.Delete(place);
            }
        }
        if(reqsplit.length == subscription){
            if(reqsplit[fourth].equals("+")){
                Book b = new Book(reqsplit[third]);
                int place = h.getIndex(Integer.parseInt(reqsplit[second]));
                h.getHeap()[place].checkoutBook(b,hashtable,h);
            }
            if(reqsplit[fourth].equals("-")) {
                int place = h.getIndex(Integer.parseInt(reqsplit[second]));
                Book b = hashtable.GetBook(reqsplit[third]);
                h.getHeap()[place].checkinBook(b, hashtable);
            }
        }
        if (reqsplit.length == query){
            if(reqsplit[second].length() == 9){
                h.getHeap()[h.getIndex(Integer.parseInt(reqsplit[second]))].printBooks();
            }
            else if(reqsplit[second].length() == 6){
                System.out.println(hashtable.GetBook(reqsplit[second]).getReader().getId());
            }else {
                Person p = h.getMax();
                System.out.println(p.getName() + " with " + p.getNumOfBooks() + " books" );
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter max number of subscription in library :");
        int count = sc.nextInt();
        sc.nextLine(); // read \n
        Heap h = new Heap(count);
        Hashtable hashtable = new Hashtable();
        System.out.println("enter request (to exit enter X) :");
        String req = sc.nextLine();
        while (!req.equals("X")) {
            String[] reqsplit = req.split(" ");
            getReq(reqsplit, hashtable, h);
            System.out.println("enter request (to exit enter X)");
            req = sc.nextLine();
        }
    }
}

