package com.abhijit.test.RecyclerAdapters;

/**
 * Created by abhijit on 3/5/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.abhijit.test.ListItems.Member;
import com.abhijit.test.R;

import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MemberViewHolder> {

    private List<Member> members;
    private Context context;

    public RecyclerAdapter(List<Member> members, Context context) {
        this.members = members;
        this.context = context;
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView name;
        private TextView time;
        private TextView desc;
        private ImageView pic_iv;

        public MemberViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            name = (TextView) itemView.findViewById(R.id.member_name);
            time = (TextView) itemView.findViewById(R.id.member_time);
            desc = (TextView) itemView.findViewById(R.id.member_desc);
            pic_iv = (ImageView) itemView.findViewById(R.id.profile_pic);
        }
    }

    @Override
    public void onBindViewHolder(MemberViewHolder memberViewHolder, int i) {
        memberViewHolder.name.setText(members.get(i).getName());
        memberViewHolder.time.setText(members.get(i).getTime());
        memberViewHolder.desc.setText(members.get(i).getDesc());
        memberViewHolder.pic_iv.setImageResource(members.get(i).getPhotoID());
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_card, viewGroup, false);
        MemberViewHolder memberViewHolder = new MemberViewHolder(view);
        return memberViewHolder;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
}