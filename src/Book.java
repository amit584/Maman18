public class Book {
    private String code;
    private Subscription reader;

    //constructor
    public Book(String code) {
        this.code = code;
        this.reader = null;
    }

    //O(1)
    public void setReader(Subscription reader) {
        this.reader = reader;
    }

    //O(1)
    public String getCode() {
        return code;
    }

    //O(1)
    public Subscription getReader() {
        return reader;
    }
}
