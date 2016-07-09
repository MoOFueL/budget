package com.moofuel.budget.backend.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "additional_info")
    private String additionalInfo;

    @NotNull
    @Column(name = "sum")
    private Integer sum;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "paychecks_files",
            joinColumns = {@JoinColumn(name = "paycheck_id")},
            inverseJoinColumns = @JoinColumn(name = "file_id"))
    private Set<File> images = new HashSet<>(0);

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

    public Set<File> getImages() {
        return images;
    }

    public void setImages(Set<File> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "PayCheck{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", sum=" + sum +
                ", images=" + images +
                '}';
    }
}
