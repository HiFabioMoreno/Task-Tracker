package org.example.Repository;

import org.example.Model.Task;

public interface TaskManagerRepo {

    void Save(Task task);
    void FindAll();
    void FindByStatus(String status);
    void UpdateDescription(String description, int id);
    void MarkAs(String status, int id);
    void Delete(int id);

}
