package controller;

public class SellerUploadController {
	private ItemController itemController;

	public SellerUploadController(ItemController itemController) {
		super();
		this.itemController = itemController;
	}

	/**
	 * Submits a new item for upload.
	 * 
	 * @param item_name     The name of the item being uploaded.
	 * @param item_category The category to which the item belongs.
	 * @param item_size     The size of the item.
	 * @param item_price    The price of the item.
	 * @throws IllegalArgumentException if any of the input parameters are invalid
	 */
	public void handleSubmit(String item_name, String item_category, String item_size, String item_price)
			throws IllegalArgumentException {
		itemController.UploadItem(item_name, item_category, item_size, item_price);
	}
}
