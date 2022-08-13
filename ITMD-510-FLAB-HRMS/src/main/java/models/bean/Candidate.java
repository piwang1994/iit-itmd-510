package models.bean;

public class Candidate {
    public String cid;
    public String name;
    public String password;


    public Candidate(String cid, String name, String password) {
        this.cid = cid;
        this.name = name;
        this.password = password;
    }


    public String getCid() {
        return cid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
