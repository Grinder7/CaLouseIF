package controller;

import javafx.collections.ObservableList;
import model.Item;
import model.User;
import model.Wishlist;
import session.UserSession;

public class BuyerWishlistController {
	
	/**
	 * Handles the removal of an item from the user's wishlist.
	 * 
	 * @param item The item to be removed from the user's wishlist.
	 */
	public void handleRemoveButton(Item item) {
		User user = UserSession.getInstance().getUser();
		Wishlist wishlist= Wishlist.ViewWishlist(user.getUser_id(), item.getItem_id());
		Wishlist.RemoveWishlist(wishlist.getWhislist_id());
	}
	
	/**
	 * Retrieves the list of items currently in the user's wishlist.
	 * 
	 * @return An {@code ObservableList<Item>} of items in the user's wishlist.
	 */
	public ObservableList<Item> getWishlistItems(){
		User user = UserSession.getInstance().getUser();
		return Wishlist.ViewWishlist(user.getUser_id());
	}
}
