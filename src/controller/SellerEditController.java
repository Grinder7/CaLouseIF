package controller;

public class SellerEditController {
	
	private ItemController itemController;
	
	public SellerEditController(ItemController itemController) {
		this.itemController = itemController;
	}

	/**
	 * Edits an existing item with new details.
	 * 
	 * @param Item_id      The unique identifier of the item to be edited.
	 * @param Item_name    The new name of the item.
	 * @param Item_category The new category of the item.
	 * @param Item_size    The new size of the item.
	 * @param Item_price   The new price of the item.
	 * @throws IllegalArgumentException if any of the parameters are invalid
	 */
	public void handleSubmitItem(String item_id, String item_name, String item_category, String item_size,
			String item_price) throws IllegalArgumentException{
		itemController.EditItem(item_id, item_name, item_category, item_size, item_price);
	}

}
