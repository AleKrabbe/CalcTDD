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
    private Button plusMinusBtn;
    
    @FXML
    private Button zeroBtn;
    
    @FXML
    private Button dotBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        equalsBtn.getStyleClass().add("equals-button");
        equalsBtn.setPickOnBounds(true);
        
        Region iconEquals =  new Region();
        iconEquals.getStyleClass().add("icon-equals");
        equalsBtn.setGraphic(iconEquals);
        
        plusBtn.getStyleClass().add("plus-button");
        plusBtn.setPickOnBounds(true);
        
        Region iconPlus =  new Region();
        iconPlus.getStyleClass().add("icon-plus");
        plusBtn.setGraphic(iconPlus);
    }
    
}
