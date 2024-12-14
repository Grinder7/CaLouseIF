package view;

import controller.SellerUploadController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SellerUploadView extends VBox{
	private GridPane itemDetailGridPane;
	
	private Label nameLabel, categoryLabel, sizeLabel, priceLabel, messageLabel;
	private TextField namaItem, categoryItem, ukuranItem, hargaItem;
	private Button submitButton;

	private SellerUploadController controller;
	
	public SellerUploadView(SellerUploadController controller) {
		super();
		this.controller = controller;
		initComponent();
		addComponent();
		styleComponent();
		initActionComponent();
	}

	public void initComponent() {
		itemDetailGridPane = new GridPane();
		
		nameLabel = new Label("Item Name: ");
		categoryLabel = new Label("Category: ");
		sizeLabel = new Label("Size: ");
		priceLabel = new Label("Price: ");	
		messageLabel = new Label();
		
		namaItem = new TextField();
		categoryItem = new TextField();
		ukuranItem = new TextField();
		hargaItem = new TextField();

		submitButton = new Button("Upload");
	}

	public void addComponent() {
		itemDetailGridPane.add(nameLabel, 0, 1);
		itemDetailGridPane.add(categoryLabel, 0, 2);
		itemDetailGridPane.add(sizeLabel, 0, 3);
		itemDetailGridPane.add(priceLabel, 0, 4);
		
		itemDetailGridPane.add(namaItem, 1, 1);
		itemDetailGridPane.add(categoryItem, 1, 2);
		itemDetailGridPane.add(ukuranItem, 1, 3);
		itemDetailGridPane.add(hargaItem, 1, 4);
		
		this.getChildren().addAll(itemDetailGridPane, messageLabel, submitButton);
	}

	public void styleComponent() {
		itemDetailGridPane.setVgap(15);
		itemDetailGridPane.setHgap(15);
		
		this.setSpacing(15);
		this.setPadding(new Insets(10));
	}

	public void initActionComponent() {
		submitButton.setOnAction(e -> {
			try {
				String Item_name = namaItem.getText();
				String Item_category = categoryItem.getText();
				String Item_size = ukuranItem.getText();
				String Item_price = hargaItem.getText();
				this.controller.handleSubmit(Item_name, Item_category, Item_size, Item_price);
				messageLabel.setText("Item uploaded");
				messageLabel.setTextFill(Color.GREEN);
			} catch (IllegalArgumentException ex) {
				messageLabel.setText(ex.getMessage());
				messageLabel.setTextFill(Color.RED);
			}
		});
	}
}
