package controller;

import javafx.collections.ObservableList;
import model.Item;

public class AdminDashboardController {
	private ItemController itemController;

	public AdminDashboardController(ItemController itemController) {
		super();
		this.itemController = itemController;
	}

	/**
	 * Retrieves a list of requested items that need admin approval.
	 *
	 * @return an {@link ObservableList} of {@link Item} objects representing the
	 *         requested items
	 * @see ItemController#ViewRequestedItem()
	 */
	public ObservableList<Item> getRequestItem() {
		return itemController.ViewRequestedItem();
	}

	/**
	 * Handles the decline action for a requested item.
	 * <p>
	 * This method is called when an admin chooses to decline an item request. It
	 * validates the provided reason for declining and delegates the operation to
	 * the {@link ItemController}'s {@code DeclineItem} method.
	 * </p>
	 *
	 * @param item   the {@link Item} object to be declined
	 * @param reason the reason for declining the item request; must not be blank
	 * @throws IllegalArgumentException if the reason is blank
	 * @see ItemController#DeclineItem(String)
	 */
	public void handleDeclineButton(Item item, String reason) throws IllegalArgumentException {
		if (reason.isBlank()) {
			throw new IllegalArgumentException("Reason cannot be empty");
		}
		itemController.DeclineItem(item.getItem_id());
	}

	/**
	 * Handles the approval action for a requested item.
	 *
	 * @param item the {@link Item} object to be approved
	 * @see ItemController#ApproveItem(String)
	 */
	public void handleApproveButton(Item item) {
		itemController.ApproveItem(item.getItem_id());
	}
}
