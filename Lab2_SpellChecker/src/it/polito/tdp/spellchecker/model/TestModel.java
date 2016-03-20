package it.polito.tdp.spellchecker.model;

import java.util.*;

public class TestModel {

	public static void main(String[] args) {
		
		Dictionary d= new ItalianDictionary();
		List <String> txtInserito = new LinkedList <String>();
		
		txtInserito.add("abate");
		txtInserito.add("helloerere");
		d.loadDictionary();
		
		System.out.println(d.spellCheckText(txtInserito));

	}

}
