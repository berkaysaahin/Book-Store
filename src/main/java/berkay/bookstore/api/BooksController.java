package berkay.bookstore.api;


import berkay.bookstore.business.BookService;
import berkay.bookstore.entities.Book;
import berkay.bookstore.entities.BookWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books")
@CrossOrigin
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

    @GetMapping(value = "/getAllSorted")
    public List<Book> getAllSorted(){
        return this.bookService.getAllSorted();
    }

    @GetMapping(value = "/getAllByPage")
    public List<Book> getAll(int pageNo,int pageSize){
        return this.bookService.getAll(pageNo,pageSize);
    }

    @PostMapping(value = "/add")
    public void add(@RequestBody Book book){
         this.bookService.add(book);
    }

    @GetMapping(value = "/getByBookName")
    public Book getByBookName(@RequestParam String bookName) {
        return this.bookService.getByBookName(bookName);
    }

    @GetMapping(value = "/getByBookNameAndCategory")
    public Book getByBookNameAndCategory_CategoryId(@RequestParam String bookName,@RequestParam int categoryId){
        return this.bookService.getByBookNameAndCategory_CategoryId(bookName, categoryId);
    }

    @GetMapping(value = "/getByBookNameContains")
    public List<Book> getByBookNameContains(@RequestParam String bookName) {
        return this.bookService.getByBookNameContains(bookName);
    }

    @GetMapping(value = "/getBookWithCategoryDetails")
    public List<BookWithCategoryDto> getBookWithCategoryDetails() {
        return this.bookService.getBookWithCategoryDetails();

    }
}
