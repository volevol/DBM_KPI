package models;

import javax.persistence.*;

@Entity
@Table(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_name")
    private Role role;

    public Assignment(){}

    public int getId(){
        return id;
    }

    public Task getTask(){
        return task;
    }

    public void setTask(Task t) {
        this.task = t;
    }

    public Worker getWorker(){
        return worker;
    }

    public void setWorker(Worker w) {
        this.worker = w;
    }

    public Role getRole(){
        return role;
    }

    public void setRole(Role r){
        this.role = r;
    }

    @Override
    public String toString(){
        return "Assignment:\nWorker " + worker +
                "\nas " + role +
                "\non the " + task;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Assignment a = (Assignment) o;
        return task.equals(a.task) &&
                worker.equals(a.worker) &&
                role.equals(a.role);
    }
}
