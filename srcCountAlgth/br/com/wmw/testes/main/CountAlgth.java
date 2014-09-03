package br.com.wmw.testes.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CountAlgth {

	public static void main(String[] args) {
		List<Integer> listNums = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 53000000; i++) {
			listNums.add(random.nextInt(61));
		}
		List<String> listResult = new ArrayList<String>();
		for (int i = 0; i <= 60; i++) {
			Integer count = 0;
			for (Integer num : listNums) {
				if (num == i) {
					count++;
				}
			}
			listResult.add(i+" = "+count);
		}
		//--
		Integer[][] matriz = new Integer[2][listResult.size()];
		List<Integer> vector = new ArrayList<Integer>();
		for (int i = 0; i < listResult.size(); i++) {
			String[] str = listResult.get(i).split("=");
			matriz[0][i] = Integer.parseInt(str[0].trim());
			matriz[1][i] = Integer.parseInt(str[1].trim());
			vector.add(Integer.parseInt(str[1].trim()));
		}
		Collections.sort(vector);
		System.out.println(vector.toString());
		int size = matriz[1].length;
		for (int j = 0; j < size; j++) {
			System.out.println(matriz[0][j]+" - "+matriz[1][j]);
		}
//		for (int i = 0; i < size; i++) {
//			if (matriz.length - i >= 0 && matriz[1][i] < matriz[1][matriz.length-i]) {
//				Integer valor1 = matriz[1][i];
//				Integer valor2 = matriz[1][matriz.length-i];
//				matriz[1][i] = valor2;
//				matriz[1][matriz.length-i] = valor1;
//			}
//			if (i < matriz.length && matriz[1][i] < matriz[1][i+1]) {
//				Integer valor1 = matriz[1][i];
//				Integer valor2 = matriz[1][i+1];
//				matriz[1][i] = valor2;
//				matriz[1][i+1] = valor1;
//			}
//		}
//		for (int i = 0; i < size; i++) {
//			if (matriz.length - i >= 0 && matriz[1][matriz.length-i] > matriz[1][i]) {
//				Integer valor1 = matriz[1][i];
//				Integer valor2 = matriz[1][matriz.length-i];
//				matriz[1][i] = valor2;
//				matriz[1][matriz.length-i] = valor1;
//			}
//			if (i < matriz.length && matriz[1][i+1] > matriz[1][i]) {
//				Integer valor1 = matriz[1][i];
//				Integer valor2 = matriz[1][i+1];
//				matriz[1][i] = valor2;
//				matriz[1][i+1] = valor1;
//			}
//		}
		//--
	}

}
