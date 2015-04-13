package com.example.fragmentexercise;

import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListFragment extends Fragment implements DetailsFragment.DetailsConfig{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.list_layout, container, false);
		ListView list = (ListView) view.findViewById(R.id.listNews);
		
		ArrayList<String> items = new ArrayList<String>();
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
		adapter.add("List Item 1");
		adapter.add("List Item 2");
		adapter.add("List Item 3");
		adapter.add("List Item 4");
		adapter.add("List Item 5");
		adapter.add("List Item 6");
		adapter.add("List Item 7");
		adapter.add("List Item 8");
		adapter.add("List Item 9");
		adapter.add("List Item 10");
		
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//retrieve the selected item
				TextView tv = (TextView)arg1;

				setDetail(tv.getText().toString());
			}
		});
		return view;
	}
	
	@Override
	public void setDetail(String text)
	{
		getFragmentManager().executePendingTransactions();
		DetailsFragment details;
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
		{
            details = (DetailsFragment) getFragmentManager().findFragmentByTag("details");
            if (details == null) {
                details = new DetailsFragment();
            }
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.layout, details, "details");
            transaction.addToBackStack(null);
            transaction.commit();
		}
		else
		{
            details = null;
			//details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.detailsView);
		}
        getFragmentManager().executePendingTransactions();
		if (details != null)
			details.updateText(text);
		else
			Log.e("ERROR", "Details fragment not found");
	}
}
