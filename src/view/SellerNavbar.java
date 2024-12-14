package view;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import router.PageData;
import router.Router;

public class SellerNavbar extends HBox{
	private Button dashboardButton, uploadItemButton, viewOfferedItemButton;
	private Router router;

	public SellerNavbar() {
		super();
		initComponent();
		addComponent();
		styleComponent();
		setActionComponent();
		router = Router.getInstance();
	}

	private void initComponent() {
		dashboardButton = new Button("Dashboard");
		uploadItemButton = new Button("Upload Item");
		viewOfferedItemButton = new Button ("View Offered Item");
	}

	private void addComponent() {
		this.getChildren().addAll(dashboardButton, uploadItemButton, viewOfferedItemButton);
	}

	private void styleComponent() {
		this.setSpacing(15);
	}

	private void setActionComponent() {
		uploadItemButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				router.navigateTo(PageData.sellerUploadPage());
			}
		});

		dashboardButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				router.navigateTo(PageData.sellerDashboardPage());
			}
		});
		
		viewOfferedItemButton.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				router.navigateTo(PageData.sellerOfferedItemPage());
			}
		});
	}

}
