package com.example.taweesoft.leftmenu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import net.simonvt.menudrawer.MenuDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MenuDrawer menuDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuDrawer = MenuDrawer.attach(this);
        menuDrawer.setContentView(R.layout.activity_main);
        menuDrawer.setMenuView(R.layout.side_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView listView = (ListView)findViewById(R.id.listView);
        Item item1 = new Item(R.drawable.ic_access_alarm_black_24dp , "Access Alarm");
        Item item2 = new Item(R.drawable.ic_account_balance_black_24dp , "Account Balance");
        Item item3 = new Item(R.drawable.ic_adb_black_24dp , "ADB");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        ListViewAdapter adapter = new ListViewAdapter(this,R.layout.item_layout,items);
        listView.setAdapter(adapter);
        replaceFragment(new Fragment1());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        replaceFragment(new Fragment1());
                        menuDrawer.toggleMenu(true);
                        break;
                    case 1:
                        replaceFragment(new Fragment2());
                        menuDrawer.toggleMenu(true);
                        break;
                }
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {

            menuDrawer.toggleMenu(true);
        }
        return super.onOptionsItemSelected(item);
    }

    public void replaceFragment(Fragment fragmnet) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragmnet)
                .addToBackStack(null)
                .commit();
    }
}
