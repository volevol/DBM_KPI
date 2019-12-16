package models;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "worker")

public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<Assigment> assigments;

    public Worker(){
    }

    public Worker(String n) {
        this.name = n;
    }

    public void addAssignment(Assignment ag) {
        ag.setWorker(this);
        assignments.add(ag);
    }

    public void removeAssingment(Assignment ag) {
        assignments.remove(ag);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public List<Assigment> getAssigments() {
        return assigments;
    }

    @Override
    public String toString() {
        return "Worker \"" + name + "\":\n" +
                "id = " + id;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker w = (Worker) o;
        return name.equals(w.name);
    }
}
