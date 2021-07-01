package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Button convertButton;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField inputTemperature;

    private static final String C_To_F_Text = "Celsius To Fahrenheit";
    private static final String F_To_C_Text = "Fahrenheit To Celsius";
    private boolean is_C_To_F = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().add(C_To_F_Text);
        choiceBox.getItems().add(F_To_C_Text);
        choiceBox.setValue(C_To_F_Text);
        convertButton.setOnAction(EventHandler-> convert());
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            is_C_To_F = t1.equals(C_To_F_Text);
        });
    }

    private void convert() {
        String input = inputTemperature.getText();
        try {
            float num = Float.parseFloat(input);
            float ans;
            if (is_C_To_F) {
                ans = 32+num*9/5;
            } else {
                ans = (num-32) * 5/9;
            }
            display(ans);
        } catch (Exception e) {
            warnUser();
        }
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setContentText("Invalid input");
        alert.show();
    }

    private void display(float ans) {
        String unit = is_C_To_F ? " F" : " C";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Temperature Converter");
        alert.setContentText(ans+unit);
        alert.show();
    }
}
