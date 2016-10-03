package com.sample.foo.sqlitesampleapp;

import android.content.Context;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.foo.sqlitesampleapp.databinding.EmployerListItemBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by obaro on 26/09/2016.
 */

public class SampleRecyclerViewCursorAdapter extends RecyclerView.Adapter<SampleRecyclerViewCursorAdapter.ViewHolder> {

    Context mContext;
    Cursor mCursor;

    public SampleRecyclerViewCursorAdapter(Context context, Cursor cursor) {

        mContext = context;
        mCursor = cursor;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        EmployerListItemBinding itemBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            itemBinding = DataBindingUtil.bind(itemView);
        }

        public void bindCursor(Cursor cursor) {
            itemBinding.nameLabel.setText(cursor.getString(
                    cursor.getColumnIndexOrThrow(SampleDBContract.Employer.COLUMN_NAME)
            ));
            itemBinding.descLabel.setText(cursor.getString(
                    cursor.getColumnIndexOrThrow(SampleDBContract.Employer.COLUMN_DESCRIPTION)
            ));

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(cursor.getLong(
                    cursor.getColumnIndexOrThrow(SampleDBContract.Employer.COLUMN_FOUNDED_DATE)));
            itemBinding.foundedLabel.setText(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
        }
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        holder.bindCursor(mCursor);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.employer_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
}