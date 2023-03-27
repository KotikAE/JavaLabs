package com.example.javalabsv2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    ObservableList<String> userComboBoxItems = FXCollections.observableArrayList("PC", "PS", "XBOX");
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField gameStatsAccountNameTextField;

    @FXML
    private Label gameStatsScore;

    @FXML
    private Label gameStatsSession;

    @FXML
    private Button gameStatsShowDataButton;

    @FXML
    private Label gameStatsTotal;

    @FXML
    private ListView<String> genreGenresListView;

    @FXML
    private Button genreShowDataButton;

    @FXML
    private ListView<String> genreTagsListView;

    @FXML
    private Label userAccountName;

    @FXML
    private TextField userAccountNameTextField;

    @FXML
    private Label userAchievements;

    @FXML
    private ChoiceBox<String> userComboBox;

    @FXML
    private Label userGameStore;

    @FXML
    private Label userIngameName;

    @FXML
    private Label userPlatform;

    @FXML
    private Button userShowDataButton;

    void initUserComboBox() {
        userComboBox.setValue("PC");
        userComboBox.setItems(userComboBoxItems);
    }
    @FXML
    void initialize() {
        initUserComboBox();
        userShowDataButton.setOnAction(actionEvent -> {
            userAccountName.setText("Переиграно");
        });
    }
}