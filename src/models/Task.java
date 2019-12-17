package models;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private String deadline;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Association> associations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    public Task(){
    }

    public Task(String n, String d, String dl) {
        this.name = n;
        this.description = d;
        this.deadline = dl;
        assignments = new ArrayList<Assignment>();
        associations = new ArrayList<Association>();
    }

    public void addAssignment(Assignment ag) {
        ag.setTask(this);
        assignments.add(ag);
    }

    public void removeAssingment(Assignment ag) {
        assignments.remove(ag);
    }

    public void addAssociation(Association ac) {
        ac.setTask(this);
        associations.add(ac);
    }

    public void removeAssociation(Association ac) {
        associations.remove(ac);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String dl) {
        this.deadline = dl;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project p) {
        this.project = p;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> ag) {
        this.assignments = ag;
    }

    public List<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(List<Association> ac) {
        this.associations = ac;
    }
    
    @Override
    public String toString() {
        return "Task \"" + name + "\":\n" +
                "id = " + id +
                "\ndescription = " + description +
                "\nDeadline: " + deadline+"\n\n";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task t = (Task) o;
        return name.equals(t.name) &&
                description.equals(t.description) &&
                deadline.equals(t.deadline);
    }
}
