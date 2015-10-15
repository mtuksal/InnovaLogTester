package com.innova.innovalogtester.singleton;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.innova.innovalogtester.R;

/**
 * Created by mtuksal on 08.10.2015.
 */
public class Injector {
    private static boolean RECORDING=false;
    private static Injector injector;
    private Context context;
    private Menu menu;
    private Injector(){

    }
    public static Injector getInstance(){
        synchronized(Injector.class){
            if (injector== null) {
                injector = new Injector();
            }
            return injector;
        }
    }
    public void setMenu(Menu menu){

        MenuItem start_item = menu.add("Start Testing");
        MenuItem stop_item = menu.add("End Testing");

        start_item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startRecording();
                Toast.makeText(getContext(), "started", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        stop_item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                stopRecording();
                Toast.makeText(getContext(), "stoped", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
    public void setContext(Context context) {
        this.context=context;
        Button button = (Button) ((Activity) context).findViewById(R.id.btn1);
    }
    /**
     *This method is used in order to figure out shall we log current functions or not
     *
     */
    public boolean isRecording(){
        return this.RECORDING;
    }
    private void startRecording(){
        this.RECORDING=true;
    }
    private void stopRecording(){
        this.RECORDING=false;
    }
    public Context getContext() {
        return context;
    }

}
