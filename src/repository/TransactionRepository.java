package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import model.Item;
import model.Transaction;

public class TransactionRepository {
	private DatabaseConnector db;
	private static ObservableMap<Transaction, Item> transactionList;

	public TransactionRepository() {
		db = DatabaseConnector.getInstance();
		if (transactionList == null) {
			transactionList = FXCollections.observableHashMap();
		}
	}

	private Transaction createTransactionFromResultSet(ResultSet rs) throws SQLException {
		return new Transaction(rs.getString("User_id"), rs.getString("Item_id"), rs.getString("transaction_id"));
	}

	/**
	 * Creates a new purchase order in the transaction database.
	 * </p>
	 * This method inserts a new transaction record into the database with the given
	 * user ID and item ID. A unique transaction ID is generated using
	 * {@code UUID.randomUUID()}.
	 * </p>
	 * 
	 * @param user_id The ID of the user making the purchase.
	 * @param item_id The ID of the item being purchased.
	 * @return A {@code Transaction} object representing the newly created
	 *         transaction, or {@code null} if an error occurs.
	 */
	public Transaction createTransaction(String user_id, String item_id) {
		String query = "INSERT INTO transaction(User_id, Item_id, transaction_id) VALUES(?, ? ,?)";
		Transaction transaction = new Transaction(user_id, item_id, UUID.randomUUID().toString());
		ItemRepository itemRepository = new ItemRepository();
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, transaction.getUser_id());
			pstmt.setString(2, transaction.getItem_id());
			pstmt.setString(3, transaction.getTransaction_id());
			pstmt.executeUpdate();

			itemRepository.updateItemPurchase(item_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return transaction;
	}

	/**
	 * Retrieves the transaction history for a specific user.
	 * <p>
	 * This method fetches all transactions from the database for the given
	 * {@code user_id}, along with the corresponding {@link Item} for each
	 * transaction. The transactions and their associated items are stored in an
	 * {@link ObservableMap}, where the key is the {@link Transaction} and the value
	 * is the {@link Item}.
	 * </p>
	 *
	 * @param user_id the ID of the user whose transaction history is to be
	 *                retrieved
	 * @return an {@link ObservableMap} containing transactions as keys and their
	 *         associated items as values
	 * @see Transaction
	 * @see Item
	 * @see ItemRepository#getItemById(String)
	 */
	public ObservableMap<Transaction, Item> getTransactionHistory(String user_id) {
		String query = "SELECT * FROM transaction WHERE User_id = ?";
		ItemRepository itemRepository = new ItemRepository();
		transactionList.clear();
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, user_id);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Transaction transaction = createTransactionFromResultSet(rs);
					Item item = itemRepository.getItemById(transaction.getItem_id());
					transactionList.put(transaction, item);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	/**
	 * Retrieves a transaction by its ID.
	 * 
	 * @param transaction_id The ID of the transaction to retrieve.
	 * @return A {@code Transaction} object representing the requested transaction,
	 *         or {@code null} if no matching transaction is found.
	 */
	public Transaction getTransactionById(String transaction_id) {
		String query = "SELECT * FROM transaction WHERE transaction_id = ?";
		Transaction transaction = null;
		try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
			pstmt.setString(1, transaction_id);
			try (ResultSet rs = pstmt.executeQuery()) {
				transaction = createTransactionFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transaction;
	}
}
