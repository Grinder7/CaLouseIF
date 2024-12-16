package model;

import javafx.collections.ObservableList;
import repository.WishlistRepository;

public class Wishlist {
	private String Whislist_id;
	private String Item_id;
	private String User_id;

	public Wishlist(String whislist_id, String item_id, String user_id) {
		super();
		Whislist_id = whislist_id;
		Item_id = item_id;
		User_id = user_id;
	}

	public String getWhislist_id() {
		return Whislist_id;
	}

	public void setWhislist_id(String whislist_id) {
		Whislist_id = whislist_id;
	}

	public String getItem_id() {
		return Item_id;
	}

	public void setItem_id(String item_id) {
		Item_id = item_id;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	/**
	 * Retrieves the wishlist of a specific user.
	 * <p>
	 * This static method fetches all the items in the wishlist of a user identified 
	 * by their {@code User_id}. It delegates the operation to the {@link WishlistRepository}'s 
	 * {@code getWishlistByUserId} method and returns the result as an {@link ObservableList}.
	 * </p>
	 *
	 * @param User_id the ID of the user whose wishlist is to be retrieved
	 * @return an {@link ObservableList} of {@link Item} objects representing the user's wishlist
	 * @see WishlistRepository#getWishlistByUserId(String)
	 */
	public static ObservableList<Item> ViewWishlist(String User_id) {
		WishlistRepository wishlistRepository = new WishlistRepository();
		return wishlistRepository.getWishlistByUserId(User_id);
	}

	/**
	 * Adds an item to the user's wishlist.
	 * <p>
	 * This method creates a new wishlist entry for the specified item and user. It
	 * interacts with the WishlistRepository to store the item in the wishlist.
	 * </p>
	 * 
	 * @param item_id The ID of the item to be added to the wishlist.
	 * @param User_id The ID of the user who is adding the item to their wishlist.
	 */
	public static void AddWishlist(String item_id, String User_id) {
		WishlistRepository wishlistRepository = new WishlistRepository();
		wishlistRepository.createWishlist(item_id, User_id);

	}

	/**
	 * Removes a specific wishlist entry based on the provided wishlist ID.
	 * <p>
	 * This static method delegates the operation to the {@link WishlistRepository}'s
	 * {@code removeWishlistById} method to delete a wishlist entry from the database.
	 * </p>
	 *
	 * @param Wishlist_id the ID of the wishlist entry to be removed
	 * @see WishlistRepository#removeWishlistById(String)
	 */
	public static void RemoveWishlist(String Wishlist_id) {
		WishlistRepository wishlistRepository = new WishlistRepository();
		wishlistRepository.removeWishlistById(Wishlist_id);
	}
	
	/**
	 * Retrieves a specific wishlist entry for a user and an item.
	 * <p>
	 * This static method fetches a wishlist entry by delegating the operation to 
	 * the {@link WishlistRepository}'s {@code getWishlistByUserIdAndItemId} method.
	 * It identifies the entry based on the user's ID and the item's ID.
	 * </p>
	 *
	 * @param User_id the ID of the user whose wishlist entry is to be retrieved
	 * @param Item_id the ID of the item in the wishlist
	 * @return a {@link Wishlist} object representing the matching wishlist entry,
	 *         or {@code null} if no entry exists
	 * @see WishlistRepository#getWishlistByUserIdAndItemId(String, String)
	 */
	public static Wishlist ViewWishlist(String User_id, String Item_id) {
		WishlistRepository wishlistRepository = new WishlistRepository();
		return wishlistRepository.getWishlistByUserIdAndItemId(User_id, Item_id);
	}

	/**
	 * Removes a specific item from all users' wishlists based on the item ID.
	 * <p>
	 * This static method delegates the operation to the {@link WishlistRepository}'s
	 * {@code removeWishlistByItemId} method to delete all wishlist entries associated
	 * with the specified item ID.
	 * </p>
	 *
	 * @param Item_id the ID of the item to be removed from all wishlists
	 * @see WishlistRepository#removeWishlistByItemId(String)
	 */
	public static void RemoveItemWishlist(String Item_id) {
//		Add one more method to remove the item from users wishlist
		WishlistRepository wishlistRepository = new WishlistRepository();
		wishlistRepository.removeWishlistByItemId(Item_id);
	}

}
