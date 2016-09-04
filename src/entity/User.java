package entity;

public class User{

private Integer Id;
private String Username;
private String Password;
private String Email;


public User(){
 
}

public User(Integer id,String username,String password, String email){
	this.Id=id;
	this.Username = username;
	this.Password = password;
    this.Email=email;
	
}


public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	this.Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	this.Password = password;
}

public Integer getId() {
	return Id;
}


public void setId(Integer id) {
	this.Id = id;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}




}
