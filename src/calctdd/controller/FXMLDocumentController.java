package calctdd.controller;

import calctdd.exceptions.ExpressionNotCompleteException;
import calctdd.model.Entry;
import calctdd.model.Expression;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Region;

/**
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
    
    public static enum Operadores {
        SUM, DIV, SUB, MUL, EQUALS;
    }
    
    private Button lastActiveOperator;
    private Expression curExpr;
    private boolean shouldResetTextField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lastActiveOperator = null;
        curExpr = null;
        shouldResetTextField = false;
        initializeButtonIconsSVG();
        resultTextField.setText("0");
        resultTextField.setTextFormatter(new TextFormatter<>(change -> 
            change.getControlNewText().length() <= 10 ? change : null));
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
            double result = Double.parseDouble(resultTextField.getText());
            if(result == 0){
                resultTextField.setText(ch);
            } else {
                if (shouldResetTextField) {
                    resultTextField.setText(ch);
                    shouldResetTextField = false;
                } else {
                    resultTextField.appendText(ch);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Not able to convert result into string.");
        }        
    }
    
    public double getResult(){
        return Double.parseDouble(resultTextField.getText());
    }
    
    private void setResult(Double value){
       resultTextField.setText(String.valueOf(value));
    }
    
    public void setActiveOperator (Button btn) {
        if (btn == null) {
            lastActiveOperator.getStyleClass().remove("active");
            lastActiveOperator.getStyleClass().add("inactive");
            lastActiveOperator = null;
        } else {
            if(lastActiveOperator != null) {
                lastActiveOperator.getStyleClass().remove("active");
                lastActiveOperator.getStyleClass().add("inactive");
            }
            btn.getStyleClass().add("active");
            lastActiveOperator = btn;
        }
    }
    
    public void resolveExpression(Operadores OP) {
        shouldResetTextField = true;
        if (curExpr == null) {
            curExpr = new Expression(new Entry(getResult()), OP);
        } else {
            if (curExpr.isComplete()) {
                try {
                    double exprResult = curExpr.execute();
                    setResult(exprResult);
                    if (OP == Operadores.EQUALS) {
                        curExpr = new Expression(new Entry(getResult()));
                    } else {
                        curExpr = new Expression(new Entry(getResult()), OP);
                    }
                } catch (ExpressionNotCompleteException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (curExpr.hasLeft()) {
                curExpr.setRight(new Entry(getResult()));
            } else {
                curExpr.setOperador(OP);
            }
        }
    }
    
    @FXML
    public void handleDigitZeroPress(ActionEvent event) {
        appenToResult("0");
    }
            
    @FXML
    public void handleDigitOnePress() {
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
        appenToResult(".");
    }
    
    @FXML
    void handleDoubleZeroes(ActionEvent event) {
        appenToResult("00");
    }
    
    @FXML
    void handleDivision(ActionEvent event) {
        setActiveOperator(divBtn);
        resolveExpression(Operadores.DIV);
    }

    @FXML
    void handleMultiplication(ActionEvent event) {
        setActiveOperator(multBtn);
        resolveExpression(Operadores.MUL);
    }

    @FXML
    void handleSubtraction(ActionEvent event) {
        setActiveOperator(minusBtn);
        resolveExpression(Operadores.SUB);
    }    
    
    @FXML
    void handleAddition(ActionEvent event) {
        setActiveOperator(plusBtn);
        resolveExpression(Operadores.SUM);
    }
    
    @FXML
    void handleEquals(ActionEvent event) {
        resolveExpression(Operadores.EQUALS);
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
