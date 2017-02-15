package controller;

import javafx.scene.control.Alert;

public class MessagePanel {
    public MessagePanel(){

    }

    public void addNoChoice(String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ostrze�enie");
        alert.setHeaderText("Wyst�pi� b��d podczas zapisu danych");
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public void showErrorMessage(String messageText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText(null);
        alert.setContentText(messageText);
        alert.showAndWait();
    }

    public void showInformationMessage(String messageText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information dialog");
        alert.setHeaderText("Gratulacje");
        alert.setContentText(messageText);
        alert.showAndWait();
    }
}
