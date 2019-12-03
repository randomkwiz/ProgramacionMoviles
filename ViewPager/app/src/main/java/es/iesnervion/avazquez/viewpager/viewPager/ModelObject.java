package es.iesnervion.avazquez.viewpager.viewPager;

import es.iesnervion.avazquez.viewpager.R;


public enum ModelObject {

    RED(R.string.red, R.layout.view_red),
    BLUE(R.string.blue, R.layout.view_blue),
    GREEN(R.string.green, R.layout.view_green);
    /*
     * The enum above lists all the pages of the ViewPagers. There are three pages with their respective layouts.
     * */

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
