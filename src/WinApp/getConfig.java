/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WinApp;


public class getConfig {
   private String ClassName, URLName, username, password;

   
   public void setConfigServer(String ClassName, String URLName, String username, String password){
      this.ClassName = ClassName;
      this.URLName = URLName;
      this.username = username;
      this.password = password;
   }
   
    public String getClassName(){
       return ClassName;
   }
    
    public String getURLName(){
       return URLName;
   }
    public String getUsername(){
       return username;
   }
    public String getPassword(){
       return password;
   }
}
