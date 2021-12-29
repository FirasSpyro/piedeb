package isetb.pidev.projetpidev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InscriptionActivity extends AppCompatActivity {
    EditText t1 , t2 ,t3,t4 ,t5;
    Button b1 , b2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscri);
        t1=findViewById(R.id.nom);
        t2=findViewById(R.id.prenom);
        t3=findViewById(R.id.edit_email);
        t4=findViewById(R.id.password);
        t5=findViewById(R.id.confirm_password);
        b1=findViewById(R.id.inscrire);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp1 = getSharedPreferences("MyInfo", MODE_PRIVATE);
                SharedPreferences.Editor esp = sp1.edit();
                String np1 = t1.getText().toString();
                esp.putString("nom", np1);


                String np2 = t2.getText().toString();
                esp.putString("login", np2);


                String np3 = t3.getText().toString();
                esp.putString("email", np3);


                String np4 = t4.getText().toString();
                esp.putString("mdp", np4);


                String np5 = t5.getText().toString();
                if (np4.equals(np5))
                {
                    esp.commit();
                    Intent intent = new Intent(InscriptionActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(InscriptionActivity.this,"mot de pass non valide",Toast.LENGTH_LONG).show();
                esp.putString("confirm",np5);
            }
        });



    }
}