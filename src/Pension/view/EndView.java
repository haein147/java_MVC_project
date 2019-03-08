package Pension.view;

import java.util.ArrayList;

import Pension.model.DTO.reserveDTO;

public class EndView {

	public static void listView(ArrayList arrayList) {
		int length = arrayList.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println(arrayList.get(index));
			}
		}
	}
	public static void projectView(ArrayList arrayList){
		System.out.println(arrayList);		
	}
	
	public static void allView(Object object){
		System.out.println(object);
	}
	public static void showError(String msg) {
		System.out.println(msg);
	}

}
