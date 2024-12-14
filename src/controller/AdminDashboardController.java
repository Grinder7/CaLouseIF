package controller;

import javafx.collections.ObservableList;
import model.Item;

public class AdminDashboardController {
	private ItemController itemController;
	
	public AdminDashboardController(ItemController itemController) {
		super();
		this.itemController = itemController;
	}

	public ObservableList<Item> getRequestItem(){
		return itemController.ViewRequestedItem();
	}
	
	public void handleDeclineButton(Item item, String reason) throws IllegalArgumentException{
		if(reason.isBlank()) {
			throw new IllegalArgumentException("Reason cannot be empty");
		}
		itemController.DeclineItem(item.getItem_id());
	}

	public void handleApproveButton(Item item) {
		itemController.ApproveItem(item.getItem_id());
	}
}
