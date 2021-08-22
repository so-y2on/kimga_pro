package com.example.firebasetest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link F_Mypage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class F_Mypage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public F_Mypage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment F_Mypage.
     */
    // TODO: Rename and change types and number of parameters
    public static F_Mypage newInstance(String param1, String param2) {
        F_Mypage fragment = new F_Mypage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView tv_my_name, tv_my_nick, tv_my_num;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_f__mypage, container, false);

        // Inflate the layout for this fragment

        tv_my_name= view.findViewById(R.id.tv_my_name);
        tv_my_nick=view.findViewById(R.id.tv_my_nick);
        tv_my_num=view.findViewById(R.id.tv_my_num);

        SharedPreferences spf = getActivity().getSharedPreferences("LoginID", Context.MODE_PRIVATE);
        String loginId = spf.getString("loginId", "s");

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //CollectionReference citiesRef = db.collection("KIMGA");

        db.collection("KIMGA")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                if (loginId.equals(document.getData().get("id").toString())) {

                                    String name = document.getData().get("name").toString();
                                    Log.d("테스트1", document.getData().get("name").toString());
                                    String nick = document.getData().get("nick").toString();
                                    Log.d("테스트2", document.getData().get("nick").toString());
                                    String num = document.getData().get("pro_num").toString();
                                    Log.d("테스트3", document.getData().get("pro_num").toString());

                                    tv_my_name.setText(name);
                                    tv_my_nick.setText(nick);
                                    tv_my_num.setText(num);
                                }
                               /* if(id.equals(login_id)&&pw.equals(login_pw)){
                                    Toast.makeText(F_Mypage.this, "로그인성공", Toast.LENGTH_SHORT).show();

                                    break;
                                }*/

                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });






        return view;
    }
}