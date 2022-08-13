package models.bean;

public class Hr {
    String hr_id;
    String hr_name;
    String company;

    public Hr(String hr_id, String hr_name, String company) {
        this.hr_id = hr_id;
        this.hr_name = hr_name;
        this.company = company;
    }

    public String getId() {
        return hr_id;
    }

    public String getName() {
        return hr_name;
    }

    public String getCompany() {
        return company;
    }

    public void setId(String hr_id) {
        this.hr_id = hr_id;
    }

    public void setName(String hr_name) {
        this.hr_name = hr_name;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
