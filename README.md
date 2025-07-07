# 📌 Gym Membership System – Java Swing GUI

This is my **first official Java project**, and one I’m truly proud of. Throughout the development process, I not only deepened my understanding of **Object-Oriented Programming** and **GUI development**, but I also got the chance to help other students who were struggling with the same concepts. That experience reinforced what I was learning and showed me how far I’d come.

After building this system, I can confidently say:  
💬 _Java is now the language I’m most comfortable with._

---

 ✅ Features

### 🏗️ Dynamic GUI Navigation  
Seamlessly switch between Home, Regular Member, and Premium Member panels using intuitive buttons and visibility toggles.

### 🧍 Add Members via Custom Forms  
Easily register both Regular and Premium members by filling out structured input fields: name, ID, contact info, trainer, plan, referral source, gender, DOB, and membership start date.

### 🧠 Smart Validation & Error Handling  
Ensures all fields are filled, selections made, and valid data types entered — with `JOptionPane` prompts to guide the user through proper form submission.

### 🚫 Duplicate ID Detection  
Prevents adding members with existing IDs by scanning the in-memory member list and notifying users in real time.

### 💾 Save to File — Both Regular & Premium Members  
- Regular members are appended to the **REGULAR MEMBER DETAILS** section in `MemberDetails.txt` in a formatted table.  
- Premium members are saved in a dedicated **Premium Members:** section with fields like paid amount, trainer, discount, and full payment status.

### 📤 Read Premium Members from File  
Allows users to retrieve and display saved premium member data using `BufferedReader`, with neatly formatted output shown in a scrollable `JTextArea`.

### 📑 Structured Output Formatting  
All saved data is organized using console-style tables for clarity and readability.

### 🧩 Object-Oriented Architecture  
Built on an extendable OOP structure with `GymMember`, `RegularMember`, and `PremiumMember` classes, ensuring modularity and future scalability.



🚀 How to Run

git clone https://github.com/biplavbhandari/GymMembershipSystem.git

Open the project folder in your favorite Java IDE (IntelliJ IDEA, Eclipse, or NetBeans).

Compile all Java files inside the src directory to ensure smooth sailing.

Run the GymGUI class — this launches the interactive membership management system.

Dive in and start managing members effortlessly through the sleek GUI!
