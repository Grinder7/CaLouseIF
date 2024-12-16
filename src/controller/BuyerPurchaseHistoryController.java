package controller;

import javafx.collections.ObservableMap;
import model.Item;
import model.Transaction;
import model.User;
import session.UserSession;

public class BuyerPurchaseHistoryController {

	/**
	 * Retrieve the buyer's purchase history
	 * 
	 * @return an {@code ObservableMap<Transaction, Item>} with {@code Transaction} as key and
	 *         {@code Item} as value representing the buyer transaction history
	 */
	public ObservableMap<Transaction, Item> getPurchaseHistory() {
		User user = UserSession.getInstance().getUser();

		return Transaction.ViewHistory(user.getUser_id());
	}

}
