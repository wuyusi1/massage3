package net.sppan.base.entity;

import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="service")
public class Sservice extends BaseEntity {
    private Integer id;
    private String servicename;
    private String serviceinfo;
    private Integer serviceprice;
    private String servicefunc;
    private String servicetag;
    private Integer servicehavesaved;
    private Integer servicedeletestatus;

    private java.util.Set<Serviceimg> serviceimgs;

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
    @Column(name = "servicename")
    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    @Basic
    @Column(name = "serviceinfo")
    public String getServiceinfo() {
        return serviceinfo;
    }

    public void setServiceinfo(String serviceinfo) {
        this.serviceinfo = serviceinfo;
    }

    @Basic
    @Column(name = "serviceprice")
    public Integer getServiceprice() {
        return serviceprice;
    }

    public void setServiceprice(Integer serviceprice) {
        this.serviceprice = serviceprice;
    }

    @Basic
    @Column(name = "servicefunc")
    public String getServicefunc() {
        return servicefunc;
    }

    public void setServicefunc(String servicefunc) {
        this.servicefunc = servicefunc;
    }

    @Basic
    @Column(name = "servicetag")
    public String getServicetag() {
        return servicetag;
    }

    public void setServicetag(String servicetag) {
        this.servicetag = servicetag;
    }

    @Basic
    @Column(name = "servicehavesaved")
    public Integer getServicehavesaved() {
        return servicehavesaved;
    }

    public void setServicehavesaved(Integer servicehavesaved) {
        this.servicehavesaved = servicehavesaved;
    }

    @Basic
    @Column(name = "servicedeletestatus")
    public Integer getServicedeletestatus() {
        return servicedeletestatus;
    }

    public void setServicedeletestatus(Integer servicedeletestatus) {
        this.servicedeletestatus = servicedeletestatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sservice service = (Sservice) o;

        if (id != service.id) return false;
        if (servicename != null ? !servicename.equals(service.servicename) : service.servicename != null) return false;
        if (serviceinfo != null ? !serviceinfo.equals(service.serviceinfo) : service.serviceinfo != null) return false;
        if (serviceprice != null ? !serviceprice.equals(service.serviceprice) : service.serviceprice != null)
            return false;
        if (servicefunc != null ? !servicefunc.equals(service.servicefunc) : service.servicefunc != null) return false;
        if (servicetag != null ? !servicetag.equals(service.servicetag) : service.servicetag != null) return false;
        if (servicehavesaved != null ? !servicehavesaved.equals(service.servicehavesaved) : service.servicehavesaved != null)
            return false;
        if (servicedeletestatus != null ? !servicedeletestatus.equals(service.servicedeletestatus) : service.servicedeletestatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (servicename != null ? servicename.hashCode() : 0);
        result = 31 * result + (serviceinfo != null ? serviceinfo.hashCode() : 0);
        result = 31 * result + (serviceprice != null ? serviceprice.hashCode() : 0);
        result = 31 * result + (servicefunc != null ? servicefunc.hashCode() : 0);
        result = 31 * result + (servicetag != null ? servicetag.hashCode() : 0);
        result = 31 * result + (servicehavesaved != null ? servicehavesaved.hashCode() : 0);
        result = 31 * result + (servicedeletestatus != null ? servicedeletestatus.hashCode() : 0);
        return result;
    }

    @Transient
    @OneToMany
    public Set<Serviceimg> getServiceimgs() {
        return serviceimgs;
    }

    public void setServiceimgs(Set<Serviceimg> serviceimgs) {
        this.serviceimgs = serviceimgs;
    }
}
