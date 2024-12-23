/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ff
 */
@Entity
@Table(catalog = "school_system", schema = "")
@NamedQueries({
    @NamedQuery(name = "Levels.findAll", query = "SELECT l FROM Levels l"),
    @NamedQuery(name = "Levels.findByName", query = "SELECT l FROM Levels l WHERE l.name = :name"),
    @NamedQuery(name = "Levels.findById", query = "SELECT l FROM Levels l WHERE l.id = :id"),
    @NamedQuery(name = "Levels.findByLevelLabel", query = "SELECT l FROM Levels l WHERE l.levelLabel = :levelLabel")})
public class Levels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "level_label", nullable = false)
    private int levelLabel;

    public Levels() {
    }

    public Levels(Integer id) {
        this.id = id;
    }

    public Levels(Integer id, String name, int levelLabel) {
        this.id = id;
        this.name = name;
        this.levelLabel = levelLabel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevelLabel() {
        return levelLabel;
    }

    public void setLevelLabel(int levelLabel) {
        this.levelLabel = levelLabel;
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
        if (!(object instanceof Levels)) {
            return false;
        }
        Levels other = (Levels) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "schoolsystem.models.Levels[ id=" + id + " ]";
    }
    
}
