package com.example.sft.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "contact_form")
public class ContactForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String message;


    public ContactForm() {}

    public ContactForm(String email, String message,String name){
        this.name=name;
        this.email=email;
        this.message=message;
    }


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String geName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
}
