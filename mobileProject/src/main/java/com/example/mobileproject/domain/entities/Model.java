package com.example.mobileproject.domain.entities;

import com.example.mobileproject.domain.enums.Category;
import jakarta.persistence.*;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{

    @Column
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Size(min = 8, max = 512)
    @Column(name = "image_url")
    private String imageIrl;

    @Column(name = "start-year")
    private Integer startYear;

    @Column(name = "end-year")
    private Integer endYear;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @ManyToOne
    private Brand brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageIrl() {
        return imageIrl;
    }

    public void setImageIrl(String imageIrl) {
        this.imageIrl = imageIrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
