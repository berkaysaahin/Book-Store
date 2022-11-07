package berkay.bookstore.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="books")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //idnin tek tek arttırılacağını söyler
    @Column(name="book_id")
    private int id;

    @Column(name="book_name")
    private String bookName;

    @Column(name="unit_price")
    private int unitPrice;

    @Column(name="units_in_stock")
    private int unitsInStock;

    @Column(name="unit_price")
    private int pages;

    @Column(name="publisher")
    private String publisher;

    @Column(name="publication_date")
    private String publicationDate;

    @Column(name="language")
    private String language;

    @Column(name="isbn")
    private String isbn;



    //author ve category icin ayri table

}