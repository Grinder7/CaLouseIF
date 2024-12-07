package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;

public class ItemRepository {
	private DatabaseConnector db;
//	to make table updateable
	private static ObservableList<Item> itemList;

	public ItemRepository() {
		db = DatabaseConnector.getInstance();
	}

	public ObservableList<Item> getAllItem() {
		itemList = FXCollections.observableArrayList();
		String query = "SELECT * FROM item WHERE item_status='approved'";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

	public Item getItemById(String item_id) {
		Item item = null;
		String query = "SELECT * FROM item WHERE Item_id = ?";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				item = new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	public Item getItemByName(String item_name) {
		Item item = null;
		String query = "SELECT * FROM item WHERE item_name = ?";
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, item_name);
			ResultSet rs = pstmt.executeQuery();
			item = new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;

	}

	public void updateOfferItem(String item_id, String offer) {
		String query = "UPDATE item SET item_offer_status = ? WHERE item_id = ?";
		try(PreparedStatement pstmt = db.getConnection().prepareStatement(query)){
			pstmt.setString(1, offer);
			pstmt.setString(2, item_id);
			pstmt.executeUpdate();
	        // After updating, fetch the updated list of items
	        Item updatedItem = getItemById(item_id);
	        
	        // Update the specific item in the list
	        for (int i = 0; i < itemList.size(); i++) {
	            if (itemList.get(i).getItem_id().equals(updatedItem.getItem_id())) {
	                itemList.set(i, updatedItem);
	                break;
	            }
	        }
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
