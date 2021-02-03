package main;

public class Segment {

	private int SegmentID;
    private String nom;
    private Obstacle o; 
    private CheckPoint cp1;
    private CheckPoint cp2;
    private int Longueur; 

    public Segment() {

    }



    public Segment(int segmentID, String nom, Obstacle o, CheckPoint cp1, CheckPoint cp2, int longueur) {
        
        SegmentID = segmentID;
        this.nom = nom;
        this.o = o;
        this.cp1 = cp1;
        this.cp2 = cp2;
        Longueur = longueur;
    }


    public int getSegmentID() {
        // TODO Auto-generated method stub
        return SegmentID;
    }

    public void setSegmentID(int segmentID) {
        this.SegmentID = segmentID;
    }

    public CheckPoint getcp1() {
        return cp1;
    }

    public void setcp1(CheckPoint cp1) {
        this.cp1 = cp1;
    }

    public CheckPoint getcp2() {
        return cp2;
    }

    public void setcp2(CheckPoint cp2) {
        this.cp2 = cp2; 
    }

    public int getLongueur() {
        return Longueur;
    }

    public void setLongueur(int Longueur) {
        this.Longueur = Longueur;
    }

    public Obstacle getObstacle() {
        return o;
    }

    public void setObstacle(Obstacle o) {
        this.o = o;
    }



    @Override
    public String toString() {
        return "Segment [SegmentID=" + SegmentID + ", nom=" + nom + ", o=" + o + ", Longueur=" + Longueur + "]";
    }

}
