package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import code.NlpirTest.CLibrary;

public class WeiboParser {
	public void parse(String filePath,String destFilePath,CLibrary instance) throws IOException{
       BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"));
       PrintWriter writer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFilePath),"utf-8")));
       String line="";
       int num=0;
       int mod=5;
       while((line=reader.readLine())!=null){
    	   String fcResult=instance.NLPIR_ParagraphProcess(line, 0);
    	   writer.write(fcResult+"\r\n");
    	   ++num;
    	   if(num%mod==0) System.out.println("complete "+num+" lines");
       }
       System.out.println("total complete "+num+" lines");
       writer.close();

	}
}
