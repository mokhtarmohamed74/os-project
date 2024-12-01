/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalFunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author youssif
 */
public class commands {
   public boolean addUser(String username) throws IOException{
       if(checkUser(username))return false;
       Runtime.getRuntime().exec("sudo useradd "+username);  
       return true; 
   }
   
   public boolean deleteUser(String username) throws IOException{
       if(!checkUser(username))return false;
       Runtime.getRuntime().exec("sudo userdel "+username);
       return true;
   }
   public boolean addGroup(String groupName) throws IOException{
       if(checkGroup(groupName))return false;
       Runtime.getRuntime().exec("sudo groupadd, "+groupName);
       return true;
   }
   public boolean deleteGroup(String groupName) throws IOException{
       if(!checkGroup(groupName))return false;
       Runtime.getRuntime().exec("sudo groupdel, "+groupName);
       return true;
   }
   public boolean addUserToGroup(String username,String groupName) throws IOException{
       if(checkUserInGroup(groupName, username))return false;
       Runtime.getRuntime().exec("sudo usermod -a -G "+groupName+" "+username);
       return true;
   }
   
private boolean checkUser(String username) throws IOException{
Process p = Runtime.getRuntime().exec("cat /etc/passwd");
InputStream is = p.getInputStream();

BufferedReader reader = new BufferedReader(new InputStreamReader(is));
String line = null;
while ((line = reader.readLine()) != null) {
   String data[]=line.split(":");
    if(data[0].equals(username)){
        //user found
        return true;
    }
}
return false;
}
private boolean checkGroup(String username) throws IOException{
Process p = Runtime.getRuntime().exec("cat /etc/group");
InputStream is = p.getInputStream();

BufferedReader reader = new BufferedReader(new InputStreamReader(is));
String line = null;
while ((line = reader.readLine()) != null) {
   String data[]=line.split(":");
    if(data[0].equals(username)){
        //group found
        return true;
    }
}
return false;
}
private boolean checkUserInGroup(String groupName,String username) throws IOException{
Process p = Runtime.getRuntime().exec("cat /etc/group");
InputStream is = p.getInputStream();

BufferedReader reader = new BufferedReader(new InputStreamReader(is));
String line = null;
while ((line = reader.readLine()) != null) {
  String data[]=line.split(":");
   
  if(data[0].equals(groupName)){
  
    String users[]=data[3].split(",");
    for(String user:users){
        if(user.equals(username)){
            return true;
        }
    }
   }
}
return false;
}
 public void changePassword(String username,String password) throws IOException{
     Runtime.getRuntime().exec("setpass "+username+" "+password);
 }
 public boolean changeUserName(String oldUserName,String newUserName) throws IOException{
     if(!checkUser(oldUserName))return false;
      Runtime.getRuntime().exec("sudo usermod -l "+newUserName+" "+oldUserName);
     return true;
 }
}

