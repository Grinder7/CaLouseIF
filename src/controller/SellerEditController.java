package controller;

public class SellerEditController {
	
	private ItemController itemController;
	
	public SellerEditController(ItemController itemController) {
		this.itemController = itemController;
	}

	public void handleSubmitItem(String item_id, String item_name, String item_category, String item_size,
			String item_price) {
		itemController.EditItem(item_id, item_name, item_category, item_size, item_price);
	}

}
