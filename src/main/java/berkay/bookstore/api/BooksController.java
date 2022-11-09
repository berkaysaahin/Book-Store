package berkay.bookstore.api;


import berkay.bookstore.business.BookService;
import berkay.bookstore.entities.Book;
import berkay.bookstore.entities.BookWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private BookService bookService;

    @Autowired
    public BooksController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public List<Book> getAll(){
        return this.bookService.getAll();
    }

    @GetMapping("/getAllSorted")
    public List<Book> getAllSorted(){
        return this.bookService.getAllSorted();
    }

    @GetMapping("/getAllByPage")
    public List<Book> getAll(int pageNo,int pageSize){
        return this.bookService.getAll(pageNo,pageSize);
    }

    @PostMapping("/add")
    public String add(@RequestBody Book book){
        return this.bookService.add(book);
    }

    @GetMapping("/getByBookName")
    public Book getByBookName(@RequestParam String bookName) {
        return this.bookService.getByBookName(bookName);
    }

    @GetMapping("/getByBookNameAndCategory")
    public Book getByBookNameAndCategory_CategoryId(@RequestParam String bookName,@RequestParam int categoryId){
        return this.bookService.getByBookNameAndCategory_CategoryId(bookName, categoryId);
    }

    @GetMapping("/getByBookNameContains")
    public List<Book> getByBookNameContains(@RequestParam String bookName) {
        return this.bookService.getByBookNameContains(bookName);
    }

    @GetMapping("/getBookWithCategoryDetails")
    public List<BookWithCategoryDto> getBookWithCategoryDetails() {
        return this.bookService.getBookWithCategoryDetails();

    }
}
