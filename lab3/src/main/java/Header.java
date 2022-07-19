enum Sex {
    FEMALE, MALE
}

enum Region {
    INNER_CITY, TOWN, RURAL, SUBURBAN
}

enum YesOrNo {
    YES, NO
}

public class Header {
    String id;
    int age;
    Sex sex;
    Region region;
    Double income;
    YesOrNo married;
    int children;
    YesOrNo car;
    YesOrNo save_act;
    YesOrNo current_act;
    YesOrNo mortgage;
    YesOrNo pep;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income=income;
    }

    public YesOrNo getMarried() {
        return married;
    }

    public void setMarried(YesOrNo married) {
        this.married = married;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public YesOrNo getCar() {
        return car;
    }

    public void setCar(YesOrNo car) {
        this.car = car;
    }

    public YesOrNo getSave_act() {
        return save_act;
    }

    public void setSave_act(YesOrNo save_act) {
        this.save_act = save_act;
    }

    public YesOrNo getCurrent_act() {
        return current_act;
    }

    public void setCurrent_act(YesOrNo current_act) {
        this.current_act = current_act;
    }

    public YesOrNo getMortgage() {
        return mortgage;
    }

    public void setMortgage(YesOrNo mortgage) {
        this.mortgage = mortgage;
    }

    public YesOrNo getPep() {
        return pep;
    }

    public void setPep(YesOrNo pep) {
        this.pep = pep;
    }


}
