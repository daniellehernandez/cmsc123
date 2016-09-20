package teeof;

import java.io.*;
import java.util.*;

/**
 * @author Danielle Hernandez
 * Exploring Java for the first time. ^_^ sorry sir for the badly written code with lots of redundant operations
 * Part 1 of TeeOfEn original submission was written in c code 
 * Written and tested using NetBeans
 */

public class TeeOf {
    
    public static String multiply(String nums, int b, int a, int log, int root, int slash, String of, int op){ //Overloading
        int result = 0;
       
       if(nums != null) {
        try {
          int basis = Integer.parseInt(nums.trim());
          result = basis*b;
          result += a;
        }
        catch(NumberFormatException x) {
                char[] en = nums.toCharArray();
                   if(log == 1){
                    return b+"log"+"("+of+")"+en[0]+"+"+a;
                   }
                   if(slash == 1){
                   return b+""+en[0]+"/"+of+"+"+a;
                   } 
                   if(op != 0){
                        if(op == 2){
                       return b+" "+"sqrt"+"("+en[0]+")"+"+"+a;
                       }
                       else if(op == 3){
                       return b+" "+"cubert"+"("+en[0]+")"+"+"+a;
                       } else {
                       return b+" "+op+"rt"+"("+en[0]+")"+"+"+a; // In cases where the root won't be just square or cube
                       }
                   } 
                
                return   b +""+ en[0] +"+"+ a;
            }
        }
         
         String fnl = result + "";
         return fnl;
        
    }
    
    public static String multiply(String nums, int b, int a, int zag, int log,int root, int slash, String of, int op){ //Overloading
        int result = 0;
        
        if(nums != null) {
        try {
          int basis = Integer.parseInt(nums.trim());
          result = basis*b - (zag-1)*b;
          result += a;
        }
        catch(NumberFormatException x) {
             char[] en = nums.toCharArray();
             int dan = 0*b-(zag-1)*b+a;
                   if(log == 1){
                    return b+"log"+"("+of+")"+en[0]+dan;
                   }   
                   if(slash == 1){
                   return b+""+en[0]+"/"+of+dan;
                   }
                   if(op != 0){
                       
                       if(op == 2){
                       return b+" "+"sqrt"+"("+en[0]+")"+dan;
                       }
                       else if(op == 3){
                       return b+" "+"cubert"+"("+en[0]+")"+dan;
                       } else {
                       return b+" "+op+"rt"+"("+en[0]+")"+dan; // In cases where the root won't be just square or cube
                       }
                   } 
             return   b +""+ en[0] + dan;
            
            }
        }
        
         String fnl = result + "";
         return fnl;
    
    }
    
    
    public static void TeeOfEn(String nums, int a, int b, String zag, int log, int root,int slash, String of, int op){
    a++;  
    String dan;
    int flag = 0;

       if(zag != null) {
        try {
              int zagu = Integer.parseInt(zag.trim());
                String result = multiply(nums,b,a,zagu,log,root,slash,of,op);
                System.out.print("T(n):"+result+"\n");
                flag = 1;
        }
        catch(NumberFormatException x){
          }
        } 
          
       if(nums != null && flag != 1 ){
          String result = multiply(nums,b,a,log,root,slash,of,op);
          System.out.print("T(n):"+result+"\n");
       }
    }
    

