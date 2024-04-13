package com.shuuriye.Laptops;

import com.shuuriye.Books.Book;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LaptopService {
    Map<Long , Laptop> laptops = new ConcurrentHashMap<>();
    AtomicLong counter = new AtomicLong(1);

    //methods
    public Collection<Laptop> getLaptops(){
        return laptops.values();
    }

    public Laptop getLaptopById(Long id){
        return laptops.get(id);
    }

    //save
    public Laptop saveLaptop(Laptop laptop)  {

    Long Laptopid = laptop.id() != null ? laptop.id() : counter.getAndIncrement();

    Laptop desktop = new Laptop(Laptopid , laptop.brand(), laptop.price());
        System.out.printf("id = %d", Laptopid);
        laptops.put(Laptopid, desktop);
        return laptop;
    }
    //delete
    public Laptop deleteLaptop(Long id){
        return laptops.remove(id);
    }

    //update
    public Laptop updateLaptop(Long id , Laptop laptopDetails){
        if(laptops.containsKey(id)){
            Laptop oldLaptop = new Laptop(id , laptopDetails.brand(), laptopDetails.price());

            laptops.put(id, oldLaptop);
            return oldLaptop;
        }
        return null;
    }
}
