package com.abhijit.test.Fragments;

/**
 * Created by abhijit on 3/5/17.
 */

import android.content.res.TypedArray;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.abhijit.test.ListItems.Member;
import com.abhijit.test.R;
import com.abhijit.test.RecyclerAdapters.RecyclerAdapter;
import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment{

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private String[] names;
    private TypedArray profile_pics;
    private String[] time;
    private String[] desc;
    private List<Member> memberList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("in onCreateView");
        names = getResources().getStringArray(R.array.names);
        profile_pics = getResources().obtainTypedArray(R.array.profile_pics);
        time = getResources().getStringArray(R.array.time);
        desc = getResources().getStringArray(R.array.desc);

        memberList = new ArrayList<Member>();
        for (int i = 0; i < names.length; i++) {
            Member member = new Member(names[i], time[i], desc[i], profile_pics.getResourceId(i, -1));
            memberList.add(member);
        }
        View rootView = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        /*layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);*/

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        System.out.println("in onViewCreated");
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(memberList, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }


}
