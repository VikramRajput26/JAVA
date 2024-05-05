package com.validation;

import java.time.LocalDate;
import java.util.Map;

import com.app.patient.Patient;
import com.app.patient.ServicePlan;
import com.patientException.PatientException;

public class PatientValidation {
	public static void checkForDupPatient(String email,  Map<String, Patient> patientsMap) throws PatientException {
        if (patientsMap.containsKey(email))
            throw new PatientException("Duplicate Email");
    }
	public static ServicePlan parseAndValidatePlanAndCharges(String plan, double regAmount) throws PatientException {
        ServicePlan servicePlan = ServicePlan.valueOf(plan.toUpperCase());
        if (servicePlan.getMinAmtReg() == regAmount) {
            return servicePlan;
        }
        throw new PatientException("Registration amount doesn't match with the chosen plan");
    }
	
	 public static Patient validatePatientInputs(String firstName, String lastName, String email, String password,
	            double regAmount, String dob, String plan, Map<String, Patient> patientsMap) throws PatientException {
	   checkForDupPatient(email, patientsMap);
	        ServicePlan servicePlan = parseAndValidatePlanAndCharges(plan, regAmount);
	        LocalDate pdate = parseAndValidateDob(dob);
	        validatePassword(password);
	        return new Patient(plan, firstName, lastName, pdate, email, password, regAmount, pdate, pdate, regAmount, servicePlan);

	    }
	 
	 public static void validatePassword(String password) throws PatientException {
	        String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
	        if (password.matches(regex))
	            throw new PatientException("Invalid password!");
	    }

	    public static LocalDate parseAndValidateDob(String dob) throws PatientException {
	        LocalDate birthdate = LocalDate.parse(dob);
	        int age = java.time.Period.between(birthdate, java.time.LocalDate.now()).getYears();
	        if (age < 10)
	            throw new PatientException("Invalid age!");
	        return birthdate;

	    }
	
}
