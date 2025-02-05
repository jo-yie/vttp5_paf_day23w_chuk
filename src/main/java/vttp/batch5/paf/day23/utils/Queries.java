package vttp.batch5.paf.day23.utils;

public class Queries {

    // INSERT INTO shopping_cart (name, address, delivery_date)
	// VALUES ("jo yie", "casa pasir ris", "2025-06-06");
    public static final String SQL_INSERT_SHOPPING_CART = 
    """
        INSERT INTO shopping_cart (name, address, delivery_date)
            VALUES (?, ?, ?)
    """;

    // INSERT INTO line_item (name, quantity, unit_price, shopping_id)
	// VALUES ("chicken", 1, 0.5, 1);
    public static final String SQL_INSERT_LINE_ITEM = 
    """
        INSERT INTO line_item (name, quantity, unit_price, shopping_id)
            VALUES (?, ?, ?, ?)        
    """;

    // SELECT * 
	// FROM shopping_cart
	// WHERE shopping_id = 1;
    public static final String SQL_GET_SHOPPING_CART_BY_ID = 
    """
        SELECT * 
            FROM shopping_cart
            WHERE shopping_id = ?    
    """;
    
    public static final String SQL_GET_LINE_ITEM_BY_ID = 
    """
        SELECT * 
            FROM line_item
            WHERE shopping_id = ?
    """;

    public static final String SQL_GET_ALL_SHOPPING_CART = 
    """
        SELECT * 
            FROM shopping_cart
    """;

    public static final String SQL_GET_ALL_LINE_ITEM = 
    """
        SELECT * 
            FROM line_item 
    """;

}
