package net.nemesis.democallbacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtText;

    private ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtText = findViewById(R.id.main_activity_text);

        loadContacts();
    }

    private void loadContacts(){
        Contact.loadContacts(new LoadContactsListener() {
            @Override
            public void onLoadContacts(ArrayList<Contact> items) {
                contacts = items;
                showContacts();
            }

            @Override
            public void onFailLoadContacts(String error) {
                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showContacts(){
        String text = "";
        for(Contact contact : contacts){
            text = text + contact.getName() + "\n";
        }

        txtText.setText(text);
    }
}
