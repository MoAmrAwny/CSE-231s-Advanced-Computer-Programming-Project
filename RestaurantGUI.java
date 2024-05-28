
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RESTURANTGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Stage window ;
    ArrayList<Order> orders = new ArrayList<>();

    Order order = new Order();
    boolean delivery = false ;



    @Override
    public void start(Stage primaryStage)
    {


    // LogIn for employees scene

        window = primaryStage;
        window.setTitle("Log-In");
        GridPane EmployeeLogIn = new GridPane();
        Scene LogIn= new Scene(EmployeeLogIn,600,400);
        LogIn.getRoot().setStyle("-fx-background-color: #8383b9;");


    // Logo for the Scene
    // The Path of the image and icons should be modified according to the location where the file is stored in order to work properly

        String image ="file:///C:\\Users\\pc\\Desktop\\Final Project\\src\\main\\java\\com\\example\\ASUPROJECT\\flavors--gusto-favicon-black.png";
        Image icon = new Image(image);
        Image logo = new Image("file:///C:\\Users\\pc\\Desktop\\Final Project\\src\\main\\java\\com\\example\\ASUPROJECT\\logo-no-background.png");
        Label mainTitle = new Label("F&G Resturant");
        window.getIcons().add(icon);

        Employee [] EmployeesList=
    {

       new cashier("HEFNY", 26, 3033, "HEFNY", 5000),

       new cashier("GANA", 21, 3001, "GANA", 3500),

       new cashier("AWNY", 45, 2500, "AWNY", 6000),

       new chef("FARHA", 38, 2855, "HAILOLA", 7000),

       new chef("HUSSIEN", 34, 2630, "HUSSIEN", 600500),

       new chef("ENG MAZEN", 30, 3500, "ASU2025", 5700)

    };



        EmployeeLogIn.setPadding(new Insets(10,10,10,10)); //will put 10 pixel padding
        EmployeeLogIn.setVgap(8);
        EmployeeLogIn.setHgap(8);



//Label Title
        Label LogInTitle = new Label("Employees Login");
        LogInTitle.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        EmployeeLogIn.setConstraints(LogInTitle, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);

// Name
        Label Namelabel = new Label("Name");
        TextField NameText = new TextField();
        NameText.setPromptText("Name");
        EmployeeLogIn.setConstraints(Namelabel, 0, 1);
        EmployeeLogIn.setConstraints(NameText, 1, 1);

// Password
        Label Passwrodlabel = new Label("Password");
        TextField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        EmployeeLogIn.setConstraints(Passwrodlabel, 0, 2);
        EmployeeLogIn.setConstraints(passwordField, 1, 2);

// Login Button
        Button loginButton = new Button("Log In");
        EmployeeLogIn.setConstraints(loginButton, 1, 3);

// Set alignment
        EmployeeLogIn.setAlignment(Pos.CENTER);




//Button action
        loginButton.setOnAction(e->{
        // Data matching
            String NameData= NameText.getText();
            String PasswordData= passwordField.getText();
            boolean flag=false;
            int i;

            for( i=0; i<6;i++ )
            {


                if (NameData.equals(EmployeesList[i].getName()) && PasswordData.equals(EmployeesList[i].getPassword())) {
                    flag = true;
                    break;
                }
            }
               if(flag)
                {
                    System.out.println( EmployeesList[i].display_info());
                    EmployeesList[i].CheckIn();
                    if(EmployeesList[i] instanceof cashier) {
                        // We should add the following stage

                        Label paidAmountLabel = new Label("Paid Amount:");
                        TextField paidAmountField = new TextField();
                        HBox xbox = new HBox(10, paidAmountLabel , paidAmountField);
                        //Image icon = new Image(getClass().getResourceAsStream("D:\\kolya\\Spring 24\\Advanced Programming\\Project\\Finaaaaaal el finaaal\\javafx learning\\demo\\src\\main\\java\\com\\example\\demo\\flavors--gusto-favicon-black.png"));
                        //primaryStage.getIcons().add(icon);
                        //        Image logo = new Image("D:\\\\kolya\\\\Spring 24\\\\Advanced Programming\\\\Project\\\\Finaaaaaal el finaaal\\\\javafx learning\\\\demo\\\\src\\\\main\\\\java\\\\com\\\\example\\\\demo\\\\flavors--gusto-favicon-black.png");
                        //        primaryStage.getIcons().add(javafx.scene.image.Image.fromPlatformImage(logo));
                                                // Load the icon image;

// Create an ImageView to display the image
                        ImageView imageView = new ImageView(logo);
                        imageView.setFitWidth(300); // Set width of the image
                        imageView.setFitHeight(150); // Set height of the image

// Add the ImageView and the label to a VBox for vertical alignment
                        VBox vbox = new VBox(imageView);
                        vbox.setAlignment(Pos.CENTER);
//        String logoo ="D:\\kolya\\Spring 24\\Advanced Programming\\Project\\Finaaaaaal el finaaal\\javafx learning\\demo\\src\\main\\java\\com\\example\\demo\\logo-no-background.png";
//        ImageView logo = new ImageView(logoo);

                        primaryStage.getIcons().add(icon);
                        // Predefined menu of items
                        FoodItems[] menu = {
                                new FoodItems("Sea Food", 50),
                                new FoodItems("ClassicBurger", 9.99),
                                new FoodItems("CheeseBurger", 10.99),
                                new FoodItems("DoubleBurger", 12.99),
                                new FoodItems("PizzaMargherita", 10.00),
                                new FoodItems("PizzaSeafood", 22.99),
                                new FoodItems("PizzaHotDog", 13.99),
                                new FoodItems("Pasta", 7.99),
                                new FoodItems("Pasta White Sauce", 10.99),
                                new FoodItems("Pasta Red Sauce", 10.99),
                                new FoodItems("Pasta with Shrimps", 19.99),
                                new FoodItems("Fried Liver", 19.99)
                        };
                        ArrayList<FoodItems> menu1 = new ArrayList<>(Arrays.asList(menu));
                        Collections.sort(menu1);
                        DrinkItems[] drinkmenu = {
                                new DrinkItems("Water Small", 1.99),
                                new DrinkItems("Water Large", 3.99),
                                new DrinkItems("MilkShake Chocolate", 8.99),
                                new DrinkItems("MilkShake Vanilla", 8.99),
                                new DrinkItems("MilkShake Carmel", 8.99),
                                new DrinkItems("Coffee", 4.99),
                                new DrinkItems("Tea", 3.99),
                                new DrinkItems("Spero Spathis", 4.99),
                                new DrinkItems("Orange Juice", 10.99),
                                new DrinkItems("Mango Juice", 19.99),
                                new DrinkItems("Strawberry Juice", 19.99)
                        };
                        ArrayList<DrinkItems> DrinksMenu = new ArrayList<>(Arrays.asList(drinkmenu));
                        Collections.sort(DrinksMenu);
                        DessertItems[] dessertmenu = {
                                new DessertItems("Brownies with Ice-Cream", 19.00),
                                new DessertItems("Cheesecake topped with mixed berries", 18.99),
                                new DessertItems("Cheesecake topped with chocolate sauce", 17.99),
                                new DessertItems("Cookie skillet", 22.00),
                                new DessertItems("Pancakes topped with our special syrup", 22.99),
                                new DessertItems("Ice-Cream", 13.99),
                        };
                        ArrayList<DessertItems> DessertsMenu = new ArrayList<>(Arrays.asList(dessertmenu));
                        Collections.sort(DessertsMenu);

                        primaryStage.setTitle("Restaurant");
                        Button Delivery = new Button("Delivery");
                        Button takeAway = new Button("take away");
                        Button dineIn = new Button("Dine in");

                        Button mainDish = new Button("Main Dishes");

                        Button drinks = new Button("Drinks");
                        Button dessert = new Button("Dessert");
                        Button back = new Button("Back");
                        Button finishOrder = new Button("finish order");

                        Delivery.setPrefSize(80, 40);
                        takeAway.setPrefSize(80, 40);
                        dineIn.setPrefSize(80, 40);

                        mainDish.setPrefSize(100, 40);
                        drinks.setPrefSize(100, 40);
                        dessert.setPrefSize(100, 40);
                        back.setPrefSize(80, 40);
                        finishOrder.setPrefSize(80, 40);

                        ArrayList<Tables> tablesList = new ArrayList<>();

                        HBox deliveryType = new HBox(40, Delivery, takeAway, dineIn);
                        deliveryType.setAlignment(Pos.CENTER); // Center align the HBox
                        deliveryType.setPadding(new Insets(50, 30, 50, 30)); // Padding to distribute buttons evenly and increase space above and below

                        BorderPane borderPane = new BorderPane();
                        borderPane.setPadding(new Insets(20, 60, 20, 60)); // Increased top padding to make space for title
                        borderPane.setCenter(deliveryType);
                        BorderPane.setAlignment(vbox, Pos.TOP_CENTER); // Aligning title to the top center
                        borderPane.setTop(vbox);

                        Label availableTable = new Label("Available Tables: " + Tables.no_of_available_tables());
                        availableTable.setStyle("-fx-font-size: 15px; -fx-font-style: italic;");

                        Button clearTableButton = new Button("Clear Table");

                        HBox bottomContent = new HBox(50, availableTable, clearTableButton);
                        bottomContent.setAlignment(Pos.CENTER); // Aligning the content to the center
                        bottomContent.setPadding(new Insets(10)); // Adding padding for space
                        borderPane.setBottom(bottomContent);

                        mainTitle.setStyle("-fx-font-size: 40px; -fx-font-weight: Bold;");

                        Scene scene = new Scene(borderPane, 600, 400);
                        scene.getRoot().setStyle("-fx-background-color: #8383b9;");

                        primaryStage.setScene(scene);
                        primaryStage.show();

                        HBox items = new HBox(20, mainDish, drinks, dessert);
                        items.setAlignment(Pos.CENTER);
                        items.setPadding(new Insets(50, 30, 50, 30));

                        HBox bottomButtons = new HBox(10, back, finishOrder);

                        bottomButtons.setAlignment(Pos.BOTTOM_CENTER);
                        BorderPane borderPane1 = new BorderPane();
                        borderPane1.setCenter(items);
                        borderPane1.setBottom(bottomButtons);
                        bottomButtons.setPadding(new Insets(10));

                        Label choosecategory = new Label("Choose Category");
                        borderPane1.setTop(choosecategory);

                        BorderPane.setAlignment(choosecategory, Pos.TOP_CENTER);
                        choosecategory.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;");


                        Scene scene1 = new Scene(borderPane1, 600, 400);
                        scene1.getRoot().setStyle("-fx-background-color: #8383b9;");
                        dessert.setOnAction(action -> {
                            GridPane gridPane = new GridPane();
                            gridPane.setAlignment(Pos.CENTER);
                            gridPane.setPadding(new Insets(20));
                            gridPane.setHgap(10);
                            gridPane.setVgap(10);

                            Label titleLabel = new Label("Menu");
                            titleLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");
                            GridPane.setConstraints(titleLabel, 0, 0, 2, 1);

                            Label menuLabel = new Label("Desserts");
                            menuLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: none;");
                            GridPane.setConstraints(menuLabel, 0, 1);

                            ListView<String> menuListView = new ListView<>();
                            for (Items item : DessertsMenu) {
                                menuListView.getItems().add(item.getname() + " - $" + item.getprice());
                            }
                            menuListView.setPrefHeight(320);
                            GridPane.setConstraints(menuListView, 0, 2, 2, 1);

                            Label quantityLabel = new Label("Quantity:");
                            GridPane.setConstraints(quantityLabel, 0, 3);

                            Spinner<Integer> quantitySpinner = new Spinner<>(1, 20, 1);
                            GridPane.setConstraints(quantitySpinner, 1, 3);

                            Button addButton = new Button("Add to Order");
                            addButton.setMaxHeight(Double.MAX_VALUE);

                            Button removeButton = new Button("Remove from Order");
                            removeButton.setMaxHeight(Double.MAX_VALUE);

                            Button backToMainMenu = new Button("Back to Main Menu");
                            backToMainMenu.setMaxHeight(Double.MAX_VALUE);

                            HBox buttonBox = new HBox(10);
                            buttonBox.getChildren().addAll(addButton, removeButton, backToMainMenu);
                            GridPane.setConstraints(buttonBox, 0, 4, 2, 1);

                            addButton.setOnAction(event -> {
                                String selectedItem = menuListView.getSelectionModel().getSelectedItem();
                                int quantity = quantitySpinner.getValue();

                                if (selectedItem != null) {
                                    String[] parts = selectedItem.split(" - \\$");
                                    String itemName = parts[0];
                                    double itemPrice = Double.parseDouble(parts[1]);

                                    Items selectedItemObject = null;
                                    for (Items item : DessertsMenu) {
                                        if (item.getname().equals(itemName) && item.getprice() == itemPrice) {
                                            selectedItemObject = item;
                                            break;
                                        }
                                    }

                                    if (selectedItemObject != null) {
                                        order.addItem(selectedItemObject, quantity);
                                        System.out.println("Added " + quantity + " " + selectedItemObject.getname() + " to the order.");

                                        double totalOrderPrice = order.calculateTotal();
                                        System.out.println("Total order price: $" + totalOrderPrice);
                                    } else {
                                        System.out.println("Error: Selected item not found in the menu.");
                                    }
                                } else {
                                    System.out.println("Error: Please select an item from the menu.");
                                }
                            });

                            backToMainMenu.setOnAction(actionEvent1 -> {
                                primaryStage.setScene(scene1);
                            });

                            removeButton.setOnAction(event -> {
                                if(order.getItems().isEmpty()){
                                    showErrorAlert("There is nothing to remove!");
                                }
                                else {

                                    order.removeItemFromOrder();
                                    System.out.print(" : is removed from the order \n");
                                    System.out.println("Total order price: $" + order.calculateTotal());

                                }});

                            gridPane.getChildren().addAll(titleLabel, menuLabel, menuListView, quantityLabel, quantitySpinner, buttonBox);

                            Scene scene2 = new Scene(gridPane, 600, 400);
                            scene2.getRoot().setStyle("-fx-background-color: #8383b9;");
                            primaryStage.setScene(scene2);
                            primaryStage.setTitle("Restaurant Management System");
                            primaryStage.show();
                        });

//        finishOrder.setOnAction(actionEvent -> {
//            double totalOrderPrice = order.calculateTotal();
//            System.out.println("Total order price: $" + totalOrderPrice);
//
//            // Code for finishing order and making payment goes here
//        });
                        Delivery.setOnAction(actionEvent -> {
                            delivery = true;
                            primaryStage.setScene(scene1);
                        });
                        takeAway.setOnAction(actionEvent -> {
                            primaryStage.setScene(scene1);
                        });

                        back.setOnAction(actionEvent -> {
                            primaryStage.setScene(scene);
                        });

                        clearTableButton.setOnAction(actionEvent -> {
                            Tables.table_is_clear();
                            availableTable.setText("Available Tables: " + Tables.no_of_available_tables());
                        });

                        dineIn.setOnAction(event -> {
                            if(Tables.no_of_available_tables() == 0)
                                showErrorAlert ("No tables available, please wait!!!!!!!!");
                            else {
                                primaryStage.setScene(scene1);
                                tablesList.add(new Tables());
                                availableTable.setText("Available Tables: " + Tables.no_of_available_tables());
                            }});

                        mainDish.setOnAction(actionEvent -> {GridPane gridPane = new GridPane();
                            gridPane.setAlignment(Pos.CENTER);
                            gridPane.setPadding(new Insets(20));
                            gridPane.setHgap(10);
                            gridPane.setVgap(10);

                            Label titleLabel = new Label("Menu");
                            titleLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");
                            GridPane.setConstraints(titleLabel, 0, 0, 2, 1);

                            Label menuLabel = new Label("Main Dishes");
                            menuLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: none;");
                            GridPane.setConstraints(menuLabel, 0, 1);

                            ListView<String> menuListView = new ListView<>();
                            for (Items item : menu1) {
                                menuListView.getItems().add(item.getname() + " - $" + item.getprice());
                            }
                            menuListView.setPrefHeight(320);
                            GridPane.setConstraints(menuListView, 0, 2, 2, 1);

                            Label quantityLabel = new Label("Quantity:");
                            GridPane.setConstraints(quantityLabel, 0, 3);

                            Spinner<Integer> quantitySpinner = new Spinner<>(1, 20, 1);
                            GridPane.setConstraints(quantitySpinner, 1, 3);

                            Button addButton = new Button("Add to Order");
                            addButton.setMaxHeight(Double.MAX_VALUE);

                            Button removeButton = new Button("Remove from Order");
                            removeButton.setMaxHeight(Double.MAX_VALUE);

                            Button backToMainMenu = new Button("Back to Main Menu");
                            backToMainMenu.setMaxHeight(Double.MAX_VALUE);

                            HBox buttonBox = new HBox(10);
                            buttonBox.getChildren().addAll(addButton, removeButton, backToMainMenu);
                            GridPane.setConstraints(buttonBox, 0, 4, 2, 1);
                            addButton.setOnAction(event -> {
                                String selectedItem = menuListView.getSelectionModel().getSelectedItem();
                                int quantity = quantitySpinner.getValue();

                                if (selectedItem != null) {
                                    String[] parts = selectedItem.split(" - \\$");
                                    String itemName = parts[0];
                                    double itemPrice = Double.parseDouble(parts[1]);

                                    Items selectedItemObject = null;
                                    for (Items item : menu) {
                                        if (item.getname().equals(itemName) && item.getprice() == itemPrice) {
                                            selectedItemObject = item;
                                            break;
                                        }
                                    }

                                    if (selectedItemObject != null) {
                                        order.addItem(selectedItemObject, quantity);
                                        System.out.println("Added " + quantity + " " + selectedItemObject.getname() + " to the order.");

                                        double totalOrderPrice = order.calculateTotal();
                                        System.out.println("Total order price: $" + totalOrderPrice);
                                    } else {
                                        System.out.println("Error: Selected item not found in the menu.");
                                    }
                                } else {
                                    System.out.println("Error: Please select an item from the menu.");
                                }
                            });
                            removeButton.setOnAction(event -> {
                                if(order.getItems().isEmpty()){
                                    showErrorAlert("There is nothing to remove!");
                                }
                                else {

                                    order.removeItemFromOrder();
                                    System.out.print(" : is removed from the order \n");
                                    System.out.println("Total order price: $" + order.calculateTotal());

                                }});
                            backToMainMenu.setOnAction(actionEvent1 -> {
                                primaryStage.setScene(scene1);
                            });

                            gridPane.getChildren().addAll(titleLabel, menuLabel, menuListView, quantityLabel, quantitySpinner, buttonBox);

                            Scene scene2 = new Scene(gridPane, 600, 400);
                            scene2.getRoot().setStyle("-fx-background-color: #8383b9;");
                            primaryStage.setScene(scene2);
                            primaryStage.setTitle("Restaurant Management System");
                            primaryStage.show();

                        });
                        drinks.setOnAction(actionEvent -> {
                            GridPane gridPane = new GridPane();
                            gridPane.setAlignment(Pos.CENTER);
                            gridPane.setPadding(new Insets(20));
                            gridPane.setHgap(10);
                            gridPane.setVgap(10);

                            Label titleLabel = new Label("Menu");
                            titleLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");
                            GridPane.setConstraints(titleLabel, 0, 0, 2, 1);

                            Label menuLabel = new Label("Drinks");
                            menuLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: none;");
                            GridPane.setConstraints(menuLabel, 0, 1);

                            ListView<String> menuListView = new ListView<>();
                            for (Items item : DrinksMenu) {
                                menuListView.getItems().add(item.getname() + " - $" + item.getprice());
                            }
                            menuListView.setPrefHeight(320);
                            GridPane.setConstraints(menuListView, 0, 2, 2, 1);

                            Label quantityLabel = new Label("Quantity:");
                            GridPane.setConstraints(quantityLabel, 0, 3);

                            Spinner<Integer> quantitySpinner = new Spinner<>(1, 20, 1);
                            GridPane.setConstraints(quantitySpinner, 1, 3);

                            Button addButton = new Button("Add to Order");
                            addButton.setMaxHeight(Double.MAX_VALUE);

                            Button removeButton = new Button("Remove from Order");
                            removeButton.setMaxHeight(Double.MAX_VALUE);

                            Button backToMainMenu = new Button("Back to Main Menu");
                            backToMainMenu.setMaxHeight(Double.MAX_VALUE);

                            HBox buttonBox = new HBox(10);
                            buttonBox.getChildren().addAll(addButton, removeButton, backToMainMenu);
                            GridPane.setConstraints(buttonBox, 0, 4, 2, 1);
                            addButton.setOnAction(event -> {
                                String selectedItem = menuListView.getSelectionModel().getSelectedItem();
                                int quantity = quantitySpinner.getValue();

                                if (selectedItem != null) {
                                    String[] parts = selectedItem.split(" - \\$");
                                    String itemName = parts[0];
                                    double itemPrice = Double.parseDouble(parts[1]);

                                    Items selectedItemObject = null;
                                    for (Items item : drinkmenu) {
                                        if (item.getname().equals(itemName) && item.getprice() == itemPrice) {
                                            selectedItemObject = item;
                                            break;
                                        }
                                    }

                                    if (selectedItemObject != null) {
                                        order.addItem(selectedItemObject, quantity);
                                        System.out.println("Added " + quantity + " " + selectedItemObject.getname() + " to the order.");

                                        double totalOrderPrice = order.calculateTotal();
                                        System.out.println("Total order price: $" + totalOrderPrice);
                                    } else {
                                        System.out.println("Error: Selected item not found in the menu.");
                                    }
                                } else {
                                    System.out.println("Error: Please select an item from the menu.");
                                }
                            });

                            removeButton.setOnAction(event -> {
                                if(order.getItems().isEmpty()){
                                    showErrorAlert("There is nothing to remove!");
                                }
                                else {

                                    order.removeItemFromOrder();
                                    System.out.print(" : is removed from the \n");
                                    System.out.println("Total order price: $" + order.calculateTotal());

                                }});

                            gridPane.getChildren().addAll(titleLabel, menuLabel, menuListView, quantityLabel, quantitySpinner, buttonBox);
                            backToMainMenu.setOnAction(actionEvent1 -> {
                                primaryStage.setScene(scene1);
                            });

                            Scene scene3 = new Scene(gridPane, 600, 400);
                            scene3.getRoot().setStyle("-fx-background-color: #8383b9;");
                            primaryStage.setScene(scene3);
                            primaryStage.setTitle("Restaurant Management System");
                            primaryStage.show();
                        });

                        finishOrder.setOnAction(actionito ->
                        {
                            Payments payment = new Payments(order);
                            Button button1 = new Button("Pay Now");
                            Label headerLabel = new Label("Restaurant Payment System");
                            // headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
                            headerLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-font-family: 'Eras Demi ITC';");
                            Label totalAmountValue;
                            Label totalAmountLabel = new Label("Total Amount:");
                            if(delivery) {
                                totalAmountValue = new Label("$" + (payment.getTotal_price()+20));
                            }
                            else {
                                totalAmountValue = new Label("$" + payment.getTotal_price());
                            }

                            ToggleGroup group = new ToggleGroup();
                            RadioButton Cash = new RadioButton("CASH");
                            RadioButton Visa = new RadioButton("VISA");

                            Cash.setToggleGroup(group);
                            Visa.setToggleGroup(group);
                            VBox layout1 = new VBox(50);
                            layout1.setPadding(new Insets(20));
                            layout1.getChildren().addAll(headerLabel,new HBox(10, totalAmountLabel, totalAmountValue),
                                    new HBox(30, Cash,Visa ),
                                    xbox,button1);
                            Scene scene5 = new Scene(layout1, 600, 400);
                            scene5.getRoot().setStyle("-fx-background-color: #8383b9;");
                            button1.setOnAction(actionEvent ->
                                    paynowClicked(paidAmountField.getText(), primaryStage, Cash, Visa, scene)
                            );


                            layout1.setAlignment(Pos.CENTER);
                            layout1.setPadding(new Insets(20));

                            primaryStage.setScene(scene5);
                            primaryStage.setTitle("Payment Window");
                          //  primaryStage.show();

                        });


                    }

                    else
                    {
                        GridPane temp= new GridPane();
                        HBox hbox= new HBox();
                        Label chefText=new Label("To be Continued");
                        hbox.getChildren().addAll(chefText);
                        chefText.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;");
                        temp.getChildren().addAll(hbox);
                        hbox.setAlignment(Pos.CENTER);
                        Scene mmm=new Scene(temp,600,400);
                        mmm.getRoot().setStyle("-fx-background-color: #8383b9;");
                        System.out.println("WELCOME!!!!");
                        window.setScene(mmm);
                        window.show();
                    }

                    }
               else showErrorAlert("Invalid Name or Password");







        });



        EmployeeLogIn.getChildren().addAll(Namelabel,NameText,Passwrodlabel,passwordField,loginButton,LogInTitle);

        window.setScene(LogIn);
        window.show();





    }

    private void showErrorAlert (String msg)
    {
        // Load the icon image for the alert
        String iconPath = "file:///C:\\Users\\pc\\Desktop\\Final Project\\src\\main\\java\\com\\example\\ASUPROJECT\\download.jpg";
        Image iconImage = new Image(iconPath);

        // Create the alert with the specified message and icon
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.setTitle("Error");
        alert.setHeaderText(null);

        // Set the icon image for the alert
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(iconImage);


        // Show the alert
        alert.showAndWait();
    }



    public void paynowClicked (String paidmoney, Stage stage, RadioButton option1, RadioButton option2, Scene scene)
    {

        Tables tables = new Tables();
        Payments payment = new Payments(order, tables);
        //  handleRadioButton(Cash,Visa);

        if (paidmoney.isEmpty()) {
            // If the paid amount field is empty, show an error message
            showErrorAlert("Please enter a valid number for the paid amount.");
            return;
        }
        double paidValue;

        try {
            paidValue = Double.parseDouble(paidmoney);
        } catch (NumberFormatException e) {
            // If the paid amount cannot be parsed as a double, show an error message
            showErrorAlert("Invalid input ,Please enter a valid number for the paid amount.");
            return;
        }

        if (paidValue < payment.getTotal_price())
            showErrorAlert("Please enter the required amount");

        else {
            if ((option1.isSelected()) || (option2.isSelected())) {
                if ((!option1.isSelected()) && (option2.isSelected())) {
                    payment.setTypeOfPayment(paymentType.VISA);
                    Label Card = new Label("Card Number:");
                    TextField CardField = new TextField();
                } else if ((option1.isSelected()) && (!option2.isSelected())) {
                    payment.setTypeOfPayment(paymentType.CASH);
                }
                Label headerLabel = new Label("Restaurant Payment System");

                headerLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-font-family: 'Eras Demi ITC';");
                Label totalAmountLabel = new Label("Total Amount:");
                double output = payment.makePayment(paidValue, payment.getTypeOfPayment(), delivery);
                Label totalAmountValue;
                if(delivery) {
                    totalAmountValue = new Label("$" + (payment.getTotal_price()+20) );
                }
                else{
                    totalAmountValue = new Label("$" + payment.getTotal_price() );
                }
                Label PaidLabel = new Label("Paid Amount:");
                Label PaidValue = new Label("$" + paidValue);
                //handleOptions ();
                Label ChangeLabel = new Label("Change:");
                Label ChangeValue = new Label("$" + output);
                VBox layout1 = new VBox(50);

                layout1.setPadding(new Insets(20));
                Button button2 = new Button("Close");
                Button button3 = new Button("New Order");

                layout1.setAlignment(Pos.CENTER);
                layout1.getChildren().addAll(headerLabel, new HBox(10, totalAmountLabel, totalAmountValue),
                        new HBox(10, PaidLabel, PaidValue), new HBox(10, ChangeLabel, ChangeValue),
                        new HBox(440, button2, button3));

                Scene scene2 = new Scene(layout1, 600, 400);
                scene2.getRoot().setStyle("-fx-background-color: #8383b9;");
                stage.setScene(scene2);
                button2.setOnAction(e -> {
                    stage.close();
                });
                button3.setOnAction(e-> {
                    order = new Order();
                    delivery = false;
                    stage.setScene(scene);
                });
                stage.setTitle("Payment Window");
                stage.show();
            } else if ((!option1.isSelected()) && (!option2.isSelected())) {
                showErrorAlert("Please select a payment method");

            }

        }
    }
}



