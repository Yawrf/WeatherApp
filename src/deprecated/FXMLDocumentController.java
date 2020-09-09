/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deprecated;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author rewil
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    TextField morningText;
    @FXML
    TextField noonText;
    @FXML
    TextField eveningText;
    @FXML
    TextField nightText;
    
    @FXML
    Label morningLabel;
    @FXML
    Label noonLabel;
    @FXML
    Label eveningLabel;
    @FXML
    Label nightLabel;
    
    @FXML
    RadioButton summerRadio;
    @FXML
    RadioButton autumnRadio;
    @FXML
    RadioButton winterRadio;
    @FXML
    RadioButton springRadio;
    @FXML
    RadioButton allRadio;
    
    ToggleGroup seasons;
    
    @FXML
    CheckBox clearCheck;
    @FXML
    CheckBox windyCheck;
    @FXML
    CheckBox cloudyCheck;
    @FXML
    CheckBox rainyCheck;
    @FXML
    CheckBox snowyCheck;
    @FXML
    CheckBox conditionsCheck;
    @FXML
    CheckBox extremesCheck;
    
    weatherPicker wp = new weatherPicker();
    
    public void generateDay() {
        wp.resetLimits();
        morningText.setText(pick());
        morningLabel.setText(wp.getLastCategory());
        noonText.setText(pickSmooth());
        noonLabel.setText(wp.getLastCategory());
        eveningText.setText(pickSmooth());
        eveningLabel.setText(wp.getLastCategory());
        nightText.setText(pickSmooth());
        nightLabel.setText(wp.getLastCategory());
    }
    
    public void redoMorning() {
        morningText.setText(pickSmooth());
    }
    
    public void redoNoon() {
        noonText.setText(pickSmooth());
    }
    
    public void redoEvening() {
        eveningText.setText(pickSmooth());
    }
    
    public void redoNight() {
        nightText.setText(pickSmooth());
    }
    
    public String pick() {
        return wp.pick(getSeason(), extremesCheck.isSelected(), clearCheck.isSelected(), windyCheck.isSelected(), cloudyCheck.isSelected(), rainyCheck.isSelected(), snowyCheck.isSelected(), conditionsCheck.isSelected());
    }
    
    public String pickSmooth() {
        return wp.pickSmooth(getSeason(), extremesCheck.isSelected(), clearCheck.isSelected(), windyCheck.isSelected(), cloudyCheck.isSelected(), rainyCheck.isSelected(), snowyCheck.isSelected(), conditionsCheck.isSelected());
    }
    
    public Season getSeason() {
        if(summerRadio.isSelected()) {
            return Season.Summer;
        }
        if(autumnRadio.isSelected()) {
            return Season.Autumn;
        }
        if(winterRadio.isSelected()) {
            return Season.Winter;
        }
        if(springRadio.isSelected()) {
            return Season.Spring;
        }
        return Season.All;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
