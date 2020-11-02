package application;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
    @FXML Button b0;
	@FXML Button b1;
	@FXML Button b2;
	@FXML Button b3;
	@FXML Button b4;
	@FXML Button b5;
	@FXML Button b6;
	@FXML Button b7;
	@FXML Button b8;
	@FXML Button b9;
	@FXML Button bPlus;
	@FXML Button bMinus;
	@FXML Button bDiv;
	@FXML Button bMult;
	@FXML Button bClear;
	@FXML Button bNeg;
	@FXML Button bPerc;
	@FXML Button bDeci;
	@FXML Label display;
	Calculator calc = new Calculator();
	
	@FXML protected void handleNum ( ActionEvent e ) {
		if ( calc.addToResult == false && calc.newNum.equals("") ) {
			display.setText("");
		}
		String digit = ( (Button) e.getSource() ).getText();
		display.setText(display.getText() + digit);
		calc.addDigit(digit);
	}
	@FXML protected void handleDeci ( ActionEvent e ) {
		String decimal = ".";
		if ( display.getText().indexOf(".")== -1) {
			display.setText(display.getText() + decimal);
			calc.addDeci();
		}
	}
	@FXML protected void handlePlus ( ActionEvent e ) {
		if ( ! calc.newNum.equals("")) {
			calc.doOperation();
			display.setText(calc.result);
		}
		calc.operation = "+";
		calc.addToResult = false;
	}
	@FXML protected void handleMinus ( ActionEvent e ) {
		if ( ! calc.newNum.equals("")) {
			calc.doOperation();
			display.setText(calc.result);
		}
		calc.operation = "-";
		calc.addToResult = false;
	}
	@FXML protected void handleDiv ( ActionEvent e ) {
		if ( ! calc.newNum.equals("")) {
			calc.doOperation();
			display.setText(calc.result);
		}
		calc.operation = "/";
		calc.addToResult = false;
	}
	@FXML protected void handleMult ( ActionEvent e ) {
		if ( ! calc.newNum.equals("")) {
			calc.doOperation();
			display.setText(calc.result);
		}
		calc.operation = "x";
		calc.addToResult = false;
	}
	@FXML protected void handleClear ( ActionEvent e ) {
		calc.clearAll();
		display.setText("");
	}
	@FXML protected void handleEquals ( ActionEvent e ) {
		calc.doOperation();
		display.setText(calc.result);
	}
	@FXML protected void handlePerc ( ActionEvent e ) {
		if ( ! calc.newNum.equals("")) {
			calc.doOperation();
			display.setText(calc.result);
		}
		calc.operation = "%";
		calc.addToResult = false;
	}
	@FXML protected void handleNeg ( ActionEvent e ) {
		String negative = "-";
		if ( display.getText().indexOf("-") == -1) {
			display.setText(negative + display.getText() );
		}
		else {
			display.setText(display.getText().substring(1) );
		}
		calc.addNeg();
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test.fxml"));
		Parent root = loader.load();
		loader.setController(this);
		Scene myScene = new Scene(root,450,600);
		primaryStage.setScene(myScene);
		primaryStage.setTitle("My Calculator");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
