package com.example.yura.fragmentanimation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private Fragment fragment1;
    private Fragment fragment2;
    private FragmentTransaction transaction;
    private boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        transaction = getSupportFragmentManager().beginTransaction();


        transaction.replace(R.id.fragment, fragment1);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public void onClick(View v){
        transaction = getSupportFragmentManager().beginTransaction();

         //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        // transaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right);

        transaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right);

        if(fragment1.isVisible()){
            transaction.replace(R.id.fragment, fragment2);
        }else{
            transaction.replace(R.id.fragment, fragment1);
        }

        transaction.commit();
    }
}

