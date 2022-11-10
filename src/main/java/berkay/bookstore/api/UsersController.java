package berkay.bookstore.api;

import berkay.bookstore.business.UserService;
import berkay.bookstore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public String add(@RequestBody User user){
        return this.userService.add(user);
    }

    @GetMapping(value = "/findByEmail")
    public User findByEmail(String email){
        return this.userService.findByEmail(email);
    }


   /* @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){

            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        List<Object> errors = new error(validationErrors,"Doğrulama hatası");

    }*/


}
