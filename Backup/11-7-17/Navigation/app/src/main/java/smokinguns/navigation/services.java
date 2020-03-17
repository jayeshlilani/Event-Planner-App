package smokinguns.navigation;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class services extends AppCompatActivity {
//    ArrayList<String> selectedItem = new ArrayList<>();

    Button btn;
    String prebook="",book="",event="",subevent="";

    TextView tvhead,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13;
    ImageView im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12,im13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        tvhead = (TextView) findViewById(R.id.tvhead);
        Typeface custom2 = Typeface.createFromAsset(getAssets(),"fonts/exosemibold.otf");
        tvhead.setTypeface(custom2);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv9 = (TextView) findViewById(R.id.tv9);
        tv10 = (TextView) findViewById(R.id.tv10);
        tv11 = (TextView) findViewById(R.id.tv11);
        tv12 = (TextView) findViewById(R.id.tv12);
        tv13 = (TextView) findViewById(R.id.tv13);
        btn= (Button) findViewById(R.id.btn);

        im1 = (ImageView) findViewById(R.id.im1);
        im2 = (ImageView) findViewById(R.id.im2);
        im3 = (ImageView) findViewById(R.id.im3);
        im4 = (ImageView) findViewById(R.id.im4);
        im5 = (ImageView) findViewById(R.id.im5);
        im6 = (ImageView) findViewById(R.id.im6);
        im7 = (ImageView) findViewById(R.id.im7);
        im8 = (ImageView) findViewById(R.id.im8);
        im9 = (ImageView) findViewById(R.id.im9);
        im10 = (ImageView) findViewById(R.id.im10);
        im11 = (ImageView) findViewById(R.id.im11);
        im12 = (ImageView) findViewById(R.id.im12);
        im13 = (ImageView) findViewById(R.id.im13);


        Intent i=getIntent();
        event=i.getStringExtra("event");
        subevent=i.getStringExtra("subevent");


        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),sound.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i=new Intent(getApplicationContext(),sound.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                    startActivity(i);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),lights.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),lights.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),decor.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),decor.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),security.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),security.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),artist.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),artist.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),av.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),av.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),catering.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),catering.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),pyro.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),pyro.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),transport.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),transport.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),powersupply.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),powersupply.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),print.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),print.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),venue.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),venue.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });

        tv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),special.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
        im13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),special.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });



        Intent j=getIntent();
        if(j.getStringExtra("book")==null)
        {
            prebook=j.getStringExtra("book");
            prebook="";
            book=book+"\n"+prebook;
        }
        else
        book=book+"\n"+j.getStringExtra("book");

        Toast.makeText(getApplicationContext(),event+subevent+book,Toast.LENGTH_SHORT).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),postbooking.class);
                i.putExtra("book",book);
                i.putExtra("event",event);
                i.putExtra("subevent",subevent);
                startActivity(i);
            }
        });
    }
}
