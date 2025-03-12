package org.example.Model;

public enum Status {
    TODO("to-do"),INPROGRESS("in-progress"),DONE("done");
    private String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
