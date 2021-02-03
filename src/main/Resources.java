package main;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.naming.NamingException;
 

@Path("/")
public class Resources {


	private DAO dao = new DAO();

	public Resources(){
		
	}
	
	/**
     *  UTILS
     */

    @SuppressWarnings("rawtypes")
    public String arrayToJson(List list) {
        String result = "{";
        for (Object obj : list) {
            result += obj.toString();
        }
        result += "}";
        return result;
    }

    public Challenge getChal(String challName) {
        for (Challenge c : dao.getallChal()) {
            if (c.getChallengeName().equals(challName)) {
                return c;
            }
        }
        return null;
    }

    public boolean existUser(String username) {
        for (User user : dao.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    
    public User getUser(String username) {
    	for (User user: dao.getUsers()) {
    		if (user.getUsername().equals(username))
    			return user;
    	}
    	return null;
    }
    
    /**
     * PUBLIC
     */

    @GET
    public String getHome() {
        return "try fit/challenges";
    }

    /**
     * Get all challenge
     * 
     * Get challenges
     * @return all available challenges
     * @return all available challenge
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("challenge/")
    public String getAllChallenge() {
    	return "coucou";
        //return arrayToJson(dao.getallChal());
  
    }
    /**
     * Get a challenge
     * @param id 
     * @return challenge with this id
     */

    @GET
    @Path("challenge/{name}/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getChallenge(@PathParam("name") String name) {
        return getChal(name).toString();
    }

  
    @POST
    @Path("challenge/create/{username}-{challName}-{challDescription}")
    @Produces(MediaType.APPLICATION_JSON)
    public String createChall(@QueryParam("username")String username, @QueryParam("challName")  String challName, @QueryParam("challDescription") String challDescription)  {
  	  	return "ça fonctionne";
    }
    
    /**
     * Store an username and a password to create an account
     * 
     * @param request  (context request for session handling)
     * @param username (username query parameter)
     * @param password (password query parameter)
     * 
     * @return a message as text/plain to confirm sign up
     * @throws NamingException
     * @throws NotSupportedException
     * @throws SystemException
     * @throws HeuristicRollbackException
     * @throws HeuristicMixedException
     * @throws RollbackException
     * @throws IllegalStateException
     * @throws SecurityException
     */

    @POST
    @Path("signup/{username}-{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public String signUp(@Context HttpServletRequest request, @QueryParam("username") String username,
            @QueryParam("password") String password) 
            throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException,
            HeuristicRollbackException, SystemException, NotSupportedException, NamingException {
        if (existUser(username))
            return "username already taken";
        List<User> users = dao.getUsers();
        dao.addUser(new User(username, password, false));
      return "successfully registered and connected as : " + username + ", " + password;
    }
    

    
    @PUT
    @Path("signin/")
    @Produces(MediaType.TEXT_PLAIN)
    public String signIn(@Context HttpServletRequest request, @QueryParam("username") String username,
            @QueryParam("password") String password)
            throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException,
            HeuristicRollbackException, SystemException, NotSupportedException, NamingException {
        if (existUser(username)) {
      	  User user = getUser(username);
      	  if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return "successfully connected as : " + username + ", " + password;
            }
        }          
        return "wrong username or password";
    }
    
    /**
    * ADMIN 
    */

   /**
    *  create CheckPoint 
    */

   @POST
   @Path("challenge/{name}/Checkpoint")
   @Produces(MediaType.APPLICATION_JSON)
   public String postCheckpoint(@PathParam("name") String nomChallenge, @QueryParam("nameCP") String nomCheckPoint) {
	   
           dao.createCheckPoint(nomChallenge,nomCheckPoint);
           return arrayToJson(getChal(nomChallenge).getAllCheckPoint());
       
   }

   /**
    * create Segment
    */
   
   @POST
   @Path("challenge/{name}/Segment")
   @Produces(MediaType.APPLICATION_JSON)
   public String postSegment(@PathParam("name") String nomChallenge,@QueryParam("nameSegment") String nomSegment,@QueryParam("cp1") int cp1,@QueryParam("cp2") int cp2,@QueryParam("Longueur") int Longueur) {
	   dao.createSegment(nomChallenge,nomSegment, cp1, cp2, Longueur);
	   return arrayToJson(getChal(nomChallenge).getAllSegment());
   }
   
   /**
    * create Obstacle
    */
   
   @POST
   @Path("challenge/{name}/Segment/{segmentID}/Obstacle")
   @Produces(MediaType.APPLICATION_JSON)
   
   public String postObstacle(@PathParam("name") String nomChallenge,@PathParam("segmentID") int segmentID,@QueryParam("nameObstacle") String nomObstacle,@QueryParam("etape") String etape,@QueryParam("distance") int distance) {
	   dao.createObstacle(nomChallenge,segmentID, nomObstacle,etape,distance);
	   return arrayToJson(getChal(nomChallenge).getAllSegment());
   }
   
   /**
    * get a CheckPoint
    */

   @GET
   @Path("challenge/{name}/CheckPoint/{cpID}")
   @Produces(MediaType.APPLICATION_JSON)
   public String GetCheckPoint (@PathParam("name") String nomChallenge,
           @PathParam("cpId") int cpId) {
       return getChal(nomChallenge).getCheckPoint(cpId).toString();
   }
   
   /**
    * get a Segment
    */
   
   @GET
   @Path("challenge/{name}/Segment/{segmentID}")
   @Produces(MediaType.APPLICATION_JSON)
   public String GetSegment(@PathParam("name") String nomChallenge, @PathParam("segmentID") int segmentID) {
	   return getChal(nomChallenge).getSegment(segmentID).toString();
   }
   
   
   
   
}
