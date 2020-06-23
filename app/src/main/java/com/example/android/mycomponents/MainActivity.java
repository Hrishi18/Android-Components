package com.example.android.mycomponents;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout rootLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.myLayout);

        FloatingActionButton fab = findViewById(R.id.fab);

        android.support.v7.widget.Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Basic Components");
        mToolbar.setSubtitle("by Hrishikesh");

        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.simple_snackbar:
                        showSimpleSnackBar();
                        break;
                    case R.id.snackbar_action_callback:
                        showSnackBarWithActionCallBack();
                        break;
                    case R.id.custom_snackbar:
                        showCustomSnackBar();
                        break;
                }

                return false;
            }
        });


    }

    private void showCustomSnackBar() {

        Snackbar snackbar = Snackbar.make(rootLayout, "Error Deleting File", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(rootLayout, "File NOT DELETED",Snackbar.LENGTH_SHORT).show();

                    }
                });
        snackbar.show();
        View snackbarLayout = snackbar.getView();
        snackbarLayout.setBackgroundColor(Color.RED);

    }

    private void showSnackBarWithActionCallBack() {
        Snackbar snackbar = Snackbar.make(rootLayout,"File Deleted Succesfully",Snackbar.LENGTH_LONG);
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Snackbar.make(rootLayout, "File recovered succesfully",Snackbar.LENGTH_SHORT).show();

            }
        });
        snackbar.show();


    }

    private void showSimpleSnackBar() {
        Snackbar.make(rootLayout,"Simple Snack Bar Example",Snackbar.LENGTH_LONG).show();

    }

    public void doFab(View view) {

        Snackbar.make(rootLayout, "Simple Snack Bar Example", Snackbar.LENGTH_LONG).show();    }
}
