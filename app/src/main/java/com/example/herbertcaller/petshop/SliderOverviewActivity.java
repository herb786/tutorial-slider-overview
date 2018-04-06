package com.example.herbertcaller.petshop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SliderOverviewActivity extends FragmentActivity {

    ViewPager viewPager;
    SliderOverviewPageAdapter pageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_overview);


        final TextView pageNumber = (TextView) findViewById(R.id.page_number);
        //pageNumber.setText("\uD83D\uDD37\uD83D\uDD36");
        pageNumber.setText("\uD83D\uDD34\u2B55");
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        // Adapter
        pageAdapter = new SliderOverviewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        //pageNumber.setText("\uD83D\uDD37\uD83D\uDD36");
                        pageNumber.setText("\uD83D\uDD34\u2B55");
                        break;
                    case 1:
                        //pageNumber.setText("\uD83D\uDD36\uD83D\uDD37");
                        pageNumber.setText("\u2B55\uD83D\uDD34");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ImageView btnClose = (ImageView) findViewById(R.id.btnClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    public class SliderOverviewPageAdapter extends FragmentStatePagerAdapter {

        public SliderOverviewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new SliderOverviewPageFragment();
            Bundle args = new Bundle();
            args.putInt(SliderOverviewPageFragment.PAGE_NUMBER, position + 1);
            fragment.setArguments(args);
            return fragment;

        }


    }

    public static class  SliderOverviewPageFragment extends Fragment {

        public static final String PAGE_NUMBER = "PAGE_NUMBER";
        private int page;

        TextView title;
        TextView image;

        public SliderOverviewPageFragment() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                page = getArguments().getInt(PAGE_NUMBER);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_slider_overview_page, container, false);

            title = (TextView) view.findViewById(R.id.title);
            image = (TextView) view.findViewById(R.id.image);

            switch (page) {
                case 1:
                    title.setText("\uD83D\uDC31FOR CAT LOVERS\uD83D\uDC31");
                    image.setText("\uD83D\uDC08");
                    break;
                case 2:
                    title.setText("\uD83D\uDC36FOR DOG LOVERS\uD83D\uDC36");
                    image.setText("\uD83D\uDC15");
                    break;
                default:
                    break;
            }

            return view;
        }

    }

}
