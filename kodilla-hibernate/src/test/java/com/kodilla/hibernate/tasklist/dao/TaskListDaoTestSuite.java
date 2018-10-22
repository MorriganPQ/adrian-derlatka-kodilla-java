package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        // Given
        TaskList toDo = new TaskList("To do", "This list contains to do tasks");
        taskListDao.save(toDo);
        String listName = toDo.getListName();
        // When
        List<TaskList> readTaskLists = taskListDao.findByListName(listName);
        // Then
        Assert.assertEquals(1, readTaskLists.size());
        // CleanUp
        int id = readTaskLists.get(0).getId();
        taskListDao.delete(id);
    }
}
