package com.example.addressBook;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NewDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextArea notesArea;

    /**
     * Processes the "new" dialog to create a new contact.
     * @return contact
     */
    @FXML
    public Contact processDialog(){
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesArea.getText().trim();
        return new Contact(firstName, lastName, phoneNumber, notes);
    }

    /**
     * Fills the text areas for the current selected contact.
     * @param contact
     */
    @FXML
    public void editContact(Contact contact){
        firstNameField.setText(contact.getFirstName());
        lastNameField.setText(contact.getLastName());
        phoneNumberField.setText(contact.getPhoneNumber());
        notesArea.setText(contact.getNotes());
    }

    /**
     * Changes the contact to be the current text fields of the dialog.
     * @param contact
     */
    @FXML
    public void updateContact(Contact contact){
        contact.setFirstName(firstNameField.getText().trim());
        contact.setLastName(lastNameField.getText().trim());
        contact.setPhoneNumber(phoneNumberField.getText().trim());
        contact.setNotes(notesArea.getText().trim());
    }
}