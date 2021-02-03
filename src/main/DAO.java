package main;

import java.util.ArrayList;
import java.util.List;

public class DAO {
	private ArrayList<Challenge> challenges;
	private ArrayList<User> users;
	private ArrayList<Segment> segments;
	
	public DAO() {
		this.users = new ArrayList<User>();
		this.challenges = new ArrayList<Challenge>();
		this.segments = new ArrayList<Segment>();
		this.users.add(new User("grandchef", "adminmdpfacile", true));
	}
	
	
	
	public ArrayList<User> getUsers() {
		
		return this.users;
	}

	public void addUser(User user) {
		this.users.add(user);
		
	}
	
	public void addChallenge(Challenge c) {
		this.challenges.add(c);
	}

	public List<Challenge> getallChal() {
		return this.challenges;
	}
	
	public List<Segment> getallSegment(){
		return this.segments;
	}

	public Challenge getChal(String challName) {
        for (Challenge c : getallChal()) {
            if (c.getChallengeName().equals(challName)) {
                return c;
            }
        }
        return null;
    }
	
	public Segment getSegment(int SegmentID) {
    	for (Segment s : getallSegment()) {
    		if (s.getSegmentID() == SegmentID) {
    			return s;
    		}
    	}
    	return null;
    }


	public void createCheckPoint(String nomChallenge, String nomCheckPoint) {
		Challenge chal = getChal(nomChallenge);
		chal.addCheckPoint(new CheckPoint(chal.getAllCheckPoint().size(),nomCheckPoint));
		
	}



	public void createSegment(String nomChallenge, String nomSegment, int cp1, int cp2, int Longueur) {
		Challenge chal = getChal(nomChallenge);
		chal.addSegment(new Segment(chal.getAllSegment().size(),nomSegment,null, chal.getCheckPoint(cp1), chal.getCheckPoint(cp2), Longueur));
		
	}



	public void createObstacle(String nomChallenge, int segmentID, String nomObstacle, String etape, int distance) {
		// TODO Auto-generated method stub
		Segment s = getSegment(segmentID);
		s.setObstacle(new Obstacle(nomObstacle,etape,distance));
	}

}
