package com.shuuriye.Laptops;

import com.shuuriye.Books.Book;
import com.shuuriye.Books.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value ="/laptops")
public class LaptopController {

    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }


    @GetMapping
    public Collection<Laptop> getBooks() {
        return laptopService.getLaptops();
    }
    @GetMapping("/{id}")
    public Laptop getBookById(@PathVariable Long id) {
        return laptopService.getLaptopById(id);
    }

    @PostMapping
    public Laptop saveLaptop(@RequestBody Laptop laptop)  {
        return laptopService.saveLaptop(laptop);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptopById(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
    }

    @PutMapping("/{id}")
    public void updateLaptop(@PathVariable Long id, @RequestBody Laptop laptop){
        laptopService.updateLaptop(id, laptop);
    }
}
