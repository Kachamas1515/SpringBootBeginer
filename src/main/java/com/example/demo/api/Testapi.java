package com.example.demo.api;

import com.example.demo.business.TestBusiness;
import com.example.demo.exception.BaseException;
import com.example.demo.model.MRegisterRequest;
import com.example.demo.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/test") //main request mapping
public class Testapi {
    //dependency injection//
    //method1//
//    @Autowired
//    private TestBusiness business;

    //method2 -> fast performance more method1//
    //injection constructor// -> alt+enter
    private final TestBusiness business;

    public Testapi(TestBusiness business) {
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
    public ResponseEntity register(@RequestBody MRegisterRequest req) throws BaseException {
        //can ctrl+alt+v
        String response = business.register(req);
        return ResponseEntity.ok(response);
        //old exception
//        try {
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
//        }
    }

    //Other Mapping
    //@PutMapping
    //@DeleteMapping
}
