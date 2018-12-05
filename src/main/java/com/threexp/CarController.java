package com.threexp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarDAO carDAO;

    @PostMapping(value = "add")
    public void add(@RequestBody Car car) {
        carDAO.add(car);
    }

    @GetMapping(value = "get")
    public List<Car> get() {
        return carDAO.getAll();
    }

    @PutMapping(value = "update")
    public void update(
            @RequestHeader(value = "id") int id,
            @RequestHeader(value = "property") String property,
            @RequestHeader(value = "value") String value) {
        carDAO.update(id, property, value);
    }

    @DeleteMapping(value = "remove")
    public void remove(@RequestHeader int id) {
        carDAO.remove(id);
    }
}
