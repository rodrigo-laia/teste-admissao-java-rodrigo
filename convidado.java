  public class convidado {
	  
	private String scongregacao;
    private Integer nconvidadosExtras;
	
    public static void main(String[] args) 
    {
    }	
	public convidado(String scongregacao, Integer nconvidadosExtras){	
		this.scongregacao = scongregacao;
		this.nconvidadosExtras = nconvidadosExtras;
	}	
	public String getCongregacao(){
		return scongregacao;	}
	
	public Integer getConvidadosExtras()	{
		return nconvidadosExtras;
	}
	
  }