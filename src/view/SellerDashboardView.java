package view;

import java.util.Arrays;

import controller.SellerDashboardController;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Item;

// Show approved items that the seller sells
public class SellerDashboardView extends BorderPane {
	private TableView<Item> itemTable;
	private TableColumn<Item, String> nameColumn, categoryColumn, sizeColumn, priceColumn, itemOfferStatusColumn;
	private VBox mainContent;
	private HBox actionBarTopHBox, actionBarBottomHBox;
	private Button refreshTableButton, editButton, deleteButton;

	private SellerDashboardController controller;
	private ObservableList<Item> itemList;

	public SellerDashboardView(SellerDashboardController controller) {
		super();
		this.controller = controller;
		itemList = controller.getSellerItems();
		initComponents();
		addComponents();
		styleComponents();
		setActionNode();
	}

	private void initComponents() {
		itemTable = new TableView<>();
		nameColumn = new TableColumn<>("Item Name");
		categoryColumn = new TableColumn<>("Category");
		sizeColumn = new TableColumn<>("Size");
		priceColumn = new TableColumn<>("Price");
		itemOfferStatusColumn = new TableColumn<>("Item Offer Status");

		nameColumn.setCellValueFactory(new PropertyValueFactory<>("item_name"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<>("item_category"));
		sizeColumn.setCellValueFactory(new PropertyValueFactory<>("item_size"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("item_price"));
//		get offer or no_offer
		itemOfferStatusColumn.setCellValueFactory(cd -> Bindings.createStringBinding(
				() -> {
					String[] offerStatus = cd.getValue().getItem_offer_status().split(",");
					if(offerStatus[0].equals("no_offer")) {
						return offerStatus[0];
					}
					
					return "offer," + offerStatus[1];
				}
		));
		
		itemTable.getColumns().addAll(Arrays.asList(nameColumn, categoryColumn, sizeColumn, priceColumn, itemOfferStatusColumn));
		itemTable.setItems(itemList);

		mainContent = new VBox();
		
		actionBarTopHBox = new HBox(15);
		actionBarBottomHBox = new HBox(15);
		
		refreshTableButton = new Button("Refresh Table");
		editButton = new Button("Edit");
		deleteButton = new Button("Delete");
	}

	private void addComponents() {
		mainContent.getChildren().add(itemTable);
		actionBarTopHBox.getChildren().add(refreshTableButton);
		actionBarBottomHBox.getChildren().addAll(editButton, deleteButton);
		
		this.setCenter(mainContent);
		this.setTop(actionBarTopHBox);
		this.setBottom(actionBarBottomHBox);
	}

	private void styleComponents() {
		this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(itemTable, Priority.ALWAYS);

		itemTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
		nameColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.35));
		categoryColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.337));
		sizeColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.1));
		priceColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.1));
		itemOfferStatusColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.1));
		
		actionBarTopHBox.setPadding(new Insets(0, 15, 15, 15));
		actionBarBottomHBox.setPadding(new Insets(15));
		actionBarBottomHBox.setAlignment(Pos.CENTER);
	}

	private void setActionNode() {
		refreshTableButton.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				itemList = controller.getSellerItems();
			}
		});
		
		editButton.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				Item item = itemTable.getSelectionModel().getSelectedItem();
				if (item != null) {
					controller.handleEditItem(item);
				}
			}
		});
		
		deleteButton.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				Item item = itemTable.getSelectionModel().getSelectedItem();
				if (item != null) {
					controller.handleDeleteItem(item);
				}
			}
		});
	}
}
