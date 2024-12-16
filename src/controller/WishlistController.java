package controller;

import javafx.collections.ObservableList;
import model.Item;
import model.Wishlist;

public class WishlistController {
	/**
	 * Views a specific wishlist for a user.
	 * <p>
	 * This method retrieves and displays the wishlist for a given user and wishlist
	 * ID.
	 * </p>
	 * 
	 * @param Wishlist_id The ID of the wishlist to be viewed.
	 * @param User_id     The ID of the user whose wishlist is being viewed.
	 * 
	 * @return an {@code ObservableList<Item>} containing all user's wishlist
	 */
	public ObservableList<Item> ViewWishlist(String User_id) {
		return Wishlist.ViewWishlist(User_id);
	}

	/**
	 * Retrieves a specific wishlist entry for a user and an item.
	 * 
	 * @param User_id the ID of the user whose wishlist entry is to be retrieved
	 * @param Item_id the ID of the item in the wishlist
	 * @return a {@link Wishlist} object representing the matching wishlist entry,
	 *         or {@code null} if no entry exists
	 * @see Wishlist#ViewWishlist(String, String)
	 */
	public Wishlist ViewWishlist(String User_id, String Item_id) {
		return Wishlist.ViewWishlist(User_id, Item_id);
	}

	/**
	 * Adds an item to the user's wishlist.
	 * <p>
	 * This method adds a specified item to the user's wishlist by invoking the
	 * AddWishlist method in the Wishlist class.
	 * </p>
	 * 
	 * @param item_id The ID of the item to be added to the wishlist.
	 * @param User_id The ID of the user adding the item to their wishlist.
	 */
	public void AddWishlist(String item_id, String User_id) throws IllegalArgumentException {
		Wishlist wishlist = Wishlist.ViewWishlist(User_id, item_id);
		if (wishlist != null) {
			throw new IllegalArgumentException("Item already in wishlist");
		}
		Wishlist.AddWishlist(item_id, User_id);
	}

	/**
	 * Removes an item from the user's wishlist.
	 * <p>
	 * This method removes the specified wishlist by invoking the RemoveWishlist
	 * method in the Wishlist class.
	 * </p>
	 * 
	 * @param Wishlist_id The ID of the wishlist item to be removed.
	 */
	public void RemoveWishlist(String Wishlist_id) {
		Wishlist.RemoveWishlist(Wishlist_id);
	}
}
