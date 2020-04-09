package com.lambton.c0777245_w2020_mad3125_midterm.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CRACustomer implements Serializable
{
    public long personSINNumber;
    public String firstName;
    public String lastName;
    public String fullName;
    public Date birthDate;
    public String gender;
    public int age;
    public LocalDate taxFilingDate;
    public double grossIncome;
    public double federalTax;
    public double provincialTax;
    public double cpp;
    public double ei;
    public double rrspContributed;
    public double carryForwardRRSP;
    public double totalTaxableIncome;
    public double totalTaxPayed;
    public double maxRRSP;


    public CRACustomer() {
    }

    public CRACustomer(long personSINNumber, String firstName, String lastName, String fullName,
                       Date birthDate, String gender, int age, LocalDate taxFilingDate, double grossIncome, double federalTax,
                       double provincialTax, double cpp, double ei, double rrspContributed, double carryForwardRRSP,
                       double totalTaxableIncome, double totalTaxPayed) {
        this.personSINNumber = personSINNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.age = age;
        this.taxFilingDate = taxFilingDate;
        this.grossIncome = grossIncome;
        this.federalTax = federalTax;
        this.provincialTax = provincialTax;
        this.cpp = cpp;
        this.ei = ei;
        this.rrspContributed = rrspContributed;
        this.carryForwardRRSP = carryForwardRRSP;
        this.totalTaxableIncome = totalTaxableIncome;
        this.totalTaxPayed = totalTaxPayed;
    }

    public CRACustomer(long personSINNumber, String firstName, String lastName,Date birthDate,
                       String gender, int age, LocalDate taxFilingDate, double grossIncome,double rrspContributed){

        this.personSINNumber = personSINNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = lastName + " " + firstName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.age = age;
        this.taxFilingDate = taxFilingDate;
        this.grossIncome = grossIncome;
        this.rrspContributed = rrspContributed;


    }

    public long getPersonSINNumber() {
        return personSINNumber;
    }

    public void setPersonSINNumber(long personSINNumber) {
        this.personSINNumber = personSINNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getTaxFilingDate() {
        return taxFilingDate;
    }

    public void setTaxFilingDate(LocalDate taxFilingDate) {
        this.taxFilingDate = taxFilingDate;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(double federalTax) {
        this.federalTax = federalTax;
    }

    public double getProvincialTax() {
        return provincialTax;
    }

    public void setProvincialTax(double provincialTax) {
        this.provincialTax = provincialTax;
    }

    public double getCpp() {

        double cppGrossModel = this.grossIncome;
        if(cppGrossModel < 57400.0){
            this.cpp = cppGrossModel * 0.0510;
        }
        else{
            this.cpp = 57400 * 0.0510;
        }
        return cpp;
    }

    public void setCpp(double cpp) {
        this.cpp = cpp;
    }

    public double getEi() {
        double eiGrossModel = this.grossIncome;
        if (eiGrossModel <53100.0){
            this.ei = eiGrossModel * 0.0162;
        }else{
            this.ei = 53100 * 0.0162;
        }
        return ei;
    }

    public void setEi(double ei) {
        this.ei = ei;
    }

    public double getRrspContributed() {
        return rrspContributed;
    }

    public void setRrspContributed(double rrspContributed) {
        this.rrspContributed = rrspContributed;
    }

    public double getCarryForwardRRSP() {


        double rrspContri = this.rrspContributed;

        this.carryForwardRRSP = getMaxRRSP() - rrspContri;

        return carryForwardRRSP;
    }
    public double getMaxRRSP() {
        this.maxRRSP = this.grossIncome * 0.18;
        return maxRRSP;
    }

    public void setMaxRRSP(double maxRRSP) {
        this.maxRRSP = maxRRSP;
    }

    public void setCarryForwardRRSP(double carryForwardRRSP) {
        this.carryForwardRRSP = carryForwardRRSP;
    }

    public double getTotalTaxableIncome() {

        if (getRrspContributed()>getMaxRRSP()){
            this.totalTaxableIncome = getGrossIncome()-(getCpp()+getEi()+getMaxRRSP());
        }else{
            this.totalTaxableIncome = getGrossIncome()-(getCpp()+getEi()+getRrspContributed());
        }

        return totalTaxableIncome;
    }

    public void setTotalTaxableIncome(double totalTaxableIncome) {
        this.totalTaxableIncome = totalTaxableIncome;
    }

    public double getTotalTaxPayed() {

        this.totalTaxPayed = getFederalTax() + getProvincialTax();
        return totalTaxPayed;
    }

    public void setTotalTaxPayed(double totalTaxPayed) {
        this.totalTaxPayed = totalTaxPayed;
    }

    @Override
    public String toString() {
        return "CRACustomer{" +
                "personSINNumber=" + personSINNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", taxFilingDate=" + taxFilingDate +
                ", grossIncome=" + grossIncome +
                ", federalTax=" + federalTax +
                ", provincialTax=" + provincialTax +
                ", cpp=" + cpp +
                ", ei=" + ei +
                ", rrspContributed=" + rrspContributed +
                ", carryForwardRRSP=" + carryForwardRRSP +
                ", totalTaxableIncome=" + totalTaxableIncome +
                ", totalTaxPayed=" + totalTaxPayed +
                '}';
    }
}
