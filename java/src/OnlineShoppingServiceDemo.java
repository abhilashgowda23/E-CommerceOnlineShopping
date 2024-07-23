package onlineshopping;

import main.java.*;

import java.util.List;

public class OnlineShoppingServiceMain {

    public static void main(String[] args) {
        OnlineShoppingService onlineShoppingService = OnlineShoppingService.getInstance();

        User user1 = new User("USER1", "Abhilash", "Abhilash@gmail.com", "abhi@123");
        User user2 = new User("USER2", "Mahadev", "Mahadev@gmail.com", "mahadev@123");
        User user3 = new User("USER3", "Krishna", "Krishna@gmail.com", "krishna@123");
        onlineShoppingService.addUser(user1);
        onlineShoppingService.addUser(user2);
        onlineShoppingService.addUser(user3);
        Product product1 = new Product("PRODUCT1", "Smartphone", "Gaming Phone", 49999.99, 10);
        Product product2 = new Product("PRODUCT2", "Laptop", "Office laptop", 39999.99, 5);
        onlineShoppingService.addProduct(product1);
        onlineShoppingService.addProduct(product2);
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addItem(product1, 10);
        cart1.addItem(product2, 1);
        Payment payment1 = new OnlinePayment();
        Order order1 = onlineShoppingService.placeOrder(user1, cart1, payment1);

        System.out.println("Order created : " + order1.getId());

        List<Product> productList = onlineShoppingService.searchProduct("laptop");
        for (Product p : productList) {
            System.out.println(p.getName());
        }
        ShoppingCart shoppingCart2 = new ShoppingCart();
        shoppingCart2.addItem(productList.get(0), 2);
        Payment payment2 = new OnlinePayment();
        Order order2 = onlineShoppingService.placeOrder(user2, shoppingCart2, payment2);
        System.out.println("Order created : " + order2.getId());

        List<Order> userOrderList = user1.getOrders();
        for (Order order : userOrderList) {
            System.out.println("---------------");
            System.out.println("Order details for the User "+user1.getName()+"\nId->" + order.getId() + "\nTotalAmount-> " + order.getTotalAmount() + "\nOrderStatus-> " + order.getOrderStatus());
            System.out.println("----------------");
        }
        List<Order> userOrderList2 = user2.getOrders();
        for (Order order : userOrderList2) {
            System.out.println("---------------");
            System.out.println("Order details for the User "+user2.getName()+"\nId->" + order.getId() + "\nTotalAmount-> " + order.getTotalAmount() + "\nOrderStatus-> " + order.getOrderStatus());
            System.out.println("----------------");
        }


    }
}
