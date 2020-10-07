package com.example.projetoandroidfaculdade.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projetoandroidfaculdade.R;
import com.example.projetoandroidfaculdade.debug.DebugActivity;

public class AddressActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
    }
}