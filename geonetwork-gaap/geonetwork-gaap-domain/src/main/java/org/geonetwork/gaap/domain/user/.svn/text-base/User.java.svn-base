package org.geonetwork.gaap.domain.user;

import org.geonetwork.gaap.domain.group.Group;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.IndexedEmbedded;

import java.util.Set;

/**
 * Class to model an application user
 *
 * @author Jose
 */
@Indexed
public class User {
    @DocumentId
    private long hibernateId;
    @Field
    private String uuid;
    @Field
    private String username;
    private String password;
    private String surname;
    private String name;
    private String profile;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String email;
    //TODO: Change
    private String organisation;
    //private Organisation organisation;
    private String kind;

    @IndexedEmbedded
    Set<Group> userGroups;

    public User() {
        this.uuid = java.util.UUID.randomUUID().toString();
    }

    public long getHibernateId() {
        return hibernateId;
    }

    public void setHibernateId(long hibernateId) {
        this.hibernateId = hibernateId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public Set<Group> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<Group> userGroups) {
        this.userGroups = userGroups;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uuid != null ? !uuid.equals(user.uuid) : user.uuid != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (state != null ? !state.equals(user.state) : user.state != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (kind != null ? !kind.equals(user.kind) : user.kind != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (organisation != null ? !organisation.equals(user.organisation) : user.organisation != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (profile != null ? !profile.equals(user.profile) : user.profile != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (zip != null ? !zip.equals(user.zip) : user.zip != null) return false;
        if (userGroups != null ? !userGroups.equals(user.userGroups) : user.userGroups != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
		int result = 1;
        
        result = prime * result + (uuid != null ? uuid.hashCode() : 0);
        result = prime * result + (username != null ? username.hashCode() : 0);
        result = prime * result + (password != null ? password.hashCode() : 0);
        result = prime * result + (surname != null ? surname.hashCode() : 0);
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (profile != null ? profile.hashCode() : 0);
        result = prime * result + (address != null ? address.hashCode() : 0);
        result = prime * result + (city != null ? city.hashCode() : 0);
        result = prime * result + (state != null ? state.hashCode() : 0);
        result = prime * result + (zip != null ? zip.hashCode() : 0);
        result = prime * result + (country != null ? country.hashCode() : 0);
        result = prime * result + (email != null ? email.hashCode() : 0);
        result = prime * result + (organisation != null ? organisation.hashCode() : 0);
        result = prime * result + (kind != null ? kind.hashCode() : 0);
        result = prime * result + (userGroups != null ? userGroups.hashCode() : 0);              
        return result;
    }
}
