package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "artfrole")
public class ArtfRole {

    @Id(name = "name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "access_level")
    private int access_level;

    @OneToMany(mappedBy = "artfrole", cascade = CascadeType.ALL)
    private List<Association> associations;

    public ArtfRole() {
    }

    public ArtfRole(String name, int access_level) {
        this.name = name;
        this.access_level = access_level;
        associations = new ArrayList<Association>();
    }

    public void addAssociation(Association a) {
        a.setArtfRole(this);
        associations.add(a);
    }

    public void removeAssociation(Association a) {
        associations.remove(a);
    }

    public List<Association> getAssociations() {
        return associations;
    }
    
    public void setAssociations(List<Association> ac) {
        this.associations = ac;
    }
    
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccess_level() {
        return access_level;
    }

    public void setAccess_level(int access_level) {
        this.access_level = access_level;
    }

    @Override
    public String toString() {
        return "ArtfRole \"" + name + "\"\tAccess_level = " + access_level+"\n\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArtfRole artfRole = (ArtfRole) o;
        return name.equals(artfRole.name) &&
                access_level==artfRole.access_level;
    }
}
