public class PremiumMember  extends GymMember{
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    
    PremiumMember(String id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate
    ,String personalTrainer){
        super(id,name,location,phone,email,gender,DOB,membershipStartDate); //parent constructor is called first and the values are initialized
        premiumCharge=50000.0;
        paidAmount=0;
        isFullPayment=false;
        discountAmount=0.0;
        
        
    }
    public double getPremiumCharge(){
        return premiumCharge;
    }
    public String getPersonalTrainer(){
        return personalTrainer;
    }
    public boolean getIsFullPayment(){
        return isFullPayment;
    }
    public double getPaidAmount(){
        return paidAmount;
    }
    public double getDiscountAmount(){
        return discountAmount;
    }
       /*if full payment is made the method returns a statement and after that everything else becomes unreachable 
       but if the fullpayment if clause isnt triggered then only other lines are executed
       paidamount cannot be more than premium ,that means the client overpaid so refund
       else if payment is made in full then nothing left to pay 
       else some payment is due and the amount is calculated and remaining amount is given back to customer*/
 
       
    public String payDueAmount(double payment) {
    if (isFullPayment) {
        return "Payment already completed";
    }
    
    paidAmount += payment;
    
    // Check if payment completes full amount (with discount if eligible)
    double amountDue = premiumCharge - discountAmount;
    
    if (paidAmount >= amountDue) {
        isFullPayment = true;
        double change = paidAmount - amountDue;
        return change > 0 
            ? String.format("Payment complete! Refund: %.2f", change)
            : "Payment complete!";
    } else {
        return String.format("Remaining due: %.2f", amountDue - paidAmount);
    }
}
    public double calculateDiscount(){
        if(isFullPayment){
           discountAmount=0.10*premiumCharge;//logical error solved
           System.out.println("Discount has been activated");
        }
        else{
            discountAmount=0;
            System.out.println("Sorry your payment plan doesnt support discount  vouchers");//if payment isnt full no discount
        }
        return discountAmount;
    }
    public void revertPremiumMember(){
        resetMember();
        personalTrainer="";
        isFullPayment=false;  
        paidAmount=0;
        discountAmount=0;
    }
    @Override
    public void display(){
        super.display(); //first the parent class method display is called and then the child class is called
        System.out.println("Personal Trainer="+personalTrainer);
        System.out.println("Paid Amount="+paidAmount);
        System.out.println("Has the full amount been made?"+isFullPayment);
        System.out.println("Remaining amount="+(premiumCharge-this.paidAmount));
        if(isFullPayment){
         System.out.println("Discounted-Amount="+discountAmount);//discount cannot exist without full payment so if case is necessary
        }
        
    }
  
    public void markAttendance(){
        attendance++;
        loyaltyPoints=loyaltyPoints+10;
    }
    
}