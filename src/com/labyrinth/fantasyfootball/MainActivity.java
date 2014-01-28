package com.labyrinth.fantasyfootball;


import com.labyrinth.fantasyfootball.fragments.DisplayRostersFragment;

import android.app.Fragment;


public class MainActivity extends AbstractSingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new DisplayRostersFragment();
	}

}
