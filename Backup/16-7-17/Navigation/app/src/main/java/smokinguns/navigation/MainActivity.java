package smokinguns.navigation;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab_fb, fab_plus, fab_contact;
    ViewFlipper flipper;
    Animation fab_open, fab_close, fab_rc, fab_rac;
    boolean isOpen = false;
    Button btn1, btn2, btn3, btn4, btn5, btn6;
    ImageButton im1, im2, im3, im4, im5, im6;
    Toolbar toolbar;

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to close the application?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.setTitle("EXIT");
        alert.show();
    }//end of onBackPressed()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Event Planner");

        fab_contact = (FloatingActionButton) findViewById(R.id.fab_contact);
        fab_fb = (FloatingActionButton) findViewById(R.id.fab_fb);
        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        flipper= (ViewFlipper) findViewById(R.id.viewflipper);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_rc = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        fab_rac = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);

        im1 = (ImageButton) findViewById(R.id.im1);
        im2 = (ImageButton) findViewById(R.id.im2);
        im3 = (ImageButton) findViewById(R.id.im3);
        im4 = (ImageButton) findViewById(R.id.im4);
        im5 = (ImageButton) findViewById(R.id.im5);
        im6 = (ImageButton) findViewById(R.id.im6);


        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    fab_fb.startAnimation(fab_close);
                    fab_contact.startAnimation(fab_close);
                    fab_plus.startAnimation(fab_rac);
                    fab_fb.setClickable(false);
                    fab_contact.setClickable(false);
                    isOpen = false;
                } else {
                    fab_fb.startAnimation(fab_open);
                    fab_contact.startAnimation(fab_open);
                    fab_plus.startAnimation(fab_rc);
                    fab_fb.setClickable(true);
                    fab_contact.setClickable(true);
                    isOpen = true;
                }
            }
        });//end of plus fab

        fab_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Intent.ACTION_DIAL);
                c.setData(Uri.parse("tel:9820352229"));
                startActivity(c);
            }
        });//end of contact fab
        fab_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("https://www.facebook.com/Smokingunsetc/");
                Intent f = new Intent(Intent.ACTION_VIEW, url);
                startActivity(f);
            }
        });//end of fb fab

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), domestic.class);
                startActivity(i);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), domestic.class);
                startActivity(i);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), social.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), social.class);
                startActivity(i);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), corporate.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), corporate.class);
                startActivity(i);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), institutional.class);
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), institutional.class);
                startActivity(i);
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), govt.class);
                startActivity(i);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), govt.class);
                startActivity(i);
            }
        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), custom.class);
                startActivity(i);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), custom.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }//end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_signIn) {
//            Intent contact=new Intent(MainActivity.this, login.class);
//            startActivity(contact);

        } else if (id == R.id.nav_gallery) {
//            Uri url = Uri.parse("https://www.facebook.com/pg/Smokingunsetc/photos/?tab=albums" + "");
//            Intent f = new Intent(Intent.ACTION_VIEW, url);
//            startActivity(f);
            Intent i = new Intent(getApplicationContext(), gallery.class);
            startActivity(i);

        } else if (id == R.id.nav_aboutUs) {
            Intent i = new Intent(getApplicationContext(), about.class);
            startActivity(i);

        } else if (id == R.id.nav_viewMore) {
//            Uri uriUrl = Uri.parse("http://www.youtube.com/channel/UCpyFNc1BDXdXwehev7Ny78A");
//            Intent viewmore = new Intent(Intent.ACTION_VIEW, uriUrl);
            Intent i = new Intent(getApplicationContext(), viewmore.class);
            startActivity(i);
            startActivity(i);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_contactUs) {
            Intent contact = new Intent(MainActivity.this, contact.class);
            startActivity(contact);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
