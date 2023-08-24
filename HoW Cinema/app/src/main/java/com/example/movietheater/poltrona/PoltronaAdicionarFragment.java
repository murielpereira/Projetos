package com.example.movietheater.poltrona;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movietheater.R;
import com.example.movietheater.database.DatabaseHelper;


public class PoltronaAdicionarFragment extends Fragment {

    private EditText etDisponivel;

    public PoltronaAdicionarFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_poltrona_adicionar, container, false);

        etDisponivel = v.findViewById(R.id.editText_nome_disponivel);

        Button btnAdicionar = v.findViewById(R.id.button_adicionar_poltrona_disponivel);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionar();
                }
            });
            // Inflate the layout for this fragment
        return v;
        }
        private void adicionar() {
            if (etDisponivel.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Por favor, informe se a poltrona esta disponível", Toast.LENGTH_LONG).show();
            } else {
                DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
                Poltrona p = new Poltrona();
                p.setDisponivel(etDisponivel.getText().toString());
                databaseHelper.createpoltronaDisponivel(p);
                Toast.makeText(getActivity(), "Poltrona salva", Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_poltrona, new ListarFragment()).commit();
            }
        }
    }

