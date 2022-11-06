package com.JNS.Ovitur.Fragments;

import android.os.Bundle;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.JNS.Ovitur.R;

public class FragmentListado extends Fragment {
    private String opcionSeleccionada;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("Se carga el fragment");
        TextView textView = view.findViewById(R.id.ftvTitutlo);
        textView.setText(this.opcionSeleccionada);
    }

    public void setDatos(String datos){
        this.opcionSeleccionada = datos;
    }
}
