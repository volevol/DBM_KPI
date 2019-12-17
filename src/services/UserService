package services;

import dao.UserDao;
import models.*;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public Project findProjectById(int id) {
        return usersDao.findProjectById(id);
    }

    public void saveProject(Project p) {
        usersDao.save(p);
    }

    public void deleteProject(Project p) {
        usersDao.delete(p);
    }

    public void updateProject(Project p) {
        usersDao.update(p);
    }

    public List<Project> findAllProjects() {
        return usersDao.findAllProjects();
    }

    public Task findTaskById(int id) {return usersDao.findTaskById(id); }

    public List<Task> findTasksByProject(Project p) { return usersDao.findTasksByProject(p); }

    public void saveTask(Task t) {
        usersDao.save(t);
    }

    public void deleteTask(Task t) {
        usersDao.delete(t);
    }

    public void updateTask(Task t) {
        usersDao.update(t);
    }

    public Worker findWorkerById(int id) {return usersDao.findWorkerById(id); }

    public List<Worker> findAllWorkers() {return usersDao.findAllWorkers(); }

    public Role findRoleById(int id) {return usersDao.findRoleById(id); }

    public List<Role> findAllRoles() {return usersDao.findAllRoles(); }

    public Artifact findArtifactById(int id) {return usersDao.findArtifactById(id);}

    public List<Artifact> findAllArtifacts() {return usersDao.findAllArtifacts();}

    public ArtfRole findArtfRoleById(int id) {return usersDao.findArtfRoleById(id);}

    public List<ArtfRole> findAllArtfRoles() {return usersDao.findAllArtfRoles();}

    public Association findAssociationById(int id) {return usersDao.findAssociationById(id);}

    public List<Association> findAssociationByTask(Task t) {return usersDao.findAssociationByTask(t);}

    public List<Association> findAssociationByArtifact(Artifact a) {return usersDao.findAssociationByArtifact(a);}

    public List<Association> findAssociationByArtfRole(ArtfRole ar) {return usersDao.findAssociationByArtfRole(ar);}

    public Assignment findAssignmentById(int id) {return usersDao.findAssignmentById(id);}

    public List<Assignment> findAssignmentByTask(Task t) {return usersDao.findAssignmentByTask(t);}

    public List<Assignment> findAssignmentByWorker(Worker w) {return usersDao.findAssignmentByWorker(w);}

    public List<Assignment> findAssignmentByRole(Role r) {return usersDao.findAssignmentByRole(r);}

    public void save(Worker w) {usersDao.save(w);}

    public void update(Worker w) {usersDao.update(w);}

    public void delete(Worker w) {usersDao.delete(w);}

    public void save(Role r) {usersDao.save(r);}

    public void update(Role r) {usersDao.update(r);}

    public void delete(Role r) {usersDao.delete(r);}

    public void save(Association ac) {usersDao.save(ac);}

    public void update(Association ac) {usersDao.update(ac);}

    public void delete(Association ac) {usersDao.delete(ac);}

    public void save(Assignment ass) {usersDao.save(ass);}

    public void update(Assignment ass) {usersDao.update(ass);}

    public void delete(Assignment ass) {usersDao.delete(ass);}

    public void save(Artifact ar) {usersDao.save(ar);}

    public void update(Artifact ar) {usersDao.update(ar);}

    public void delete(Artifact ar) {usersDao.delete(ar);}

    public void save(ArtfRole arole) {usersDao.save(arole);}

    public void update(ArtfRole arole) {usersDao.update(arole);}

    public void delete(ArtfRole arole) {usersDao.delete(arole);}
}
