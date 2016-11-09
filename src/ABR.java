package ABR;
import java.util.List;

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
	
	//Getter (Package Protected)
	
	 ABR getG(){
		return this.brancheG;
	}
	 ABR getD(){
		return this.brancheD;
	}
	int getRootValue(){
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
	
	
	//Insert
	public void insert(int value){
		if(this.isEmpty()){
			this.valueNode = value;
			this.estVide = false;
			this.brancheD = new ABR();
			this.brancheG = new ABR();
			return;
		}else{
			if (this.getRootValue()==value){
				return;
			}else if(this.getRootValue()>value){
				this.getG().insert(value);
			}else{
				this.getD().insert(value);
			}
		}
		
	}
	
	
	//Contains
	public boolean contains(int value){
		if(this.isEmpty()){
			return false;
		}else{
			if(this.getRootValue()>value){
				return this.getG().contains(value);
			}else if(this.getRootValue()<value){
				return this.getD().contains(value);
			}else{
				return true;
			}
		}
	}
	
	
	// To list
	public void toList(List<Integer> list){
		if (this.isEmpty()){
		}else{
			this.getG().toList(list);
			list.add(this.getRootValue());
			this.getD().toList(list);
			
		}
	}
	
	//Is Valid ABR tree
	public boolean isValidABR(){
		if (this.isEmpty()){
			return true;
		}else{
			return this.getG().isValidABRGauche(this.getRootValue()) &  this.getD().isValidABRDroite(this.getRootValue());
		}

	}
	private boolean isValidABRGauche(int noeudPrecedent){
		if (this.isEmpty()){
			return true;
		}else if(this.getRootValue()==noeudPrecedent){
			return false;
		}else if(noeudPrecedent > this.getRootValue()){
			return this.getG().isValidABRGauche(this.getRootValue()) &  this.getD().isValidABRDroite(this.getRootValue());
		}else{
			return false;
		}
	}
	private boolean isValidABRDroite(int noeudPrecedent){
		if (this.isEmpty()){
			return true;
		}else if(this.getRootValue()==noeudPrecedent){
			return false;
		}else if(noeudPrecedent < this.getRootValue()){
			return this.getG().isValidABRGauche(this.getRootValue()) &  this.getD().isValidABRDroite(this.getRootValue());
		}else{
			return false;
		}
	}
	
	
}
