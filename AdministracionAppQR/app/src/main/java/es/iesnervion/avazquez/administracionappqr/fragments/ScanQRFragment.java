package es.iesnervion.avazquez.administracionappqr.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.iesnervion.avazquez.administracionappqr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanQRFragment extends Fragment {


    public ScanQRFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan_qr, container, false);
    }

}
