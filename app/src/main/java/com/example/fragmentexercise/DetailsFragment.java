package com.example.fragmentexercise;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.detail_layout, container, false);
	}
	
	public interface DetailsConfig{
		public void setDetail(String text);
	}
	
	public void updateText(String text)
	{
		TextView tv = (TextView) getView().findViewById(R.id.detailsText);
		tv.setText("You have selected " + text);
	}
}
