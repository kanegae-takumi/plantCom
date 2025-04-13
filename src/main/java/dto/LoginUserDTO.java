package dto;

public class LoginUserDTO {
    private int id;
    private String account_name;
    private String name;
    private String email;

    public LoginUserDTO(int id, String account_name, String name, String email) {
        this.id = id;
        this.account_name = account_name;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getAccount_name() { return account_name; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setId(int id) { this.id = id; }
    public void setAccount_name(String account_name) { this.account_name = account_name; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}
