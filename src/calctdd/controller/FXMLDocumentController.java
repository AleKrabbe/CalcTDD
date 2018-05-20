package calctdd.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Region;

/**
 *
 * @author Alexandre
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField resultTextField;    
    @FXML
    private Button equalsBtn;
    @FXML
    private Button plusBtn;
    @FXML
    private Button minusBtn;
    @FXML
    private Button multBtn;
    @FXML
    private Button divBtn;
    @FXML
    private Button backSpaceBtn;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeButtonIconsSVG();
        resultTextField.setText("0");
        resultTextField.setTextFormatter(new TextFormatter<>(change -> 
            change.getControlNewText().length() <= 13 ? change : null));
    }
    
    private void initializeButtonIconsSVG(){
        loadSVG(equalsBtn, "equals-button", "icon-equals");   
        loadSVG(plusBtn, "plus-button", "icon-plus");
        loadSVG(minusBtn, "minus-button", "icon-minus");
        loadSVG(multBtn, "times-button", "icon-times");
        loadSVG(divBtn, "divide-button", "icon-divide");
        loadSVG(backSpaceBtn, "backspace-button", "icon-backspace");
    }
    
    private void loadSVG(Button btn, String btnClass, String iconClass){
        btn.getStyleClass().add(btnClass);
        btn.setPickOnBounds(true);
        Region icon = new Region();
        icon.getStyleClass().add(iconClass);
        btn.setGraphic(icon);
    }
    
    private void appenToResult(String ch){
        try {
            int result = Integer.parseInt(resultTextField.getText());
            if(result == 0){
                resultTextField.setText(ch);
            } else {
                resultTextField.appendText(ch);
            }
        } catch (NumberFormatException e) {
            resultTextField.appendText(ch);
        }        
    }
    
    public int getResult(){
        return Integer.parseInt(resultTextField.getText());
    }
    
    @FXML
    public void handleDigitZeroPress(ActionEvent event) {
        appenToResult("0");
    }
            
    @FXML
    public void handleDigitOnePress(ActionEvent event) {
        appenToResult("1");
    }
            
    @FXML
    void handleDigitTwoPress(ActionEvent event) {
        appenToResult("2");
    }
            
    @FXML
    void handleDigitThreePress(ActionEvent event) {
        appenToResult("3");
    }
            
    @FXML
    void handleDigitFourPress(ActionEvent event) {
        appenToResult("4");
    }
    
    @FXML
    void handleDigitFivePress(ActionEvent event) {
        appenToResult("5");
    }
    
    @FXML
    void handleDigitSixPress(ActionEvent event) {
        appenToResult("6");
    }    
    
    @FXML
    void handleDigitSevenPress(ActionEvent event) {
        appenToResult("7");
    }
    
    @FXML
    void handleDigitEightPress(ActionEvent event) {
        appenToResult("8");
    }

    @FXML
    void handleDigitNinePress(ActionEvent event) {
        appenToResult("9");
    }
    
    @FXML
    void handleComma(ActionEvent event) {
        appenToResult(",");
    }
    
    @FXML
    void handleDoubleZeroes(ActionEvent event) {
        appenToResult("00");
    }
    
    @FXML
    void handleDivision(ActionEvent event) {
        System.out.println("Need to implement");
    }

    @FXML
    void handleMultiplication(ActionEvent event) {
        System.out.println("Need to implement");
    }

    @FXML
    void handleSubtraction(ActionEvent event) {
        System.out.println("Need to implement");
    }    
    
    @FXML
    void handleAddition(ActionEvent event) {
        System.out.println("Need to implement");
    }
    
    @FXML
    void handleEquals(ActionEvent event) {
        System.out.println("Need to implement");
    }

    @FXML
    void handleBackspace(ActionEvent event) {
        System.out.println("Need to implement");
    }

    @FXML
    void handleClearAll(ActionEvent event) {
        System.out.println("Need to implement");
    }

    @FXML
    void handleClearEntry(ActionEvent event) {
        System.out.println("Need to implement");
    }
    
}
