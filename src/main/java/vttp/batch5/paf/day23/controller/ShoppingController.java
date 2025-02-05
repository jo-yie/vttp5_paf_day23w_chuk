package vttp.batch5.paf.day23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vttp.batch5.paf.day23.model.LineItem;
import vttp.batch5.paf.day23.model.ShoppingCart;
import vttp.batch5.paf.day23.service.ShoppingService;

@RestController
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService; 

    @PutMapping("/api/purchaseorder")
    public ResponseEntity<Object> postShoppingCart(@RequestBody ShoppingCart shopping) {

        // testing
        System.out.println(shopping.getName());
        System.out.println(shopping.getAddress());
        System.out.println(shopping.getDeliveryDate());
        for (LineItem li : shopping.getLineItems()) {
            System.out.println(li.getName());
            System.out.println(li.getQuantity());
            System.out.println(li.getUnitPrice());
        }

        shoppingService.insertShoppingCart(shopping);

        return ResponseEntity.ok()
            .body(shopping);

    }
    
}
