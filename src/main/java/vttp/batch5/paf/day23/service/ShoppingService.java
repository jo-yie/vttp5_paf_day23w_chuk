package vttp.batch5.paf.day23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.day23.model.ShoppingCart;
import vttp.batch5.paf.day23.repo.ShoppingRepo;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingRepo shoppingRepo; 

    public void insertShoppingCart(ShoppingCart shoppingCart) { 

        shoppingRepo.insertShoppingCart(shoppingCart);

    }
    
}
