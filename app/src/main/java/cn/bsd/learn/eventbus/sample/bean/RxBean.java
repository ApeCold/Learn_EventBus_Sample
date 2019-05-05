package cn.bsd.learn.eventbus.sample.bean;

public class RxBean {
    private String name;
    private String phone;
    private int gender;
    private int age;

    public RxBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EventBean{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
