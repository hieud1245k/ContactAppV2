package com.hieuminh.contactappv1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hieuminh.contactappv1.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> implements Filterable {
    private static ArrayList<Contact> arrContacts;
    private ArrayList<Contact> arrContactFull;
    private static ActivityMainBinding binding;
    private static Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;
        public View view;
        public TextView tv_call,tv_sms,tv_infor;
        public ImageView iv_call, iv_sms, iv_info;
        public LinearLayout ll_function,ll_infor, ll_sms , ll_call;
        public MyViewHolder(View view) {
            super(view);
            this.view = view;
            tv = this.view.findViewById(R.id.tv_fullname);
//            tv_call = this.view.findViewById(R.id.tv_call);
//
//            try {
//                tv_call.setText(arrContacts.get(getAdapterPosition()).getMobile());
//            } catch (Exception e) {
//                System.out.println(e);
//            }

//            tv_sms = this.view.findViewById(R.id.tv_sms);
//            tv_infor = this.view.findViewById(R.id.tv_infor);
            iv_call = this.view.findViewById(R.id.iv_call);
            iv_sms = this.view.findViewById(R.id.iv_sms);
            iv_info = this.view.findViewById(R.id.iv_info);
            ll_function = this.view.findViewById(R.id.ll_function);
            ll_infor = this.view.findViewById(R.id.ll_infor);
            ll_infor.setOnClickListener(view1 -> {
                Intent intent = new Intent(context,InforActivity.class);
                Contact contact = arrContacts.get(getLayoutPosition());
                intent.putExtra("contactInfor",contact);
                context.startActivity(intent);
            });

            tv.setOnClickListener(view1 -> {
                if(ll_function.getVisibility() == View.VISIBLE) {
                    ll_function.setVisibility(View.GONE);
                } else {
                    ll_function.setVisibility(View.VISIBLE);
                }
            });


            ll_sms = this.view.findViewById(R.id.ll_sms);
            ll_sms.setOnClickListener(view1 -> {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", arrContacts.get(getAdapterPosition()).getMobile(), null)));
            });

            ll_call = this.view.findViewById(R.id.ll_call);
            ll_call.setOnClickListener(view1 -> {
                int position = getAdapterPosition();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", arrContacts.get(position).getMobile(), null));
                context.startActivity(intent);
            });
        }

    }

    public myAdapter(ArrayList<Contact> arrContacts,Context context) {
        this.arrContacts = arrContacts;
        this.arrContactFull = new ArrayList<>(arrContacts);
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detail, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            holder.tv.setText(this.arrContacts.get(position).getName());
        } catch (NullPointerException e) {
            System.out.println("Loi " + position);
        }
    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Contact> filterContacts = new ArrayList<>();
            if(charSequence == null || charSequence.length() == 0) {
                filterContacts.addAll(arrContactFull);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (Contact item : arrContactFull) {
                    if(item.getName().toLowerCase().contains(filterPattern)) {
                        filterContacts.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filterContacts;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            arrContacts.clear();
            arrContacts.addAll((ArrayList<Contact>) filterResults.values);
            notifyDataSetChanged();
        }
    };

}
