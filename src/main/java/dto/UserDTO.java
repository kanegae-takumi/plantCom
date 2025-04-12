package dto;

public class UserDTO {
	private String account_name;
    private String name;
    private String email;
    private String password;

    public UserDTO(String account_name, String name, String email, String password) {
    	this.account_name = account_name;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // getter & setter
    public String getAccount_Name() { return account_name; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setAccount_Name(String account_name) { this.account_name = account_name; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
