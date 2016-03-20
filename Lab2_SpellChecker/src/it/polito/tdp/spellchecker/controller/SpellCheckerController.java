package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.EnglishDictionary;
import it.polito.tdp.spellchecker.model.ItalianDictionary;
import it.polito.tdp.spellchecker.model.TestModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {

	private TestModel model;
	
	private String linguaScelta;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbScelta;

    @FXML
    private TextArea txtInput;

    @FXML
    private Button btnCheck;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Label lblResult;

    @FXML
    private Button btnClear;

    @FXML
    private Label lblTime;

    @FXML
    void doClearText(ActionEvent event) {
    	
    	txtInput.clear();
    	txtOutput.clear();
    	lblResult.setText("");
    	lblTime.setText("");
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	linguaScelta = cmbScelta.getValue();
    	
    	if(linguaScelta == "Italiano"){
    		
    		Dictionary d1 = new ItalianDictionary();
    		d1.loadDictionary();
    		String testo[] = txtInput.getText().replaceAll("[ˆ(A-Za-z0-9 )]", "").toLowerCase().split(" ");
    		List<String> parole = new ArrayList<String>();
    		
    		for(int i=0;i<testo.length;i++){
    			parole.add(testo[i]);
    		}
    		double t0 = System.nanoTime();
    		d1.spellCheckText(parole);
    		double t1 = System.nanoTime();
    		
    		for(int m=0;m<d1.spellCheckText(parole).size();m++){
    			if(d1.spellCheckText(parole).get(m).isCheck()==false){
    				txtOutput.appendText(d1.spellCheckText(parole).get(m).getParola()+" ");
    				lblResult.setText("Il testo contiene degli errori");
    			}
    		}
    		lblTime.setText("Tempo impiegato: " + (t1-t0)/(10^9) + "s");
    	}
    	else{
    		
    		Dictionary d2 = new EnglishDictionary();
    		d2.loadDictionary();
    		String testo2[] = txtInput.getText().replaceAll("[ˆ(A-Za-z0-9 )]", "").toLowerCase().split(" ");
    		List<String> parole2 = new ArrayList<String>();
    		
    		for(int i=0;i<testo2.length;i++){
    			parole2.add(testo2[i]);
    		}
    		double t0 = System.nanoTime();
    		d2.spellCheckText(parole2);
    		double t1 = System.nanoTime();
    		
    		for(int m=0;m<d2.spellCheckText(parole2).size();m++){
    			if(d2.spellCheckText(parole2).get(m).isCheck()==false){
    				txtOutput.appendText(d2.spellCheckText(parole2).get(m).getParola()+" ");
    				lblResult.setText("Il testo contiene degli errori");
    			}
    		}
    		lblTime.setText("Tempo impiegato: " + (t1-t0)/(10^9) + "s");
    		
    	}
    }
    
    public void setModel(TestModel model){
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert cmbScelta != null : "fx:id=\"cmbScelta\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblResult != null : "fx:id=\"lblResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";

        
        cmbScelta.getItems().addAll("Italiano","Inglese");
    }
}
