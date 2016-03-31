package com.example.happy_fan.day30_layoutdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private static final String TAG = BlankFragment.class.getSimpleName();
    private TextView tv_show;

    public BlankFragment() {
        // Required empty public constructor
    }
    public static BlankFragment newInstance(Bundle bundle){
        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setArguments(bundle);
        return blankFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_second,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String name = arguments.getString("name", "未找到");
        tv_show = (TextView)view.findViewById(R.id.tv_show);
        if(savedInstanceState != null) {
            Log.d(TAG, "onViewCreated: savedInstanceState" + savedInstanceState.toString());
        }
        tv_show.setText(name);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: fragment被销毁了");
    }
}
