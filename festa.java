import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class festa
{  
    public static void main(String[] args) 
	{
		convidados();
    }
	
   public static void convidados()
  
    {	    
	    String Cg = null ;
        String Cv = null ;
        Integer NCv = 0; 	  
  	
	    Scanner sc = new Scanner(System.in);
        ArrayList<convidado> listaConvidados = new ArrayList();      
	    int contador = 0;
        
		do {
	       
		   System.out.print("Informe a Congregacao:");
           Cg = sc.nextLine(); 
           
		   if (Cg.isEmpty()) {
			   
			   System.out.println("Congregacao Nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe a Congregacao:");
               Cg = sc.nextLine(); 
            
			   if (Cg.isEmpty()) {
			   
			   System.out.println("Congregacao Nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe a Congregacao:");
               Cg = sc.nextLine();
			   
			   }

               if (Cg.isEmpty()) {
			   
			   System.out.println("Congregacao Nao foi informado, vou encerrar!");
               sc.nextLine();
			   System.exit(0);
			   }
		      	 		   
			} 
		             
	        System.out.print("Informe o Convidado:");
            Cv = sc.nextLine(); 
           
		    if (Cv.isEmpty()) {						
		       
			   System.out.println("Convidado Nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe o Convidado:");
               Cv = sc.nextLine(); 
            
			   if (Cv.isEmpty()) {
			   
			   System.out.println("Convidado Nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe o Convidado:");
               Cv = sc.nextLine();
			   
			   }

               if (Cv.isEmpty()) {
			   
			   System.out.println("Convidado Nao foi informado, vou encerrar!");
               sc.nextLine();
			   System.exit(0);
			   }
		   
		    }
			
			System.out.print("Informe o Nro Convidados Extras:");
            NCv = Integer.parseInt(sc.nextLine()); 
      		
			if (NCv == 0) {						
		       
			   System.out.println("Nro Convidados Extras Nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe o Nro Convidados Extras:");
               NCv = Integer.parseInt(sc.nextLine()); 
            
			   if (NCv == 0) {
			   
			   System.out.println("Nro Convidados Extras Nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe o Nro Convidados Extras:");
               NCv = Integer.parseInt(sc.nextLine());
			   
			   }

               if (NCv == 0) {
			   
			   System.out.println("Nro Convidados Extras Nao foi informado, vou encerrar!");
               sc.nextLine();
			   System.exit(0);
			   }
		   
		    }
	
         	listaConvidados.add(new convidado(Cg,Cv,NCv));
		    contador = contador + 1;
 			
			System.out.println("");
			System.out.print("Deseja inserir mais convidados? S ou N:");
            String SN = sc.nextLine();
            String cSN = new String ("S");
			
			if (SN.equals(cSN)) {
			System.out.println("");
			}else{
			
		        if(listaConvidados.isEmpty()){
                System.out.println("Não existem registros cadastrados,vou encerrar!");
                sc.nextLine();
                System.exit(0);			   
  		        }else{
                System.out.println("");					
				System.out.println("Lista de Convidados por Congregacao.");
                exibir(listaConvidados);
				listaConvidados.clear(); 
                System.out.println("Fim da lista.");
				System.out.println("");	
				                			
				System.out.print("Deseja continuar usando a aplicacao? S ou N:");
                String SNf = sc.nextLine();
                String cSNf = new String ("S");
			
			    if (SNf.equals(cSNf)) {
			    System.out.println("");
			    }else{
			    System.exit(0);			   
  		        }
				
			    }    		   
	        }
			
	    } while (contador != 0);
	   	   
	   sc.close();  
       	   
	}	  
   	   
	public static void exibir (ArrayList <convidado> Lista){
		
		Map<String,Integer> totalConvidados = new HashMap<String,Integer>();
 
	    for (convidado item: Lista){ 
		
			if (totalConvidados.containsKey(item.getCongregacao())) {
               Integer ValorExistente = totalConvidados.get(item.getCongregacao());
			   totalConvidados.replace(item.getCongregacao(),(1 + ValorExistente + item.getnConvidado())) ;
            } else {
            totalConvidados.put(item.getCongregacao(), (1 + item.getnConvidado()));        
	  	    }
        }
		
		for (Map.Entry<String, Integer> set : totalConvidados.entrySet()) {
          
           System.out.println(set.getKey() + " = " + set.getValue());
		   
        }
   	    }          
}
