package net.sppan.base.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Order extends BaseEntity {
    private Integer id;
    private String customername;
    private String customertel;

    @JSONField(format = "yyyy-MM-dd")
    private Date createdate;

    @JSONField(format = "yyyy-MM-dd")
    private Date updatedate;

    private String servicename;
    private String serviceprice;
    private String massagername;
    private Integer orderstatus;//0待支付 1已支付但未完成 3已完成
    private Integer orderdeletestatus;
    private Integer customervip;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
    @Column(name = "customertel")
    public String getCustomertel() {
        return customertel;
    }

    public void setCustomertel(String customertel) {
        this.customertel = customertel;
    }

    @Basic
    @Column(name = "createdate")
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Basic
    @Column(name = "updatedate")
    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
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
    @Column(name = "serviceprice")
    public String getServiceprice() {
        return serviceprice;
    }

    public void setServiceprice(String serviceprice) {
        this.serviceprice = serviceprice;
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
    @Column(name = "orderstatus")
    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Basic
    @Column(name = "orderdeletestatus")
    public Integer getOrderdeletestatus() {
        return orderdeletestatus;
    }

    public void setOrderdeletestatus(Integer orderdeletestatus) {
        this.orderdeletestatus = orderdeletestatus;
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

        Order order = (Order) o;

        if (id != order.id) return false;
        if (customername != null ? !customername.equals(order.customername) : order.customername != null) return false;
        if (customertel != null ? !customertel.equals(order.customertel) : order.customertel != null) return false;
        if (createdate != null ? !createdate.equals(order.createdate) : order.createdate != null) return false;
        if (updatedate != null ? !updatedate.equals(order.updatedate) : order.updatedate != null) return false;
        if (servicename != null ? !servicename.equals(order.servicename) : order.servicename != null) return false;
        if (serviceprice != null ? !serviceprice.equals(order.serviceprice) : order.serviceprice != null) return false;
        if (massagername != null ? !massagername.equals(order.massagername) : order.massagername != null) return false;
        if (orderstatus != null ? !orderstatus.equals(order.orderstatus) : order.orderstatus != null) return false;
        if (orderdeletestatus != null ? !orderdeletestatus.equals(order.orderdeletestatus) : order.orderdeletestatus != null)
            return false;
        if (customervip != null ? !customervip.equals(order.customervip) : order.customervip != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (customername != null ? customername.hashCode() : 0);
        result = 31 * result + (customertel != null ? customertel.hashCode() : 0);
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        result = 31 * result + (updatedate != null ? updatedate.hashCode() : 0);
        result = 31 * result + (servicename != null ? servicename.hashCode() : 0);
        result = 31 * result + (serviceprice != null ? serviceprice.hashCode() : 0);
        result = 31 * result + (massagername != null ? massagername.hashCode() : 0);
        result = 31 * result + (orderstatus != null ? orderstatus.hashCode() : 0);
        result = 31 * result + (orderdeletestatus != null ? orderdeletestatus.hashCode() : 0);
        result = 31 * result + (customervip != null ? customervip.hashCode() : 0);
        return result;
    }
}
