package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Join_pat extends AppCompatActivity {



    Button btn_join_pat;
    EditText et_pat_id, et_pat_pw, et_pat_name, et_pat_nick, et_pro_num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_pat);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //아이디 초기화
        et_pat_id = findViewById(R.id.et_pat_id);
        et_pat_pw = findViewById(R.id.et_pat_pw);
        et_pat_name = findViewById(R.id.et_pat_name);
        et_pat_nick = findViewById(R.id.et_pat_nick);
        et_pro_num = findViewById(R.id.et_pro_num);
        btn_join_pat = findViewById(R.id.btn_join_pat);



//회원가입 버튼
    btn_join_pat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String pat_id = et_pat_id.getText().toString();
            String pat_pw = et_pat_pw.getText().toString();
            String pat_name = et_pat_name.getText().toString();
            String nick = et_pat_nick.getText().toString();
            String pro_num = et_pro_num.getText().toString();


            //DB에 값 넣기
            Map<String, Object> Join = new HashMap<>();
            Join.put("id",et_pat_id.getText().toString());
            Join.put("pw", et_pat_pw.getText().toString());
            Join.put("name", et_pat_name.getText().toString());
            Join.put("nick", et_pat_nick.getText().toString());
            Join.put("pro_num", et_pro_num.getText().toString());

            db.collection("Member")
                    .add(Join)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("테스트", "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("테스트", "Error adding document", e);
                        }
                    });



            Intent intent = new Intent(getApplicationContext(), Login_pat.class);
            startActivity(intent);



        }
    });




    }
}