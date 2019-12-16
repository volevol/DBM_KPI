package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "project")
public class Project {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Project() {
    }

    public Project(String name, String description){
        this.name = name;
        this.description = description;
        tasks = new ArrayList<Task>();
    }

    public void addTask(Task t) {
        t.setProject(this);
        tasks.add(t);
    }

    public void removeTask(Task t) {
        tasks.remove(t);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setAutos(List<Task> ts) {
        this.tasks = ts;
    }

    @Override
    public String toString() {
        return "Project \"" + name + "\":\n" +
                "id = " + id +
                "\ndescription = " + description;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project p = (Project) o;
        return name.equals(p.name) &&
                description.equals(p.description);
    }
}
