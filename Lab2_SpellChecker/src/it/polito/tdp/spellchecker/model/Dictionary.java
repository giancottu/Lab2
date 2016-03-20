package it.polito.tdp.spellchecker.model;

import java.util.*;

public class Dictionary {
	
	List<String> dizionario = new LinkedList<String>();
	
	public void loadDictionary(){
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		List<RichWord> paroleErrate = new LinkedList<RichWord>();
		
		for(String parola : inputTextList){
			if(!dizionario.contains(parola)){ //parola errata
				
				RichWord parola1 = new RichWord();
				paroleErrate.add(parola1);
				parola1.setParola(parola);
				parola1.setCheck(false);
				
			}else{
				
				RichWord parola2 = new RichWord();
				paroleErrate.add(parola2);
				parola2.setParola(parola);
				parola2.setCheck(true);
				
			}
		}
		return paroleErrate;
	}
}
