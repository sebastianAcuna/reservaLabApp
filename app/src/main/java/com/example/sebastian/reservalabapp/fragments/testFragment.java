package com.example.sebastian.reservalabapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sebastian.reservalabapp.R;



public class testFragment extends Fragment {

    private EditText textData;
    private Button btnSend;
    private DataListener  callback;

    //constructor
    public testFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            callback = (DataListener) context;
        }catch(Exception e ){
            throw new ClassCastException(context.toString() + "should implement DataListener ");
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test, container,false);


        textData = view.findViewById(R.id.et_frag);
        btnSend = view.findViewById(R.id.btn_frag);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(textData.getText().toString());
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void sendText(String name){
        callback.sendData(name);
    }

    public interface DataListener{
        void sendData(String text);
    }

}
