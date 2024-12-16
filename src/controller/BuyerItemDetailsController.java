package controller;

import model.Item;
import model.User;
import model.Wishlist;
import session.UserSession;

public class BuyerItemDetailsController {
	private ItemController itemController;
	private WishlistController wishlistController;
	private TransactionController transactionController;

	public BuyerItemDetailsController(ItemController itemController, WishlistController wishlistController,
			TransactionController transactionController) {
		this.itemController = itemController;
		this.wishlistController = wishlistController;
		this.transactionController = transactionController;
	}

	/**
	 * Handles the purchase action for an item.
	 * <p>
	 * This method checks the availability of the item, performs the purchase
	 * operation, and removes the item from the user's wishlist if it exists. If the
	 * item is no longer available, an exception is thrown.
	 * </p>
	 *
	 * @param item the {@link Item} object that the user wants to purchase
	 * @throws IllegalArgumentException if the item is no longer available (already
	 *                                  sold)
	 * @see TransactionController#PurchaseItems(String, String)
	 * @see WishlistController#ViewWishlist(String, String)
	 * @see Wishlist#RemoveWishlist(String)
	 */
	public void handlePurchaseButton(Item item) throws IllegalArgumentException {
		User user = UserSession.getInstance().getUser();
		item = Item.VIewAcceptedItem(item.getItem_id());
//		if item status is not accepted, then it have already been bought
		if (item == null) {
			throw new IllegalArgumentException("Product sold");
		}
		transactionController.PurchaseItems(user.getUser_id(), item.getItem_id());
		Wishlist wishlist = wishlistController.ViewWishlist(user.getUser_id(), item.getItem_id());
		if (wishlist != null) {
			Wishlist.RemoveWishlist(wishlist.getWhislist_id());
		}
	}

	/**
	 * Handles the action of making an offer on an item.
	 *
	 * @param item  the {@code Item} for which an offer is being made
	 * @param offer the offer price as a {@code String}
	 */
	public void handleOfferButton(Item item, String offer) {
		itemController.OfferPrice(item.getItem_id(), offer);
	}

	/**
	 * Handles the action of adding an item to the user's wishlist.
	 *
	 * @param item the {@link Item} object to be added to the user's wishlist
	 * @throws IllegalArgumentException if an error occurs while adding the item to
	 *                                  the wishlist
	 * @see WishlistController#AddWishlist(String, String)
	 * @see UserSession#getInstance()
	 */
	public void handleAddToWishlist(Item item) throws IllegalArgumentException {
		wishlistController.AddWishlist(item.getItem_id(), UserSession.getInstance().getUser().getUser_id());
	}
}
