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
	
	public ObservableList<Item> getSellerItems(){
//		Get current seller object
		User user = UserSession.getInstance().getUser();
		return itemController.BrowseItem(user.getUser_id());
	}

	public void handleEditItem(Item item) {
		Router.getInstance().navigateTo(PageData.sellerEditPage(item));
	}

	public void handleDeleteItem(Item item) {
		itemController.DeleteItem(item.getItem_id());
	}
}
