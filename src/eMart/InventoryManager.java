package src.eMart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager implements IInventoryManager {
    @Override
    public void addItem(Item item) {
        String sql = "INSERT INTO items(name, quantity, price) VALUES(?, ?, ?)";

        try (Connection conn = DBHelper.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getQuantity());
            pstmt.setDouble(3, item.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items";

        try (Connection conn = DBHelper.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"));
                items.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    @Override
    public void generateReport() {
        List<Item> items = getAllItems();
        System.out.println("ID\tName\tQuantity\tPrice");
        for (Item item : items) {
            System.out
                    .println(item.getId() + "\t" + item.getName() + "\t" + item.getQuantity() + "\t\t"
                            + item.getPrice());
        }
    }

    @Override
    public void removeItem(int id) {
        String sql = "DELETE FROM items WHERE id = ?";

        try (Connection conn = DBHelper.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Item with ID " + id + " was removed successfully.");
            } else {
                System.out.println("No item found with ID " + id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
