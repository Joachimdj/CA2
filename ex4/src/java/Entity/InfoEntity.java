/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author JoachimDittman
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class InfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "g1")
    @SequenceGenerator(name = "g1", allocationSize = 1, initialValue = 1, sequenceName = "g1")
    private Long id;
    private String email;

    public InfoEntity(String email) {
        this.email = email;
    }

    public InfoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
}
