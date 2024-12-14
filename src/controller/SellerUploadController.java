package controller;

public class SellerUploadController {
	private ItemController itemController;

	public SellerUploadController(ItemController itemController) {
		super();
		this.itemController = itemController;
	}

	public void handleSubmit(String item_name, String item_category, String item_size, String item_price)
			throws IllegalArgumentException {
		itemController.UploadItem(item_name, item_category, item_size, item_price);
	}
}
