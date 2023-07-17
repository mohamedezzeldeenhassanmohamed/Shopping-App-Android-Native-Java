# Shopping-App-Android

Shopping Android Application using java and SQLite. (splash page , login page , register page , home page , profile page , purchases page , products page , display product details page , setting page) in this project.

# I can explain the different components and features of a shopping Android application using Java and SQLite.

1. Splash Page: The splash page is the initial screen that appears when the app is launched. It usually displays a logo or an image and provides a smooth transition to the login or registration page.

2. Login and Register Pages: These pages allow users to log in to their existing accounts or register for a new account. Users will provide their credentials such as username and password to access the app.

3. Home Page: The home page serves as the main interface of the application, where users can see a curated selection of products, offers, and categories. It may include features like search functionality, featured products, and navigation menus.

4. Profile Page: The profile page allows users to view and edit their personal information, such as name, address, contact details, and payment methods. It also provides options to change passwords and manage account settings.

5. Purchases Page: This page displays the user's purchase history, including details such as order date, order ID, purchased products, and total amount spent. Users can track their orders, view order status, and initiate returns if applicable.

6. Products Page: The products page lists various products available for purchase. It may display product images, names, prices, ratings, and other relevant information. Users can browse through the products and select items to view more details or add them to the cart.

7. Display Product Details Page: When users select a specific product from the products page, they are directed to the product details page. This page provides detailed information about the selected product, including descriptions, specifications, customer reviews, and related products.

8. Cart Page: The cart page shows the items that the user has added for purchase. Users can review the items, modify quantities, remove items, and proceed to checkout.

9. Settings Page: The settings page allows users to customize app preferences and configurations. It may include options to manage notifications, language preferences, payment methods, delivery addresses, and other settings.

10. SQLite Database: SQLite is a lightweight and embedded database engine that can be used in Android applications. It can be utilized to store user authentication details, product information, purchase history, and other relevant data.

In summary, a shopping Android application using Java and SQLite would typically consist of a splash page, login and register pages for user authentication, a home page to display products, a profile page for managing user information, a purchases page to view order history, a products page to browse and select items, a display product details page for comprehensive information, a cart page to manage selected items, and a settings page for customization. The SQLite database is used to store and retrieve essential data for the application's functionality.

# To develop a shopping Android application using Java and SQLite, you can follow these steps:

1. Set up the project:
   - Create a new Android project in Android Studio.
   - Set the minimum SDK version and other project settings.

2. Design the user interface:
   - Create XML layout files for each activity (splash page, login page, register page, home page, profile page, purchases page, products page, display product details page, setting page).
   - Design the UI elements such as buttons, text fields, list views, etc., according to your requirements.
   - Customize the UI by adding images, colors, and styles.

3. Implement Database Operations:
   - Create a SQLiteOpenHelper subclass to handle database creation and version management.
   - Define the database schema - tables, columns, and relationships.
   - Implement methods to perform CRUD operations (Create, Read, Update, Delete) on the SQLite database, such as inserting user details, retrieving product information, updating profile data, etc.

4. Implement Activity Classes:
   - For each activity, create a corresponding Java class that extends the `AppCompatActivity` class.
   - Link the XML layout files with the activity classes using the `setContentView()` method.
   - Implement event handlers for UI interactions such as button clicks, form submissions, etc.
   - Use the SQLite database operations to retrieve or store data as required.

5. Handle Navigation between Activities:
   - Define intents and implement navigation logic to move between different activities based on user actions.
   - For example, after successful login, navigate from the login page to the home page, and so on.

6. Add Functionality:
   - Implement functionality specific to each activity, such as displaying product lists on the home page, retrieving user profile information, displaying purchase history, etc.
   - Implement search functionality, sorting options, filtering, and pagination if needed.
   - Handle user authentication and validation for login and registration.
   - Implement features like adding products to the cart, managing cart items, and proceeding to checkout.

7. Test and Debug:
   - Test the application on different devices and screen sizes to ensure proper layout and functionality.
   - Debug any issues or errors that arise during testing.

8. Publish the Application:
   - Generate a signed APK (Android Package Kit) file for distribution.
   - Publish the APK to the Google Play Store or other app marketplaces, following their guidelines and policies.

