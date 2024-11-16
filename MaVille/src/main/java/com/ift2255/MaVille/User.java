//User.java
//IFT2255 - Équipe 15
//Class pour le type User
package com.ift2255.MaVille;

public class User {
    protected String fullName;
    protected Date birthDate;
    protected String email;
    protected String password;
    protected int phone; //Ça serait un peu mieux commme string n'est-ce pas?
    protected String userAddress; //on a probablement besoin d'un autre object d'adresse au lieu d'utiliser un String

    public User(String fullName,Date birthDate, String email, String password, int phone, String userAddress){
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userAddress = userAddress;
    }

    //methods
    public boolean isAdult(){
        return (this.getAge() >= 18);
    }

    public int getAge(){
        return 19;
        //on doit modifier le fonction eventuellement pour calculer l'age
        //à partir de la date d'aujourd'hui 
    }

    public void signUp(){
        //fonction
    }

    public void logIn(){
        //fonction
    }

    public void logOut(){
        //fonction
    }

    //getters
    public String getName(){return this.fullName;}

    public Date getBirthDate(){return this.birthDate;}

    public String getEmail(){return this.email;}

    public String getPassword(){return password;}

    public int getPhone(){return phone;}

    public String getUserAddress(){return userAddress;}

// setters

    public void setName(String name){this.fullName = name;}

    public void setBirthDate(Date birthDate){this.birthDate = birthDate;}

    public void setEmail(String email){this.email = email;}

    public void setPassword(String password){this.password = password;}

    public void setPhone(int phone){this.phone = phone;}

    public void setUserAddress(String address){this.userAddress = address;}


    
}
