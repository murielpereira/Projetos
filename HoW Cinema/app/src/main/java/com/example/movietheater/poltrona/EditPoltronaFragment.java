package com.example.movietheater.poltrona;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaDataSource;
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


public class EditPoltronaFragment extends Fragment {
    private EditText etDisponivel;
    private Poltrona p;
    private DatabaseHelper databaseHelper;


    public EditPoltronaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_edit_poltrona, container, false);

        etDisponivel = v.findViewById(R.id.editText_poltrona_disponivel);


        Bundle b = getArguments();
        int id_poltrona = b.getInt("id");
        databaseHelper = new DatabaseHelper(getActivity());
        p = databaseHelper.getPoltronaId(id_poltrona);
        etDisponivel.setText(p.getDisponivel());

        Button btnEditar = v.findViewById(R.id.button_editar_poltrona);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar(id_poltrona);
            }
        });
        Button btnExcluir = v.findViewById(R.id.button_excluir_poltrona);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.excluir_poltrona);
                builder.setPositiveButton("sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        excluir(id_poltrona);
                    }
                });
                builder.setNegativeButton("nao", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Não faz nada
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return v;
    }

    private void editar(int id) {
        if (etDisponivel.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Por favor, a alteração na disponibilidade da poltrona", Toast.LENGTH_LONG).show();
        } else {
            p = new Poltrona();
            p.setId(id);
            p.setDisponivel(etDisponivel.getText().toString());
            Toast.makeText(getActivity(), "Poltrona atualizada", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_poltrona, new ListarFragment()).commit();
        }
    }

    private void excluir (int id) {
        p = new Poltrona();
        p.setId(id);
        databaseHelper.deletePoltronaDisponivel(p);
        Toast.makeText(getActivity(), "Poltrona excluído", Toast.LENGTH_LONG).show();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_poltrona, new ListarFragment()).commit();
    }
}