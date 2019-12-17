package models;

import javax.persistence.*;

@Entity
@Table(name = "association")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artifact_id")
    private Artifact artifact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artfrole_name")
    private ArtfRole artfRole;

    public Association(){}

    public int getId(){
        return id;
    }

    public Task getTask(){
        return task;
    }

    public void setTask(Task t) {
        this.task = t;
    }

    public Artifact getArtifact(){
        return artifact;
    }

    public void setArtifact(Artifact a) {
        this.artifact = a;
    }

    public ArtfRole getRole(){
        return artfRole;
    }

    public void setArtfRole(ArtfRole ar){
        this.artfRole = ar;
    }

    @Override
    public String toString(){
        return "Association:\nArtifact " + artifact +
                "\nas " + artfRole +
                "\nfor the " + task+"\n\n";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Association a = (Association) o;
        return task.equals(a.task) &&
                artifact.equals(a.artifact) &&
                artfRole.equals(a.artfRole);
    }
}
