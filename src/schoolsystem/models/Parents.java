/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ff
 */
@Entity
@Table(catalog = "school_system", schema = "")
@NamedQueries({
    @NamedQuery(name = "Parents.findAll", query = "SELECT p FROM Parents p"),
    @NamedQuery(name = "Parents.findById", query = "SELECT p FROM Parents p WHERE p.id = :id"),
    @NamedQuery(name = "Parents.findByName", query = "SELECT p FROM Parents p WHERE p.name = :name"),
    @NamedQuery(name = "Parents.findByBirthDate", query = "SELECT p FROM Parents p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "Parents.findByPhone", query = "SELECT p FROM Parents p WHERE p.phone = :phone"),
    @NamedQuery(name = "Parents.findByJob", query = "SELECT p FROM Parents p WHERE p.job = :job"),
    @NamedQuery(name = "Parents.findByAddress", query = "SELECT p FROM Parents p WHERE p.address = :address"),
    @NamedQuery(name = "Parents.findByGender", query = "SELECT p FROM Parents p WHERE p.gender = :gender"),
    @NamedQuery(name = "Parents.findByReligion", query = "SELECT p FROM Parents p WHERE p.religion = :religion")})
public class Parents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String name;
    @Basic(optional = false)
    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @Column(nullable = false, length = 35)
    private String phone;
    @Basic(optional = false)
    @Column(nullable = false, length = 35)
    private String job;
    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String address;
    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String gender;
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String religion;

    public Parents() {
    }

    public Parents(Integer id) {
        this.id = id;
    }

    public Parents(Integer id, String name, Date birthDate, String phone, String job, String address, String gender, String religion) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.job = job;
        this.address = address;
        this.gender = gender;
        this.religion = religion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parents)) {
            return false;
        }
        Parents other = (Parents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "schoolsystem.models.Parents[ id=" + id + " ]";
    }
    
}
