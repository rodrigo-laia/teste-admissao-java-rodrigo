  public class convidado {
	  
	private String Congr;
    private String Conv; 
    private Integer nConv;
    
	public static void main(String[] args) {	  
	}
	
	public convidado(String Congr, String Conv, Integer nConv){	
		this.Congr = Congr;
		this.Conv = Conv;
		this.nConv = nConv;
	}	
	public String getCongregacao(){
		return Congr;
	}
	
	public void SetCongregacao(String Congr){
		this.Congr = Congr;
	}
	
	public String getConvidado(){
		return Conv;
	}
	
	public void SetConvidado(String Conv)	{
		this.Conv = Conv;
	}
	
	public Integer getnConvidado()	{
		return nConv;
	}
	
	public void SetnConvidado(Integer nConv)	{
		this.nConv = nConv;
	}
		
  }