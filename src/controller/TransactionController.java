package controller;

import javafx.collections.ObservableMap;
import model.Item;
import model.Transaction;

public class TransactionController {

	/**
	 * Creates a new purchase transaction for a specific user and item.
	 *
	 * @param User_id the ID of the user making the purchase
	 * @param Item_id the ID of the item being purchased
	 * @return the created {@code Transaction} object
	 */
	public Transaction PurchaseItems(String User_id, String Item_id) {
		return Transaction.PurchaseItems(User_id, Item_id);
	}

	/**
	 * Retrieves the transaction history for a specific user, mapping each
	 * transaction to the corresponding item.
	 *
	 * @param user_id The unique identifier of the user whose transaction history is
	 *                to be retrieved.
	 * @return An {@link ObservableMap} where each {@link Transaction} is mapped to
	 *         the corresponding {@link Item} in the user's transaction history.
	 */
	public ObservableMap<Transaction, Item> ViewHistory(String user_id) {
		return Transaction.ViewHistory(user_id);
	}

	/**
	 * Retrieves a specific transaction by its ID.
	 *
	 * @param Transaction_id the ID of the transaction to retrieve
	 * @return the {@code Transaction} object corresponding to the given ID, or
	 *         {@code null} if not found
	 */

	public Transaction CreateTransaction(String Transaction_id) {
		return Transaction.CreateTransaction(Transaction_id);
	}
}
