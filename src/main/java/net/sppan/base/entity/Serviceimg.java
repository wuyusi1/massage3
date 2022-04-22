package net.sppan.base.entity;

import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name="serviceimg")
public class Serviceimg extends BaseEntity {
    private Integer id;
    private String imgname;
    private String imgpath;
    private Date imgdate;
    private Integer serviceid;

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
    @Column(name = "imgname")
    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    @Basic
    @Column(name = "imgpath")
    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Basic
    @Column(name = "imgdate")
    public Date getImgdate() {
        return imgdate;
    }

    public void setImgdate(Date imgdate) {
        this.imgdate = imgdate;
    }

    @Basic
    @Column(name = "serviceid")
    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Serviceimg that = (Serviceimg) o;

        if (id != that.id) return false;
        if (imgname != null ? !imgname.equals(that.imgname) : that.imgname != null) return false;
        if (imgpath != null ? !imgpath.equals(that.imgpath) : that.imgpath != null) return false;
        if (imgdate != null ? !imgdate.equals(that.imgdate) : that.imgdate != null) return false;
        if (serviceid != null ? !serviceid.equals(that.serviceid) : that.serviceid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imgname != null ? imgname.hashCode() : 0);
        result = 31 * result + (imgpath != null ? imgpath.hashCode() : 0);
        result = 31 * result + (imgdate != null ? imgdate.hashCode() : 0);
        result = 31 * result + (serviceid != null ? serviceid.hashCode() : 0);
        return result;
    }
}
