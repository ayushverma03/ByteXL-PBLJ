import java.sql.*;
import java.util.Scanner;

public class ProductCRUD {
    static String url = "jdbc:mysql://localhost:3306/yourDatabase";
    static String username = "root";
    static String password = "yourPassword";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false); // transaction handling
            while (true) {
                System.out.println("\nProduct CRUD Menu:");
                System.out.println("1. Create Product");
                System.out.println("2. Read Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> createProduct(conn, sc);
                    case 2 -> readProducts(conn);
                    case 3 -> updateProduct(conn, sc);
                    case 4 -> deleteProduct(conn, sc);
                    case 5 -> { conn.close(); sc.close(); return; }
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void createProduct(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Product ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Product Name: "); String name = sc.nextLine();
        System.out.print("Price: "); double price = sc.nextDouble();
        System.out.print("Quantity: "); int qty = sc.nextInt();

        String sql = "INSERT INTO Product VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, qty);
            ps.executeUpdate();
            conn.commit();
            System.out.println("Product created successfully.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void readProducts(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Product";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Products:");
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Price: %.2f, Qty: %d%n",
                        rs.getInt("ProductID"), rs.getString("ProductName"),
                        rs.getDouble("Price"), rs.getInt("Quantity"));
            }
        }
    }

    static void updateProduct(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID to update: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("New Name: "); String name = sc.nextLine();
        System.out.print("New Price: "); double price = sc.nextDouble();
        System.out.print("New Quantity: "); int qty = sc.nextInt();

        String sql = "UPDATE Product SET ProductName=?, Price=?, Quantity=? WHERE ProductID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, qty);
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            if (rows > 0) conn.commit();
            System.out.println(rows > 0 ? "Product updated." : "Product not found.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void deleteProduct(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID to delete: "); int id = sc.nextInt();
        String sql = "DELETE FROM Product WHERE ProductID=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) conn.commit();
            System.out.println(rows > 0 ? "Product deleted." : "Product not found.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Error: " + e.getMessage());
        }
    }
}
