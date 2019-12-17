package models;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<Assignment> assignments;

    public Worker(){
    }

    public Worker(String n) {
        this.name = n;
        assignments = new ArrayList<Assignment>();
    }

    public void addAssignment(Assignment ag) {
        ag.setWorker(this);
        assignments.add(ag);
    }

    public void removeAssignment(Assignment ag) {
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

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> ag) {
        this.assignments = ag;
    }
    
    @Override
    public String toString() {
        return "Worker \"" + name + "\" with id - " + id+"\n\n";
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
