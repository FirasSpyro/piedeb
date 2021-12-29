package isetb.pidev.projetpidev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1 = findViewById(R.id.edit_login);
        e2 = findViewById(R.id.editPassword);
        b1 = findViewById(R.id.connexion);
        b2  = findViewById(R.id.inscription);

b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String log = e1.getText().toString();
        String pw = e2.getText().toString();
        if (log.equals("") || pw.equals(""))
            Toast.makeText(LoginActivity.this, "champs vides", Toast.LENGTH_LONG).show();
        else {
            SharedPreferences sp = getSharedPreferences("Myinfo", MODE_PRIVATE);
            String login = sp.getString("login", "error");
            String password = sp.getString("password", "error");
            if (!log.equals(login) || pw.equals(password))
                Toast.makeText(LoginActivity.this, "login ou mot de pass incorrect ", Toast.LENGTH_LONG).show();
            else {
                Toast.makeText(LoginActivity.this, " CONNEXION", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("log", login);
                startActivity(intent);

            }
        }
    }

});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });
    }
}
