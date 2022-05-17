package hcmute.edu.vn.foodapp_08.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hcmute.edu.vn.foodapp_08.R;


public class NotificationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

//        TextView openSetting = (TextView) view.findViewById(R.id.txtOpenSettingNotification);
//        openSetting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), SettingNotificationActivity.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }
}