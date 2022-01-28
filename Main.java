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
	    String congregacao = null;
        Integer nroConvidado = 0 ; 	  
  	
	    Scanner scan = new Scanner(System.in);
        ArrayList<convidado> listaConvidados = new ArrayList<convidado>();      
	    int contador = 0;
        
		do {
	       
		   System.out.print("Informe a Congregacao:");
           congregacao = scan.nextLine(); 
           
		   if (congregacao.isEmpty()) {
			   
			   System.out.println("Congregacao nao foi informado, pressione uma tecla para continuar!");
               scan.nextLine();
		       
			   System.out.print("Informe a Congregacao:");
               congregacao = scan.nextLine(); 
            
			   if (congregacao.isEmpty()) {
			   
			   System.out.println("Congregacao nao foi informado, pressione uma tecla para continuar!");
               scan.nextLine();
		       
			   System.out.print("Informe a Congregacao:");
               congregacao = scan.nextLine();
			   
			   }

               if (congregacao.isEmpty()) {
			   
			   System.out.println("Congregacao não foi informado, vou encerrar!");
               scan.nextLine();
			   System.exit(0);
			   }
		      	 		   
			} 
		             
			System.out.print("Informe o Nro Convidados Extras:");
            nroConvidado = Integer.parseInt(scan.nextLine()); 
      		
			if (nroConvidado == 0) {						
		       
			   System.out.println("Nro Convidados Extras nao foi informado, pressione uma tecla para continuar!");
               scan.nextLine();
		       
			   System.out.print("Informe o Nro Convidados Extras:");
               nroConvidado = Integer.parseInt(scan.nextLine()); 
            
			   if (nroConvidado == 0) {
			   
			   System.out.println("Nro Convidados Extras Nao foi informado, pressione uma tecla para continuar!");
               scan.nextLine();
		       
			   System.out.print("Informe o Nro Convidados Extras:");
               nroConvidado = Integer.parseInt(scan.nextLine());
			   
			   }

               if (nroConvidado == 0) {
			   
			   System.out.println("Nro Convidados Extras nao foi informado, vou encerrar!");
               scan.nextLine();
			   System.exit(0);
			   }
		   
		    }
	
         	listaConvidados.add(new convidado(congregacao,nroConvidado));
		              
			contador = contador + 1;
 			
			System.out.println("");
			System.out.print("Deseja inserir mais convidados? S ou N:");
            String insertSN = scan.nextLine();
            String cinsertSN = new String ("S");
			
			if (insertSN.equals(cinsertSN)) {
			System.out.println("");
			}else{
			
		        if(listaConvidados.isEmpty()){
                System.out.println("Não existem registros cadastrados,vou encerrar!");
                scan.nextLine();
                System.exit(0);			   
  		       
 			    }else{
                
				System.out.println("");					
				System.out.println("Lista de Convidados por Congregacao:");                
	              
			    
				imprimirConvidadosAgrupados(convidadosPorCongregacao(listaConvidados));
							
                				
				listaConvidados.clear(); 
                
				System.out.println("Fim da lista.");
				System.out.println("");	
				                			
				System.out.print("Deseja continuar usando a aplicacao? S ou N:");
                String continueSN = scan.nextLine();
                String ccontinueSN = new String ("S");
			
			    if (continueSN.equals(ccontinueSN)) {
			    System.out.println("");
			    }else{
			    System.exit(0);			   
  		        }
				
			    }    		   
	        }
			
	    } while (contador != 0);
	   	   
	   scan.close();  
       	   
	}	  
    
	private static void imprimirConvidadosAgrupados(Map<String,List<convidado>> convidados)
	{
		
        convidados.forEach((k,l) -> System.out.println(String.format("Congregacao: %s | Nro Convidados: %s", k, l.stream()
			                                                                      .mapToInt( x -> x.getConvidadosExtras()).sum() + l.size())));
    
	}
    private  static  Map<String,List<convidado>> convidadosPorCongregacao(Collection <convidado> convidados){
  
        Map<String, List<convidado>> groupByCongregacao = convidados.stream().collect(Collectors.groupingBy(convidado::getCongregacao));
	
	    return groupByCongregacao;
	
    } 
 
}
