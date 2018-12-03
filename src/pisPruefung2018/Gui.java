package pisPruefung2018;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class Gui extends Application {
    public void start(Stage primaryStage) {
        //All icons are under Creative Commons Attribution-NoDerivs 3.0 Unported licence.
        //source: https://icons8.com/license/
        //image for Buttons & Window icon:
        //submit icon 80 x 80 Pixel
        //Background Image is Public Domain
        //source https://pixabay.com/de/blog/posts/public-domain-bilder-und-bildrechte-was-ist-erla-33/
        BackgroundImage bGi = new BackgroundImage(new Image(
                "https://cdn.pixabay.com/photo/2018/07/31/10/22/address-book-3574685_960_720.jpg"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        //Icon Images for Main Menu
        Image imgAdd = new Image(getClass().getResourceAsStream("icons8-add-user-male-80.png"));
        Image imgDelete = new Image(getClass().getResourceAsStream("icons8-denied-80.png"));
        Image imgSearch = new Image(getClass().getResourceAsStream("icons8-find-user-male-80.png"));
        Image imgContacts = new Image(getClass().getResourceAsStream("icons8-contacts-80.png"));

        //Window Icon
        Image imgWindow = new Image(getClass().getResourceAsStream("icons8-contacts-80.png"));

        //Main Menu Button for Add an Contact
        Button btn0 = new Button("", new ImageView(imgAdd));
        btn0.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        btn0.setPrefWidth(200);
        btn0.setPrefHeight(50);

        //When Button "Add Contact" (Icon with Contact and plus sign) is pushed,
        //a new Scene for adding a Contact will be opened.
        btn0.setOnAction(action -> {
            //Adds Icon to Scene Add on Top
            Button btnIconedit = new Button("", new ImageView(imgAdd));
            btnIconedit.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            //Adds Add Button in Menu Add Contact
            Button btnAdd = new Button("Add");
            btnAdd.setPrefWidth(100);
            btnAdd.setPrefHeight(50);

            //Adds Clear Button in Menu Add Contact
            Button btnClear = new Button("Clear");
            btnClear.setPrefWidth(100);
            btnClear.setPrefHeight(50);

            //Adds Labal Name: above tF0 in Grid
            Label label0 = new Label("Name:");
            label0.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));

            //Adds TextFiled for Name
            TextField tF0 = new TextField();
            tF0.setPrefColumnCount(10);
            tF0.setStyle("-fx-font: 22 arial; -fx-base: #b9b9b9;");
            tF0.setAlignment(Pos.CENTER);
            tF0.setPrefHeight(5);
            tF0.setPrefWidth(200);

            //Adds Labal "Surname:" above tF1 in Grid
            Label label1 = new Label("Surname:");
            label1.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));

            //Adds TextFiled for Surname
            TextField tF1 = new TextField();
            tF1.setPrefColumnCount(10);
            tF1.setStyle("-fx-font: 22 arial; -fx-base: #b9b9b9;");
            tF1.setAlignment(Pos.CENTER);
            tF1.setPrefHeight(5);
            tF1.setPrefWidth(200);

            //Adds Labal "Phone Number:" above tF2 in Grid
            Label label2 = new Label("Phone Number:");
            label2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));

            //Adds TextFiled for Phone Number
            TextField tF2 = new TextField();
            tF2.setPrefColumnCount(10);
            tF2.setStyle("-fx-font: 22 arial; -fx-base: #b9b9b9;");
            tF2.setAlignment(Pos.CENTER);
            tF2.setPrefHeight(5);
            tF2.setPrefWidth(200);

            //Adds Labal "E-mail Adress" above tF3 in Grid
            Label label3 = new Label("E-Mail-Adress:");
            label3.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));

            //Adds TextFiled for E-Mail Adress
            TextField tF3 = new TextField();
            tF3.setPrefColumnCount(10);
            tF3.setStyle("-fx-font: 22 arial; -fx-base: #b9b9b9;");
            tF3.setAlignment(Pos.CENTER);
            tF3.setPrefHeight(5);
            tF3.setPrefWidth(200);

            //Adds alert with Massage when btnSubmit is pushed
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Added to Phone Book successfully!");
            alert.setContentText("Contact information has been added to Phone Book");

            //Adds HBox for Buttons Submit & Clear
            HBox hBContact = new HBox();
            hBContact.getChildren().addAll(btnAdd, btnClear);

            //When Button Submit is pushed The Tefield Input will be used to create a new Conatct
            btnAdd.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    //Instance of Contact with Textfield input
                    Contact newContact = new Contact(tF0.getText(), tF1.getText(), tF2.getText(), tF3.getText());
                    //Creates String with Textfields input
                    String stringEntry = newContact.toString();
                    //Creates Instance of Datafieldentrys
                    DataFileEntrys newEntry = new DataFileEntrys();
                    //calls addEntry Method with created String from Textfieleds
                    newEntry.addEntry(stringEntry);
                    //shows alert from above
                    alert.showAndWait();
                    //clears all TextFileds (tF0, tF1, tF2, tF3) in the add Contact Scene
                    tF0.clear();
                    tF1.clear();
                    tF2.clear();
                    tF3.clear();
                }
            });

            //When Button Clear is pushed, all Text in TextField will be deleted
            btnClear.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent f) {
                    //clears all TextFileds (tF0, tF1, tF2, tF3) in the add Contact Scene
                    tF0.clear();
                    tF1.clear();
                    tF2.clear();
                    tF3.clear();
                }
            });

            //create VBox for all Labels & Textfields in the add Contact Scene
            VBox vBContact = new VBox();
            vBContact.getChildren().addAll(btnIconedit, label0, tF0, label1, tF1, label2, tF2, label3, tF3, hBContact);

            //Adds GridPane to add Contact Scene
            GridPane addLayout = new GridPane();
            //Adds the VBox to the GridPane
            addLayout.getChildren().add(vBContact);
            addLayout.setAlignment(Pos.CENTER);

            // Sets the Scene size and adds GridPane
            Scene addContactScene = new Scene(addLayout, 500, 500);
            //Creates Stage
            Stage addContactStage = new Stage();
            //Sets Name of stage wich is shown on top of the Window of add contact Scene
            addContactStage.setTitle("Add Contact");
            //adds Scene to Stage
            addContactStage.setScene(addContactScene);
            //shows Stage
            addContactStage.show();
        });

        //Main Menu Btton to delete an Conact (Icon with Conact and Minus sign)
        Button btn1 = new Button("", new ImageView(imgDelete));
        btn1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        btn1.setPrefWidth(200);
        btn1.setPrefHeight(50);

        //opens new Scene for delete an Contact from Phone book
        btn1.setOnAction(action -> {
            //icon delete Contact on top of Scene
            Button btnIconDel = new Button("", new ImageView(imgDelete));
            btnIconDel.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            //adds Label for instructions for using keywords to find & delete an Contact
            Label labelDelete = new Label("Enter Name, Surname, Phone Number or");
            Label labelDelete2 = new Label("E-Mail Adress of the Contact you wish to delete:");
            labelDelete.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            labelDelete2.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));

            //adds the textfield for keywords for searching & delete
            TextField tFdelete = new TextField();
            tFdelete.setPrefColumnCount(10);
            tFdelete.setStyle("-fx-font: 22 arial; -fx-base: #b9b9b9;");
            tFdelete.setAlignment(Pos.CENTER);
            tFdelete.setPrefHeight(5);
            tFdelete.setPrefWidth(200);

            //adds an Button for submit an deletion of an Contact
            Button btnSubmitDel = new Button("Delete");
            btnSubmitDel.setPrefWidth(200);
            btnSubmitDel.setPrefHeight(50);

            //when button is pressed the keyword is ued for searching and if found, for deletion of an Contact
            btnSubmitDel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent j) {
                    //creates instance of DataFileEntrys
                    DataFileEntrys delContact = new DataFileEntrys();
                    //Creates alert with Massage for successfull deletion
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Conact deleted from Database successfully!");
                    alert.setContentText(delContact.search(tFdelete.getText()) + "\n" + " -> has been deleted from Phone Book!");
                    alert.showAndWait();
                    //calls method for deleting an conatct with the parameter of Textfield tFdelete
                    delContact.deleteEntry(tFdelete.getText());
                    //clears textField tFdelete when Button is pushed
                    tFdelete.clear();
                }
            });

            //creates VBox for Icon, Buttons & Labels in Scene delete Contact
            VBox vbDel = new VBox();
            vbDel.getChildren().addAll(btnIconDel, labelDelete, labelDelete2, tFdelete, btnSubmitDel);
            vbDel.setAlignment(Pos.CENTER);

            //creates GridPane for Scene
            GridPane deleteLayout = new GridPane();
            //adds Vbox to GridPane
            deleteLayout.getChildren().add(vbDel);
            deleteLayout.setAlignment(Pos.CENTER);

            //set size of scene delete contact and adds GridPane to scene
            Scene deleteContactScene = new Scene(deleteLayout, 500, 500);
            //creates new stage for delete Contact
            Stage deleteContactStage = new Stage();
            //sets titel of scene
            deleteContactStage.setTitle("Delete Contact");
            //adds scene to stage
            deleteContactStage.setScene(deleteContactScene);
            //shows stage
            deleteContactStage.show();
        });

        //creates button for search on main window
        Button btn2 = new Button("", new ImageView(imgSearch));
        btn2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        btn2.setPrefWidth(200);
        btn2.setPrefHeight(50);

        //opens new scene for search
        btn2.setOnAction(action -> {
            //adds icon search on the top of the scene
            Button btnIconSearch = new Button("", new ImageView(imgSearch));
            btnIconSearch.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            //adds Label for instruction how to use the search
            Label labelSearch = new Label("Search for Name, Surname, Phone Number");
            Label labelSearch2 = new Label("or E-mail Adress in Phone Book:");
            labelSearch.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            labelSearch2.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));

            //adds textfield for input parameter for the search
            TextField tF0search = new TextField();
            tF0search.setPrefColumnCount(10);
            tF0search.setStyle("-fx-font: 22 arial; -fx-base: #b9b9b9;");
            tF0search.setAlignment(Pos.CENTER);
            tF0search.setPrefHeight(5);
            tF0search.setPrefWidth(200);

            //adds button to start the search
            Button btnSubmitSearch = new Button("Search");
            btnSubmitSearch.setStyle("-fx-font: 22 arial; -fx-base: #b9b9b9;");
            btnSubmitSearch.setPrefWidth(200);
            btnSubmitSearch.setPrefHeight(50);

            //adds textArea to show rrsult of the search
            TextArea textAreaSearchResult = new TextArea();
            textAreaSearchResult.setStyle("-fx-font-size: 14");

            //when button is press an instance of DataFileEntrys is created
            //and the method search with the parameter of tF0search is called.
            //sets the text of the textarea with the result of the method search
            btnSubmitSearch.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent h) {
                    //creates instance of DataFileentrys
                    DataFileEntrys newSearchContact = new DataFileEntrys();
                    //sets text of textarea with result of search method
                    //parameter of search method is set to input from textFiled tF0search
                    textAreaSearchResult.setText(newSearchContact.search(tF0search.getText()));
                }
            });

            //adds VBox for icon, labels, textfield, textarea and button to scene search
            VBox hbSearch = new VBox();
            hbSearch.getChildren().addAll(btnIconSearch, labelSearch, labelSearch2, tF0search, textAreaSearchResult, btnSubmitSearch);
            hbSearch.setAlignment(Pos.CENTER);

            //creates GridPane for scene search
            GridPane SearchLayout = new GridPane();
            //adds VBox to GridPane
            SearchLayout.getChildren().add(hbSearch);
            SearchLayout.setAlignment(Pos.CENTER);

            //adds GridPane to Scene and sets size to 500 width and 500 height
            Scene searchContactScene = new Scene(SearchLayout, 500, 500);
            Stage searchContactStage = new Stage();
            //sets name of window search
            searchContactStage.setTitle("Search Contact");
            //adds scene to stage
            searchContactStage.setScene(searchContactScene);
            //shows stage
            searchContactStage.show();
        });

        //creates button for show all Contacts on main Window
        Button btn3 = new Button("", new ImageView(imgContacts));
        btn3.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        btn3.setPrefWidth(200);
        btn3.setPrefHeight(50);

        //when button is pushed an new instance of DataFileEntrys is created
        //and method showAllEntrys is called
        btn3.setOnAction(action -> {
            //add icon for show all to scene show all
            Button btnIconContacts = new Button("", new ImageView(imgContacts));
            btnIconContacts.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

            //adds label to scene show all
            Label labelContacts = new Label("List of all Contacts in Phone Book: ");
            labelContacts.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));

            //adds textArea for result of method showAllEntrys()
            TextArea textAreaContacts = new TextArea();
            textAreaContacts.setStyle("-fx-font-size: 14");

            //creates VBox on scene show all
            VBox vbContact = new VBox();
            //adds icon, label andtextarea to VBox
            vbContact.getChildren().addAll(btnIconContacts, labelContacts, textAreaContacts);
            vbContact.setAlignment(Pos.CENTER);

            //creates instance of DataFileEntrys
            DataFileEntrys newAllContact = new DataFileEntrys();
            //sets text of textArea to result of showAllentrys method
            textAreaContacts.setText(newAllContact.showAllEntrys());

            //creates GripPane
            GridPane showAllLayout = new GridPane();
            //adds VBox to Gridpane
            showAllLayout.getChildren().addAll(vbContact);
            showAllLayout.setAlignment(Pos.CENTER);

            //adds GridPane to scene and sets size to 500 width and 500 height
            Scene showContactsScene = new Scene(showAllLayout, 500, 500);
            //creates new stage
            Stage showContactStage = new Stage();
            //sets titel of stage
            showContactStage.setTitle("Show Contacts");
            //adds scene to stage
            showContactStage.setScene(showContactsScene);
            //shwo stage
            showContactStage.show();
        });

        //creates GridPane for main window
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        //HBox for buttons add and delete
        HBox topBtn = new HBox();
        topBtn.setSpacing(10);
        topBtn.getChildren().addAll(btn0, btn1);
        topBtn.setPadding(new Insets(15, 12, 15, 12));
        topBtn.setAlignment(Pos.CENTER);

        //HBox for buttons search and show all
        HBox middleBtn = new HBox();
        middleBtn.setSpacing(10);
        middleBtn.getChildren().addAll(btn2, btn3);
        middleBtn.setPadding(new Insets(15, 12, 15, 12));
        middleBtn.setAlignment(Pos.CENTER);

        //GridPane oder for icons on main window
        root.add(topBtn, 0, 1); //row for add and delete
        root.add(middleBtn, 0, 2); // row for search and show all

        //sets background to image bGi
        root.setBackground(new Background(bGi));
        //sets size of main window to 600 width & 600 height
        Scene scene = new Scene(root, 600, 600);

        //icon for main window
        primaryStage.getIcons().add(imgWindow);
        //sets title of main window
        primaryStage.setTitle("Phone Book");
        //set main window to not resizeable
        primaryStage.setResizable(false);
        //adds main scene to main stage
        primaryStage.setScene(scene);
        //shows main satge
        primaryStage.show();
    }
}