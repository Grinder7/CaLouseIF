package view;

import controller.SellerEditController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.Item;

public class SellerEditView extends VBox {
	private GridPane itemDetailGridPane;

	private Label idLabel, nameLabel, categoryLabel, sizeLabel, priceLabel, messageLabel;
	private TextField idItem, namaItem, categoryItem, ukuranItem, hargaItem;
	private Button submitButton;

	private SellerEditController controller;
	private Item item;

	public SellerEditView(SellerEditController controller, Item item) {
		super();
		this.controller = controller;
		this.item = item;
		initComponent();
		addComponent();
		styleComponent();
		initActionComponent();
	}

	public void initComponent() {
		itemDetailGridPane = new GridPane();

		idLabel = new Label("ID: ");
		nameLabel = new Label("Item Name: ");
		categoryLabel = new Label("Category: ");
		sizeLabel = new Label("Size: ");
		priceLabel = new Label("Price: ");
		messageLabel = new Label();

		idItem = new TextField();
		idItem.setText(item.getItem_id());
		idItem.setPromptText("Id Item");

		namaItem = new TextField();
		namaItem.setText(item.getItem_name());
		namaItem.setPromptText("Item Name");

		categoryItem = new TextField();
		categoryItem.setText(item.getItem_category());
		categoryItem.setPromptText("Item Category");

		ukuranItem = new TextField();
		ukuranItem.setText(item.getItem_size());
		ukuranItem.setPromptText("Item Size");

		hargaItem = new TextField();
		hargaItem.setText(item.getItem_price());
		hargaItem.setPromptText("Item Price");

		submitButton = new Button("Submit");
	}

	public void addComponent() {
		itemDetailGridPane.add(idLabel, 0, 0);
		itemDetailGridPane.add(nameLabel, 0, 1);
		itemDetailGridPane.add(categoryLabel, 0, 2);
		itemDetailGridPane.add(sizeLabel, 0, 3);
		itemDetailGridPane.add(priceLabel, 0, 4);

		itemDetailGridPane.add(idItem, 1, 0);
		itemDetailGridPane.add(namaItem, 1, 1);
		itemDetailGridPane.add(categoryItem, 1, 2);
		itemDetailGridPane.add(ukuranItem, 1, 3);
		itemDetailGridPane.add(hargaItem, 1, 4);

		this.getChildren().addAll(itemDetailGridPane, messageLabel, submitButton);
	}

	public void styleComponent() {
		itemDetailGridPane.setVgap(15);
		itemDetailGridPane.setHgap(15);

		this.setPadding(new Insets(15));
		this.setSpacing(15);

		idItem.setDisable(true);
	}

	public void initActionComponent() {
		submitButton.setOnAction(e -> {
			try {
				String Item_id = idItem.getText();
				String Item_name = namaItem.getText();
				String Item_category = categoryItem.getText();
				String Item_size = ukuranItem.getText();
				String Item_price = hargaItem.getText();
				controller.handleSubmitItem(Item_id, Item_name, Item_category, Item_size, Item_price);
				messageLabel.setText("Item uploaded");
				messageLabel.setTextFill(Color.GREEN);
			} catch (IllegalArgumentException ex) {
				messageLabel.setText(ex.getMessage());
				messageLabel.setTextFill(Color.RED);
			}

		});
	}
}
