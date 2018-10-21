/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;

/**
 * @author Kanmani
 */
public class Midlet_1 extends MIDlet implements CommandListener {
    Command register,alreadyRegister,back,getLogin,bill,vehi,ans;
    Display display;
    Form reg,login,user;
    TextField name,no,city,pswd,userno,pswd1,km;
    RecordStore db;
    String username;
    List vehicle;
    
    
    
   public  Midlet_1() throws RecordStoreException
    {
        //db=RecordStore.openRecordStore("myapp", true);
        
        
        int num;
        
        display=Display.getDisplay(this);
        name=new TextField("Name: ","",30,TextField.ANY);
        no=new TextField("Phone number: ","",30,TextField.PHONENUMBER);
        city=new TextField("City: ","",30,TextField.ANY);
        pswd=new TextField("Password: ","",30,TextField.PASSWORD);
        userno=new TextField("User Phone Number","",30,TextField.PHONENUMBER);
        pswd1=new TextField("Password","",30,TextField.PASSWORD);
        km=new TextField("Give Kms","",30,TextField.DECIMAL);
        register=new Command("Register",Command.OK,1);
        reg=new Form("Register Page");
        login=new Form("Login Page");
        user=new Form("User Page");
        alreadyRegister=new Command("Registered",Command.OK,2);
        back=new Command("Cancel",Command.CANCEL,3);
        getLogin=new Command("Sign up",Command.OK,4);
        bill=new Command("Calulate ",Command.OK,4);
        vehicle=new List("Choose Vehicle",List.EXCLUSIVE);
        vehi=new Command("get Vehicle",Command.OK,5);
        ans=new Command("View",Command.OK,4);
        
        
        
    }
    public void startApp() {
        reg.append(name);
        reg.append(no);
        reg.append(city);
        reg.append(pswd);
        reg.addCommand(register);
        reg.addCommand(alreadyRegister);
        reg.setCommandListener(this);
        display.setCurrent(reg);
     user.setCommandListener(this);
          login.setCommandListener(this);
       login.append(userno);
     login.append(pswd1);
        login.addCommand(getLogin);  
        
        user.append(km);
        vehicle.append("Scorpio",null);
        vehicle.append("Maruti",null);
        vehicle.append("Omni",null);
        user.addCommand(bill);
       user.addCommand(vehi);       
       vehicle.addCommand(ans);
       vehicle.setCommandListener(this);
           
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        String label=c.getLabel();
        
        if(label.equals("Register")){
            /*frm1.addCommand(ok);
        frm1.addCommand(b2);
            display.setCurrent(frm1);
            byte data1=Byte.parseByte(name.getString());
            byte data2=Byte.parseByte(no.getString());
            byte data3=Byte.parseByte(city.getString());
            byte data4=Byte.parseByte(pswd.getString());
            byte[] data=new byte[]{data1,data2,data3,data4};*/
            
            Alert al=new Alert("You are registering");
            al.setType(AlertType.CONFIRMATION);
            display.setCurrent(al);
        
    }
    else if(label.equals("Registered"))
    {
               
            display.setCurrent(login);
    }
    else if(label.equals("Sign up"))
    {
        System.out.println(no.getString());
        if(no.getString().equals(userno.getString())&&pswd.getString().equals(pswd1.getString()))
        {
            
            Alert al=new Alert("you are loggin in");
            al.setType(AlertType.INFO);
            display.setCurrent(al);
            display.setCurrent(user);
           
        }
        else{
            Alert al=new Alert("Wrong user id and Password or not registered ");
            al.setType(AlertType.ERROR);
            display.setCurrent(al);
            
            display.setCurrent(reg);
            
        }
        
    }
        
    else if(label.equals("get Vehicle"))
    {
        display.setCurrent(vehicle);
     }
    else if(label.equals("View"))
     {
            int answer,km1;
            km1=Integer.parseInt(km.getString());
            String item=vehicle.getString(vehicle.getSelectedIndex());
            if(item.equals("Scorpio"))
                answer=km1*7;
            else if(item.equals("Maruti"))
                answer=km1*8;
                
            else if(item.equals("Omni"))
                answer=km1*6;
            else
                answer=9;
            
            Alert al=new Alert("You have to pay "+Integer.toString(answer));
            al.setType(AlertType.INFO);
            display.setCurrent(al);
               
                
           
     }
}
}
