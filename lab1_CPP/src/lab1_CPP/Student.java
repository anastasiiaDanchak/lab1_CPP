package lab1_CPP;

public class Student {
	
	private String firstName;
	private String lastName;
	private String dormitory;
	private int roomNumber;
	private double rentFee;
	private int age;
    private boolean isBeneficiary;  

Student (String firstName, String lastName, String dormitory, int roomNumber, double rentFee, int age, boolean isBeneficiary)
{
	
this.firstName=firstName;
this.lastName=lastName;
this.dormitory=dormitory;
this.roomNumber=roomNumber;
this.rentFee=rentFee;
this.age=age;
this.isBeneficiary = isBeneficiary;

}

public String getFirstName() {
    return firstName;
}

public String getLastName() {
    return lastName;
}

public String getDormitory() {
    return dormitory;
}

public int getRoomNumber() {
    return roomNumber;
}

public double getRentFee() {
    return rentFee;
}

public int getAge() {
    return age;
}

public boolean isBeneficiary() {
    return isBeneficiary;
}

public String toString() {
    return firstName + " " + lastName + ", Room: " + roomNumber + ", Dormitory: " + dormitory + ", Fee: " + rentFee + ", Age: " + age + ", Beneficiary: " + isBeneficiary;
}
}
