package berkay.bookstore.dataAccess;

import berkay.bookstore.entities.BookWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import berkay.bookstore.entities.Book;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {

    Book getByBookName(String bookName);

    Book getByBookNameAndCategory_CategoryId(String bookName,int categoryId);

    List<Book> getByBookNameOrCategory_CategoryId(String bookName, int categoryId);

    List<Book> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Book> getByBookNameContains(String bookName);

    List<Book> getByBookNameStartsWith(String bookName);

    @Query("From Book where bookName=:bookName and category.categoryId=:categoryId")
    List<Book> getByNameAndCategory(String bookName,int categoryId);

    @Query("Select new berkay.bookstore.entities.BookWithCategoryDto  (b.id,b.bookName,c.categoryName) From Category c Inner join c.books  b")
    List<BookWithCategoryDto> getBookWithCategoryDetails();

}
