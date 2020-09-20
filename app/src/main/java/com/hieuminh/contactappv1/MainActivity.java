package com.hieuminh.contactappv1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hieuminh.contactappv1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private myAdapter adapter;
    private ArrayList<Contact> arrContacts = new ArrayList<>();
    private ContactDatabase contactDatabase;
    private ContactDao contactDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrContacts.add(new Contact(1,"One","0123456789","",""));
        arrContacts.add(new Contact(1,"Two","0134567895","",""));
        arrContacts.add(new Contact(1,"Three","0324825255","",""));
        arrContacts.add(new Contact(1,"Four","0355464621","",""));
        arrContacts.add(new Contact(1,"Five","0387256255","",""));
//        arrContacts.add(new Contact(1,"Six","0983325252","",""));
//        arrContacts.add(new Contact(1,"Seven","0156982426","",""));
//        arrContacts.add(new Contact(1,"Eigh","0354982525","",""));
//        arrContacts.add(new Contact(1,"Nine","0355555555","",""));
//        arrContacts.add(new Contact(1,"Ten","0785222522","",""));
//        arrContacts.add(new Contact(1,"Eleven","0385555555","",""));
//        arrContacts.add(new Contact(1,"Twelve","0385856664","",""));
//        arrContacts.add(new Contact(1,"Thirteen","0355158158","",""));
//        arrContacts.add(new Contact(1,"Fourteen","0442521455","",""));
//        arrContacts.add(new Contact(1,"Fiften","0148522555","",""));



        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
//                contactDatabase = ContactDatabase.getInstance(getApplicationContext());
//                contactDao = contactDatabase.contactDao();
//                List<Contact> dbContacts = contactDao.getAllContact();
//                for(Contact contact : dbContacts) {
//                    arrContacts.add(contact);
//                }
//                adapter.notifyDataSetChanged();
            }
        });

        Intent intent = getIntent();
        if(intent != null) {
            Contact contact = (Contact)intent.getSerializableExtra("contactAdd");
//            try {
//                contactDao.insertContacts(contact);
//            } catch (NullPointerException e) {
//                System.out.println(e);
//            }
            arrContacts.add(contact);
        }

        adapter = new myAdapter(arrContacts,this);
        binding.rvItem.setHasFixedSize(true);
        binding.rvItem.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItem.setAdapter(adapter);

        binding.svSearch.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        binding.fabAdd.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this,AddContactActivity.class);
            startActivity(intent1);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_menu,menu);
//        SearchView searchView = (SearchView) menu.getItem(R.id.action_search).getActionView();
//        SearchView searchView = (SearchView) menu.getItem(R.id.action_search).getActionView();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId() == R.id.action_search) {
//
//        }
        return true;
    }
}