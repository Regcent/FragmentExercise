package com.example.fragmentexercise;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
        ListFragment listFrag;
        listFrag = (ListFragment) getFragmentManager().findFragmentByTag("init");
        if (listFrag == null)
        {
            listFrag = new ListFragment();
            getFragmentManager().beginTransaction().add(R.id.layout, listFrag, "init").commit();
        }


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
		{
            DetailsFragment details;
            details = (DetailsFragment) getFragmentManager().findFragmentByTag("details");
            if (details == null) {
                details = new DetailsFragment();
            }
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.layout, details, "details").commit();

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
