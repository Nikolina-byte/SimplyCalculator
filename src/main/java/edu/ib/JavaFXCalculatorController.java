package edu.ib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class connecting the GUI with the backhand
 * @author Nikolina Czart
 */

public class JavaFXCalculatorController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnMultiplied;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnPlusMinus;

    @FXML
    private Button btnZero;

    @FXML
    private Button btnComma;

    @FXML
    private Button btnEquals;

    @FXML
    private Button btnPercent;

    @FXML
    private Button btnClearLast;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnBack;

    @FXML
    private TextArea textAreaHistory;

    @FXML
    private TextField textEquation;

    @FXML
    private TextField textScore;

    @FXML
    private Button btnClearHistory;


    StringBuilder calculatorHistory = new StringBuilder();
    Boolean isOperatorClick = false;
    Boolean isLastOperationEqual = false;
    private boolean isStart = true;

    Calculator calculator = new Calculator();

    @FXML
    void onClickNumber(ActionEvent event) {
        if (isStart) {
            textScore.setText("");
            isStart = false;
        }
        else if (isOperatorClick) {
            textScore.setText("");
            isOperatorClick = false;
        }
        String value = ((Button)event.getSource()).getText();

        this.calculator.concatProgressNumber(value);
        textScore.setText(this.calculator.getProgressNumber());
        isLastOperationEqual = false;
    }

    @FXML
    void onClickOperator(ActionEvent event) {
        this.isOperatorClick = true;
        String value = ((Button)event.getSource()).getText();
        Operation operation = Operation.fromString(value);
        this.calculator.addProgressNumber(textScore.getText());
        this.calculator.addOperations(operation);
        this.textEquation.setText(this.calculator.getCalculationInfo());
        isLastOperationEqual = false;
    }

    @FXML
    void onClickSimplyOperation(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        Operation operation = Operation.fromString(value);
        this.calculator.executeOperation(operation);
        this.textScore.setText(this.calculator.getProgressNumber());
    }

    @FXML
    void onClickEquals(ActionEvent event) {
        if(isLastOperationEqual){
            this.calculator.initialWithLastOperation();
        }
        else{
            this.calculator.addProgressNumber(textScore.getText());
        }

        this.calculator.addOperations(Operation.EQU);
        String calculationInfo = this.calculator.getCalculationInfo();
        textEquation.setText(this.calculator.getCalculationInfo());
        Double calculateResult = this.calculator.calculate();
        String results = Converter.getStringCalculateValue(calculateResult);
        textScore.setText(results);
        calculatorHistory=calculatorHistory.append(calculationInfo + results);
        textAreaHistory.setText(calculatorHistory + "\n" + textAreaHistory.getText());


        calculator.clearCalculation();
        calculatorHistory = new StringBuilder();
        isLastOperationEqual = true;
    }

    @FXML
    void onClickClearAll(ActionEvent event) {
        this.calculator = new Calculator();
        textEquation.setText("");
        setZeroScore();
    }

    @FXML
    void onClickClearHistory(ActionEvent event) {
        textAreaHistory.setText("");
    }

    @FXML
    void onClickClearLast(ActionEvent event) {
        this.calculator.setProgressNumber("");
        setZeroScore();
    }

    @FXML
    void onClickBack(ActionEvent event) {
        String scoreValue = textScore.getText();
        String newProgressNumber = scoreValue.substring(0, scoreValue.length()-1);
        calculator.setProgressNumber(newProgressNumber);
        textScore.setText(calculator.getProgressNumber());
    }

    @FXML
    void initialize() {
        assert textEquation != null : "fx:id=\"textEquation\" was not injected: check your FXML file 'calculator.fxml'.";
        assert textScore != null : "fx:id=\"textScore\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnClearHistory != null : "fx:id=\"btnClearHistory\" was not injected: check your FXML file 'calculator.fxml'.";
        assert textAreaHistory != null : "fx:id=\"textAreaHistory\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnClearLast != null : "fx:id=\"btnClearLast\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnClearAll != null : "fx:id=\"btnClearAll\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnSix != null : "fx:id=\"btnSix\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnMultiplied != null : "fx:id=\"btnMultiplied\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnPercent != null : "fx:id=\"btnPercent\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnPlusMinus != null : "fx:id=\"btnPlusMinus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnComma != null : "fx:id=\"btnComma\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnEquals != null : "fx:id=\"btnEquals\" was not injected: check your FXML file 'calculator.fxml'.";

        this.calculatorHistory.delete(0,calculatorHistory.length());

        this.calculator = new Calculator();
    }

    private void setZeroScore(){
        this.textScore.setText("0");
    }
}
