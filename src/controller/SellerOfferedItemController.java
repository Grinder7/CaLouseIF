package controller;

import javafx.collections.ObservableList;
import model.Item;
import model.User;
import session.UserSession;

public class SellerOfferedItemController {

	private ItemController itemController;

	public SellerOfferedItemController(ItemController itemController) {
		this.itemController = itemController;
	}

	/**
	 * Retrieves a list of items that the current seller has received offers for.
	 * 
	 * @return an {@code ObservableList<Item>} containing the items that have
	 *         received offers
	 */
	public ObservableList<Item> getOfferedSellerItems() {
		// Get current seller user object
		User user = UserSession.getInstance().getUser();
		return itemController.ViewOfferItem(user.getUser_id());
	}

	/**
	 * Accepts an offer for a given item. The item will be marked as accepted and
	 * the offer price will be updated.
	 * 
	 * @param item The item for which the offer is being accepted.
	 */
	public void handleAcceptOffer(Item item) {
		itemController.AcceptOffer(item.getItem_id());
	}

	/**
	 * Declines an offer for a given item. A reason must be provided for the
	 * rejection.
	 * 
	 * @param item   The item for which the offer is being declined.
	 * @param reason The reason for declining the offer.
	 * @throws IllegalArgumentException if the reason is blank or empty.
	 */
	public void handleDeclineOffer(Item item, String reason) throws IllegalArgumentException {
		if (reason.isBlank()) {
			throw new IllegalArgumentException("Reason cannot be empty");
		}
		itemController.DeclineOffer(item.getItem_id());
	}

}
