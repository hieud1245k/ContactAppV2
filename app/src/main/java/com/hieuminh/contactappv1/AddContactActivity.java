package com.hieuminh.contactappv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.hieuminh.contactappv1.databinding.ActivityMainBinding;

import java.io.Serializable;

import static com.hieuminh.contactappv1.R.layout.activity_add_contact;

public class AddContactActivity extends AppCompatActivity {

    private EditText et_fullNameAdd, et_mobilePhoneAdd, et_emailAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_add_contact);
        ConnectView();
    }

    private void ConnectView() {
        et_fullNameAdd = findViewById(R.id.et_fullNameAdd);
        et_mobilePhoneAdd = findViewById(R.id.et_mobilePhoneAdd);
        et_emailAdd = findViewById(R.id.et_emailAdd);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_done) {
            Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
            Contact contact = new Contact(1, et_fullNameAdd.getText().toString()
                    , et_mobilePhoneAdd.getText().toString(), "", et_emailAdd.getText().toString());
            intent.putExtra("contactAdd", contact);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_back) {
            Intent intent = new Intent(AddContactActivity.this,MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}