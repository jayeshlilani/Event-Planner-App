package smokinguns.etc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import smokinguns.etc.R;

public class sp extends AwesomeSplash {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sp);
//    }
SharedPreferences sp1;
    @Override
    public void initSplash(ConfigSplash configSplash) {
        ActionBar aB=getSupportActionBar();
        aB.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        configSplash.setBackgroundColor(R.color.bg_splash);
        configSplash.setAnimCircularRevealDuration(5000);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);


        configSplash.setLogoSplash(R.drawable.smgicon);
        configSplash.setAnimCircularRevealDuration(5000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeInUp);

//        configSplash.setTitleSplash("The Show Makers");
//        configSplash.setTitleTextColor(R.color.colorPrimaryDark);
//        configSplash.setTitleTextSize(30f);
//        configSplash.setAnimTitleDuration(3000);
//        configSplash.setAnimTitleTechnique(Techniques.SlideInLeft);
    }

    @Override
    public void animationsFinished() {
        sp1=getSharedPreferences("event",MODE_PRIVATE);
        String get1=sp1.getString("name","");
        if(get1=="")
        {

            Intent i = new Intent(getApplicationContext(), appintro.class);
            startActivity(i);
            finish();
            SharedPreferences.Editor editor = sp1.edit();
            editor.putString("name","done");
            editor.commit();

        }
        else
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
