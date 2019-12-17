import models.*;
import services.UserService;

import java.util.List;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
        UserService us = new UserService();
        Project curr = us.findProjectById(1);
        List<Task> currTasks = us.findTasksByProject(curr);
        System.out.print(currTasks);
    }
}
