public class Book {
    private String code;
    private Person reader;

    public Book(String code) {
        this.code = code;
        this.reader = null;
    }

    public void setReader(Person reader) {
        this.reader = reader;
    }

    public String getCode() {
        return code;
    }

    public Person getReader() {
        return reader;
    }
}
