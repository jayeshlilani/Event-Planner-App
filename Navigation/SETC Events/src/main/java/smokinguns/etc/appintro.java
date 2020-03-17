package smokinguns.etc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import smokinguns.etc.R;

public class appintro extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView[] dots;
    Button next,skip;
    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout dotsLayout;
    private IntroManager introManager;
    private int[] layouts;
    ViewGroup container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        introManager = new IntroManager(this);

        ActionBar aB=getSupportActionBar();
        aB.hide();

        if (!introManager.check()) {
            introManager.setFirst(false);
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        }
        if(Build.VERSION.SDK_INT>=21)
        {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_appintro);

        viewPager= (ViewPager) findViewById(R.id.view_pager);
        dotsLayout= (LinearLayout) findViewById(R.id.layoutDots);
        skip= (Button) findViewById(R.id.btn_skip);
        next= (Button) findViewById(R.id.btn_next);
        layouts=new int[]{R.layout.slide_1,R.layout.slide_2,R.layout.slide_3,R.layout.slide_4};
        addButtonDots(0);
      //  changeStatusBarColor();
        viewPagerAdapter=new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewListener);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

try {

    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int current = getItem(+1);
            if (current < layouts.length) {
                viewPager.setCurrentItem(current);
            } else {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }

        }
    });
}
catch (Exception e)
{
    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
}
    }

    private void addButtonDots(int positon)
    {
        dots=new TextView[layouts.length];
        int[] colorsActive=getResources().getIntArray(R.array.dot_active);
        int[] colorsInactive=getResources().getIntArray(R.array.dot_inactive);
        dotsLayout.removeAllViews();
        for(int i=0;i<dots.length;i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[positon]);
            dotsLayout.addView(dots[i]);
        }
        if(dots.length>0)
            dots[positon].setTextColor(colorsActive[positon]);
    }

    private int getItem(int i)
    {
        return viewPager.getCurrentItem()+i;
    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener()
    {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addButtonDots(position);
            if (position==layouts.length-1)
            {
                next.setText("PROCEED");
                skip.setVisibility(View.GONE);
            }
            else
            {
                next.setText("NEXT");
                skip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

//    private void changeStatusBarColor()
//    {
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
//        {
//            Window window=getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
//    }
    public class ViewPagerAdapter extends PagerAdapter {


        private LayoutInflater layoutInflater;


        public Object instantiateItem(ViewGroup container,int position)
        {
            layoutInflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v=layoutInflater.inflate(layouts[position],container,false);
            container.addView(v);
            return v;
        }
        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        @Override
            public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }
    }
}