package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bookshelf")
@NamedQuery(name = "Bookshelf.deleteAllRows", query = "DELETE from Bookshelf ")
public class Bookshelf {

    @Id
    @Column(name="bookshelf_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookshelf_id;

    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    private User user;

    public Bookshelf(){
    }

    public Bookshelf(User user){
        this.user = user;
    }


    public int getBookshelfId() {
        return bookshelf_id;
    }

    public void setBookshelf(int bookshelf_id) { this.bookshelf_id = bookshelf_id; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public String getUserName() {
//        return user_name;
//    }
//
//    public void setUserName(String user_name) {
//        this.user_name = user_name;
//    }

//    public List<User> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(List<User> userList) {
//        this.userList = userList;
//    }


    @Override
    public String toString() {
        return "Bookshelf{" +
                "bookshelf_id=" + bookshelf_id +
                ", user_name='" + user.getUserName() + '\'' +
                '}';
    }
}
