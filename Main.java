import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class Main
{  
    public static void main(String[] args) 
	{
		convidados();
    }
	
   public static void convidados()
  
    {	    
	    String Cg = null ;
        Integer NCv = 0; 	  
  	
	    Scanner sc = new Scanner(System.in);
        ArrayList<Convidado> listaConvidados = new ArrayList<Convidado>();      
	    int contador = 0;
        
		do {
	       
		   System.out.print("Informe a Congregacao:");
           Cg = sc.nextLine(); 
           
		   if (Cg.isEmpty()) {
			   
			   System.out.println("Congregacao nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe a Congregacao:");
               Cg = sc.nextLine(); 
            
			   if (Cg.isEmpty()) {
			   
			   System.out.println("Congregacao nao foi informado, pressione uma tecla para continuar!");
               sc.nextLine();
		       
			   System.out.print("Informe a Congregacao:");
               Cg = sc.nextLine();
			   
			   }

               if (Cg.isEmpty()) {
			   
			   System.out.println("Congregacao não foi informado, vou encerrar!");
               sc.nextLine();
			   System.exit(0);
			   }
		      	 		   
			} 
		             
			System.out.print("Informe o Nro Convidados Extras:");
            NCv = Integer.parseInt(sc.nextLine()); 
      		
			if (NCv == 0) {						
		       
			   System.out.println("Nro Convidados Extras nao foi informado, pressione uma tecla para continuar!");
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
			   
			   System.out.println("Nro Convidados Extras nao foi informado, vou encerrar!");
               sc.nextLine();
			   System.exit(0);
			   }
		   
		    }
	
         	listaConvidados.add(new Convidado(Cg,NCv));
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
				System.out.println("Lista de Convidados por Congregacao:");
                
				imprimirConvidadosAgrupados(convidadosPorCongregacao(listaConvidados));
				
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
   	
	private static void imprimirConvidadosAgrupados(Map<String,Integer> convidados)
	{
		for (Map.Entry<String, Integer> set : convidados.entrySet()) {
          
           System.out.println(set.getKey() + " = " + set.getValue());
		   
        }
	}
	
	private static Map<String,Integer> convidadosPorCongregacao (Collection<Convidado> convidados){
		
		Map<String,Integer> totalConvidados = new HashMap<String,Integer>();
 
	    for (Convidado item: convidados){ 
		
			if (totalConvidados.containsKey(item.getCongregacao())) {
               Integer ValorExistente = totalConvidados.get(item.getCongregacao());
			   totalConvidados.replace(item.getCongregacao(),(1 + ValorExistente + item.getConvidadosExtras())) ;
            } else {
            totalConvidados.put(item.getCongregacao(), (1 + item.getConvidadosExtras()));        
	  	    }
        }

		return totalConvidados;
   	}          
}
