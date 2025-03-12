package org.example.Model;

public class Task {
    private int id;
    private String description;
    private String status;
    private String created;
    private String updated;

    public Task(int id, String description, String status, String created, String updated){
        this.id =id;
        this.description = description;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    public Task(String description, String status, String created, String updated){
        this.description = description;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
