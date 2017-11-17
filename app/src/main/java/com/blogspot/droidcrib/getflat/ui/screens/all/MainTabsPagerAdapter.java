package com.blogspot.droidcrib.getflat.ui.screens.all;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.blogspot.droidcrib.getflat.ui.screens.favorites.FavoritesListFragment;
import com.blogspot.droidcrib.getflat.ui.screens.parameters.SettingsFragment;

/**
 *
 */

public class MainTabsPagerAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;
    SparseArray<Fragment> registeredFragments = new SparseArray<>();

    public MainTabsPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
//        registeredFragments.put(0, ApartmentsListFragment.getInstance());
//        registeredFragments.put(1, ApartmentsListFragment.getInstance());
//        registeredFragments.put(2, NotesListFragment.getInstance());
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SettingsFragment.getInstance();
            case 1:
                return ApartmentsListFragment.getInstance();
            case 2:
                return FavoritesListFragment.getInstance();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        Fragment fragment = (Fragment) super.instantiateItem(container, position);
//        registeredFragments.put(position, fragment);
//        return fragment;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        registeredFragments.remove(position);
//        super.destroyItem(container, position, object);
//    }
//
//    public Fragment getRegisteredFragment(int position) {
//        return registeredFragments.get(position);
//    }

}
