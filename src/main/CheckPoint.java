package main;

public class CheckPoint {
	
	int CheckPointID;
	String nom;
	
	public CheckPoint() {
		
	}

	
	public CheckPoint(int checkPointID, String nom) {
		
		CheckPointID = checkPointID;
		this.nom = nom;
	}


	public int getCheckPointID() {
		// TODO Auto-generated method stub
		return CheckPointID;
	}

	public void setCheckPointID(int CheckPointID) {
		this.CheckPointID = CheckPointID;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "CheckPoint [CheckPointID=" + CheckPointID + ", nom=" + nom + "]";
	}
	
	
}
