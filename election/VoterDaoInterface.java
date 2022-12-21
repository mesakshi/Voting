package election;

import java.io.IOException;
import java.sql.SQLException;

    public interface VoterDaoInterface {
    	
    public Voter viewAll() throws IOException ;
    public Voter voterRegistration (Voter voter) throws IOException, ClassNotFoundException, SQLException;
    public Voter searchByUsernameAndPassword(String username, String password) throws IOException;
    public Voter searchByUsername(String username) throws IOException;
    public void candidatesList()throws IOException;

}