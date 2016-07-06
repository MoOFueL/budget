package com.moofuel.budget.backend.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by MoOFueL on 02.07.2016.
 */
@Entity
@Table(name = "paychecks")
public class PayCheck {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    private void prePersist() {
        createdAt = new Date();
    }

    @JsonIgnore
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "sum")
    private Integer sum;

    @NotNull
    @Column(name = "photo")
    private byte[] photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "PayCheck{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", userId=" + userId +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", sum=" + sum +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
