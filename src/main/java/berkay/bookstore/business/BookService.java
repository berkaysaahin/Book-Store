package berkay.bookstore.business;

import berkay.bookstore.entities.BookWithCategoryDto;

import berkay.bookstore.entities.Book;

import java.util.List;


public interface BookService {

    List<Book> getAll();

    List<Book> getAllSorted();

    List<Book> getAll(int pageNo,int pageSize);

    String add(Book book);

    Book getByBookName(String bookName);

    Book getByBookNameAndCategory_CategoryId(String bookName,int categoryId);

    List<Book> getByBookNameOrCategory_CategoryId(String bookName,int categoryId);

    List<Book> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Book> getByBookNameContains(String bookName);

    List<Book> getByBookNameStartsWith(String bookName);

    List<Book> getByNameAndCategory(String bookName, int categoryId);

    List<BookWithCategoryDto> getBookWithCategoryDetails();


}
