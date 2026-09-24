package person;

public  class AccountHolder{
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getLastName() {
        return LastName;
    }

    private String Name;
    private String LastName;
    private String uuid;

    public AccountHolder(String lastName, String name) {
        LastName = lastName;
        Name = name;
        this.uuid = "...";
    }

}
