package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class F_Home extends Fragment {

    EditText et_haru;
    ImageView img1,img2,img3,img4,img5,img6;
    Button btn_Main_Save;
    // 식사
    Button btn_NE, btn_EJal, btn_ELittle, btn_EGwa, btn_EPok;
    // 잠
    Button btn_NS, btn_S4, btn_S56, btn_S79, btn_TheS;
    RadioGroup radioGroup_ex, radioGroup_e, radioGroup_s, radioGroup_f;
    int i = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_f__home, container, false);

        //아이디 초기화
        radioGroup_ex=view.findViewById(R.id.radioGroup_ex);
        radioGroup_e=view.findViewById(R.id.radioGroup_e);
        radioGroup_s=view.findViewById(R.id.radioGroup_s);
        radioGroup_f=view.findViewById(R.id.radioGroup_f);
        ImageButton btn_calendar= view.findViewById(R.id.btn_calendar);
        // 기분
        img1=view.findViewById(R.id.img1);
        img2=view.findViewById(R.id.img2);
        img3=view.findViewById(R.id.img3);
        img4=view.findViewById(R.id.img4);
        img5=view.findViewById(R.id.img5);
        img6=view.findViewById(R.id.img6);
        //저장버튼
        btn_Main_Save=view.findViewById(R.id.btn_Main_Save);

        //한줄일기
        et_haru=view.findViewById(R.id.et_haru);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> Main = new HashMap<>();

        ConstraintLayout cl = view.findViewById(R.id.cl);
        cl.setFocusable(false);

        view.setFocusable(false);



            btn_Main_Save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int ex = radioGroup_ex.getCheckedRadioButtonId();
                    int e = radioGroup_e.getCheckedRadioButtonId();
                    int s = radioGroup_s.getCheckedRadioButtonId();
                    int f = radioGroup_f.getCheckedRadioButtonId();
                    RadioButton rb_ex = (RadioButton) view.findViewById(ex);
                    RadioButton rb_e = (RadioButton) view.findViewById(e);
                    RadioButton rb_s = (RadioButton) view.findViewById(s);
                    RadioButton rb_f = (RadioButton) view.findViewById(f);


                    Map<String, Object> Main = new HashMap<>();

                    Main.put("운동", rb_ex.getText().toString());
                    Main.put("식사", rb_e.getText().toString());
                    Main.put("수면", rb_s.getText().toString());
                    Main.put("감정", rb_f.getText().toString());
                    Main.put("한줄일기", et_haru.getText().toString());

                    db.collection("manage").document("manage" + i++)
                            .set(Main)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG", "DocumentSnapshot successfully written!");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("TAG", "Error writing document", e);
                                }
                            });


//                db.collection("Main").document("21/08/21").set(Main);
//                db.collection("Main")
//                        .add(Main)
//                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                            @Override
//                            public void onSuccess(DocumentReference documentReference) {
//                                Log.d("테스트", "DocumentSnapshot added with ID: " + documentReference.getId());
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.w("테스트", "Error adding document", e);
//                            }
//                        });
                    Toast.makeText(getContext().getApplicationContext(), "저장 성공!", Toast.LENGTH_SHORT).show();
                    et_haru.setText(null);
                    rb_ex.setChecked(false);
                    rb_e.setChecked(false);
                    rb_s.setChecked(false);
                    rb_f.setChecked(false);

                }


            });


        //캘린더버튼 눌렀을때
        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Calendar.class);
                startActivity(intent);
            }
        });


        return view;
    }
}