    public static void main(String[] args) {
        String toOpen = "sample-test-cases.txt"; 
        String perLine = null;
        int a = 0, b = 0, flag = 0, log = 0, root = 0, slash = 0, op = 0, twos = 0, cts = 0;
        char[] numbers = new char[10];
        char[] temps = new char[10];
        char[] of = new char[10];
        char[] check = new char[10];

        try{
            FileReader InputFile = new FileReader(toOpen);
            BufferedReader bufferedReader = new BufferedReader(InputFile); //Input text should be inside the class path folder
            
            
            while((perLine = bufferedReader.readLine()) != null){
            int ct = 0, z = 0, marker = 0;    
 
            for(int i = 0; i < perLine.length(); i++){   
              if(perLine.charAt(i) == '}'){
            
                     
                String zig = new String(numbers);    
                String zag = new String(temps); 
                String off = new String(of);  

              try{
               int zzz = Integer.parseInt(zig.trim());
               if( check[1] == '>' && check[2] == '+'){
               twos = 1;
               } 
               
               } catch(NumberFormatException x){
                   if(check[1] == '<' && check[2] == '-'){
                   System.out.print("T(n):Infinite\n");
                   twos = 3;
                   }
               }
              
                if(twos == 1){
                System.out.print("T(n):2\n");
                }  
               
                if(op >= 1){
                op += 1;
                }
                
                if(twos == 0){
                TeeOfEn(zig,a,b,zag,log,root,slash,off,op);
                }
                
                a = 0;
                b = 0;
                log = 0;
                root = 0;
                slash = 0;
                op = 0;
                twos = 0;
                for(int e = 0; e < cts; e++){
                check[e] = 0;
                 }
                cts = 0;
                }
              
            }
            
            for(int i = 0; i < perLine.length(); i++){   

              if(perLine.charAt(i) == 'i' && perLine.charAt(i+1) == 'n' && perLine.charAt(i+2) == 't'){
                 StringBuilder str = new StringBuilder(perLine);
                 str.delete(i, i+3);
                 perLine = str.toString();
                }    
            }
            
            for(int i = 0; i < perLine.length(); i++){ 
            
            if(perLine.charAt(0) == 'f'){
                flag = 1;
                z++;
                break;
                }
            }
            
            StringTokenizer Tokens = new StringTokenizer(perLine, ";(){for");
            while (Tokens.hasMoreTokens())
            {   
                //Tokenizer TeeOfN Part 1
                
                ct++;
                if(ct == 2 && z == 1){
                //System.out.println("Initializer:");
                marker = 1;
                } else if(ct == 3 && z == 1){
                //System.out.println("Condition:");
                marker = 2;
                } else if(ct == 4 && z == 1){
                //System.out.println("Step:");
                marker = 3;
                } else if (z != 4){
                //System.out.println("Body:");
                marker = 4;
                }
               //System.out.println(Tokens.nextToken());
            String FinalTok = Tokens.nextToken();
            char[] myString = FinalTok.toCharArray();
               
            if(marker == 1){
            int u = 0;    
            
            check[cts] = myString[5];
            cts++;
            
            for(int k = 0; k < FinalTok.length();k++){ 
               if(myString[k] == '='){
               a++;
               }
               temps[u] = 0;
               if(myString[k] == '=' && myString[k+2] == 'n'){
               twos = 1;
               }
                if(myString[k] == '=' && myString[k+2] != '1'){
                    flag = 1;
                    for(int v = k+2; v < FinalTok.length(); v++,u++){
                    temps[u] = myString[v];
                    }
                 break;   
                }
               
               
              }    
            }
            
            if(marker == 2){
            int count = 0;
            int q = 0, halt = 0;
            
            check[cts] = myString[3];
            cts++;
            
            for(int g = 0; g < FinalTok.length(); g++){
            if(myString[g] == '*' || myString[g] == '+' || myString[g] == '-' || myString[g] == '/'){
            op++;
            }    
            if((myString[g] == '+' || myString[g] == '-' || myString[g] == '*' || myString[g] == '/' || myString[g] == '=' || myString[g] == '<' || myString[g] == '>') && (myString[g+1] != ' ') ){
                    myString[g+1] = 'p';
                    b++;
                    } else if((myString[g] == '+' || myString[g] == '-' || myString[g] == '*' || myString[g] == '/' || myString[g] == '=' || myString[g] == '<' || myString[g] == '>')){
                     if(myString[g+1] == ' '){
                       a++;
                     }
                    b++;    
                    }
             }
            
            for(int l = FinalTok.length()-1; myString[l] != ' ';l--){
                halt++;
            }
            halt--;
            for(int l = FinalTok.length()-1; myString[l] != ' ' ; l--,halt--){
                numbers[halt] = myString[l];
            }
           
           }
           
          
           if(marker == 3 ){
               
               check[cts] = myString[2];
               cts++;
               
                for(int h = 0; h < FinalTok.length(); h++){
                if((myString[h] == '+' || myString[h] == '-' || myString[h] == '*' || myString[h] == '/' || myString[h] == '=' || myString[h] == '<' || myString[h] == '>') && (myString[h+1] != ' ') ){ 
                    if(myString[h+1] == '='){
                    int r = h+3;    
                    for(int s = 0; s <= FinalTok.length()-(r); s++,r++){
                    of[s] = myString[r];
                    }
                        if(myString[h] == '*'){
                        log = 1;
                        }
                        if(myString[h] == '/'){
                        //ASK SIR
                        }
                         if(myString[h] == '+' || myString[h] == '-'){
                        slash = 1;
                        }
                    }
                    myString[h+1] = 'p';
                        b++;
                        } else if((myString[h] == '+' || myString[h] == '-' || myString[h] == '*' || myString[h] == '/' || myString[h] == '=' || myString[h] == '<' || myString[h] == '>')){
                        b++;   
                        }
                }   
            }
            
            if(marker == 4){
                for(int w = 0; w < FinalTok.length(); w++){
                    if((myString[w] == '+' || myString[w] == '-' || myString[w] == '*' || myString[w] == '/' || myString[w] == '=' || myString[w] == '<' || myString[w] == '>') && (myString[w+1] != ' ') ){ 
                    myString[w+1] = 'p';
                    b++;
                    } else if((myString[w] == '+' || myString[w] == '-' || myString[w] == '*' || myString[w] == '/' || myString[w] == '=' || myString[w] == '<' || myString[w] == '>')){
                    b++;    
                    }
            
                }
            } 
            
        }
            
            
        }
            bufferedReader.close();
        } catch(FileNotFoundException x){
            System.out.println("Can't open " + toOpen);
        } catch(IOException x){
            System.out.println("Error Read");
        }


    }
    
}
