package com.example.addressBook;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;


public class Controller {

    @FXML
    private BorderPane mainWindow;

    @FXML
    private TableView<Contact> tableView;

    private ContactData data;

    public void initialize(){
        data = new ContactData();
        data.loadContacts();
        tableView.setItems(data.getContacts());
    }

    @FXML
    public void handleNew(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindow.getScene().getWindow());
        dialog.setTitle("Add a new Contact.");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            NewDialogController controller = fxmlLoader.getController();
            Contact contact = controller.processDialog();
            data.addContact(contact);
            data.saveContacts();
        }
    }

    @FXML
    public void handleEdit(){
        //TODO
        return;
    }

    @FXML
    public void handleDelete(){
        //TODO
        return;
    }
}
