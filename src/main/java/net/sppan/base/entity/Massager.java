package net.sppan.base.entity;

import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;

@Table(name="massager")
@Entity
public class Massager extends BaseEntity {
    private Integer id;
    private String massagername;
    private String massagertel;
    private String massagersex;
    private Integer massagerage;
    private String massagerjob;
    private String massagerinfo;
    private Integer massagerdeletestatus;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "massagername")
    public String getMassagername() {
        return massagername;
    }

    public void setMassagername(String massagername) {
        this.massagername = massagername;
    }

    @Basic
    @Column(name = "massagertel")
    public String getMassagertel() {
        return massagertel;
    }

    public void setMassagertel(String massagertel) {
        this.massagertel = massagertel;
    }

    @Basic
    @Column(name = "massagersex")
    public String getMassagersex() {
        return massagersex;
    }

    public void setMassagersex(String massagersex) {
        this.massagersex = massagersex;
    }

    @Basic
    @Column(name = "massagerage")
    public Integer getMassagerage() {
        return massagerage;
    }

    public void setMassagerage(Integer massagerage) {
        this.massagerage = massagerage;
    }

    @Basic
    @Column(name = "massagerjob")
    public String getMassagerjob() {
        return massagerjob;
    }

    public void setMassagerjob(String massagerjob) {
        this.massagerjob = massagerjob;
    }

    @Basic
    @Column(name = "massagerinfo")
    public String getMassagerinfo() {
        return massagerinfo;
    }

    public void setMassagerinfo(String massagerinfo) {
        this.massagerinfo = massagerinfo;
    }

    @Basic
    @Column(name = "massagerdeletestatus")
    public Integer getMassagerdeletestatus() {
        return massagerdeletestatus;
    }

    public void setMassagerdeletestatus(Integer massagerdeletestatus) {
        this.massagerdeletestatus = massagerdeletestatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Massager massager = (Massager) o;

        if (id != massager.id) return false;
        if (massagername != null ? !massagername.equals(massager.massagername) : massager.massagername != null)
            return false;
        if (massagertel != null ? !massagertel.equals(massager.massagertel) : massager.massagertel != null)
            return false;
        if (massagersex != null ? !massagersex.equals(massager.massagersex) : massager.massagersex != null)
            return false;
        if (massagerage != null ? !massagerage.equals(massager.massagerage) : massager.massagerage != null)
            return false;
        if (massagerjob != null ? !massagerjob.equals(massager.massagerjob) : massager.massagerjob != null)
            return false;
        if (massagerinfo != null ? !massagerinfo.equals(massager.massagerinfo) : massager.massagerinfo != null)
            return false;
        if (massagerdeletestatus != null ? !massagerdeletestatus.equals(massager.massagerdeletestatus) : massager.massagerdeletestatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (massagername != null ? massagername.hashCode() : 0);
        result = 31 * result + (massagertel != null ? massagertel.hashCode() : 0);
        result = 31 * result + (massagersex != null ? massagersex.hashCode() : 0);
        result = 31 * result + (massagerage != null ? massagerage.hashCode() : 0);
        result = 31 * result + (massagerjob != null ? massagerjob.hashCode() : 0);
        result = 31 * result + (massagerinfo != null ? massagerinfo.hashCode() : 0);
        result = 31 * result + (massagerdeletestatus != null ? massagerdeletestatus.hashCode() : 0);
        return result;
    }
}
