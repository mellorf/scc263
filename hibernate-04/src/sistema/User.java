package sistema;

public class User {
    private Long id;
    private String name;
    private String address;

    public User() {}  // Hibernate obriga tal método com construtor vazio
    		      // Ele utiliza Reflection API para criar objetos, por
		      // isso necessita desse construtor
    public Long getId() { return id; }
    private void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
