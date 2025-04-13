package dto;

public class LoginUserDTO {
    private int id;
    private String accountName;
    private String name;
    private String email;

    public LoginUserDTO(int id, String accountName, String name, String email) {
        this.id = id;
        this.accountName = accountName;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getAccountName() { return accountName; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setId(int id) { this.id = id; }
    public void setAccountName(String accountName) { this.accountName = accountName; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}
