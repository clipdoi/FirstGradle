package com.example.api;

import com.example.dto.NewDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
//@Controller
@RequestMapping("api/demo")
public class NewAPI {

    @RequestMapping(value="/test", method = RequestMethod.GET)
    //@GetMapping("/test")
    public String testAPI() {
        return "success";
    }

    //@PostMapping("/new")
    @RequestMapping(value="/new", method = RequestMethod.POST)
    @ResponseBody
    public NewDTO createNew(@RequestBody NewDTO model) {
        return model;
    }

    //@PutMapping("/new")
    @RequestMapping(value="/new", method = RequestMethod.PUT)
    @ResponseBody
    public NewDTO updateNew(@RequestBody NewDTO model) {
        return model;
    }

    //@DeleteMapping("/delete/id")
    @RequestMapping(value="/new/{id}", method = RequestMethod.DELETE)
    public String deleteNew(@PathVariable String id) {
        return id;
    }
}
