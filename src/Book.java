import java.util.Date;

public class Book {
    private int id;
    private String name;
    private String author;
    private int publishingYear;
    private String field ;

    public Book(int id, String name, String author, int publishingYear, String field) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.field = field;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishingYear=" + publishingYear +
                ", field='" + field + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
