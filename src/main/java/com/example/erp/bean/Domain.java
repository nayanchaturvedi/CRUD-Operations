package com.example.erp.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Domain")

public class Domain implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer domain_id;

    @Column(nullable = false)
    private String program;

    @Column(nullable = false)
    private Integer batch;

 public Domain()
 {

 }
 public Domain(String program, Integer batch)
 {
     this.batch=batch;
     this.program=program;
 }

    public String getProgram(){return program;}
    public void  setProgram(String program){ this.program=program;}

    public Integer getBatch(){return batch;}
    public void  setBatch(Integer batch){ this.batch=batch;}
}