* Remember to follow best practices for coding, user experience design, and security when developing the application. It's also recommended to use libraries like Retrofit for API integration, Picasso or Glide for image loading, and RecyclerView for efficient list display.

* Note: This is a high-level overview of the steps involved in developing a shopping Android application using Java and SQLite. The actual implementation may vary based on your specific requirements and design choices.

# ShoppingApp_GUI

<p> splash page</p>
<div align=center>
        <img src="https://user-images.githubusercontent.com/81251707/170893391-366785e3-ce83-40de-9e6f-a6ed864a79f0.jpg" alt="splash page" height="400" width="200">
</div>
<p> login page</p>
<div align=center>
        <img src="https://user-images.githubusercontent.com/81251707/170893392-40938f12-4e62-41f4-9ed2-ec2d66ee8996.jpg" alt="login page" height="400" width="200">
</div>
<p> register page</p>
<div align=center>
        <img src="https://user-images.githubusercontent.com/81251707/170893396-60112b7d-72f8-4bac-be40-273ac5fda0b2.jpg" alt="register page" height="400" width="200">
</div>
<p> home page</p>
<div align=center>
        <img src="https://user-images.githubusercontent.com/81251707/170893397-630a5ea2-c60b-4819-bd1c-ab4275747215.jpg" alt="home page" height="400" width="200">
</div>
<p> profile page</p>
<div align=center>
        <img src="https://user-images.githubusercontent.com/81251707/170893407-ed4eafdd-946d-4eb9-bed9-41930e6e1469.jpg" alt="home page" height="400" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893408-a428a4e1-7ab3-443f-92f5-0de9ca77ddbe.jpg" alt="home page" height="400" width="200">
</div>


<p> setting page</p>
<div align=center>
        <img src="https://user-images.githubusercontent.com/81251707/170893409-c54ebd13-1391-4b50-acad-2020353060f8.jpg" alt="setting" height="400" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893411-84967844-a831-4f8f-b849-40954023a84e.jpg" alt="setting" height="400" width="200">
</div>

<p> products page</p>
<div align=center>
        <img src="https://user-images.githubusercontent.com/81251707/170893412-304d9286-ae77-4b10-a7ab-76b348079000.jpg" alt="products" height="600" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893413-c18fc576-09d1-4c1f-b9b0-8cae0a510fa5.jpg" alt="products" height="550" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893416-26099d83-87eb-423d-9f12-88fe522537ed.jpg" alt="products" height="500" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893418-33da3708-3261-4437-b56b-58a10321fca2.jpg" alt="products" height="550" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893419-a7b7c680-8222-4ec2-b8d4-2127669d3f2c.jpg" alt="products" height="500" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893420-023e0e04-76a0-4c7b-ac8e-680bd30a5540.jpg" alt="products" height="500" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893422-bc79a589-bcde-439d-8fc7-301fa9adbae6.jpg" alt="products" height="500" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893425-63675035-656f-47b3-a1b9-b5eb53397299.jpg" alt="products" height="500" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893426-ad40c89e-024a-4df1-8d46-fd09b0e666b9.jpg" alt="products" height="550" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893428-3ab93233-cc2a-431d-82df-b418565e5353.jpg" alt="products" height="500" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893429-75c6a6e7-825e-4e91-aa50-759f8715df94.jpg" alt="products" height="500" width="200">
</div>

<p> display product details page && purchases page</p>
<div align=center>
        <img src="https://user-images.githubusercontent.com/81251707/170893468-8b6feaf4-091a-4731-ba35-2a005e9b8351.jpg" alt="purchases page" height="400" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893470-995da7e1-ac8e-48b6-bcd8-c4fe7e1c3d60.jpg" alt="purchases page" height="400" width="200">
        <img src="https://user-images.githubusercontent.com/81251707/170893471-d56d5b92-bf06-4a84-baef-63c7fe95de78.jpg" alt="display product" height="430" width="200">
</div>

<p> search product</p>
<div align=center>
        <img src="https://user-images.githubusercontent.com/81251707/170893430-8b358855-82d2-43e5-ab57-1583cbddb446.jpg" alt="search product" height="400" width="200">
</div>
