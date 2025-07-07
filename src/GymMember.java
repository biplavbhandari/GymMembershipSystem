public abstract class GymMember{
    protected String id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
      
    /* parameterized constructor has been used so the child class must implement one as well */
    GymMember(String id,String name,String location,String phone ,String email,String gender,
    String DOB,String membershipStartDate){
        attendance=0;
        activeStatus=false;
        loyaltyPoints=0;
        this.name=name;
        this.location=location;//this.location represents the attribute location represents the parameter
        this.id=id;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        
        
        
    }
    /* every abstract method  has its child class implementation to complete its meaning
       so encapsulation+inheritance*/
    public abstract void markAttendance();
    /* getters methods are used but the  input is done through the GUI so no setter is required*/
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }
    public String getDOB(){
        return DOB;
    }
    public String getMembershipStartDate(){
        return membershipStartDate;
    }
    public int getAttendance(){
        return attendance;
    }
    public double getLoyaltyPoints(){
        return loyaltyPoints;
    }
    public boolean getActiveStatus(){
        return activeStatus;
    }
    public void activateMembership(){
        activeStatus=true;
    }
     public boolean deactivateMembership(){
         if (activeStatus){
             activeStatus=false; //activeStatus flag is used to check validity of a membership
            return activeStatus;
         }
         else{
             System.out.println("Cannot deactivate an inactive membership");
             return activeStatus;
         }
       
    }
    public void resetMember(){
        activeStatus=false;
        attendance=0;
        loyaltyPoints=0.0;
        System.out.println(name+ "'s membership has been reset");
    }
    public void display(){
        System.out.println("_________________________");
        System.out.println("Member details->");
        System.out.println("_________________________");
        System.out.println("Id="+id);
        System.out.println("Name="+name);
        System.out.println("Location="+location);
        System.out.println("Phone:"+phone);
        System.out.println("E-mail="+email);
        System.out.println("Gender="+gender);
        System.out.println("Date-of-Birth="+DOB);
        System.out.println("Membership-start="+membershipStartDate);
        System.out.println("Attendance="+attendance);
        System.out.println("LoyaltyPoints="+loyaltyPoints);
        System.out.println("ActiveStatus="+activeStatus);
        System.out.println("------------------------------");
    }
   
    
}