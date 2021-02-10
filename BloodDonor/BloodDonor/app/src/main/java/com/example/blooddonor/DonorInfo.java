package com.example.blooddonor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DonorInfo extends Fragment {
    TextView DName, DNumber, DAddress, DGroup, userName_Txt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view =inflater.inflate(R.layout.donor_info, container, false);
        Bundle bundle = this.getArguments();

        if(bundle != null){
            Donor InfoDonor = new Donor();
            Object infoDonor = (String) bundle.getSerializable("donor");
        }

        init(view);
      return view;
    }

    private void init(View view) {

        userName_Txt = view.findViewById(R.id.userNameTxt);
        DName = view.findViewById(R.id.first_nameTxt);
        DNumber = view.findViewById(R.id.second_nameTxt);
       DAddress = view.findViewById(R.id.address);
       DGroup = view.findViewById(R.id.B_group);



      // DNumber.setTe

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            Donor donor = new Donor();
            donor = DonorCustomAdapter.donor;
            userName_Txt.setText(donor.getName());
            DName.setText(donor.getName());
            DNumber.setText(donor.getNumber());
            DAddress.setText(donor.getAddress());
            DGroup.setText(donor.getBgroup());
        }
        else {
        }
    }
}