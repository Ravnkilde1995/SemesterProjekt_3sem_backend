package entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@NamedQuery(name = "Book.deleteAllRows", query = "DELETE from Book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_id")
    private int bookId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "title")
    private String title;

    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private int categoryId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "publication_date")
    private Date publicationDate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "copies_downloaded")
    private int copiesDownloaded;

    @JoinTable(name = "book_author", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "book_id")}, inverseJoinColumns = {
            @JoinColumn(name = "author_id", referencedColumnName = "author_id")})
    @ManyToMany
    private List<Author> authorList = new ArrayList<>();

    public Book() {
    }

    public Book(int bookId, String title, int categoryId, Date publicationDate, int copiesDownloaded) {
        this.bookId = bookId;
        this.title = title;
        this.categoryId = categoryId;
        this.publicationDate = publicationDate;
        this.copiesDownloaded = copiesDownloaded;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getCopiesDownloaded() {
        return copiesDownloaded;
    }

    public void setCopiesDownloaded(int copiesDownloaded) {
        this.copiesDownloaded = copiesDownloaded;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", publicationDate=" + publicationDate +
                ", copiesDownloaded=" + copiesDownloaded +
                ", authorList=" + authorList +
                '}';
    }
}
