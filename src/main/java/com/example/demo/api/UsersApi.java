package com.example.demo.api;

import com.example.demo.business.UserBusiness;
import com.example.demo.entity.User;
import com.example.demo.exception.BaseException;
import com.example.demo.model.MRegisterRequest;
import com.example.demo.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user") //main request mapping
public class UsersApi {
    //dependency injection//
    //method1//
//    @Autowired
//    private TestBusiness business;

    //method2 -> fast performance more method1//
    //injection constructor// -> alt+enter
    private final UserBusiness business;

    public UsersApi(UserBusiness business) {
        this.business = business;
    }

    @GetMapping
    @RequestMapping("/get1") //sub reauest mapping
    public String test() {
        return "Hello Test";
    }

    @GetMapping
    @RequestMapping("/get2")
    public Response testmodel() {
        Response res = new Response();
        res.setName("AM");
        res.setFood("KFC");
        return res;
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<User> register(@RequestBody MRegisterRequest req) throws BaseException {
        //can ctrl+alt+v
        User response = business.register(req);
        return ResponseEntity.ok(response);
        //old exception
//        try {
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
//        }
    }

    //**Other Mapping**//
    //@PutMapping
    //@DeleteMapping
    @PostMapping
    public ResponseEntity<String> uploadProflePicture(@RequestPart MultipartFile file) throws BaseException{
        String res = business.uploadProfilePicture(file);
        return ResponseEntity.ok(res);
    }
}
