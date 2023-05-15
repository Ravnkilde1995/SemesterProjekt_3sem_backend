package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bookshelf")
@NamedQuery(name = "Bookshelf.deleteAllRows", query = "DELETE from Bookshelf ")
public class Bookshelf implements Serializable {


    @Id
    @Column(name="bookshelf_id")
    private int bookshelf_id;


    @Column(name = "user_name", length = 25)
    private String user_name;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="description")
    private String description;

    @Column(name="google_id")
    private String google_id;


    public Bookshelf(){

    }



    public Bookshelf(String user_name, String title, String author, String description, String google_id) {
        this.user_name = user_name;
        this.title = title;
        this.author = author;
        this.description = description;
        this.google_id = google_id;
    }

    public Bookshelf(String user_name) {
        this.user_name = user_name;
    }

    public int getBookshelf_id() {
        return bookshelf_id;
    }

    public void setBookshelf_id(int bookshelf_id) {
        this.bookshelf_id = bookshelf_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoogle_id() {
        return google_id;
    }

    public void setGoogle_id(String google_id) {
        this.google_id = google_id;
    }

    @Override
    public String toString() {
        return "Bookshelf{" +
                "bookshelf_id=" + bookshelf_id +
                ", user_name='" + user_name + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", google_id='" + google_id + '\'' +
                '}';
    }
}
