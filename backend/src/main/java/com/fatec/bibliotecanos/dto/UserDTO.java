package com.fatec.bibliotecanos.dto;

import com.fatec.bibliotecanos.entities.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String situation;
    private String observation;

    @NotBlank(message = "Campo obrigatório")
    private String firstName;
    private String lastName;
    private String phone;
    private String ITIN; //  Individual Taxpayer Identification Number == CPF
    private String zipCode;
    private String address;
    private String number;
    private String complement;
    private String city;
    private String state;

    @Email(message = "Favor entrar um email válido")
    private String email;

    Set<RoleDTO> roles = new HashSet<>();

    public UserDTO() {
    }

    public UserDTO(Long id, String situation, String observation, String firstName, String lastName, String phone, String ITIN, String zipCode, String address, String number, String complement, String city, String state, String email) {
        this.id = id;
        this.situation = situation;
        this.observation = observation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.ITIN = ITIN;
        this.zipCode = zipCode;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.email = email;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        this.situation = entity.getSituation();
        this.observation = entity.getObservation();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        this.phone = entity.getPhone();
        this.ITIN = entity.getITIN();
        this.zipCode = entity.getZipCode();
        this.address = entity.getAddress();
        this.number = entity.getNumber();
        this.complement = entity.getComplement();
        this.city = entity.getCity();
        this.state = entity.getState();
        email = entity.getEmail();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getITIN() {
        return ITIN;
    }

    public void setITIN(String ITIN) {
        this.ITIN = ITIN;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }
}
