package berkay.bookstore.business;

import berkay.bookstore.dataAccess.BookDao;
import berkay.bookstore.entities.Book;
import berkay.bookstore.entities.BookWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookManager implements BookService{


    private BookDao bookDao;

    @Autowired
    public BookManager(BookDao bookDao){
        this.bookDao = bookDao;
    }


    @Override
    public List<Book> getAll() {
        return this.bookDao.findAll();

    }

    @Override
    public List<Book> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"bookName");
        return this.bookDao.findAll(sort);
    }

    @Override
    public List<Book> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return this.bookDao.findAll(pageable).getContent();
    }

    @Override
    public String add(Book book) {
        this.bookDao.save(book);
        return "Kitap eklendi";
    }

    @Override
    public Book getByBookName(String bookName) {
        return this.bookDao.getByBookName(bookName);
    }

    @Override
    public Book getByBookNameAndCategory_CategoryId(String bookName, int categoryId) {
        return this.bookDao.getByBookNameAndCategory_CategoryId(bookName,categoryId);
    }

    @Override
    public List<Book> getByBookNameOrCategory_CategoryId(String bookName, int categoryId) {
        return this.bookDao.getByBookNameOrCategory_CategoryId(bookName,categoryId);
    }

    @Override
    public List<Book> getByCategory_CategoryIdIn(List<Integer> categories) {
        return this.bookDao.getByCategory_CategoryIdIn(categories);
    }

    @Override
    public List<Book> getByBookNameContains(String bookName) {
        return this.bookDao.getByBookNameContains(bookName);
    }

    @Override
    public List<Book> getByBookNameStartsWith(String bookName) {
        return this.bookDao.getByBookNameStartsWith(bookName);
    }

    @Override
    public List<Book> getByNameAndCategory(String bookName, int categoryId) {
        return this.bookDao.getByNameAndCategory(bookName,categoryId);
    }

    @Override
    public List<BookWithCategoryDto> getBookWithCategoryDetails() {
        return this.bookDao.getBookWithCategoryDetails();
    }

}
