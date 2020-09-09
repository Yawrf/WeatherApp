/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rewil
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private ListView conditionsList;
    @FXML private CheckBox rerollSubsCheck;
    
    @FXML private ListView seasonsList;
    @FXML private ListView enabledSeasonsList;
    @FXML private ListView genresList;
    @FXML private ListView enabledGenresList;
    
    @FXML private TextField numField;
    
    @FXML private CheckBox timeCheck;
    @FXML private TextField startHourField;
    @FXML private TextField startMinuteField;
    @FXML private TextField incHourField;
    @FXML private TextField incMinuteField;
    
    @FXML private CheckBox smoothCheck;
    
    private ArrayList<String> disabledSeasons = new ArrayList<>();
    private ArrayList<String> enabledSeasons = new ArrayList<>();
    private ArrayList<String> disabledGenres = new ArrayList<>();
    private ArrayList<String> enabledGenres = new ArrayList<>();
    
    private ConditionManager cm = new ConditionManager();
    private ArrayList<Condition> conditions = new ArrayList<>();
    
  //----------------------------------------------------------------------------
    
    @FXML 
    public void rerollAction() {
        int i = conditionsList.getSelectionModel().getSelectedIndex();
        conditionsList.getSelectionModel().clearSelection();
        if(i == -1) return;
        do{ 
            rerollProcess(i++);
        } while(rerollSubsCheck.isSelected() && i < conditions.size());
    }
    private void rerollProcess(int i) {
        Condition c = null;
        if(i == 0 || conditions.get(i-1) == null) c = cm.getCondition();
        else c = cm.getCondition(conditions.get(i-1));
        conditions.remove(i);
        conditions.add(i, c);
        
        ObservableList<String> list = conditionsList.getItems();
        String temp = "";
        if(timeCheck.isSelected()) {
            temp = list.get(i);
            temp = temp.split(" ")[0] + " ";
        }
        temp += c.getName();
        list.remove(i);
        list.add(i, temp);
        
    }
    @FXML 
    public void generateAction() {
        if(enabledSeasons.isEmpty() || enabledGenres.isEmpty()) return;
        // Setup
        int count = 12;
        try{
            count = Integer.parseInt(numField.getText().trim());
        } catch (Exception e) {}
        int hour = 8;
        int minute = 0;
        int incHour = 1;
        int incMinute = 0;
        if(timeCheck.isSelected()) {
            try {
                hour = Integer.parseInt(startHourField.getText().trim());
                minute = Integer.parseInt(startMinuteField.getText().trim());
                incHour = Integer.parseInt(incHourField.getText().trim());
                incMinute = Integer.parseInt(incMinuteField.getText().trim());
            } catch (Exception e) {}
        }
        
        // Generation
        Condition c = null;
        if(!conditions.isEmpty() && smoothCheck.isSelected()) {
            c = conditions.get(conditions.size() - 1);
            if(c != null) c = cm.getCondition(c);
            else c = cm.getCondition();
        } else {
            c = cm.getCondition();
        }
        conditions.clear();
        conditions.add(c);
        for(int i = 0;  i < count; ++i) {
            if(c == null) break;
            c = cm.getCondition(c);
            conditions.add(c);
        }
        
        // Printing
        ArrayList<String> out = new ArrayList<>();
        for(Condition d : conditions) {
            String temp = "";
            if(d == null) temp += "Could not find viable condition";
            else {
                if(timeCheck.isSelected()) {
                    temp += "[";
                    while(minute > 59) {
                        minute -= 60;
                        hour += 1;
                    }
                    if(hour == 13) hour = 1;
                    if(hour < 10) temp += "0";
                    temp += hour + ":";
                    if(minute < 10) temp += "0";
                    temp += minute + "] ";
                    hour += incHour;
                    minute += incMinute;
                }
                temp += d.getName();
            }
            out.add(temp);
        }
        conditionsList.setItems(convertList(out));
    }
    
    @FXML
    public void enableSeasonAction() {
        int i = seasonsList.getSelectionModel().getSelectedIndex();
        if(i == -1) return;
        String temp = disabledSeasons.remove(i);
        enabledSeasons.add(temp);
        cm.enableSeason(temp);
        updateSeasonLists();
    }
    @FXML
    public void disableSeasonAction() {
        int i = enabledSeasonsList.getSelectionModel().getSelectedIndex();
        if(i == -1) return;
        String temp = enabledSeasons.remove(i);
        disabledSeasons.add(temp);
        cm.disableSeason(temp);
        updateSeasonLists();
    }
    @FXML
    public void enableGenreAction() {
        int i = genresList.getSelectionModel().getSelectedIndex();
        if(i == -1) return;
        String temp = disabledGenres.remove(i);
        enabledGenres.add(temp);
        cm.enableGenre(temp);
        updateGenreLists();
    }
    @FXML
    public void disableGenreAction() {
        int i = enabledGenresList.getSelectionModel().getSelectedIndex();
        if(i == -1) return;
        String temp = enabledGenres.remove(i);
        disabledGenres.add(temp);
        cm.disableGenre(temp);
        updateGenreLists();
    }
    //<editor-fold desc="List Mouse Actions">
    @FXML
    public void enableSeasonClick(MouseEvent e) {
        if(e.getClickCount() > 1 && e.getButton().equals(MouseButton.PRIMARY)) enableSeasonAction();
    }
    @FXML
    public void disableSeasonClick(MouseEvent e) {
        if(e.getClickCount() > 1 && e.getButton().equals(MouseButton.PRIMARY)) disableSeasonAction();
    }
    @FXML
    public void enableGenreClick(MouseEvent e) {
        if(e.getClickCount() > 1 && e.getButton().equals(MouseButton.PRIMARY)) enableGenreAction();
    }
    @FXML
    public void disableGenreClick(MouseEvent e) {
        if(e.getClickCount() > 1 && e.getButton().equals(MouseButton.PRIMARY)) disableGenreAction();
    }
    //</editor-fold>
    
    @FXML
    public void toggleTimeAction() {
        startHourField.setDisable(!timeCheck.isSelected());
        startMinuteField.setDisable(!timeCheck.isSelected());
        incHourField.setDisable(!timeCheck.isSelected());
        incMinuteField.setDisable(!timeCheck.isSelected());
    }
    
  //----------------------------------------------------------------------------
    
    private <T> ObservableList<T> convertList(ArrayList<T> list) {
        return FXCollections.observableArrayList(list);
    }
    
    private void updateSeasonLists() {
        seasonsList.setItems(convertList(disabledSeasons));
        enabledSeasonsList.setItems(convertList(enabledSeasons));
    }
    private void updateGenreLists() {
        genresList.setItems(convertList(disabledGenres));
        enabledGenresList.setItems(convertList(enabledGenres));
    }
    
  //----------------------------------------------------------------------------
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(String s : cm.getSeasons()) disabledSeasons.add(s);
        String temp = disabledSeasons.remove(0);
        enabledSeasons.add(temp);
        cm.enableSeason(temp);
        for(String s : cm.getGenres()) {
            enabledGenres.add(s);
            cm.enableGenre(s);
        }
        updateSeasonLists();
        updateGenreLists();
    }    
    
}
