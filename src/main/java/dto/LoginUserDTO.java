package dto;

public class LoginUserDTO {
    private int id;
    private String account_name;
    private String name;
    private String email;
    private String profile_image;

    // ✔ 旧コンストラクタ（4つの引数）
    public LoginUserDTO(int id, String account_name, String name, String email) {
        this.id = id;
        this.account_name = account_name;
        this.name = name;
        this.email = email;
        this.profile_image = null;  // デフォルトでnull
    }

    // ✔ 新コンストラクタ（5つの引数）
    public LoginUserDTO(int id, String account_name, String name, String email, String profile_image) {
        this.id = id;
        this.account_name = account_name;
        this.name = name;
        this.email = email;
        this.profile_image = profile_image;
    }

    public int getId() { return id; }
    public String getAccount_name() { return account_name; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getProfile_image() { return profile_image; }

    public void setId(int id) { this.id = id; }
    public void setAccount_name(String account_name) { this.account_name = account_name; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setProfile_image(String profile_image) { this.profile_image = profile_image; }
}
