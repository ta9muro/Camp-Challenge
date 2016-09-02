/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import object.testHuman_2;
import object.testHuman;

/**
 *
 * @author ta9muro
 */
public class testHuman_2_Action {
    static public void main(String args[]){

testHuman_2 soeda = new testHuman_2();
soeda.setHuman("soeda", 33);

testHuman taku = new testHuman();
taku.setHuman("taku", 20);

soeda.kougi();
soeda.kaito();

taku.situmon();
taku.jishu();

  }
    
}



