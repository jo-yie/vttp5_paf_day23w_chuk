package vttp.batch5.paf.day23.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day23.model.LineItem;
import vttp.batch5.paf.day23.model.ShoppingCart;
import vttp.batch5.paf.day23.utils.Queries;

@Repository
public class ShoppingRepo {

    @Autowired
    private JdbcTemplate template; 

    // public void insertShoppingCart(ShoppingCart shoppingCart) {

    //     template.update(Queries.SQL_INSERT_SHOPPING_CART,
    //         shoppingCart.getName(), 
    //         shoppingCart.getAddress(),
    //         shoppingCart.getDeliveryDate());

    //     List<LineItem> lineItems = shoppingCart.getLineItems();
        
    //     for (LineItem li : lineItems) {
    //         insertLineItem(li);
    //     }

    // }

    public void insertShoppingCart(ShoppingCart shoppingCart) {

        KeyHolder keyHolder = new GeneratedKeyHolder(); 
        
        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement ps = con.prepareStatement(Queries.SQL_INSERT_SHOPPING_CART, new String[] {"shopping_id"});
                ps.setString(1, shoppingCart.getName());
                ps.setString(2, shoppingCart.getAddress());
                ps.setDate(3, new java.sql.Date(shoppingCart.getDeliveryDate().getTime()));

                return ps;

            }

        };

        template.update(psc, keyHolder);

        int generatedKey = keyHolder.getKey().intValue();

        List<LineItem> lineItems = shoppingCart.getLineItems();
        for (LineItem li : lineItems) { 
            insertLineItem(li, generatedKey);

        }

    }

    public void insertLineItem(LineItem lineItem, int shoppingId) {

        template.update(Queries.SQL_INSERT_LINE_ITEM,
            lineItem.getName(),
            lineItem.getQuantity(),
            lineItem.getUnitPrice(),
            shoppingId); 

    }
    
}
