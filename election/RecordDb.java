package election;

import java.sql.*;

public class RecordDb {
	
	private int voterId;
    private int symbol;

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }
 public RecordDb(){}


    public RecordDb(int voterId, int symbol) {
        this.voterId = voterId;
        this.symbol = symbol;
    }

    private final static String USERNAME = "root";

    private final static String PASSWORD = "Root@12345";

    private final static String URL = "jdbc:mysql://localhost:3306/voter";


    public void voteCount() throws ClassNotFoundException, SQLException {

        Connection con = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement stmt1 = con.createStatement();

            ResultSet rs1 = stmt1.executeQuery("SELECT COUNT(*) AS COUNT FROM vote where symbol=1");
            Integer Party1 = null;
            while(rs1.next()) {
                System.out.println("The total vote for Symbol 1 (YOUNG PARTY) is:: " + rs1.getInt("COUNT"));
                Party1=rs1.getInt(1);
            }

            //Create a Statement class to execute the SQL statement
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM vote where symbol=2");
            Integer Party2=null;
            while(rs.next()) {
                System.out.println("The total vote for Symbol 2 (OLD PARTY) is:: " + rs.getInt("COUNT"));
                Party2=rs.getInt(1);


                //Closing the connection
            } if(Party2< Party1){
                System.out.println(" PARTY A IS WINNER ");
            } else{
                System.out.println("PARTY B IS WINNER ");}
        }catch (SQLException e){
            e.printStackTrace();}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public Voter doVote(Integer voterId, Integer symbol) throws ClassNotFoundException, SQLException {
        //have to make table and chagne voting system ....
        RecordDb vote=new RecordDb(voterId,symbol);
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String insertQuery = "INSERT INTO vote (voter_id,symbol)"
                + "value (" +vote.getVoterId()+','+vote.getSymbol()+")";


        System.out.println(insertQuery);

        Statement statement = con.createStatement();
        int resultValue = statement.executeUpdate(insertQuery);



        if (resultValue == 2) {
            System.out.println("You already voted");
        }

        statement.close();
        con.close();
        return null;
    }

}

