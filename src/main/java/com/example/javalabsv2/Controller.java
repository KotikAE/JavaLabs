package com.example.javalabsv2;

import java.io.IOException;
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
    private String userName = "";
    private ClientModel model;
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
        model = new ClientModel(this);
        userShowDataButton.setOnAction(actionEvent -> {
            try {
                model.userTabSend(userAccountNameTextField.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        gameStatsShowDataButton.setOnAction(actionEvent -> {
            try {
                model.gameStatsTabSend(gameStatsAccountNameTextField.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        genreShowDataButton.setOnAction(actionEvent -> {
            try {
                model.genreTabSend();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void setUserTabData(String inAccountName, String inIngameName, Integer inAchievements, String inGameStore) {
        userAccountName.setText(inAccountName);
        userIngameName.setText(inIngameName);
        userAchievements.setText(inAchievements.toString());
        userPlatform.setText(userComboBox.getValue());
        userGameStore.setText(inGameStore);
    }

    void setGameStatsTabData(Integer inTotalTime, Integer inSessionTime, Integer inCurrentScore) {
        gameStatsTotal.setText(inTotalTime.toString());
        gameStatsSession.setText(inSessionTime.toString());
        gameStatsScore.setText(inCurrentScore.toString());
    }

    void setGenreTabData(ObservableList<String> inGenreList, ObservableList<String> inTagList) {
        genreGenresListView.setItems(inGenreList);
        genreTagsListView.setItems(inTagList);
    }
}