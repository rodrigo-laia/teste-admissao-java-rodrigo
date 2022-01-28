  public class convidado {
	  
	private String congregacao;
    private Integer convidadosExtras;
	
    public static void main(String[] args) 
    {
    }	
	public convidado(String congregacao, Integer convidadosExtras){	
		this.congregacao = congregacao;
		this.convidadosExtras = convidadosExtras;
	}	
	public String getCongregacao(){
		return congregacao;	}
	
	public Integer getConvidadosExtras()	{
		return convidadosExtras;
	}
	
  }