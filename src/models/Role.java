package models;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "duties")
    private String duties;

    @Column(name = "rights")
    private String rights;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Assignment> assignments;

    public Role(){
    }

    public Role(String n, String d, String r) {
        this.name = n;
        this.duties = d;
        this.rights = r;
        assignments = new ArrayList<Assignment>();
    }

    public void addAssignment(Assignment ag) {
        ag.setRole(this);
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

    public String getDuties() {
        return duties;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getRights() {
        return rights;
    }

    public void setDuties(String d) {
        this.duties = d;
    }

    public void setRights(String r) { this.rights = r; }

    public List<Assignment> getAssignments() {
        return assignments;
    }
    
    public void setAssignments(List<Assignment> ag) {
        this.assignments = ag;
    }

    @Override
    public String toString() {
        return "Role \"" + name + "\":\n" +
                "rights = " + rights +
                "\nduties = " + duties+"\n\n";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role r = (Role) o;
        return name.equals(r.name) &&
                duties.equals(r.duties) && rights.equals(r.rights);
    }
}
