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
	
	public ObservableList<Item> getOfferedSellerItems() {
//		Get current seller user object
		User user = UserSession.getInstance().getUser();
		return itemController.ViewOfferItem(user.getUser_id());
	}

	public void handleAcceptOffer(Item item) {
		itemController.AcceptOffer(item.getItem_id());
	}

	public void handleDeclineOffer(Item item, String reason) throws IllegalArgumentException{
		if(reason.isBlank()) {
			throw new IllegalArgumentException("Reason cannot be empty");
		}
		itemController.DeclineOffer(item.getItem_id());
	}

}
