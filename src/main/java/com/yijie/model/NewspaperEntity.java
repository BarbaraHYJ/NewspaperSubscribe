package com.yijie.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by barbara on 2016/12/5.
 */
@Entity
@Table(name = "newspaper", schema = "newspaper_subscribe", catalog = "")
public class NewspaperEntity {
    private int nId;
    private String nName;
    private String nOffice;
    private int nTime;
    private double nPrice;
    private String nContent;
    private int cId;
    private Collection<OrdersEntity> ordersesByNId;

    @Id
    @Column(name = "n_id", nullable = false)
    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    @Basic
    @Column(name = "n_name", nullable = false, length = 40)
    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    @Basic
    @Column(name = "n_office", nullable = false, length = 40)
    public String getnOffice() {
        return nOffice;
    }

    public void setnOffice(String nOffice) {
        this.nOffice = nOffice;
    }

    @Basic
    @Column(name = "n_time", nullable = false)
    public int getnTime() {
        return nTime;
    }

    public void setnTime(int nTime) {
        this.nTime = nTime;
    }

    @Basic
    @Column(name = "n_price", nullable = false, precision = 0)
    public double getnPrice() {
        return nPrice;
    }

    public void setnPrice(double nPrice) {
        this.nPrice = nPrice;
    }

    @Basic
    @Column(name = "n_content", nullable = true, length = 100)
    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    @Basic
    @Column(name = "c_id", nullable = false)
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewspaperEntity that = (NewspaperEntity) o;

        if (nId != that.nId) return false;
        if (nTime != that.nTime) return false;
        if (Double.compare(that.nPrice, nPrice) != 0) return false;
        if (cId != that.cId) return false;
        if (nName != null ? !nName.equals(that.nName) : that.nName != null) return false;
        if (nOffice != null ? !nOffice.equals(that.nOffice) : that.nOffice != null) return false;
        if (nContent != null ? !nContent.equals(that.nContent) : that.nContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nId;
        result = 31 * result + (nName != null ? nName.hashCode() : 0);
        result = 31 * result + (nOffice != null ? nOffice.hashCode() : 0);
        result = 31 * result + nTime;
        temp = Double.doubleToLongBits(nPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (nContent != null ? nContent.hashCode() : 0);
        result = 31 * result + cId;
        return result;
    }

    @OneToMany
    @JoinColumn(name = "n_id")
    public Collection<OrdersEntity> getOrdersesByNId() {
        return ordersesByNId;
    }

    public void setOrdersesByNId(Collection<OrdersEntity> ordersesByNId) {
        this.ordersesByNId = ordersesByNId;
    }
}
