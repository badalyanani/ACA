package com.example.ani.todo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


public class Fragment1 extends Fragment {
   private TextView editCalendar;
    private Button btnSave;
    private OnStateChangeListener onSaveListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Date currentTime = Calendar.getInstance().getTime();
        editCalendar = view.findViewById(R.id.txt_time);
        editCalendar.setText(currentTime.toString());
        btnSave = view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onSaveListener != null) {
                    onSaveListener.onSave();
                }
            }
        });



    }

    public void setOnSaveListener(OnStateChangeListener onSaveListener) {
        this.onSaveListener = onSaveListener;
    }

    public interface OnStateChangeListener{
        public void onSave();
    }
}

