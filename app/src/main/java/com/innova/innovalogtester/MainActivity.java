package com.innova.innovalogtester;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.innova.innovalogtester.R;
import com.innova.innovalogtester.annotations.TesterDebugLog;
import com.innova.innovalogtester.singleton.Injector;



public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.getInstance().setContext(this);
        Button button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//Muratcan Test branchi içerisinde gönderildi
//                cihanAyaktami();
//                fibonacci(4);
//                Greeter greeter = new Greeter("Jake");
//                greeter.sayHello();
//                Charmer charmer = new Charmer("Jake");
//                charmer.askHowAreYou();
//                startSleepyThread();
                ranaGicikOldumu2("value 1"," VALUE2");

//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Injector.getInstance().setMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @TesterDebugLog
    private  int foo(){
        return 12;
    }
    @TesterDebugLog
    private void printArgs(String... args) {
        for (String arg : args) {
            Log.i("Args", arg);
        }
    }

    @TesterDebugLog
    private int fibonacci(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than zero.");
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        // NOTE: Don't ever do this. Use the iterative approach!
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    private void startSleepyThread() {
        new Thread(new Runnable() {
            private static final long SOME_POINTLESS_AMOUNT_OF_TIME = 50;

            @Override public void run() {
                sleepyMethod(SOME_POINTLESS_AMOUNT_OF_TIME);
            }

            @TesterDebugLog
            private void sleepyMethod(long milliseconds) {
                SystemClock.sleep(milliseconds);
            }
        }, "I'm a lazy thr.. bah! whatever!").start();
    }

    static class Greeter {
        private final String name;

        @TesterDebugLog
        Greeter(String name) {
            this.name = name;
        }

        @TesterDebugLog
        public String sayHello() {
            return "Hello, " + name;
        }
    }

    @TesterDebugLog
    static class Charmer {
        private final String name;

        Charmer(String name) {
            this.name = name;
        }

        public String askHowAreYou() {
            return "How are you " + name + "?";
        }
    }

    @TesterDebugLog
    private boolean cihanAyaktami(){
        if(SystemClock.currentThreadTimeMillis()%2==0)
            return true;
        else
            return false;
    }

    @TesterDebugLog
    private boolean ranaGicikOldumu2(String str1, String str2){
        if(SystemClock.currentThreadTimeMillis()%2==0)
            return true;
        else
            return false;
    }
}
