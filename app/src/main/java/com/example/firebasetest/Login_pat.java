package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;

public class Login_pat extends AppCompatActivity {

    Button btn_login_pat;
    TextView tv_join_pat;
    EditText et_login_id, et_login_pw;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    String login_id, login_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pat);


        firebaseAuth = FirebaseAuth.getInstance();


        btn_login_pat = findViewById(R.id.btn_login_pat);
        tv_join_pat = findViewById(R.id.tv_join_pat);
        et_login_id = findViewById(R.id.et_login_id);
        et_login_pw = findViewById(R.id.et_login_pw);

        login_id = et_login_id.getText().toString();
        login_pw = et_login_pw.getText().toString();

        // Create a reference to the cities collection
        CollectionReference citiesRef = db.collection("KIMGA");
        Intent intent = new Intent(Login_pat.this, Home.class);


        btn_login_pat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                login_id = et_login_id.getText().toString();
                login_pw = et_login_pw.getText().toString();

                db.collection("KIMGA")
                        /*.whereEqualTo("id", login_id)*/
                        //여기 주석 처리 해야지 나오더라구용
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        String id = document.getData().get("id").toString();
                                        String pw = document.getData().get("pw").toString();

                                        if(id.equals(login_id)&&pw.equals(login_pw)){
                                            Toast.makeText(Login_pat.this, "로그인성공", Toast.LENGTH_SHORT).show();
                                            startActivity(intent);
                                            break;
                                        }


                                        Log.d("TAG", document.getId() + " => " + document.getData());
                                    }
                                } else {
                                    Log.d("TAG", "Error getting documents: ", task.getException());
                                }
                            }
                        });


            }
        });


        tv_join_pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Join_pat.class);
                startActivity(intent2);
            }
        });



    }
}

