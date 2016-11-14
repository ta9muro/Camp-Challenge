/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;


/**
 *
 * @author takuyamuroyama
 */
public class loginLogic {
    public boolean execute(UserData ud){
        if((ud.getName() != null) && (ud.getPassword() != null)){
            return true;
        }else{
            return false;
        }
    }
    
}
