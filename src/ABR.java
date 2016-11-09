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
	
	//Find
	public ABR find(int value){
		if(this.isEmpty()){
			return new ABR();
		}else{
			if(this.getRootValue()>value){
				return this.getG().find(value);
			}else if(this.getRootValue()<value){
				return this.getD().find(value);
			}else{
				return this;
			}
		}
	}
	//Find Plus proche successeur sous arbre droit 
	public ABR findPlusProcheSuccGauche(){
		if(this.getG().getG().isEmpty()){
			return this;
		}else{
				return this.getG().findPlusProcheSuccGauche();
			}
		}
	//Delete
	public void delete(int a){
		ABR arbreADel = this.find(a);
		ABR BrancheDroite= arbreADel.getD();
		ABR BrancheGauche= arbreADel.getG();
		if(BrancheDroite.isEmpty() & BrancheGauche.isEmpty()){
			// Cas 0 enfant
			arbreADel = new ABR();
		}else if (BrancheDroite.isEmpty() | BrancheGauche.isEmpty()){
			//Cas 1 seul enfant
			if(BrancheGauche.isEmpty()){
				arbreADel = arbreADel.getD();
			}else{
				arbreADel= arbreADel.getG();
			}
		}else{
			//Cas 2 enfants
			ABR parentDuNoeudAEchanger =arbreADel.findPlusProcheSuccGauche();
			ABR ValnoeudAEchanger = parentDuNoeudAEchanger.getG();
			//Echange des noeuds
			arbreADel.brancheD = new ABR();
			arbreADel.brancheG = new ABR();
			
			//Il faudrait chopper le parent du noeud a Del si il existe
			parentDuNoeudAEchanger.brancheG = arbreADel;
			ValnoeudAEchanger.brancheD = BrancheDroite;
			ValnoeudAEchanger.brancheG = BrancheGauche;
			//parentDuNoeudADel.brancheG ou brancheD = ValnoeudAEchanger;
			
			delete(a);
		}
		
		
	}
	
}
