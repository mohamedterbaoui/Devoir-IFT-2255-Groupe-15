//User.java
//IFT2255 - Équipe 15
//Class pour le type User
package com.ift2255.MaVille;
import java.util.Date;

public class User {
    protected String firstName;
    protected String lastName;
    protected Date birthDate;
    protected String email;
    protected String password;
    protected String phone; //Ça serait un peu mieux commme string n'est-ce pas?
    protected String userAddress; //on a probablement besoin d'un autre object d'adresse au lieu d'utiliser un String

    public User(String firstName, String lastName, Date birthDate, String email, String password, String phone, String userAddress){
        this.firstName = firstName;
        this.lastName = lastName;
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
    public String getFirstName(){return this.firstName;}

    public String getLastName(){return this.lastName;}

    public String getName(){
        String name = firstName + " " + lastName;
        return name;
    }

    public Date getBirthDate(){return this.birthDate;}

    public String getEmail(){return this.email;}

    public String getPassword(){return password;}

    public String getPhone(){return phone;}

    public String getUserAddress(){return userAddress;}

// setters

    public void setFirstName(String firstName){this.firstName = firstName;}

    public void setLastName(String lastName){this.lastName = lastName;};

    public void setBirthDate(Date birthDate){this.birthDate = birthDate;}

    public void setEmail(String email){this.email = email;}

    public void setPassword(String password){this.password = password;}

    public void setPhone(String phone){this.phone = phone;}

    public void setUserAddress(String address){this.userAddress = address;}


    
}
