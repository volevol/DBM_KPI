package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "artifact")
public class Artifact {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "type")
    private String type;

    @Column (name = "content")
    private String content;

    @OneToMany(mappedBy = "artifact", cascade = CascadeType.ALL)
    private List<Asociation> asociations;

    public Artifact() {
    }

    public Artifact(String name, String description, String content){
        this.name = name;
        this.type = type;
        this.content = content;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void getType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAutos(List<Asociation> as) {
        this.asociations = as;
    }

    @Override
    public String toString() {
        return "Artifact \"" + name + "\":\n" +
                "id = " + id +
                "\ntype = " + type +
                "\ncontent = " + content;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Artifact art = (Artifact) o;
        return name.equals(art.name) &&
                type.equals(art.type) &&
                content.equals(art.content);
    }
}
