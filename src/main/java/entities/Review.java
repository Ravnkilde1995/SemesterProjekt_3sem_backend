package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "review")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "review_id")
    private int review_id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "bookshelf_id")
    private int bookshelf_id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "book_id")
    private int book_id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "review_score")
    private int review_score;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "review_text")
    private String review_text;


    public Review() {
    }

    public Review(int bookshelf_id, int book_id, int review_score, String review_text) {
        this.bookshelf_id = bookshelf_id;
        this.book_id = book_id;
        this.review_score = review_score;
        this.review_text = review_text;
    }

    public int getReview_id() {
        return review_id;
    }
    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBookshelf_id() {
        return bookshelf_id;
    }
    public void setBookshelf_id(int bookshelf_id) {
        this.bookshelf_id = bookshelf_id;
    }

    public int getReview_score() {
        return review_score;
    }
    public void setReview_score(int review_score) {
        this.review_score = review_score;
    }

    public String getReview_text() {
        return review_text;
    }
    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_id=" + review_id +
                ", bookshelf_id=" + bookshelf_id +
                ", book_id=" + book_id +
                ", review_score=" + review_score +
                ", review_text='" + review_text + '\'' +
                '}';
    }
}
