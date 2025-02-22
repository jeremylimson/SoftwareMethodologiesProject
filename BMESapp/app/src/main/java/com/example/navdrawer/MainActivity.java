package com.example.navdrawer;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;

    private String Username = "Admin";
    private String Password = "1234";

    boolean isValid = false;
    private int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        eName = findViewById(R.id.eName);
        ePassword = findViewById(R.id.ePassword);
        eLogin = findViewById(R.id.eLogin);
        eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "slow down there buckaroo, you forgot to type in a name and password", Toast.LENGTH_SHORT).show();
                }else{
                    isValid = validate(inputName, inputPassword);


                    if(!isValid) {

                        counter--;

                        Toast.makeText(MainActivity.this, "Woah there partner. That username and password combination just don't match. Try again", Toast.LENGTH_SHORT).show();

                        if (counter == 0) {
                            eLogin.setEnabled(false);
                        }
                    }else{

                        Toast.makeText(MainActivity.this, "\"1234\" Nice password pal", Toast.LENGTH_LONG).show();
                        setContentView(R.layout.activity_main);
                        Toolbar toolbar = findViewById(R.id.toolbar);
                        setSupportActionBar(toolbar);
                        FloatingActionButton fab = findViewById(R.id.fab);
                        fab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //figure out what to do later
                                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }

                        });
                        DrawerLayout drawer = findViewById(R.id.drawer_layout);
                        NavigationView navigationView = findViewById(R.id.nav_view);
                        // Passing each menu ID as a set of Ids because each
                        // menu should be considered as top level destinations.
                        mAppBarConfiguration = new AppBarConfiguration.Builder(
                                R.id.nav_home, R.id.nav_news, R.id.nav_calendar, R.id.nav_contacts)
                                .setOpenableLayout(drawer)
                                .build();
                        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, mAppBarConfiguration);
                        NavigationUI.setupWithNavController(navigationView, navController);
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
/*
    public void menu(View v) {

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //figure out what to do later
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_news, R.id.nav_calendar, R.id.nav_contacts)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }
*/
    private boolean validate(String name, String password){
if(name.equals(Username) && password.equals(Password)){
    return true;
}
        return false;
    }
}