package es.iesnervion.avazquez.viewpager.viewPager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import es.iesnervion.avazquez.viewpager.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

        /*
        * The ViewPager uses a PagerAdapter whose job is
        * to supply views to the MainActivity similar to what a ListAdapter does for a ListView.
        * */
        /*
        * https://www.journaldev.com/10096/android-viewpager-example-tutorial
        * */
    }


}
