package JavaFundamentals;

//implements Comparable<User>
public class User {
    private Integer id;
    private String name;
    private String address;
    private Integer age;

    public User() {
    }

    public User(Integer id, String name, String address, Integer age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
    
    /**
    //implement comparable only if we need to sort on single parameter else implement comparator
    @Override
    public int compareTo(User user) {
        return this.id - user.id;
    }
    **/
}
