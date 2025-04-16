package dto;

public class UserDTO {
    private int id;  // IDフィールドを追加
    private String account_name;
    private String name;
    private String email;
    private String password;
    private String profileImage;

    public UserDTO(String account_name, String name, String email, String password) {
        this.account_name = account_name;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImage = "notice-icon.png"; // デフォルト値
    }

    // 新しいコンストラクタ（画像あり用）
    public UserDTO(String account_name, String name, String email, String password, String profileImage) {
        this.account_name = account_name;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage != null && !profileImage.isEmpty() ? profileImage : "notice-icon.png";
    }

    // getter & setter
    public int getId() { return id; }  // getIdメソッドを追加
    public void setId(int id) { this.id = id; }  // setIdメソッドを追加

    public String getAccount_Name() { return account_name; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getProfileImage() { return profileImage; }

    public void setAccount_Name(String account_name) { this.account_name = account_name; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage != null && !profileImage.isEmpty() ? profileImage : "notice-icon.png";
    }
}
