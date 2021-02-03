package main;

public class Obstacle {
    private String nom;
    private String etape;
    private int distance;



    public Obstacle() {
    }


    public Obstacle(String nom, String etape, int distance) {
        this.nom = nom;
        this.etape = etape;
        this.distance = distance;
    }
    
    /**
    public int getObstacleID() {
        return ObstacleID;
    }

    public void setObstacleID(int obstacleID) {
        this.ObstacleID = obstacleID;
    }**/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtape() {
        return etape;
    }

    public void setEtape(String etape) {
        this.etape = etape;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    @Override
    public String toString() {
        return "Obstacle [nom=" + nom + ", etape=" + etape + ", distance=" + distance
                + "]";
    }

}
