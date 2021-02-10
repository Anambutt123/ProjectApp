package com.example.blooddonor;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DonorList extends Fragment {

    private RecyclerView donorRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DonorCustomAdapter mAdapter;
    private EditText searchBar;


    private List<String> list;
    ArrayList<Donor> donors;
    DonorCustomAdapter mainAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.donor_list, container, false);

        donorRecyclerView=view.findViewById(R.id.recyclerview_donor);
        searchBar = view.findViewById(R.id.search_bar);
        donorRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        donorRecyclerView.setLayoutManager(layoutManager);
        donorRecyclerView.setHasFixedSize(true);
        donors = new ArrayList();
        donors.add(new Donor("Ayesha","0303030303030","Lahore","A+"));
        donors.add(new Donor("Amna","0303030303030","Lahore","A-"));
        donors.add(new Donor("kiran","0303030303030","Islamabad","B+"));
        donors.add(new Donor("Sobia","0303030303030","Karachi","O+"));
        donors.add(new Donor("Fatima","0303030303030","Karachi","O+"));
        donors.add(new Donor("Hiba","0303030303030","Karachi","B+"));
        donors.add(new Donor("Farwa","0303030303030","Karachi","O-"));
        donors.add(new Donor("Laiba","0303030303030","Karachi","B-"));

        mainAdapter = new DonorCustomAdapter(getActivity(), donors);
       donorRecyclerView.setAdapter(mainAdapter);


        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().isEmpty()){
                    mainAdapter = new DonorCustomAdapter(getActivity(), donors);
                    donorRecyclerView.setAdapter(mainAdapter);
                }else {
                    SearchValue(s.toString());
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                //Log.e("TextWatcherTest", "afterTextChanged:\t" +s.toString());
            }
        });
        return view;
    }

    public void SearchValue(String search){
        ArrayList<Donor> arrayList = new ArrayList<>();
        for(int i=0;i<donors.size();i++){
            if(donors.get(i).getName().toLowerCase().contains(search.toLowerCase())){
                arrayList.add(donors.get(i));
            }

        }

        mainAdapter  = new DonorCustomAdapter(getActivity(),arrayList);
        donorRecyclerView.setAdapter(mainAdapter);

    }



}