package com.embarkx.firstspringproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//annotation that tells spring that our SpringMVC is ready to handle web request from web
//RestController is specialized version of controller and it combines two annotation Controller and respondBody
@RestController
public class HelloController {
    //we map this method to url with @getMapping
    //   if any request come in our domain with "/Hello" we will be calling this method
    @GetMapping("/Hello")
    public String Hello(){
        return "Hello Master Garv";
    }

    @PostMapping("/helloPost")
    //RequestBody is used to incdicate the requestBody should be bound to parameter name
    public String helloPost(@RequestBody String name){
        return "Hello Master "+name+" !";
    }
}
