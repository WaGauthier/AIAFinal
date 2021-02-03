package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;

public class Challenge {

	private String nom ;
    //private int ChallengeID;
    private String description;
    private ArrayList<User> players;
    
    @ElementCollection
    private ArrayList<CheckPoint> cp ;
    @ElementCollection
    private ArrayList<Segment> segments ;


    public Challenge() {
    	
    }
    
    public Challenge( String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.players = new ArrayList<User>();
        this.segments = new ArrayList<Segment>();
        this.cp = new ArrayList<CheckPoint>();
       
    }
    /**
    public int getChalId() {
        // TODO Auto-generated method stub
        return ChallengeID;
    }

    public void setChalId(int ChallengeID) {
        this.ChallengeID = ChallengeID;
    }**/

    public String getChallengeName() {
        return nom;
    }

    public String setChallengeName(String nom) {
        return nom;
    }

    public ArrayList<User> getPlayer() {
        return players;
    }

    public void setPlayer(User player) {
        this.players.add(player);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Ajout Segment + Checkpoint
     * @param s --- cp
     */
    
    public void addCheckPoint(CheckPoint cp) {
    	this.cp.add(cp);
    }
    
    public void addSegment(Segment s) {
    	this.segments.add(s);
    }
    
    public List<CheckPoint> getAllCheckPoint(){
    	return cp;
    }
    
    public List<Segment> getAllSegment(){
    	return segments;
    }
    
    public void setCheckPoint(ArrayList<CheckPoint> cp) {
    	this.cp = cp;
    }
    
    public void setSegment(ArrayList<Segment> s) {
    	this.segments = s;
    }
  
    public CheckPoint getCheckPoint(int CheckPointID) {
    	for (CheckPoint cp : getAllCheckPoint()) {
    		if (cp.getCheckPointID() == CheckPointID) {
    			return cp;
    		}
    	}
    	return null;
    }
    
    public void RemoveCheckPoint(int CheckPointID) {
    	cp.remove(getCheckPoint(CheckPointID));
    }
    
    public Segment getSegment(int SegmentID) {
    	for (Segment s : getAllSegment()) {
    		if (s.getSegmentID() == SegmentID) {
    			return s;
    		}
    	}
    	return null;
    }
    
    public void RemoveSegment (int SegmentID) {
    	segments.remove(getSegment(SegmentID));
    }
    
    
	@Override
	public String toString() {
		return "Challenge [nom=" + nom + ", description=" + description + ", players="
				+ players + ", cp=" + cp + ", s=" + segments+ "]";
	}
    
    
}
