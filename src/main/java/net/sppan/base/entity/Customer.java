package net.sppan.base.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String customername;
    private Integer customersex;
    private String customernickname;
    private String customertel;
    private String customeremail;
    private String customeraddress;
    private String customerpwd;
    private Integer customervip;
    private Integer customerdeletestatus;

    @JSONField(format = "yyyy-MM-dd")
    private Date customerbirth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customername")
    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    @Basic
    @Column(name = "customersex")
    public Integer getCustomersex() {
        return customersex;
    }

    public void setCustomersex(Integer customersex) {
        this.customersex = customersex;
    }

    @Basic
    @Column(name = "customernickname")
    public String getCustomernickname() {
        return customernickname;
    }

    public void setCustomernickname(String customernickname) {
        this.customernickname = customernickname;
    }

    @Basic
    @Column(name = "customertel")
    public String getCustomertel() {
        return customertel;
    }

    public void setCustomertel(String customertel) {
        this.customertel = customertel;
    }

    @Basic
    @Column(name = "customeremail")
    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    @Basic
    @Column(name = "customeraddress")
    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    @Basic
    @Column(name = "customerpwd")
    public String getCustomerpwd() {
        return customerpwd;
    }

    public void setCustomerpwd(String customerpwd) {
        this.customerpwd = customerpwd;
    }

    @Basic
    @Column(name = "customervip")
    public Integer getCustomervip() {
        return customervip;
    }

    public void setCustomervip(Integer customervip) {
        this.customervip = customervip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (customername != null ? !customername.equals(customer.customername) : customer.customername != null)
            return false;
        if (customersex != null ? !customersex.equals(customer.customersex) : customer.customersex != null)
            return false;
        if (customernickname != null ? !customernickname.equals(customer.customernickname) : customer.customernickname != null)
            return false;
        if (customertel != null ? !customertel.equals(customer.customertel) : customer.customertel != null)
            return false;
        if (customeremail != null ? !customeremail.equals(customer.customeremail) : customer.customeremail != null)
            return false;
        if (customeraddress != null ? !customeraddress.equals(customer.customeraddress) : customer.customeraddress != null)
            return false;
        if (customerpwd != null ? !customerpwd.equals(customer.customerpwd) : customer.customerpwd != null)
            return false;
        if (customervip != null ? !customervip.equals(customer.customervip) : customer.customervip != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (customername != null ? customername.hashCode() : 0);
        result = 31 * result + (customersex != null ? customersex.hashCode() : 0);
        result = 31 * result + (customernickname != null ? customernickname.hashCode() : 0);
        result = 31 * result + (customertel != null ? customertel.hashCode() : 0);
        result = 31 * result + (customeremail != null ? customeremail.hashCode() : 0);
        result = 31 * result + (customeraddress != null ? customeraddress.hashCode() : 0);
        result = 31 * result + (customerpwd != null ? customerpwd.hashCode() : 0);
        result = 31 * result + (customervip != null ? customervip.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "customerdeletestatus")
    public Integer getCustomerdeletestatus() {
        return customerdeletestatus;
    }

    public void setCustomerdeletestatus(Integer customerdeletestatus) {
        this.customerdeletestatus = customerdeletestatus;
    }

    @Basic
    @Column(name = "customerbirth")
    public Date getCustomerbirth() {
        return customerbirth;
    }

    public void setCustomerbirth(Date customerbirth) {
        this.customerbirth = customerbirth;
    }
}
