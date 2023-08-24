package com.example.movietheater;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MenuFragment extends Fragment {

    public MenuFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSeat:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new com.example.movietheater.client.MainClientFragment()).commit();
                break;
            case R.id.menuMovie:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new com.example.movietheater.poltrona.PoltronaMainFragment()).commit();
                break;
            case R.id.menuClient:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new com.example.movietheater.movies.MainFragment()).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}