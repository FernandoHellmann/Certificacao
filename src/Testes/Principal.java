package Testes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

public class Principal {

	void Principal() {
		// TODO Auto-generated constructor stub
	}	
	
	public static void main(String[] args) throws FileNotFoundException {

		double sadi = 10 / 0;

		String str = "April, 20, 2014";
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		formatter.format("PI10", Math.PI);

		File dir = new File("C:\\WMW\\");
		 File arq = new File(dir, "serial.txt");
		    try {
		        FileReader fileReader = new FileReader(arq);

		        BufferedReader bufferedReader = new BufferedReader(fileReader);
		        ArrayList<String> listSerial = new ArrayList<String>();
		        String linha = "";

		        while ((linha = bufferedReader.readLine()) != null) {
		        	listSerial.add(linha);
		        }
		        for (String string : listSerial) {
		        	int count = 0;
		        	for (int i = 0; i < listSerial.size(); i++) {
						if (string.equals(listSerial.get(i))) {
							count++;
						}
		        	}
		        	System.out.println(count);
				}
		        fileReader.close();
		        bufferedReader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }


//		    try {
//		    	String line;
//		    	BufferedWriter writeBri;
//		    	BufferedWriter writeBre;
//		    	String newLine = System.getProperty("line.separator");
//		    	Process p = Runtime.getRuntime().exec("c:\\WMW\\Ferramentas\\apache-tomcat-hevi\\bin\\startup.bat");
//
//		    	BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
//		    	BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//
//		    	writeBri = new BufferedWriter(new FileWriter("c:\\txt.txt"));
//		    	writeBre = new BufferedWriter(new FileWriter("c:\\txt.txt"));
//
//		    	while ((line = bri.readLine()) != null) {
//		    		writeBri.write(line + newLine);
//		    	}
//		    	bri.close();
//		    	writeBri.close();
//		    	while ((line = bre.readLine()) != null) {
//		    		writeBre.write(line + newLine);
//		    	}
//		    	bre.close();
//		    	writeBre.close();
//		    	p.waitFor();
//		    	System.out.println("Done.");
//		    } catch (Exception err) {
//		    	err.printStackTrace();
//		    }
	}


}

