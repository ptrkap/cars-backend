package com.threexp;

import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @PostMapping(value = "add")
    public void add(@RequestParam String car) {
        System.out.println("add - " + car);
    }

    @GetMapping(value = "get")
    public String get(@RequestParam int id) {
        return "foobar - " + id;
    }

    @PutMapping(value = "update")
    public void update(@RequestParam String car) {
        System.out.println("update - " + car);
    }

    @DeleteMapping(value = "remove")
    public void remove(@RequestParam int id) {
        System.out.println("remove - " + id);
    }
}
