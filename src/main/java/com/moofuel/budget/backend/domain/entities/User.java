package com.moofuel.budget.backend.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MoOFueL on 02.07.2016.
 */
@Entity
@Table(name = "users")
public class User {

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

    @NotNull
    @Size(max = 256)
    @Column(name = "fio")
    private String fio;

    @Size(max = 512)
    @Column(name = "additional_info")
    private String additonalInfo;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "synchronized_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date synchronizedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_paychecks",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "paycheck_id", referencedColumnName = "id"))
    private Set<PayCheck> payChecks = new HashSet<>(0);

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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAdditonalInfo() {
        return additonalInfo;
    }

    public void setAdditonalInfo(String additonalInfo) {
        this.additonalInfo = additonalInfo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getSynchronizedAt() {
        return synchronizedAt;
    }

    public void setSynchronizedAt(Date synchronizedAt) {
        this.synchronizedAt = synchronizedAt;
    }

    public Set<PayCheck> getPayChecks() {
        return payChecks;
    }

    public void setPayChecks(Set<PayCheck> payChecks) {
        this.payChecks = payChecks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", fio='" + fio + '\'' +
                ", additonalInfo='" + additonalInfo + '\'' +
                ", active=" + active +
                ", synchronizedAt=" + synchronizedAt +
                ", payChecks=" + payChecks +
                '}';
    }
}
