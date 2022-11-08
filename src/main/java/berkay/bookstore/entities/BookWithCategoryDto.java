package berkay.bookstore.entities;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookWithCategoryDto {

    private int id;
    private String bookName;
    private String categoryName;


}
