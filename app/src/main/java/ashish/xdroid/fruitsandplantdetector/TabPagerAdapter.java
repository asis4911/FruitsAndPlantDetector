package ashish.xdroid.fruitsandplantdetector;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                return new Fragment_tab1();
            case 1:
                return new Fragment_tab2();
            case 2:
                return new Fragment_tab3();
            default:
                assert false;
                return fragment;

        }
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Detection Fruit";
        }else if (position == 1) {
            title = "Avaliable Objects";
        }else if (position == 2) {
            title = "Enjoy";
        }
        return title;
    }
}
