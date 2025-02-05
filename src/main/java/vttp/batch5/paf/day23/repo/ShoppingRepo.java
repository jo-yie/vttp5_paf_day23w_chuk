package vttp.batch5.paf.day23.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day23.model.LineItem;
import vttp.batch5.paf.day23.model.ShoppingCart;
import vttp.batch5.paf.day23.utils.Queries;

@Repository
public class ShoppingRepo {

    @Autowired
    private JdbcTemplate template; 

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

    public ShoppingCart getShoppingCart(int shopping_id) {

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_SHOPPING_CART_BY_ID, shopping_id);

        ShoppingCart shoppingCart = new ShoppingCart(); 

        while (rs.next()) {

            shoppingCart.setName(rs.getString("name"));
            shoppingCart.setAddress(rs.getString("address"));
            shoppingCart.setDeliveryDate(rs.getDate("delivery_date"));
            shoppingCart.setLineItems(getLineItems(shopping_id));

        }

        return shoppingCart;
    }

    public List<LineItem> getLineItems(int shopping_id) {

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_LINE_ITEM_BY_ID, shopping_id);

        List<LineItem> lineItems = new LinkedList<>(); 

        while (rs.next()) {

            LineItem li = new LineItem(); 
            li.setName(rs.getString("name"));
            li.setQuantity(rs.getInt("quantity"));
            li.setUnitPrice(rs.getFloat("unit_price"));

            lineItems.add(li);

        }

        return lineItems; 

    }

    public List<ShoppingCart> getAllShoppingCarts() {

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_ALL_SHOPPING_CART); 
        List<ShoppingCart> results = new LinkedList<>(); 

        while (rs.next()) {

            ShoppingCart shoppingCart = new ShoppingCart(); 

            shoppingCart.setName(rs.getString("name"));
            shoppingCart.setAddress(rs.getString("address"));
            shoppingCart.setDeliveryDate(rs.getDate("delivery_date"));

            int shopping_id = rs.getInt("shopping_id");
            shoppingCart.setLineItems(getLineItems(shopping_id));

            results.add(shoppingCart);

        }

        return results; 

    }
    
}
