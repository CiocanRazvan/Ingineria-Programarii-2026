public class Main {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Marketplace System ===\n");

        // Create categories
        Category electronics = new Category(1L, "Electronics", null);
        Category clothing = new Category(2L, "Clothing", null);

        System.out.println("✓ Categories created: " + electronics.getName() + ", " + clothing.getName());

        // Create a seller
        Seller seller = new Seller(
            "John",
            "Doe",
            "john@example.com",
            "0712345678",
            "password123",
            "johndoe",
            "TechStore",
            4.5,
            true,
            0.15
        );

        System.out.println("✓ Seller created: " + seller.getStoreName() + " (Rating: " + seller.getRating() + ")\n");

        // Create a customer
        Customer customer = new Customer(
            "Alice",
            "Smith",
            "alice@example.com",
            "password456",
            "0787654321"
        );

        System.out.println("✓ Customer created: " + customer.fullNume());

        // Create products
        Product laptop = new Product(
            "Laptop Pro",
            "High-performance laptop with 16GB RAM",
            1299.99,
            50,
            seller,
            electronics
        );

        Product tshirt = new Product(
            "Cotton T-Shirt",
            "Comfortable cotton t-shirt",
            29.99,
            100,
            seller,
            clothing
        );

        System.out.println("✓ Products created: " + laptop.getName() + ", " + tshirt.getName() + "\n");

        // Create addresses
        Address homeAddress = new Address(
            "123 Main Street",
            "Bucharest",
            "Bucharest",
            "010101",
            "Romania"
        );

        Address workAddress = new Address(
            "456 Business Ave",
            "Bucharest",
            "Bucharest",
            "010202",
            "Romania"
        );

        System.out.println("✓ Addresses created");
        System.out.println("  - Home: " + homeAddress.getFullAddress());
        System.out.println("  - Work: " + workAddress.getFullAddress() + "\n");

        // Add items to cart
        System.out.println("--- Shopping Cart Operations ---");
        Cart cart = customer.getCart();
        cart.addItem(laptop, 1);
        cart.addItem(tshirt, 2);

        System.out.println("✓ Items added to cart:");
        cart.showCart();

        // Create wishlist
        System.out.println("\n--- Wishlist Operations ---");
        Wishlist wishlist = customer.getWishlist();
        wishlist.addProduct(laptop);
        wishlist.addProduct(tshirt);

        System.out.println("✓ Products added to wishlist: " + wishlist.getProducts().size() + " items");

        // Create an order
        System.out.println("\n--- Order Operations ---");
        Order order = customer.placeOrder(homeAddress, PaymentMethod.CARD);
        
        // Add items to order
        OrderItem item1 = new OrderItem(order, laptop, 1);
        OrderItem item2 = new OrderItem(order, tshirt, 2);
        order.getItems().add(item1);
        order.getItems().add(item2);
        order.setTotalPrice(order.calculateTotal());

        System.out.println("✓ Order placed:");
        System.out.println("  - Order ID: " + order.getOrderId());
        System.out.println("  - Status: " + order.getStatus());
        System.out.println("  - Total: $" + order.getTotalPrice());
        System.out.println("  - Delivery Address: " + order.getDeliveryAddress().getFullAddress());

        // Confirm order
        System.out.println("\n--- Order Confirmation ---");
        order.confirm();
        System.out.println("✓ Order confirmed. Status: " + order.getStatus());

        // Process payment
        System.out.println("\n--- Payment Processing ---");
        Payment payment = order.getPayment();
        boolean paymentSuccess = payment.processPayment();

        System.out.println("✓ Payment processed:");
        System.out.println("  - Amount: $" + payment.getAmount());
        System.out.println("  - Method: " + payment.getMethod());
        System.out.println("  - Status: " + payment.getStatus());

        // Ship order
        System.out.println("\n--- Shipment Operations ---");
        order.ship();
        Shipment shipment = order.getShipment();

        System.out.println("✓ Order shipped:");
        System.out.println("  - Tracking Number: " + shipment.getTrackingNumber());
        System.out.println("  - Carrier: " + shipment.getCarrier());
        System.out.println("  - Status: " + shipment.getStatus());
        System.out.println("  - Estimated Delivery: " + shipment.getEstimatedDelivery());

        // Deliver order
        System.out.println("\n--- Order Delivery ---");
        order.deliver();
        System.out.println("✓ Order delivered. Final Status: " + order.getStatus());

        // Write a review
        System.out.println("\n--- Customer Review ---");
        Review review = customer.writeReview(laptop, 5, "Excellent Product", "Great quality and fast delivery!");

        if (review != null) {
            System.out.println("✓ Review written:");
            System.out.println("  - Product: " + review.getProduct().getName());
            System.out.println("  - Rating: " + review.getRating() + "/5");
            System.out.println("  - Title: " + review.getTitle());
            System.out.println("  - Verified Purchase: " + review.isVerified());
        } else {
            System.out.println("✓ Review not written (product not purchased)");
        }

        // Apply discount
        System.out.println("\n--- Discount Operations ---");
        Discount discount = new Discount(
            "SAVE20",
            DiscountType.PERCENTAGE,
            20.0,
            java.time.LocalDate.now().plusDays(30),
            100
        );

        System.out.println("✓ Discount created:");
        System.out.println("  - Code: " + discount.getCode());
        System.out.println("  - Type: " + discount.getDiscountType());
        System.out.println("  - Value: " + discount.getValue());
        System.out.println("  - Valid: " + discount.isValid());

        // Admin operations
        System.out.println("\n--- Admin Operations ---");
        Admin admin = new Admin(
            "Admin",
            "User",
            "admin@example.com",
            "0700000000",
            "adminpass",
            "admin",
            UserRole.SUPER_ADMIN
        );

        System.out.println("✓ Admin created: " + admin.fullNume() + " (Role: " + admin.getRole() + ")");
        admin.manageProducts();
        admin.manageUsers();
        admin.viewReports();

        System.out.println("\n=== System Summary ===");
        System.out.println("✓ Marketplace system initialized successfully");
        System.out.println("✓ All core entities created and operational");
        System.out.println("✓ Order lifecycle completed: PENDING → CONFIRMED → SHIPPED → DELIVERED");
    }
}
