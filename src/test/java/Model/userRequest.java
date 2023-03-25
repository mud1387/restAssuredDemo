package Model;

public class userRequest {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private String name;
    private String job;

    public userRequest(String name, String job){
        this.name=name;
        this.job=job;
    }
}
