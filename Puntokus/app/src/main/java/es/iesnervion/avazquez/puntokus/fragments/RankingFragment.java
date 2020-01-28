package es.iesnervion.avazquez.puntokus.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.iesnervion.avazquez.puntokus.R;
import es.iesnervion.avazquez.puntokus.entities.Game;
import es.iesnervion.avazquez.puntokus.entities.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment {


    public RankingFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.listView_ranking)
    ListView listViewRanking;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    ArrayList<String> listaPartidas;
    Game partida;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        ButterKnife.bind(this,view);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        listaPartidas = new ArrayList<>();
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                        listaPartidas);

        databaseReference.child("Games").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds: dataSnapshot.getChildren()){
                        partida = new Game();
                        for(DataSnapshot hijo: ds.getChildren()){

                            switch (hijo.getValue().toString().trim()){
                                case "email":
                                    partida.setEmail(hijo.child("email").getValue().toString());
                                    break;
                                case "level":
                                    partida.setLevel(hijo.child("level").getValue().toString());
                                    break;
                                case "timeInMilis":
                                    partida.setTimeInMilis(Long.parseLong(hijo.child("timeInMilis").getValue().toString()));
                                    break;

                            }
                        }
                        listaPartidas.add(partida.toString());
                    }

                listViewRanking.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }

}
