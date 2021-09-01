package RecyclerViews;

public class UserHelper {
    private String First_Name;
    private String Last_Name;
    private String Password;
    private String Email;
    private int number =1;
    private String imageUrl;


    UserHelper(){

    }
    public UserHelper(String imageUrl , int number){
        this.imageUrl = imageUrl;
        this.number = number;
    }
    public UserHelper(String Email ,String Password){
        this.Email = Email;
        this.Password = Password;
    }

    public UserHelper(String first_Name, String last_Name, String password) {
        First_Name = first_Name;
        Last_Name = last_Name;
        Password = password;
    }
    public String getImageUrl(){
        return imageUrl;
    }

    public UserHelper(String email) {
        Email = email;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }
}
