package router;

import controller.AdminDashboardController;
import controller.BuyerHomepageController;
import controller.BuyerItemDetailsController;
import controller.BuyerPurchaseHistoryController;
import controller.BuyerWishlistController;
import controller.ItemController;
import controller.LoginController;
import controller.RegisterController;
import controller.SellerDashboardController;
import controller.SellerEditController;
import controller.SellerOfferedItemController;
import controller.SellerUploadController;
import controller.TransactionController;
import controller.UserController;
import controller.WishlistController;
import javafx.scene.Node;
import javafx.scene.Parent;
import model.Item;
import view.AdminDashboardView;
import view.BuyerHomepageView;
import view.BuyerItemDetailsView;
import view.BuyerNavbar;
import view.BuyerPurchaseHistoryView;
import view.BuyerWishlistView;
import view.LoginView;
import view.RegisterView;
import view.SellerDashboardView;
import view.SellerEditView;
import view.SellerNavbar;
import view.SellerOfferedItemView;
import view.SellerUploadView;

/**
 * Provides static methods to retrieve various pages as {@code Node} objects.
 * <p>
 * This class contains methods that create and return the corresponding views
 * for different pages of the application. Each method initializes the necessary
 * controllers and views, and returns the view as a {@code Node}.
 * </p>
 */
public class PageData {

	/**
	 * Returns the login page as a {@code Node}.
	 *
	 * @return a {@code Node} representing the login page view
	 */
	public static Node loginPage() {
		LoginController controller = new LoginController(new UserController());
		return new LoginView(controller);
	}

	/**
	 * Returns the register page as a {@code Node}.
	 * 
	 * @return a {@code Node} representing the register page view
	 */
	public static Node registerPage() {
		RegisterController controller = new RegisterController(new UserController());
		return new RegisterView(controller);
	}

	/**
	 * Returns the seller upload page as a {@code Node}.
	 *
	 * @return a {@code Node} representing the seller upload page view
	 */
	public static Node sellerUploadPage() {
		return new SellerUploadView(new SellerUploadController(new ItemController()));
	}

	/**
	 * Returns the seller edit page as a {@code Node}.
	 * 
	 * @return a {@code Node} representing the seller edit page view
	 */
	public static Node sellerEditPage(Item item) {
		return new SellerEditView(new SellerEditController(new ItemController()), item);
	}

	/**
	 * Returns the {@code Node} for the admin dashboard page.
	 *
	 * @return the {@code Node} representing the admin dashboard page
	 */
	public static Node adminDashboardPage() {
		return new AdminDashboardView(new AdminDashboardController(new ItemController()));
	}

	/**
	 * Returns the {@code Node} for the buyer's homepage.
	 *
	 * @return the {@code Node} representing the buyer's homepage
	 */
	public static Node buyerHomePage() {
		return new BuyerHomepageView(new BuyerHomepageController(new ItemController()));
	}

	/**
	 * Returns the {@code Node} for the item details page for a buyer.
	 *
	 * @return the {@code Node} representing the buyer's item details page
	 */
	public static Node buyerItemDetailsPage(Item item) {
		return new BuyerItemDetailsView(new BuyerItemDetailsController(new ItemController(), new WishlistController(),
				new TransactionController()), item);
	}

	/**
	 * Creates and returns the navigation bar for buyers.
	 *
	 * @return a {@code Parent} node representing the buyer's navigation bar
	 */
	public static Parent buyerNavbar() {
		return new BuyerNavbar();
	}

	/**
	 * Creates and returns the Buyer Wishlist page.
	 *
	 * @return a {@link Node} representing the buyer's wishlist page
	 */
	public static Node buyerWishlistPage() {
		return new BuyerWishlistView(new BuyerWishlistController());
	}

	/**
	 * Creates and returns the Buyer Purchase History page.
	 *
	 * @return a {@link Node} representing the buyer's purchase history page
	 */
	public static Node buyerPurchaseHistoryPage() {
		return new BuyerPurchaseHistoryView(new BuyerPurchaseHistoryController());
	}

	/**
	 * Creates and returns the Seller Dashboard page.
	 *
	 * @return a {@link Node} representing the seller's dashboard page
	 */
	public static Node sellerDashboardPage() {
		return new SellerDashboardView(new SellerDashboardController(new ItemController()));
	}

	/**
	 * Creates and returns the Seller Navbar.
	 *
	 * @return a {@link Node} representing the seller's navigation bar
	 */
	public static Node sellerNavbar() {
		return new SellerNavbar();
	}

	/**
	 * Creates and returns the Seller Offered Item page.
	 *
	 * @return a {@link Node} representing the seller's offered item page
	 */
	public static Node sellerOfferedItemPage() {
		return new SellerOfferedItemView(new SellerOfferedItemController(new ItemController()));
	}

}
