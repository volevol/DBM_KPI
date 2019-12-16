package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "artfrole")
public class ArtfRole {

    @Id(name = "name")
    private String name;

    @Column(name = "access_level")
    private int access_level;

    @OneToMany(mappedBy = "artfrole", cascade = CascadeType.ALL)
    private List<Asociation> asociations;

    public ArtfRole() {
    }

    public ArtfRole(String name, int access_level) {
        this.name = name;
        this.access_level = access_level;
        asociations = new ArrayList<Asociation>();
    }

    public void addAsociation(Asociation a) {
        a.setProject(this);
        asociations.add(a);
    }

    public void removeAsociation(Asociation a) {
        asociations.remove(a);
    }

    public List<Asociation> getAsociation() {
        return asociations;
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
        return "ArtfRole \"" + name + "\":\n" +
                "access_level = " + access_level;
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
                access_level.equals(artfRole.access_level)
    }
}
