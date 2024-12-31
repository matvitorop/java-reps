package com.education.ztu;

import java.sql.*;
import java.util.ResourceBundle;

public class Tasks {
    // TASK 2
    public static Connection GetConnection() {
        Connection con = null;
        try {
            ResourceBundle rb = ResourceBundle.getBundle("database");
            String name = rb.getString("db.username");
            String password = rb.getString("db.password");
            String url = rb.getString("db.url");
            String driver = rb.getString("db.driver");

            Class.forName(driver);
            con = DriverManager.getConnection(url, name, password);
            System.out.println("З'єднання встановлено успішно!");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    // TASK 3
    public static void CreateTable(Connection con) {
        String newTable = """
                CREATE TABLE IF NOT EXISTS updatedProducts (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    price DECIMAL(10, 2) NOT NULL,
                    category VARCHAR(100) NOT NULL
                );
                """;
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(newTable);
            System.out.println("Table was created");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void ProductInsertion(Connection con) {
        try (Statement stmt = con.createStatement()) {
            con.setAutoCommit(false);

            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 1', 10.99);");
            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 2', 20.49);");
            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 3', 15.25);");
            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 4', 8.99);");
            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 5', 12.49);");
            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 6', 22.00);");
            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 7', 5.49);");
            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 8', 18.99);");
            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 9', 25.00);");
            stmt.addBatch("INSERT INTO products (name, price) VALUES ('Product 10', 30.00);");

            int[] results = stmt.executeBatch();
            con.commit();
            System.out.println("Successfully inserted products");

            System.out.println("Results:");
            for (int result : results) {
                System.out.println(result);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // TASK 4
    public static void UpdatedProductInsertion(Connection con) {
        String statementLayout = "INSERT INTO updatedProducts (name, price, category) VALUES (?, ?, ?);";
        try (PreparedStatement stmt = con.prepareStatement(statementLayout)) {
            con.setAutoCommit(false);

            stmt.setString(1, "Product 1");
            stmt.setInt(2, 10);
            stmt.setString(3, "Chanel");
            stmt.addBatch();

            stmt.setString(1, "Product 2");
            stmt.setInt(2, 13);
            stmt.setString(3, "Chanel");
            stmt.addBatch();

            stmt.setString(1, "Product 3");
            stmt.setInt(2, 228);
            stmt.setString(3, "Prada");
            stmt.addBatch();

            stmt.setString(1, "Product 4");
            stmt.setInt(2, 123);
            stmt.setString(3, "Prada");
            stmt.addBatch();

            stmt.setString(1, "Product 5");
            stmt.setInt(2, 987);
            stmt.setString(3, "ZhytomirSocks");
            stmt.addBatch();

            stmt.executeBatch();
            con.commit();

            System.out.println("Successfully inserted UpdatedProducts");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void DeleteAllProducts(Connection con) {
        String deleteSQL = "DELETE FROM updatedProducts";
        try (PreparedStatement stmt = con.prepareStatement(deleteSQL)) {
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Deleted " + rowsDeleted + " rows");
        } catch (Exception e) {
            System.out.println("Deleting error: " + e.getMessage());
        }
    }

    // TASK 5
    public static void testRollback(Connection con) {
        String insertSQL1 = "INSERT INTO updatedProducts (name, price, category) VALUES (?, ?, ?)";

        try (PreparedStatement stmt1 = con.prepareStatement(insertSQL1)) {
            con.setAutoCommit(false);


            stmt1.setString(1, "Product 1");
            stmt1.setDouble(2, 15);
            stmt1.setString(3, "Chanel");
            stmt1.executeUpdate();

            Savepoint svpt = con.setSavepoint("firstProductInserted");


            stmt1.setString(1, "Product 2");
            stmt1.setDouble(2, 16);
            stmt1.setString(3, "Channel");
            stmt1.executeUpdate();

            con.rollback(svpt);
            con.commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // TASK 3,4
    public static void GetProducts(Connection con) {
        String selectSQL = "SELECT * FROM updatedProducts";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            System.out.println("List of products:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");

                System.out.printf("ID: %d, Name: %s, Category: %s, Price: %.2f%n", id, name, category, price);
            }
        } catch (Exception e) {
            System.out.println("Error with getting data: " + e.getMessage());
        }
    }

    public static void GetByCategory(Connection con, String category) {
        String selectSQL = "SELECT * FROM updatedProducts WHERE category = ?";

        try (PreparedStatement stmt = con.prepareStatement(selectSQL)) {
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();

            System.out.println("List of products:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String brandCategory = rs.getString("category");

                System.out.printf("ID: %d, Name: %s, Category: %s, Price: %.2f%n", id, name, category, price);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Connection con = GetConnection();
        if (con != null) {
            //CreateTable(con);
            //ProductInsertion(con);
            //UpdatedProductInsertion(con);

            //GetProducts(con);
            //GetByCategory(con, "ZhytomirSocks");

            //DeleteAllProducts(con);
            //testRollback(con);
            //GetProducts(con);

            // TASK 6
            try{
                ProductDAO productDAO = new ProductDAO(con);
                //productDAO.create(new Product("Product 1", 10.99, "Chanel"));
                //productDAO.create(new Product("Product 2", 15.49, "Prada"));

                // read
                Product product = productDAO.read(53);
                System.out.println("Продукт із ID 53: " + product);

                // update
                if (product != null) {
                    product.setPrice(12.99);
                    productDAO.update(product);
                }

                // readAll
                System.out.println("Всі продукти:");
                for (Product p : productDAO.readAll()) {
                    System.out.println(p);
                }

                // delete
                productDAO.delete(56);
                System.out.println("Після видалення:");
                for (Product p : productDAO.readAll()) {
                    System.out.println(p);
                }

            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}