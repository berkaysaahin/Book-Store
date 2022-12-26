package berkay.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","books"})
@Entity
@Table(name="categories")
public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;


    @Column(name="category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Book> books;
}
