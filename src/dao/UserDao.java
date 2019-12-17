package dao;

import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class UserDao {

    public Project findProjectById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Project.class, id);
    }

    public void save(Project p) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(p);
        tx1.commit();
        session.close();
    }

    public void update(Project p) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(p);
        tx1.commit();
        session.close();
    }

    public void delete(Project p) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(p);
        tx1.commit();
        session.close();
    }

    public List<Project> findAllProjects() {
        List<Project> projects = (List<Project>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Project").list();
        return projects;
    }

    public Task findTaskById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Task.class, id);
    }

    public List<Task> findTasksByProject(Project p) {
        List<Task> tasks = (List<Task>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Task T WHERE T.project = "+ p.getId()).list();
        return tasks;
    }

    public Worker findWorkerById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Worker.class, id);
    }

    public List<Worker> findAllWorkers() {
        List<Worker> workers = (List<Worker>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Worker").list();
        return workers;
    }

    public Role findRoleById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Role.class, id);
    }

    public List<Role> findAllRoles() {
        List<Role> roles = (List<Role>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Role").list();
        return roles;
    }


    public Artifact findArtifactById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Artifact.class, id);
    }

    public List<Artifact> findAllArtifacts() {
        List<Artifact> artifacts = (List<Artifact>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Artifact").list();
        return artifacts;
    }

    public ArtfRole findArtfRoleById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ArtfRole.class, id);
    }

    public List<ArtfRole> findAllArtfroles() {
        List<ArtfRole> artfroles = (List<ArtfRole>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM ArtfRole").list();
        return artfroles;
    }


    public Association findAssociationById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Association.class, id);
    }


    public List<Association> findAssociationByTask(Task t) {
        List<Association>  associations = (List<Association>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Association A WHERE A.task = "+ t.getId()).list();
        return associations;
    }

    public List<Association> findAssociationByArtifact(Artifact a) {
        List<Association> associations = (List<Association>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Association A WHERE A.artifact = "+ a.getId()).list();
        return  associations;
    }

    public List<Association> findAssociationByArtfrole(ArtfRole ar) {
        List<Association> associations = (List<Association>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM ArtfRole A WHERE A.artfRole = "+ ar.getId()).list();
        return  associations;
    }

    public Assignment findAssignmentById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Assignment.class, id);
    }


    public List<Assignment> findAssignmentByTask(Task t) {
        List<Assignment>  assignments = (List<Assignment>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Assignment A WHERE A.task = "+ t.getId()).list();
        return assignments ;
    }

    public List<Assignment> findAssignmentByWorker(Worker w) {
        List<Assignment> assignments = (List<Assignment>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Assignment A WHERE A.worker = "+ w.getId()).list();
        return  assignments;
    }

    public List<Assignment> findAssignmentByRole(Role r) {
        List<Assignment> assignments = (List<Assignment>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Assignment A WHERE A.role = "+ r.getId()).list();
        return  assignments;
    }


    public void save(Task t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(t);
        tx1.commit();
        session.close();
    }

    public void update(Task t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(t);
        tx1.commit();
        session.close();
    }

    public void delete(Task t) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(t);
        tx1.commit();
        session.close();
    }


    public void save(Worker w) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(w);
        tx1.commit();
        session.close();
    }

    public void update(Worker w) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(w);
        tx1.commit();
        session.close();
    }

    public void delete(Worker w) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(w);
        tx1.commit();
        session.close();
    }


    public void save(Role r) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(r);
        tx1.commit();
        session.close();
    }

    public void update(Role r) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(r);
        tx1.commit();
        session.close();
    }

    public void delete(Role r) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(r);
        tx1.commit();
        session.close();
    }

    public void save(Association ac) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(ac);
        tx1.commit();
        session.close();
    }

    public void update(Association ac) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(ac);
        tx1.commit();
        session.close();
    }

    public void delete(Association ac) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(ac);
        tx1.commit();
        session.close();
    }

    public void save(Assignment ass) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(ass);
        tx1.commit();
        session.close();
    }

    public void update(Assignment ass) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(ass);
        tx1.commit();
        session.close();
    }

    public void delete(Assignment ass) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(ass);
        tx1.commit();
        session.close();
    }


    public void save(Artifact ar) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(ar);
        tx1.commit();
        session.close();
    }

    public void update(Artifact ar) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(ar);
        tx1.commit();
        session.close();
    }

    public void delete(Artifact ar) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(ar);
        tx1.commit();
        session.close();
    }


    public void save(ArtfRole arole) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(arole);
        tx1.commit();
        session.close();
    }

    public void update(ArtfRole arole) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(arole);
        tx1.commit();
        session.close();
    }

    public void delete(ArtfRole arole) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(arole);
        tx1.commit();
        session.close();
    }

}
