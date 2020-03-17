package smokinguns.navigation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
    String prebook = "", book = "", event = "", subevent = "";

    static String sound[] = {"2 tops on stand (active) - ₹3000",
            "2 tops on stand (passive) - ₹3500",
            "2 Dual Columns - ₹4000",
            "1 Mike (wired) - ₹200",
            "1 Mike (cordless) - ₹500",
            "DJ with Console - ₹1000",
            "2 Bass + 2 Tops + 2 Mikes - ₹4000",
            "4 Bass + 4 Tops + 4 Mikes - ₹6000",
            "2 Monitors - ₹2000",
            "Band Operator with Console - ₹6000",
            "Outdoor Set DJ with Console - ₹15000",
            "Drum Kick Mikes - ₹1000",
            "Foot Mikes - ₹200",
            "Gun Mikes - ₹1000",
            "Collor Mikes - ₹1000",
            "Headset Mikes - ₹1000",
            "DJ Boxes - ₹500",
            "Guitar Amps - ₹3000"};

    static String light[] = {"Pan Cars(1000W) - ₹150",
            "Imported Multicolored Gel - ₹150",
            "Victory Scanners - ₹1000",
            "Moving heads - ₹1000",
            "Color labs - ₹1000",
            "Jumbo Smoke Machine - ₹500",
            "Jumbo Strobe - ₹500",
            "Small Smoke Machine - ₹300",
            "Small Strobe Machine - ₹300",
            "Dimmer and Fader/Power - ₹500",
            "EFX Lights (12 options) - ₹300",
            "Haze Machine - ₹1000",
            "Snow Machine - ₹2000",
            "Board - ₹1500",
            "Laser 300 mW - ₹500",
            "Follow Spot (1.2kW) - ₹1500",
            "Light Stands (powder coated) - ₹200",
            "Light Operator (Professional) - ₹2000"};

    static String decor[] = {"Chairs (Plastic)",
            "Chairs (Wooden wtih cushion)",
            "Chairs (Special)",
            "Table (Plastic)",
            "Table (Wooden)",
            "Sofa",
            "Sofa (Special)",
            "Halogen (Yellow-1000W)",
            "Halogen (White-1000W)",
            "Dimmer and Fader/Power - ₹500",
            "Fans",
            "Stage (1.5ft)",
            "Stage (2.5ft)",
            "Stage (4ft)",
            "Backdrop + sidefills (10ft)",
            "Masking for projector screen (12' x 9')",
            "Carpet on Stage",
            "Main Gate Frame",
            "Ramp (T-shape)",
            "Green Room (furnished)",
            "Stalls (furnished)",
            "Mobile Washrooms",
            "Barricades",
            "Inflates and Maniquins",
            "Staircase",
            "Drapping (as per order)"};

    static String security[] = {"Securty Guard (Male)",
            "Security Guard (Female)",
            "CCTV",
            "Access Card System",
            "Fire fighting equipments",
            "Metal Detectors"};

    static String artist[] = {"2"};

    static String av[] = {"3000 lumens projector - ₹3000",
            "3500 lumens projector - ₹3500",
            "4000 lumens projector - ₹4000",
            "4500 lumens projector - ₹4500",
            "5000 lumens projector - ₹5000",
            "Screen (all sizes) - ₹1000",
            "Laptops - ₹1000",
            "Switches - ₹2500",
            "Karaoke set (screen+sound+DVD) - ₹4000",
            "Digital Photography (on CD) - ₹2000",
            "Camera for live relay and recording  - ₹3500",
            "Plasma Screen (42') - ₹3000",
            "Electronic Screen (as per sq.ft.)",
            "SMS wall (new advertising concept) - ₹25000"};

    static String cater[] = {"Indo-Chinese Cuisine",
            "Chinese Cuisine",
            "Mexican Cuisine",
            "South-Indian Cuisine",
            "Punjabi Cuisine",
            "Rajasthani Cuisine",
            "Sofa (Special)",
            "Sindhi Cuisine",
            "Bengali Cuisine",
            "Mughal Cuisine",
            "Goan Cuisine",
            "Soft drinks",
            "Wine",
            "Beer",
            "Vodka",
            "Tequila"};

    static String pyro[] = {"Conetti blast - ₹600",
            "Niagara falls (40-50ft) - ₹3500",
            "Fireball - ₹6000",
            "Aerial blast - ₹500",
            "Writing logo burner (tube) - ₹1200",
            "Writing logo burner (copper) - ₹6000",
            "Mashal - ₹1200",
            "Mouth fire - ₹500",
            "Aerial Confetti (baloon) - ₹400",
            "Stage fire - ₹8000"};

    static String trans[] = {"Car (as per model)",
            "Bus",
            "Air travel on hire",
            "Water travel on hire",
            "Caravan with Make-Up room",
            ""};

    static String power[] = {"30KVA noise proof Genset - ₹5000",
            "65KVA noise proof Genset - ₹7000",
            "125KVA noise proof Genset - ₹8000",
            "140KVA noise proof Genset - ₹10000",
            "180KVA noise proof Genset - ₹12000",
            "250KVA noise proof Genset - ₹15000"};

    static String design[] = {"Flex Printing (all types)",
            "Standees",
            "Kiosk disk",
            "Umbrellas",
            "T-Shirts",
            "Mouse pads",
            "Pens",
            "Key-chains"};

    static String venue[] = {"Hotel stay",
            "Cottage for parties",
            "Bungalows for parties",
            "Banquet hall",
            "Mall",
            "Stalls",
            "Resorts",
            "Adventure Picnic"};

    static String special[] = {"2"};

    String a = "";
    AlertDialog ad;

    boolean[] checkedItems1 = new boolean[sound.length];
    boolean[] checkedItems2 = new boolean[light.length];
    boolean[] checkedItems3 = new boolean[decor.length];
    boolean[] checkedItems4 = new boolean[security.length];
    boolean[] checkedItems5 = new boolean[artist.length];
    boolean[] checkedItems6 = new boolean[av.length];
    boolean[] checkedItems7 = new boolean[cater.length];
    boolean[] checkedItems8 = new boolean[pyro.length];
    boolean[] checkedItems9 = new boolean[trans.length];
    boolean[] checkedItems10 = new boolean[power.length];
    boolean[] checkedItems11 = new boolean[design.length];
    boolean[] checkedItems12 = new boolean[venue.length];
    boolean[] checkedItems13 = new boolean[special.length];

    TextView tvhead, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13;
    ImageView im1, im2, im3, im4, im5, im6, im7, im8, im9, im10, im11, im12, im13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        tvhead = (TextView) findViewById(R.id.tvhead);
        Typeface custom2 = Typeface.createFromAsset(getAssets(), "fonts/exosemibold.otf");
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
        btn = (Button) findViewById(R.id.btn);

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


        Intent i = getIntent();
        event = i.getStringExtra("event");
        subevent = i.getStringExtra("subevent");


        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder1.setTitle("Select products");
        builder1.setItems(sound, null);
        builder1.setNegativeButton("Done", null);
        builder1.setMultiChoiceItems(sound, checkedItems1, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + sound[which];
            }
        });
        final AlertDialog.Builder builder2 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder2.setTitle("Select products");
        builder2.setItems(light, null);
        builder2.setNegativeButton("Done", null);
        builder2.setMultiChoiceItems(light, checkedItems2, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + light[which];
            }
        });
        final AlertDialog.Builder builder3 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder3.setTitle("Select products");
        builder3.setItems(decor, null);
        builder3.setNegativeButton("Done", null);
        builder3.setMultiChoiceItems(decor, checkedItems3, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + decor[which];
            }
        });
        final AlertDialog.Builder builder4 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder4.setTitle("Select products");
        builder4.setItems(security, null);
        builder4.setNegativeButton("Done", null);
        builder4.setMultiChoiceItems(security, checkedItems4, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + security[which];
            }
        });
        final AlertDialog.Builder builder5 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder5.setTitle("Select products");
        builder5.setItems(artist, null);
        builder5.setNegativeButton("Done", null);
        builder5.setMultiChoiceItems(artist, checkedItems5, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + artist[which];
            }
        });
        final AlertDialog.Builder builder6 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder6.setTitle("Select products");
        builder6.setItems(av, null);
        builder6.setNegativeButton("Done", null);
        builder6.setMultiChoiceItems(av, checkedItems6, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + av[which];
            }
        });
        final AlertDialog.Builder builder7 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder7.setTitle("Select products");
        builder7.setItems(cater, null);
        builder7.setNegativeButton("Done", null);
        builder7.setMultiChoiceItems(cater, checkedItems7, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + cater[which];
            }
        });
        final AlertDialog.Builder builder8 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder8.setTitle("Select products");
        builder8.setItems(pyro, null);
        builder8.setNegativeButton("Done", null);
        builder8.setMultiChoiceItems(pyro, checkedItems8, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + pyro[which];
            }
        });
        final AlertDialog.Builder builder9 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder9.setTitle("Select products");
        builder9.setItems(trans, null);
        builder9.setNegativeButton("Done", null);
        builder9.setMultiChoiceItems(trans, checkedItems9, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + trans[which];
            }
        });
        final AlertDialog.Builder builder10 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder10.setTitle("Select products");
        builder10.setItems(power, null);
        builder10.setNegativeButton("Done", null);
        builder10.setMultiChoiceItems(power, checkedItems10, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + power[which];
            }
        });
        final AlertDialog.Builder builder11 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder11.setTitle("Select products");
        builder11.setItems(design, null);
        builder11.setNegativeButton("Done", null);
        builder11.setMultiChoiceItems(design, checkedItems11, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + design[which];
            }
        });
        final AlertDialog.Builder builder12 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder12.setTitle("Select products");
        builder12.setItems(venue, null);
        builder12.setNegativeButton("Done", null);
        builder12.setMultiChoiceItems(venue, checkedItems12, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + venue[which];
            }
        });
        final AlertDialog.Builder builder13 = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder13.setTitle("Select products");
        builder13.setItems(special, null);
        builder13.setNegativeButton("Done", null);
        builder13.setMultiChoiceItems(special, checkedItems13, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                a = a + "\n" + special[which];
            }
        });


        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder1.create();
                ad.show();
            }
        });
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder1.create();
                ad.show();
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder2.create();
                ad.show();
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder2.create();
                ad.show();
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder3.create();
                ad.show();
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder3.create();
                ad.show();
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder4.create();
                ad.show();
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder4.create();
                ad.show();
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder5.create();
                ad.show();
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder5.create();
                ad.show();
            }
        });

        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder6.create();
                ad.show();
            }
        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder6.create();
                ad.show();
            }
        });

        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder7.create();
                ad.show();
            }
        });
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder7.create();
                ad.show();
            }
        });

        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder8.create();
                ad.show();
            }
        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder8.create();
                ad.show();
            }
        });

        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder9.create();
                ad.show();
            }
        });
        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder9.create();
                ad.show();
            }
        });

        tv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder10.create();
                ad.show();
            }
        });
        im10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder10.create();
                ad.show();
            }
        });

        tv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder11.create();
                ad.show();
            }
        });
        im11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder11.create();
                ad.show();
            }
        });

        tv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder12.create();
                ad.show();
            }
        });
        im12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder12.create();
                ad.show();
            }
        });

        tv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder13.create();
                ad.show();
            }
        });
        im13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = builder13.create();
                ad.show();
            }
        });


//        Intent j=getIntent();
//        if(j.getStringExtra("book")==null)
//        {
//            prebook=j.getStringExtra("book");
//            prebook="";
//            book=book+"\n"+prebook;
//        }
//        else
//        book=book+j.getStringExtra("book");

        //  Toast.makeText(getApplicationContext(),event+subevent+book,Toast.LENGTH_SHORT).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), checkdistance.class);
                i.putExtra("book", a);
                i.putExtra("event", event);
                i.putExtra("subevent", subevent);
                startActivity(i);
            }
        });

    }
}

