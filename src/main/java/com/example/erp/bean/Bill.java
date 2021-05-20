package com.example.erp.bean;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity
@Table(name="Bill")
public class Bill implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "integer default 1")
    private Integer bill_id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Bill_Student", joinColumns = {@JoinColumn(name = "bill_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Students> students;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String status;

    public Bill()
    {
    }
    public Bill(String description, Integer amount, String date, String status )
    {
        this.description= description;
        this.amount= amount;
        this.date= date;
        this.status=status;
    }

    public Bill(Integer bill_id) {
        this.bill_id=bill_id;
    }

    public String getDescription(){return description;}
    public void  setDescription(String description){ this.description=description;}

    public Integer getAmount(){return amount;}
    public void  setAmount(Integer amount){ this.amount=amount;}

    public String getDate(){return date;}
    public void  setDate(String date){ this.date=date;}

    public String getStatus(){return status;}
    public void  setStatus(String status){ this.status=status;}

    public Integer getBill_id() {
        return bill_id;
    }

    public void setBill_id(Integer bill_id) {
        this.bill_id = bill_id;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
