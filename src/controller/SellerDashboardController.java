package controller;

import javafx.collections.ObservableList;
import model.Item;
import model.User;
import router.PageData;
import router.Router;
import session.UserSession;

public class SellerDashboardController {
	private ItemController itemController;
	
	public SellerDashboardController(ItemController itemController) {
		super();
		this.itemController = itemController;
	}
	
    /**
     * Retrieves a list of items belonging to the current seller.
     * 
     * @return an {@code ObservableList<Item>} containing the items owned by the current seller
     */
	public ObservableList<Item> getSellerItems(){
//		Get current seller object
		User user = UserSession.getInstance().getUser();
		return itemController.BrowseItem(user.getUser_id());
	}

    /**
     * Handles the action of editing an item by navigating to the seller edit page.
     * 
     * @param item the {@code Item} object to be edited
     */
	public void handleEditItem(Item item) {
		Router.getInstance().navigateTo(PageData.sellerEditPage(item));
	}

    /**
     * Handles the action of deleting an item by passing its item ID to the deletion function.
     * 
     * @param item the {@code Item} object to be deleted
     */
	public void handleDeleteItem(Item item) {
		itemController.DeleteItem(item.getItem_id());
	}
}
