
/**
 * Purpose: This program creates the class that ChallengeProgramTester.java uses to manipulate and create data.
 * It initialzes variables and creates getter and setter methods for names, relations, birthdays, phone numbers,
 * and email addresses. 
 *
 * @author Blake Fowler
 * @version 2/28/2024
 *
 */
public class challengeProgram {

    // instance variables
    private String name;
    private String relation;
    private String birthday;
    private String phoneNumber;
    private String emailAddress;

    // Constructor for objects of class challengeProgram
    public challengeProgram (String n, String r, String b, String p, String e)
    {
        // initialize instance variables
        this.name = n;
        this.relation = r;
        this.birthday = b;
        this.phoneNumber = p;
        this.emailAddress = e;
    }

//All of our getter and setter methods follow here
    public String getName()
    {
        return name;
    }
   
    public void setName(String n)
    {
        name = n;
    }
   
    public String getRelation()
    {
        return relation;
    }
    
    public void setRelation(String r)
    {
        relation = r;
    }
   
    public String getBirthday()
    {
        return birthday;
    }
    
    public void setBirthday(String b)
    {
        birthday = b;
    }
    
    public String getPhoneNumber()
    {
       return phoneNumber;
    }
   
    public void setPhoneNumber(String p) 
    { 
      phoneNumber = p;
    }
    
     public String getEmailAddress()
    {
        return emailAddress;
    }
    
    public void setEmailAddress(String e)
    {
        emailAddress = e;
    }

    //Our handy toString method with it all neatly formatted for the lovely table
   
     public String toString() {
        return String.format("%-15s%-15s%-15s%-15s%-30s", name, relation, birthday, phoneNumber, emailAddress);
    }
}