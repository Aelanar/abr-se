package ABR;

public class ABR {

	private int valueNode;
	private boolean estVide=true;
	private ABR brancheD = null;
	private ABR brancheG = null;
	
	
	public ABR(){
		//Arbre vide
	}

	public ABR(int valueNode, ABR brancheD, ABR brancheG){
		this.valueNode = valueNode;
		this.brancheD = brancheD;
		this.brancheG = brancheG;
		this.estVide = false;
	}
	
	//Getter
	
	public ABR getG(){
		return this.brancheG;
	}
	public ABR getD(){
		return this.brancheD;
	}
	public int getRootValue(){
		return this.valueNode;
	}
	
	//Is Empty
	
	public boolean isEmpty(){
		return this.estVide;
	}
	
	// Nub Element
	
	public int nbElements(){
		if(this.isEmpty()){
			return 0;
		}
		else{
			return 1 + this.getG().nbElements() + this.getD().nbElements();
		}
	}
	
	public void insert(int value){
		if(this.isEmpty()){
			this.valueNode = value;
			this.estVide = false;
			this.brancheD = new ABR();
			this.brancheG = new ABR();
			return;
		}else{
			if(this.getRootValue()>value){
				this.getG().insert(value);
			}else{
				this.getD().insert(value);
			}
		}
		
	}
}
