/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JoachimDittman
 */
@Entity
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name; 
    private String description;
    private String cvr;
    private Long NumEmployess;
    private Long MarketValue;

    public Company(String name, String description, String cvr, Long NumEmployess, Long MarketValue) {
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.NumEmployess = NumEmployess;
        this.MarketValue = MarketValue;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public Long getNumEmployess() {
        return NumEmployess;
    }

    public void setNumEmployess(Long NumEmployess) {
        this.NumEmployess = NumEmployess;
    }

    public Long getMarketValue() {
        return MarketValue;
    }

    public void setMarketValue(Long MarketValue) {
        this.MarketValue = MarketValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Company[ id=" + id + " ]";
    }
    
}
