package berkay.bookstore.entities;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="books")

public class Book {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private int bookId;

    @NotNull
    @Column(name="book_name")
    private String bookName;

    @NotNull
    @Column(name="unit_price")
    private int unitPrice;

    @NotNull
    @Column(name="units_in_stock")
    private int unitsInStock;

    @NotNull
    @Column(name="pages")
    private int pages;

    @NotNull
    @Column(name="publisher")
    private String publisher;

    @NotNull
    @Column(name="publication_date")
    private String publicationDate;

    @NotNull
    @Column(name="language")
    private String language;

    @NotNull
    @Column(name="isbn")
    private String isbn;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    //author ve category icin ayri table

}
