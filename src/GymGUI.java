import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class GymGUI{
    private ArrayList<GymMember> members=new ArrayList<GymMember>();
    private JFrame guiFrame;
    private JLabel homeTitle, premiumTitle,idPremium,namePremium,locationPremium,phonePremium,emailPremium,
    genderPremium,membershipStartDatePremium,dobPremium,referralSourcePremium,paidAmountPremium,
    trainersNamePremium,chargePremium,discount;
    private JPanel premiumPanel,homePanel,regularPanel;
    private JTextField idPremiumTF,namePremiumTF,locationPremiumTF,phonePremiumTF,emailPremiumTF,
    referralSourcePremiumTF,paidAmountPremiumTF,trainersNamePremiumTF,chargePremiumTF,discountTF;
   
    private JButton activatePremiumMembership,deactivatePremiumMembership,discountCalculate,markPremiumAttendance,
    revertPremiumMember,displayPremium,clearPremium,payDueAmountPremium,addPremiumMember,backPremium,payDueAmount,saveToFilePremium,readFromFilePremium;
    private JComboBox dobPremiumYearComboBox,dobPremiumMonthComboBox,dobPremiumDayComboBox
    ,msPremiumYearComboBox,msPremiumMonthComboBox,msPremiumDayComboBox;
    private JRadioButton malePremiumRadioButton,femalePremiumRadioButton,othersPremiumRadioButton;
    private JButton addRegularMemberBtn, addPremiumMemberBtn;
    private JLabel  regularTitle,idRegular,nameRegular,locationRegular,phoneRegular,emailRegular,
    genderRegular,membershipStartDateRegular,dobRegular,referralSourceRegular,paidAmountRegular,
    removalReasonRegular,trainersNameRegular,chargeRegular,plan;
    private JTextField idRegularTF,nameRegularTF,locationRegularTF,phoneRegularTF,emailRegularTF,
    referralSourceRegularTF,paidAmountRegularTF,trainersNameRegularTF,chargeRegularTF;
    private JTextArea removalReasonRegularTA;
    private JButton activateRegularMembership,deactivateRegularMembership,discountRegularMaHudaina,markRegularAttendance,
    revertRegularMember,displayRegular,clearRegular,payDueAmountRegular,addRegularMember,backRegular,upgradePlan,saveToFileRegular,readFromFileRegular;
    private JComboBox dobRegularYearComboBox,dobRegularMonthComboBox,dobRegularDayComboBox
    ,msRegularYearComboBox,msRegularMonthComboBox,msRegularDayComboBox;
    private JRadioButton maleRegularRadioButton,femaleRegularRadioButton,othersRegularRadioButton;

    public GymGUI() {
        guiFrame = new JFrame("Gym Membership System");
        //loadMembersFromFile();
        guiFrame.setLayout(null);
        guiFrame.setTitle("24046543 Biplav Bhandari");
        guiFrame.setSize(800, 800);
        
        guiFrame.setResizable(false);
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //homePanel starts from here ::
        homePanel = new JPanel();
        homePanel.setLayout(null); 
        homePanel.setSize(800,800);

        homeTitle = new JLabel("Gym-Membership Form");
        homeTitle.setBounds(200, 100, 400, 50);
        homeTitle.setFont(new Font("Arial", Font.BOLD, 30));
        addRegularMemberBtn = new JButton("Regular Member");
        addRegularMemberBtn.setBounds(250, 250, 250, 50);
        addPremiumMemberBtn = new JButton("Premium Member");
        addPremiumMemberBtn.setBounds(250, 350, 250, 50);
        homePanel.add(homeTitle);
        homePanel.add(addRegularMemberBtn);
        homePanel.add(addPremiumMemberBtn);

        // Premium Panel from heree::::
        premiumPanel = new JPanel();
        premiumPanel.setLayout(null); 
        premiumPanel.setSize(800,800);
        premiumTitle = new JLabel("Premium Membership ");
        premiumTitle.setBounds(300,10,250,30);
        premiumTitle.setFont(new Font("Arial", Font.BOLD, 20));
    

        idPremium=new JLabel("Id:");
        idPremium.setBounds(50, 50, 100, 30);
        idPremiumTF=new JTextField(20);
        idPremiumTF.setBounds(150, 50, 200, 30);
        namePremium=new JLabel("Name:");
        namePremium.setBounds(50, 90, 100, 30);
        namePremiumTF=new JTextField(20);
        namePremiumTF.setBounds(150, 90, 200, 30);
        locationPremium=new JLabel("Location");
        locationPremium.setBounds(50, 130, 100, 30);
        locationPremiumTF=new JTextField(20);
        locationPremiumTF.setBounds(150, 130, 200, 30);
        phonePremium = new JLabel("Phone ");
        phonePremium.setBounds(50, 170, 100, 30);
        phonePremiumTF=new JTextField(20);
       phonePremiumTF.setBounds(150, 170, 200, 30);
        emailPremium=new JLabel("Email");
        emailPremium.setBounds(50, 210, 100, 30);
        emailPremiumTF=new JTextField(20);
        emailPremiumTF.setBounds(150, 210, 200, 30); 
        genderPremium=new JLabel("Gender");
        genderPremium.setBounds(50, 250, 100, 30);
        malePremiumRadioButton=new JRadioButton("Male");
        malePremiumRadioButton.setBounds(150, 250, 60, 30); 
        femalePremiumRadioButton=new JRadioButton("Female");
        femalePremiumRadioButton.setBounds(220, 250, 70, 30);
        othersPremiumRadioButton=new JRadioButton("Others");
        othersPremiumRadioButton.setBounds(300, 250, 80, 30); 
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(malePremiumRadioButton);
        genderGroup.add(femalePremiumRadioButton);
        genderGroup.add(othersPremiumRadioButton);

        dobPremium= new JLabel("DOB:");
        dobPremium.setBounds(50, 290, 100, 30);
        String[] years =new String[35];
        for(int i=0;i<35;i++){
            years[i]=String.valueOf(1990+i);
        }
        String[] months= {"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
        String[] dates=new String[31];
        for(int i=0;i<31;i++){
            dates[i]=String.valueOf(i+1);
        }
        dobPremiumYearComboBox=new JComboBox<>(years);
        dobPremiumYearComboBox.setBounds(150, 290, 80, 30);
        dobPremiumMonthComboBox=new JComboBox<>(months);
        dobPremiumMonthComboBox.setBounds(240, 290, 90, 30);
        dobPremiumDayComboBox=new JComboBox<>(dates);
        dobPremiumDayComboBox.setBounds(340, 290, 80, 30);  

        membershipStartDatePremium = new JLabel("Membership Start Date:");
       membershipStartDatePremium.setBounds(50, 330, 180, 30);

        msPremiumYearComboBox = new JComboBox<>(years);
       msPremiumYearComboBox.setBounds(200, 330, 80, 30);

        msPremiumMonthComboBox = new JComboBox<>(months);
        msPremiumMonthComboBox.setBounds(290, 330, 90, 30); 

        msPremiumDayComboBox = new JComboBox<>(dates);
        msPremiumDayComboBox.setBounds(390, 330, 80, 30);  

        referralSourcePremium = new JLabel("Referral Source");
        referralSourcePremium.setBounds(450, 50, 150, 30);  
        referralSourcePremiumTF = new JTextField(20);
        referralSourcePremiumTF.setBounds(550, 50, 200, 30); 

        paidAmountPremium = new JLabel("Paid-Amount");
        paidAmountPremium.setBounds(450, 90, 150, 30);  
        paidAmountPremiumTF = new JTextField(20);
      paidAmountPremiumTF.setBounds(550, 90, 200, 30);   

        chargePremium = new JLabel("Plan-Charge");
        chargePremium.setBounds(400, 130, 150, 30);
        chargePremiumTF = new JTextField("1000", 20);
        chargePremiumTF.setEditable(false);
        chargePremiumTF.setBounds(550, 130, 200, 30);   

        discount = new JLabel("Discount");
        discount.setBounds(400, 170, 150, 30);   
        discountTF = new JTextField("200", 20);
        discountTF.setEditable(false);
        discountTF.setBounds(550, 170, 200, 30); 
        trainersNamePremium = new JLabel("Trainers-Name");
        trainersNamePremium.setBounds(400, 210, 150, 30); 
        trainersNamePremiumTF = new JTextField(20);
       trainersNamePremiumTF.setBounds(550, 210, 200, 30);  

        //removalReasonPremium = new JLabel("RemovalReason");
        //removalReasonPremium.setBounds(50, 400, 150, 30); 

        //removalReasonPremiumTA = new JTextArea(19, 20);
        //removalReasonPremiumTA.setBounds(150, 400, 600, 60); 

        //removalReasonPremiumTA.setLineWrap(true);  
        //removalReasonPremiumTA.setWrapStyleWord(true);  

        activatePremiumMembership = new JButton("Activate Member");
        activatePremiumMembership.setBounds(100, 510, 150, 30);  

        deactivatePremiumMembership = new JButton("Deactivate Member");
       deactivatePremiumMembership.setBounds(300, 510, 150, 30); 

        discountCalculate = new JButton("Discount");
      discountCalculate.setBounds(500, 510, 150, 30); 

        markPremiumAttendance = new JButton("Mark Attendance");
       markPremiumAttendance.setBounds(100, 550, 150, 30);  

        revertPremiumMember = new JButton("Revert Membership");
        revertPremiumMember.setBounds(300, 550, 150, 30); 

        displayPremium = new JButton("Display");
      displayPremium.setBounds(500, 550, 150, 30);  

        clearPremium = new JButton("Clear");
       clearPremium.setBounds(100, 590, 150, 30); 

        addPremiumMember = new JButton("Add P.Member");
        addPremiumMember.setBounds(300, 590, 150, 30);    

        backPremium = new JButton("Back");
       backPremium.setBounds(500, 590, 150, 30); 
        payDueAmount=new JButton("Pay Due Amount");
       payDueAmount.setBounds(100, 630, 150, 30); 
        saveToFilePremium = new JButton("Save");
       saveToFilePremium.setBounds(300, 630, 150, 30); 

        readFromFilePremium = new JButton("Read From File");
       readFromFilePremium.setBounds(500, 630, 150, 30); 

        premiumPanel.add(premiumTitle);
        premiumPanel.add(idPremium);
        premiumPanel.add(idPremiumTF);
        premiumPanel.add(namePremium);
        premiumPanel.add(namePremiumTF);

        premiumPanel.add(locationPremium);
        premiumPanel.add(locationPremiumTF);
        premiumPanel.add(phonePremium);
        premiumPanel.add(phonePremiumTF);

        premiumPanel.add(emailPremium);
        premiumPanel.add(emailPremiumTF);

        premiumPanel.add(genderPremium);
        premiumPanel.add(malePremiumRadioButton);
        premiumPanel.add(femalePremiumRadioButton);
        premiumPanel.add(othersPremiumRadioButton);
        premiumPanel.add(dobPremium);
        premiumPanel.add(dobPremiumYearComboBox);
        premiumPanel.add(dobPremiumMonthComboBox);
        premiumPanel.add(dobPremiumDayComboBox);
        premiumPanel.add(membershipStartDatePremium);
        premiumPanel.add(msPremiumYearComboBox);
        premiumPanel.add(msPremiumMonthComboBox);
        premiumPanel.add(msPremiumDayComboBox);
        premiumPanel.add(referralSourcePremium);
        premiumPanel.add(referralSourcePremiumTF);
        premiumPanel.add(paidAmountPremium);
        premiumPanel.add(paidAmountPremiumTF);
        premiumPanel.add(chargePremium);
        premiumPanel.add(chargePremiumTF);
        premiumPanel.add(discount);
        premiumPanel.add(discountTF);
        premiumPanel.add(trainersNamePremium);
        premiumPanel.add(trainersNamePremiumTF);
        //premiumPanel.add(removalReasonPremium);
        //premiumPanel.add(removalReasonPremiumTA);
        premiumPanel.add(activatePremiumMembership);
        premiumPanel.add(deactivatePremiumMembership);
        premiumPanel.add(discountCalculate);
        premiumPanel.add(markPremiumAttendance);
        premiumPanel.add(revertPremiumMember);
        premiumPanel.add(displayPremium);
        premiumPanel.add(clearPremium);
        premiumPanel.add(addPremiumMember);
        premiumPanel.add(backPremium);
        premiumPanel.add(payDueAmount);
        premiumPanel.add(saveToFilePremium);
        premiumPanel.add(readFromFilePremium);

        guiFrame.add(homePanel);
        guiFrame.add(premiumPanel);
        homePanel.setVisible(true);
        premiumPanel.setVisible(false);

        //homePanel buttons
        addPremiumMemberBtn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    homePanel.setVisible(false);
                    regularPanel.setVisible(false);
                    premiumPanel.setVisible(true);

                }
            });
        backPremium.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed (ActionEvent e){
                    homePanel.setVisible(true);
                    regularPanel.setVisible(false);
                    premiumPanel.setVisible(false);

                }

            }
        );
       
        activatePremiumMembership.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idPremiumTF.getText().trim();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(premiumPanel, "Please enter a member ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (GymMember member : members) {
                    if (member.getId().equals(id)) {
                        member.activateMembership();
                        JOptionPane.showMessageDialog(premiumPanel, "Membership activated for: " + member.getName(), 
                                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(premiumPanel, "Member not found with ID: " + id, 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
       deactivatePremiumMembership.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idPremiumTF.getText().trim();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(premiumPanel, "Please enter a member ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (GymMember member : members) {
                    if (member.getId().equals(id)) {
                        boolean result = member.deactivateMembership();
                        if (result) {
                            JOptionPane.showMessageDialog(premiumPanel, "Membership deactivated for: " + member.getName(), 
                                                        "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(premiumPanel, "Membership was already inactive for: " + member.getName(), 
                                                        "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(premiumPanel, "Member not found with ID: " + id, 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

       markPremiumAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idPremiumTF.getText().trim();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(premiumPanel, "Please enter a member ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (GymMember member : members) {
                    if (member.getId().equals(id)) {
                        if (!member.getActiveStatus()) {
                            JOptionPane.showMessageDialog(premiumPanel, "Cannot mark attendance for inactive member", 
                                                        "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        member.markAttendance();
                        JOptionPane.showMessageDialog(premiumPanel, "Attendance marked for: " + member.getName(), 
                                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(premiumPanel, "Member not found with ID: " + id, 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        revertPremiumMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idPremiumTF.getText().trim();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(premiumPanel, "Please enter a member ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (int i = 0; i < members.size(); i++) {
                    GymMember member = members.get(i);
                    if (member.getId().equals(id) && member instanceof PremiumMember) {
                        ((PremiumMember)member).revertPremiumMember();
                        members.remove(i);
                        JOptionPane.showMessageDialog(premiumPanel, "Premium member reverted and removed: " + member.getName(), 
                                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        
                        // Clear fields
                        idPremiumTF.setText("");
                        namePremiumTF.setText("");
                        locationPremiumTF.setText("");
                        phonePremiumTF.setText("");
                        emailPremiumTF.setText("");
                        referralSourcePremiumTF.setText("");
                        paidAmountPremiumTF.setText("");
                        trainersNamePremiumTF.setText("");
                        
                        malePremiumRadioButton.setSelected(false);
                        femalePremiumRadioButton.setSelected(false);
                        othersPremiumRadioButton.setSelected(false);
                        
                        dobPremiumYearComboBox.setSelectedIndex(0);
                        dobPremiumMonthComboBox.setSelectedIndex(0);
                        dobPremiumDayComboBox.setSelectedIndex(0);
                        
                        msPremiumYearComboBox.setSelectedIndex(0);
                        msPremiumMonthComboBox.setSelectedIndex(0);
                        msPremiumDayComboBox.setSelectedIndex(0);
                        
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(premiumPanel, "Premium member not found with ID: " + id, 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        displayPremium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (members.isEmpty()) {
                    JOptionPane.showMessageDialog(premiumPanel, "No members to display", "Info", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                StringBuilder sb = new StringBuilder();
                sb.append("Premium Members:\n\n");
                
                for (GymMember member : members) {
                    if (member instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) member;
                        sb.append("ID: ").append(pm.getId()).append("\n");
                        sb.append("Name: ").append(pm.getName()).append("\n");
                        sb.append("Location: ").append(pm.getLocation()).append("\n");
                        sb.append("Phone: ").append(pm.getPhone()).append("\n");
                        sb.append("Email: ").append(pm.getEmail()).append("\n");
                        sb.append("Trainer: ").append(pm.getPersonalTrainer()).append("\n");
                        sb.append("Paid Amount: ").append(pm.getPaidAmount()).append("\n");
                        sb.append("Active: ").append(pm.getActiveStatus()).append("\n");
                        sb.append("----------------------------\n");
                    }
                }
                
                JTextArea textArea = new JTextArea(sb.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400));
                
                JOptionPane.showMessageDialog(premiumPanel, scrollPane, "Premium Members", JOptionPane.INFORMATION_MESSAGE);
            }
        });

       clearPremium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idPremiumTF.setText("");
                namePremiumTF.setText("");
                locationPremiumTF.setText("");
                phonePremiumTF.setText("");
                emailPremiumTF.setText("");
                referralSourcePremiumTF.setText("");
                paidAmountPremiumTF.setText("");
                trainersNamePremiumTF.setText("");
                
                malePremiumRadioButton.setSelected(false);
                femalePremiumRadioButton.setSelected(false);
                othersPremiumRadioButton.setSelected(false);
                
                dobPremiumYearComboBox.setSelectedIndex(0);
                dobPremiumMonthComboBox.setSelectedIndex(0);
                dobPremiumDayComboBox.setSelectedIndex(0);
                
                msPremiumYearComboBox.setSelectedIndex(0);
                msPremiumMonthComboBox.setSelectedIndex(0);
                msPremiumDayComboBox.setSelectedIndex(0);
            }
        });
        addPremiumMember .addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    try{
                        String id =idPremiumTF.getText();
                        String name=namePremiumTF.getText();
                        String email=emailPremiumTF.getText();
                        String location=locationPremiumTF.getText();
                        String phone =phonePremiumTF.getText();
                        String referralSource=referralSourcePremium.getText();
                        String paidAmount=paidAmountPremium.getText();
                        String trainersName=trainersNamePremium.getText();
                       
                        String dobYear =(String)dobPremiumYearComboBox.getSelectedItem(); 
                        String dobMonth=(String)dobPremiumMonthComboBox.getSelectedItem();
                        String dobDay=(String)dobPremiumDayComboBox.getSelectedItem();
                        String dob = dobYear + "-" + dobMonth + "-" + dobDay;

                        String msYear = (String) msPremiumYearComboBox.getSelectedItem();
                        String msMonth = (String) msPremiumMonthComboBox.getSelectedItem();
                        String msDay = (String) msPremiumDayComboBox.getSelectedItem();
                        String membershipStartDate = msYear + "-" + msMonth + "-" + msDay;
                        String gender = malePremiumRadioButton.isSelected()?"Male":femalePremiumRadioButton.isSelected()?"Female":othersPremiumRadioButton.isSelected()?"Other":"Not Selected";

                        // Validation for empty fields
                        if (id.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() ||trainersName.isEmpty()|| 
                        paidAmount.isEmpty() || dobYear == null || dobMonth == null|| dobDay == null || msYear == null || 
                        msMonth == null || msDay == null ) {
                            JOptionPane.showMessageDialog(premiumPanel, "Please fill out all the fields." , "Missing Information", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        //Check for duplicate member ID using for each loop

                        for (GymMember m : members){
                            if(m.getId().equals(id)){
                                JOptionPane.showMessageDialog(guiFrame, "Member ID already exists!", "duplicate ID", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                        PremiumMember prem =new PremiumMember(id,name,location,phone,email,gender,dob,membershipStartDate,trainersName);
                        members.add(prem);
                        JOptionPane.showMessageDialog(premiumPanel,"Member Added Successfully","Confirmation ",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(premiumPanel,"must be a valid number ","INVALID ENTRY",JOptionPane.ERROR_MESSAGE);

                    }
                }

            }); 
discountCalculate.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String id = idPremiumTF.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(premiumPanel, "Enter member ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (GymMember member : members) {
            if (member.getId().equals(id) && member instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) member;
                double discount = pm.calculateDiscount();
                
                // Update GUI and show message
                discountTF.setText(String.valueOf(discount));
                if (pm.getIsFullPayment()) {
                    JOptionPane.showMessageDialog(premiumPanel, 
                        "10% discount applied: " + discount,
                        "Discount", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(premiumPanel,
                        "No discount available. Pay in full first.",
                        "Discount", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(premiumPanel, "Member not found", "Error", JOptionPane.ERROR_MESSAGE);
    }
});
payDueAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idPremiumTF.getText().trim();
                String amountStr = paidAmountPremiumTF.getText().trim();
                
                if (id.isEmpty() || amountStr.isEmpty()) {
                    JOptionPane.showMessageDialog(premiumPanel, "Please enter member ID and amount", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(premiumPanel, "Amount must be positive", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    for (GymMember member : members) {
                        if (member.getId().equals(id) && member instanceof PremiumMember) {
                            PremiumMember pm = (PremiumMember) member;
                            String result = pm.payDueAmount(amount);
                            JOptionPane.showMessageDialog(premiumPanel, result, "Payment", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    
                    JOptionPane.showMessageDialog(premiumPanel, "Premium member not found with ID: " + id, 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(premiumPanel, "Invalid amount format", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

// Save Premium Members to file when saveToFilePremium button is pressed
saveToFilePremium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PrintWriter writer = new PrintWriter(new FileWriter("MemberDetails.txt"))) {
                    writer.println("Premium Members:");
                    writer.println(String.format("%-10s %-20s %-15s %-15s %-25s %-15s %-15s %-10s %-15s %-15s", 
                        "ID", "Name", "Location", "Phone", "Email", "Trainer", "Paid Amount", "Active", "Discount", "Full Payment"));
                    
                    for (GymMember member : members) {
                        if (member instanceof PremiumMember) {
                            PremiumMember pm = (PremiumMember) member;
                            writer.println(String.format("%-10s %-20s %-15s %-15s %-25s %-15s %-15.2f %-10s %-15.2f %-15s", 
                                pm.getId(), pm.getName(), pm.getLocation(), pm.getPhone(), pm.getEmail(), 
                                pm.getPersonalTrainer(), pm.getPaidAmount(), pm.getActiveStatus(), 
                                pm.getDiscountAmount(), pm.getIsFullPayment()));
                        }
                    }
                    
                    JOptionPane.showMessageDialog(premiumPanel, "Premium members saved to file successfully", 
                                                "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(premiumPanel, "Error saving to file: " + ex.getMessage(), 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

 readFromFilePremium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    boolean inPremiumSection = false;
                    
                    while ((line = reader.readLine()) != null) {
                        if (line.equals("Premium Members:")) {
                            inPremiumSection = true;
                            content.append(line).append("\n");
                            // Read and append the header line
                            content.append(reader.readLine()).append("\n");
                            continue;
                        }
                        
                        if (inPremiumSection) {
                            if (line.isEmpty()) break; // End of section
                            content.append(line).append("\n");
                        }
                    }
                    
                    if (content.length() > 0) {
                        JTextArea textArea = new JTextArea(content.toString());
                        textArea.setEditable(false);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(800, 400));
                        JOptionPane.showMessageDialog(premiumPanel, scrollPane, "Premium Members from File", 
                                                    JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(premiumPanel, "No premium member data found in file", 
                                                    "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(premiumPanel, "Error reading from file: " + ex.getMessage(), 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        //regular Panel starts from here:::::
        regularPanel = new JPanel();
        regularPanel.setLayout(null); 
        regularPanel.setSize(800,800);
        regularTitle = new JLabel("Regular Member");
       regularTitle.setBounds(250, 10, 300, 30); 
        regularTitle.setFont(new Font("Arial", Font.BOLD, 20));
        
        idRegular=new JLabel("Id:");
        idRegular.setBounds(50, 50, 100, 30);
        idRegularTF=new JTextField(20);
        idRegularTF.setBounds(150, 50, 200, 30);
        nameRegular=new JLabel("Name:");
        nameRegular.setBounds(50, 90, 100, 30);
        nameRegularTF=new JTextField(20);
        nameRegularTF.setBounds(150, 90, 200, 30);
        locationRegular=new JLabel("Location");
        locationRegular.setBounds(50, 130, 100, 30);
        locationRegularTF=new JTextField(20);
        locationRegularTF.setBounds(150, 130, 200, 30);
        phoneRegular = new JLabel("Phone ");
        phoneRegular.setBounds(50, 170, 100, 30);
        phoneRegularTF=new JTextField(20);
        phoneRegularTF.setBounds(150, 170, 200, 30); 
        emailRegular=new JLabel("Email");
        emailRegular.setBounds(50, 210, 100, 30);
        emailRegularTF=new JTextField(20);
        emailRegularTF.setBounds(150, 210, 200, 30);
        genderRegular=new JLabel("Gender");
        genderRegular.setBounds(50, 250, 100, 30);
        maleRegularRadioButton=new JRadioButton("Male");
        maleRegularRadioButton.setBounds(150, 250, 100, 30);
        femaleRegularRadioButton=new JRadioButton("Female");
        femaleRegularRadioButton.setBounds(250, 250, 100, 30);
        othersRegularRadioButton=new JRadioButton("Others");
        othersRegularRadioButton.setBounds(350, 250, 100, 30);
        ButtonGroup genderGroupRegular=new ButtonGroup();
        genderGroupRegular.add(maleRegularRadioButton);
        genderGroupRegular.add(femaleRegularRadioButton);
        genderGroupRegular.add(othersRegularRadioButton);
        dobRegular= new JLabel("DOB:");
        dobRegular.setBounds(50, 300, 100, 30); 
        dobRegularYearComboBox=new JComboBox<>(years);
        dobRegularYearComboBox.setBounds(150, 300, 80, 30);
        dobRegularMonthComboBox=new JComboBox<>(months);
       dobRegularMonthComboBox.setBounds(260, 300, 90, 30); 
        dobRegularDayComboBox=new JComboBox<>(dates);
        dobRegularDayComboBox.setBounds(370, 300, 80, 30);  

        membershipStartDateRegular = new JLabel("Membership Start Date:");
      membershipStartDateRegular.setBounds(50, 350, 200, 30);

        msRegularYearComboBox = new JComboBox<>(years);
        msRegularYearComboBox.setBounds(200, 350, 80, 30); 

        msRegularMonthComboBox = new JComboBox<>(months);
       msRegularMonthComboBox.setBounds(310, 350, 90, 30); 

        msRegularDayComboBox = new JComboBox<>(dates);
        msRegularDayComboBox.setBounds(420, 350, 80, 30);      
        referralSourceRegular = new JLabel("Referral Source");
        referralSourceRegular.setBounds(400, 50, 150, 30);  
        referralSourceRegularTF = new JTextField(20);
        referralSourceRegularTF.setBounds(550, 50, 200, 30); 

        paidAmountRegular = new JLabel("Paid-Amount");
        paidAmountRegular.setBounds(400, 90, 150, 30);  
        paidAmountRegularTF = new JTextField(20);
       paidAmountRegularTF.setBounds(550, 90, 200, 30);  

        chargeRegular = new JLabel("Plan-Charge");
        chargeRegular.setBounds(400, 130, 150, 30);
        chargeRegularTF = new JTextField("6500", 20);
        chargeRegularTF.setEditable(false);
        chargeRegularTF.setBounds(550, 130, 200, 30);  

        trainersNameRegular = new JLabel("Trainers-Name");
        trainersNameRegular.setBounds(400, 210, 150, 30); 
        trainersNameRegularTF = new JTextField(20);
        trainersNameRegularTF.setBounds(550, 210, 200, 30);  

        removalReasonRegular = new JLabel("RemovalReason");
        removalReasonRegular.setBounds(50, 400, 150, 30); 

        removalReasonRegularTA = new JTextArea(19, 20);
        removalReasonRegularTA.setBounds(150, 400, 600, 60); 

        removalReasonRegularTA.setLineWrap(true);  
        removalReasonRegularTA.setWrapStyleWord(true);  
        activateRegularMembership = new JButton("Activate Member");
       activateRegularMembership.setBounds(100, 510, 150, 30);

        deactivateRegularMembership = new JButton("Deactivate Member");
      deactivateRegularMembership.setBounds(300, 510, 150, 30); 
        upgradePlan  =new JButton("Upgrade Plan");
        upgradePlan.setBounds(500, 510, 150, 30);  

        //discountCalculate = new JButton("Discount");
        //discountCalculate.setBounds(520, 510, 150, 30); 
        String[] plans = {"basic", "standard", "deluxe"};
        plan= new JLabel("Plan");
        plan.setBounds(490,300,250,30);
        JComboBox planCombo= new JComboBox<>(plans);
       planCombo.setBounds(540, 300, 140, 30);  

        markRegularAttendance = new JButton("Mark Attendance");
        markRegularAttendance.setBounds(100, 550, 150, 30); 

        revertRegularMember = new JButton("Revert Membership");
       revertRegularMember.setBounds(300, 550, 150, 30); 

        displayRegular = new JButton("Display");
        displayRegular.setBounds(500, 550, 150, 30);  
        clearRegular = new JButton("Clear");
       clearRegular.setBounds(100, 590, 150, 30);

        addRegularMember = new JButton("Add R.Member");
       addRegularMember.setBounds(300, 590, 150, 30); 
        saveToFileRegular=new JButton("Save To file");
        saveToFileRegular.setBounds(200, 640, 200, 30); 
        
        readFromFileRegular=new JButton("Read From File");
       readFromFileRegular.setBounds(420, 640, 200, 30); 

        backRegular = new JButton("Back");
        backRegular.setBounds(500, 590, 150, 30); 
        regularPanel.add(regularTitle);
        regularPanel.add(idRegular);
        regularPanel.add(idRegularTF);
        regularPanel.add(nameRegular);
        regularPanel.add(nameRegularTF);

        regularPanel.add(locationRegular);
        regularPanel.add(locationRegularTF);
        regularPanel.add(phoneRegular);
        regularPanel.add(phoneRegularTF);

        regularPanel.add(emailRegular);
        regularPanel.add(emailRegularTF);

        regularPanel.add(genderRegular);
        regularPanel.add(maleRegularRadioButton);
        regularPanel.add(femaleRegularRadioButton);
        regularPanel.add(othersRegularRadioButton);
        regularPanel.add(dobRegular);
        regularPanel.add(dobRegularYearComboBox);
        regularPanel.add(dobRegularMonthComboBox);
        regularPanel.add(dobRegularDayComboBox);
        regularPanel.add(membershipStartDateRegular);
        regularPanel.add(msRegularYearComboBox);
        regularPanel.add(msRegularMonthComboBox);
        regularPanel.add(msRegularDayComboBox);
        regularPanel.add(referralSourceRegular);
        regularPanel.add(referralSourceRegularTF);
        regularPanel.add(paidAmountRegular);
        regularPanel.add(paidAmountRegularTF);
        regularPanel.add(chargeRegular);
        regularPanel.add(chargeRegularTF);
        regularPanel.add(plan);
        regularPanel.add(planCombo);
        regularPanel.add(trainersNameRegular);
        regularPanel.add(trainersNameRegularTF);
        regularPanel.add(removalReasonRegular);
        regularPanel.add(removalReasonRegularTA);
        regularPanel.add(activateRegularMembership);
        regularPanel.add(deactivateRegularMembership);
        //regularPanel.add(discountCalculate);
        regularPanel.add(markRegularAttendance);
        regularPanel.add(upgradePlan);
        regularPanel.add(revertRegularMember);
        regularPanel.add(displayRegular);
        regularPanel.add(clearRegular);
        regularPanel.add(addRegularMember);
        regularPanel.add(backRegular);
        regularPanel.add(saveToFileRegular);
        regularPanel.add(readFromFileRegular);

        guiFrame.add(regularPanel);
        regularPanel.setVisible(false);


      
        //Regular Buttons:
        addRegularMemberBtn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    homePanel.setVisible(false);
                    premiumPanel.setVisible(false);
                    regularPanel.setVisible(true);

                }
            });
        backRegular.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed (ActionEvent e){
                    homePanel.setVisible(true);
                    regularPanel.setVisible(false);
                    premiumPanel.setVisible(false);

                }

            }
        );
        addRegularMember .addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    try{
                        String id =idRegularTF.getText();
                        String name=nameRegularTF.getText();
                        String email=emailRegularTF.getText();
                        String location=locationRegularTF.getText();
                        String phone =phoneRegularTF.getText();
                        String referralSource=referralSourceRegular.getText();
                        String paidAmount=paidAmountRegular.getText();
                        //String trainersName=trainersNamePremium.getText();

                        String dobYear =(String)dobRegularYearComboBox.getSelectedItem(); 
                        String dobMonth=(String)dobRegularMonthComboBox.getSelectedItem();
                        String dobDay=(String)dobRegularDayComboBox.getSelectedItem();
                        String dob = dobYear + "-" + dobMonth + "-" + dobDay;

                        String msYear = (String) msRegularYearComboBox.getSelectedItem();
                        String msMonth = (String) msRegularMonthComboBox.getSelectedItem();
                        String msDay = (String) msRegularDayComboBox.getSelectedItem();
                        String membershipStartDate = msYear + "-" + msMonth + "-" + msDay;
                        String gender = maleRegularRadioButton.isSelected()?"Male":femaleRegularRadioButton.isSelected()?"Female":othersRegularRadioButton.isSelected()?"Other":"Not Selected";

                        // Validation for empty fields
                        if (id.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() || 
                        paidAmount.isEmpty() || dobYear == null || dobMonth == null|| dobDay == null || msYear == null || 
                        msMonth == null || msDay == null ) {
                            JOptionPane.showMessageDialog(regularPanel, "Please fill out all the fields." , "Missing Information", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        //Check for duplicate member ID using for each loop

                        for (GymMember m : members){
                            if(m.getId().equals(id)){
                                JOptionPane.showMessageDialog(guiFrame, "Member ID already exists!", "duplicate ID", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                        RegularMember prem =new RegularMember(id,name,location,phone,email,gender,dob,membershipStartDate,referralSource);
                        members.add(prem);
                        prem.activateMembership();
                        JOptionPane.showMessageDialog(premiumPanel,"Member Added Successfully","Confirmation ",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(premiumPanel,"must be a valid number ","INVALID ENTRY",JOptionPane.ERROR_MESSAGE);

                    }
                }

            }); 
        clearRegular.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    idRegularTF.setText("");
                    nameRegularTF.setText("");
                    locationRegularTF.setText("");
                    phoneRegularTF.setText("");
                    emailRegularTF.setText("");
                    maleRegularRadioButton.setSelected(false);
                    femaleRegularRadioButton.setSelected(false);
                    othersRegularRadioButton.setSelected(false);
                    referralSourceRegularTF.setText("");
                    removalReasonRegularTA.setText("");
                    trainersNameRegularTF.setText("");
                    dobRegularYearComboBox.setSelectedIndex(0);
                    dobRegularMonthComboBox.setSelectedIndex(0);
                    dobRegularDayComboBox.setSelectedIndex(0);
                    msRegularYearComboBox.setSelectedIndex(0);
                    msRegularMonthComboBox.setSelectedIndex(0);
                    msRegularDayComboBox.setSelectedIndex(0);

                }
            });
         activateRegularMembership.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idRegularTF.getText().trim();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(regularPanel, "Please enter a member ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (GymMember member : members) {
                    if (member.getId().equals(id)) {
                        member.activateMembership();
                        JOptionPane.showMessageDialog(regularPanel, "Membership activated for: " + member.getName(), 
                                                      "Success", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(regularPanel, "Member not found with ID: " + id, 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        deactivateRegularMembership.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idRegularTF.getText().trim();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(regularPanel, "Please enter a member ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (GymMember member : members) {
                    if (member.getId().equals(id)) {
                        boolean result = member.deactivateMembership();
                        if (result) {
                            JOptionPane.showMessageDialog(regularPanel, "Membership deactivated for: " + member.getName(), 
                                                          "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(regularPanel, "Membership was already inactive for: " + member.getName(), 
                                                          "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(regularPanel, "Member not found with ID: " + id, 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
 markRegularAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idRegularTF.getText().trim();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(regularPanel, "Please enter a member ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (GymMember member : members) {
                    if (member.getId().equals(id)) {
                        if (!member.getActiveStatus()) {
                            JOptionPane.showMessageDialog(regularPanel, "Cannot mark attendance for inactive member", 
                                                        "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        member.markAttendance();
                        JOptionPane.showMessageDialog(regularPanel, "Attendance marked for: " + member.getName(), 
                                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(regularPanel, "Member not found with ID: " + id, 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

     revertRegularMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idRegularTF.getText().trim();
                String removalReason = removalReasonRegularTA.getText().trim();
                
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(regularPanel, "Please enter a member ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (removalReason.isEmpty()) {
                    JOptionPane.showMessageDialog(regularPanel, "Please enter a removal reason", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (int i = 0; i < members.size(); i++) {
                    GymMember member = members.get(i);
                    if (member.getId().equals(id) && member instanceof RegularMember) {
                        ((RegularMember)member).revertRegularMember(removalReason);
                        members.remove(i);
                        JOptionPane.showMessageDialog(regularPanel, "Regular member reverted and removed: " + member.getName(), 
                                                      "Success", JOptionPane.INFORMATION_MESSAGE);
                        
                        // Clear fields
                        idRegularTF.setText("");
                        nameRegularTF.setText("");
                        locationRegularTF.setText("");
                        phoneRegularTF.setText("");
                        emailRegularTF.setText("");
                        referralSourceRegularTF.setText("");
                        removalReasonRegularTA.setText("");
                        
                        maleRegularRadioButton.setSelected(false);
                        femaleRegularRadioButton.setSelected(false);
                        othersRegularRadioButton.setSelected(false);
                        
                        dobRegularYearComboBox.setSelectedIndex(0);
                        dobRegularMonthComboBox.setSelectedIndex(0);
                        dobRegularDayComboBox.setSelectedIndex(0);
                        
                        msRegularYearComboBox.setSelectedIndex(0);
                        msRegularMonthComboBox.setSelectedIndex(0);
                        msRegularDayComboBox.setSelectedIndex(0);
                        
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(regularPanel, "Regular member not found with ID: " + id, 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
         displayRegular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (members.isEmpty()) {
                    JOptionPane.showMessageDialog(regularPanel, "No members to display", "Info", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                StringBuilder sb = new StringBuilder();
                sb.append("Regular Members:\n\n");
                
                for (GymMember member : members) {
                    if (member instanceof RegularMember) {
                        RegularMember rm = (RegularMember) member;
                        sb.append("ID: ").append(rm.getId()).append("\n");
                        sb.append("Name: ").append(rm.getName()).append("\n");
                        sb.append("Location: ").append(rm.getLocation()).append("\n");
                        sb.append("Phone: ").append(rm.getPhone()).append("\n");
                        sb.append("Email: ").append(rm.getEmail()).append("\n");
                        sb.append("Referral Source: ").append(rm.getReferralSource()).append("\n");
                        sb.append("Plan: ").append(rm.getPlan()).append("\n");
                        sb.append("Price: ").append(rm.getPrice()).append("\n");
                        sb.append("Active: ").append(rm.getActiveStatus()).append("\n");
                        sb.append("----------------------------\n");
                    }
                }
                
                JTextArea textArea = new JTextArea(sb.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400));
                
                JOptionPane.showMessageDialog(regularPanel, scrollPane, "Regular Members", JOptionPane.INFORMATION_MESSAGE);
            }
        });
       upgradePlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idRegularTF.getText().trim();
                String selectedPlan = (String) planCombo.getSelectedItem();
                
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(regularPanel, "Please enter a member ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                for (GymMember member : members) {
                    if (member.getId().equals(id) && member instanceof RegularMember) {
                        RegularMember rm = (RegularMember) member;
                        String result = rm.upgradePlan(selectedPlan);
                        JOptionPane.showMessageDialog(regularPanel, result, "Plan Upgrade", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(regularPanel, "Regular member not found with ID: " + id, 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
// Update the saveToFileRegular action listener
saveToFileRegular.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // First read existing content
            StringBuilder fileContent = new StringBuilder();
            File file = new File("MemberDetails.txt");
            
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        fileContent.append(line).append("\n");
                    }
                }
            }
            
            // Find where to insert regular members
            int insertPosition = fileContent.indexOf("REGULAR MEMBER DETAILS");
            if (insertPosition == -1) {
                // No existing regular section - create new one at end
                fileContent.append("\nREGULAR MEMBER DETAILS\n");
                fileContent.append("--------------------------------------------------\n");
                fileContent.append(String.format("%-10s | %-20s | %-15s | %-15s | %-25s | %-15s | %-10s | %-10s | %-10s\n", 
                    "ID", "Name", "Location", "Phone", "Email", "Referral", "Plan", "Price", "Active"));
                fileContent.append("--------------------------------------------------\n");
            } else {
                // Remove existing regular section to replace it
                int endPosition = fileContent.indexOf("PREMIUM MEMBER DETAILS", insertPosition);
                if (endPosition == -1) {
                    endPosition = fileContent.length();
                }
                fileContent.delete(insertPosition, endPosition);
            }
            
            // Add current regular members
            StringBuilder regularContent = new StringBuilder();
            regularContent.append("REGULAR MEMBER DETAILS\n");
            regularContent.append("--------------------------------------------------\n");
            regularContent.append(String.format("%-10s | %-20s | %-15s | %-15s | %-25s | %-15s | %-10s | %-10s | %-10s\n", 
                "ID", "Name", "Location", "Phone", "Email", "Referral", "Plan", "Price", "Active"));
            regularContent.append("--------------------------------------------------\n");
            
            for (GymMember member : members) {
                if (member instanceof RegularMember) {
                    RegularMember rm = (RegularMember) member;
                    regularContent.append(String.format("%-10s | %-20s | %-15s | %-15s | %-25s | %-15s | %-10s | %-10.2f | %-10s\n", 
                        rm.getId(), rm.getName(), rm.getLocation(), rm.getPhone(), rm.getEmail(), 
                        rm.getReferralSource(), rm.getPlan(), rm.getPrice(), rm.getActiveStatus()));
                }
            }
            
            // Insert the regular section at the beginning
            fileContent.insert(0, regularContent.toString());
            
            // Write the complete content back to file
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                writer.print(fileContent.toString());
            }
            
            JOptionPane.showMessageDialog(regularPanel, "Regular members saved successfully", 
                                        "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(regularPanel, "Error saving members: " + ex.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
readFromFileRegular.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            boolean inRegularSection = false;
            
            content.append("=== REGULAR MEMBERS ===\n\n");
            
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("REGULAR MEMBER DETAILS")) {
                    inRegularSection = true;
                    
                    reader.readLine(); 
                    reader.readLine(); 
                    reader.readLine();
                    continue;
                }
                
                if (inRegularSection) {
                    if (line.trim().isEmpty() || line.contains("PREMIUM MEMBER DETAILS")) {
                        break;
                    }
                    content.append(line).append("\n");
                }
            }
            
            if (content.length() > 10) { 
                JTextArea textArea = new JTextArea(content.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(750, 400));
                JOptionPane.showMessageDialog(regularPanel, scrollPane, 
                    "Regular Members from File", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(regularPanel, 
                    "No regular members found in file", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(regularPanel, 
                "MemberDetails.txt not found", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(regularPanel, 
                "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});


        guiFrame.setVisible(true);
    }
   



    public static void main(String[] args){
        new GymGUI();
    }
}
