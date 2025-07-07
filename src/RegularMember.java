public class RegularMember extends GymMember{
    private  final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    
    RegularMember(String id,String name,String location,String phone,String email,String 
    gender,String DOB,String membershipDate,String referralSource){
        super(id,name,location,phone,email,gender,DOB,membershipDate);
        this.referralSource=referralSource;
        isEligibleForUpgrade=false;
        attendanceLimit=30;
        plan="basic";
        price =6500;
        removalReason="";
        
        
    }
    public boolean getIsEligibleforUpgrade(){
        return isEligibleForUpgrade;
    }
    public String getRemovalReason(){
        return removalReason;
    }
    public String getReferralSource(){
        return referralSource;
    }
    public String getPlan(){
        return plan;
    }
    public double getPrice(){
        return price;
    }
    public int getAttendanceLimit(){
        return attendanceLimit;
    }
    /* simple switch case where plan is input and returns the value of these specific plan price based on condition 
       the -1 is default if something incorrect received in the parameter*/
    public double getPlanPrice(String plan){
        switch(plan){
            case "basic":
             
                return 6500;
             case "standard":
                 return 12500;
             case "deluxe":
                 return 18500;
             default:
                 return -1;
                
        }
    }
    
    public String upgradePlan(String updatedPlan){
       if(attendance>=attendanceLimit) { //the parent class variable attendance is used and this is possible because the variable is protected and we are inside child class
           isEligibleForUpgrade=true;
           
       }
       if(isEligibleForUpgrade){ 
           {
             if(updatedPlan.equals(plan)){ //no update needed in this case
              return "You are already on this plan";
             }
             double newPrice=getPlanPrice(updatedPlan);
             if(newPrice!=-1){ //if the value of newPrice isnt invalid then ...
                 plan=updatedPlan;
                 price=newPrice;
                 return"Plan upgraded to "+updatedPlan;
             }
             return "Invalid plan.Choose an appropriate plan"; //this means newprice has an invalid value 
           }
           
       }
       return "Attendance limit hasn't been reached.Upgrade cannot be performed";
       
    }
    public void revertRegularMember(String removalReason){
        resetMember();
        isEligibleForUpgrade=false;
        plan="basic";
        price=6500;
        this.removalReason=removalReason;
    }
    /*implementation of the abstract class in child class is mandatory because abstract */
    @Override
    public void markAttendance(){
        attendance++;
        loyaltyPoints=loyaltyPoints+5;
    }
    @Override
    public void display(){
       super.display();
       System.out.println("Plan: " + plan);
    System.out.println("Price: " + price);
    if(removalReason.length()!=0){ //removalReason is only empty when the client hasn't been removed
        System.out.println("Removal Reason"+removalReason);
    }
    }
    
}