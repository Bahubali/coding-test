package com.main;

import com.common.Human;

/**
 * Created by bahubali.n on 21/02/17.
 */
public class Boy extends Human {

    @Override
    public void eatingHabits() {

    }

//    private void sayHello() {
//        System.out.println("I'm child class method");
//    }

    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.sayHello();
    }
}
