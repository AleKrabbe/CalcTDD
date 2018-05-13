package calctdd.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author Alexandre
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextArea resultTextArea;
    
    @FXML
    private Button ceBtn;
    
    @FXML
    private Button cBtn;
    
    @FXML
    private Button backSpaceBtn;
    
    @FXML
    private Button divBtn;
    
    @FXML
    private Button sevenBtn;
    
    @FXML
    private Button eightBtn;
    
    @FXML
    private Button nineBtn;
    
    @FXML
    private Button multBtn;
    
    @FXML
    private Button fourBtn;
    
    @FXML
    private Button fiveBtn;
    
    @FXML
    private Button sixBtn;
    
    @FXML
    private Button minusBtn;
    
    @FXML
    private Button oneBtn;
    
    @FXML
    private Button twoBtn;
    
    @FXML
    private Button threeBtn;
    
    @FXML
    private Button equalsBtn;
    
    @FXML
    private Button plusBtn;
    
    @FXML
    private Button doubleDecimalBtn;
    
    @FXML
    private Button zeroBtn;
    
    @FXML
    private Button dotBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeButtonIconsSVG();
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
    
}
