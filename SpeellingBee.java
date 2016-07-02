import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class SpeellingBee {
	public static int sb(char[] input){
		int l=input.length;
		int m=1;
		if(l>1){
			int x=1;
			int y=1;
			int z=1;
			if(input[0]!=input[1]){
				x=2;
			}else{
				x=1;
			}
			if(input[l-1]!=input[l-2]){
				y=2;
			}else{
				y=1;
			}
			for(int i=1;i<l-1;i++){
				if(input[i]!=input[i-1] && input[i]!=input[i+1] && input[i-1]!=input[i+1]){
					z=3;
				}else if(input[i]==input[i-1] && input[i]==input[i+1] && input[i-1]==input[i+1]){
					z=1;
				}else{
					z=2;
				}
				m=m*z;
			}
			m=m*x*y;
		}else{
			m=1;
		}
		return m;
	}
	public static void main(String[] argv) {
		//create file
		File file=new File("C:/Users/Michelle/Desktop","w.txt");
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		// write in file
		/*
		String w="abcde";
		byte bt[]=new byte[1024];
		bt=w.getBytes();
		try{
			FileOutputStream in=new FileOutputStream(file);
			in.write(bt, 0, bt.length);
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		*/
		//read from file by lines
		BufferedReader reader = null;
		try{
			reader=new BufferedReader(new FileReader(file));
			String input=null;
			int line=1;
			int lineno=0;
			while((input=reader.readLine())!=null){
				//call the lazy spelling bee method
				if(lineno!=0){
					int l=input.length();
					char[] inputch = new char[l];
					inputch = input.toCharArray();
					int output=sb(inputch);
					System.out.println("Case #"+lineno+": "+output);
				}
				lineno++;
			}
			reader.close();
		}catch(IOException e){
			
		}
		
	}
}

