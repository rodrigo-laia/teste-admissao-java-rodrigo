import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;
public class Main
{  
    public static void main(String[] args) 
	{
		convidados();
    }
	
   public static void convidados()
   
    {	    
	    String sCg = null ;
        Integer nNCv = 0; 	  
  	
	    Scanner sc = new Scanner(System.in);
        ArrayList<convidado> listaConvidados = new ArrayList<convidado>();      
	    int contador = 0;
        
		do {
	       
		   System.out.print("Informe a Congregacao:");
           sCg = sc.nextLine(); 
           
		   if (sCg.isEmpty()) {
			   
			   System.out.println("Congregacao nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe a Congregacao:");
               sCg = sc.nextLine(); 
            
			   if (sCg.isEmpty()) {
			   
			   System.out.println("Congregacao nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe a Congregacao:");
               sCg = sc.nextLine();
			   
			   }

               if (sCg.isEmpty()) {
			   
			   System.out.println("Congregacao não foi informado, vou encerrar!");
               sc.nextLine();
			   System.exit(0);
			   }
		      	 		   
			} 
		             
			System.out.print("Informe o Nro Convidados Extras:");
            nNCv = Integer.parseInt(sc.nextLine()); 
      		
			if (nNCv == 0) {						
		       
			   System.out.println("Nro Convidados Extras nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe o Nro Convidados Extras:");
               nNCv = Integer.parseInt(sc.nextLine()); 
            
			   if (nNCv == 0) {
			   
			   System.out.println("Nro Convidados Extras Nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe o Nro Convidados Extras:");
               nNCv = Integer.parseInt(sc.nextLine());
			   
			   }

               if (nNCv == 0) {
			   
			   System.out.println("Nro Convidados Extras nao foi informado, vou encerrar!");
               sc.nextLine();
			   System.exit(0);
			   }
		   
		    }
	
         	// listaConvidados.add(new convidado(sCg,nNCv));
		    
			 Optional<convidado> opt = listaConvidados.stream().filter(i -> i.getCongregacao().equals(sCg)).findAny();
             if (opt.isPresent()) {                
		        listaConvidados.add(new convidado(sCg,nNCv));
			 }else{
                listaConvidados.add(new convidado(sCg,(nNCv +1)));			     
			 }
			
			contador = contador + 1;
 			
			System.out.println("");
			System.out.print("Deseja inserir mais convidados? S ou N:");
            String sSN = sc.nextLine();
            String scSN = new String ("S");
			
			if (sSN.equals(scSN)) {
			System.out.println("");
			}else{
			
		        if(listaConvidados.isEmpty()){
                System.out.println("Não existem registros cadastrados,vou encerrar!");
                sc.nextLine();
                System.exit(0);			   
  		       
 			    }else{
                
				System.out.println("");					
				System.out.println("Lista de Convidados por Congregacao:");                
	            
				Map<String, Integer> sum = listaConvidados.stream()
				.collect(Collectors.groupingBy(convidado::getCongregacao, Collectors.summingInt(convidado::getConvidadosExtras)));
   
                System.out.println(sum);
				
				listaConvidados.clear(); 
                
				System.out.println("Fim da lista.");
				System.out.println("");	
				                			
				System.out.print("Deseja continuar usando a aplicacao? S ou N:");
                String sSNf = sc.nextLine();
                String scSNf = new String ("S");
			
			    if (sSNf.equals(scSNf)) {
			    System.out.println("");
			    }else{
			    System.exit(0);			   
  		        }
				
			    }    		   
	        }
			
	    } while (contador != 0);
	   	   
	   sc.close();  
       	   
	}	  
   	             
}
