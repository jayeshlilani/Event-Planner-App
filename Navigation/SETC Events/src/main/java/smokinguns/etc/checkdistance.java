package smokinguns.etc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import smokinguns.etc.R;

public class checkdistance extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    Button btn1, btn2, btndate, btntime;
    String book = "", event = "", subevent = "",guestCount="";
    TextView tv1, tv2, tvhead;
    Spinner spcount;
    float dist = 0.0f;
    LinearLayout lldist,llcount;
    EditText et1;
    //    ProgressDialog progressDialog;
    double srcLat, srcLng, dstnLat, dstnLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkdistance);
        et1 = (EditText) findViewById(R.id.et1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btndate = (Button) findViewById(R.id.btndate);
        btntime = (Button) findViewById(R.id.btntime);
        tvhead = (TextView) findViewById(R.id.tvhead);
        lldist = (LinearLayout) findViewById(R.id.lldist);
        llcount = (LinearLayout) findViewById(R.id.llcount);
        spcount = (Spinner) findViewById(R.id.spcount);

        Typeface custom2 = Typeface.createFromAsset(getAssets(), "fonts/exosemibold.otf");
        tvhead.setTypeface(custom2);
        tv1.setTypeface(custom2);
        tv2.setTypeface(custom2);
        btn1.setTypeface(custom2);
        btn2.setTypeface(custom2);
        btndate.setTypeface(custom2);
        btntime.setTypeface(custom2);

        Intent i = getIntent();
        book = i.getStringExtra("book");
        event = i.getStringExtra("event");
        subevent = i.getStringExtra("subevent");

        ArrayList<String> count = new ArrayList<String>();
        count.add("N.A.");
        count.add("20");
        count.add("50");
        count.add("100");
        count.add("300");
        count.add("500");
        count.add("1000");
        count.add("1000+");
        ArrayAdapter<String> countAdp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,count);
        spcount.setAdapter(countAdp);

        spcount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                guestCount=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                guestCount="N.A.";
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                String destination = et1.getText().toString();

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (destination.length() == 0) {
                    et1.setError("Pincode can be empty");
                    et1.requestFocus();
                    //   hideDialog();

                } else if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
                    //  hideDialog();
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();

                } else {
                    Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.ENGLISH);

                    try {
                        List<Address> srcAddressList = geocoder.getFromLocationName("400088", 1);
                        List<Address> dstnAddressList = geocoder.getFromLocationName(destination, 1);

                        Address srcAddress = srcAddressList.get(0);
                        Address dstnAddress = dstnAddressList.get(0);

                        srcLat = srcAddress.getLatitude();
                        srcLng = srcAddress.getLongitude();
                        dstnLat = dstnAddress.getLatitude();
                        dstnLng = dstnAddress.getLongitude();

                        //    hideDialog();

                        dist = Float.parseFloat(getDistance());
                        float km = dist;
                        String sm = String.format("%.2f", km);

                        tv1.setText("Distance : " + sm + " km");
                        //dist = Integer.parseInt(getDistance());
                        if (km < 5.0f) {
                            tv2.setText("Hurray! No transportation charges");
                            tv2.setTextColor(Color.parseColor("#64DD17"));


                        } else if (km > 400.0f) {
                            tv2.setText("Sorry, we are not available in your area");
                            tv2.setTextColor(Color.RED);
                            et1.requestFocus();
                            return;

                        } else {
                            tv2.setText("*Extra transportation cost will be charged*");
                            tv2.setTextColor(Color.RED);
                        }

                        tv1.setVisibility(View.VISIBLE);
                        tv2.setVisibility(View.VISIBLE);
                        btn2.setVisibility(View.VISIBLE);
                        lldist.setVisibility(View.VISIBLE);
                        llcount.setVisibility(View.VISIBLE);

                    } catch (Exception e) {
                        e.printStackTrace();
                        et1.setError("Invalid pincode");
                        et1.requestFocus();
                        et1.setText("");
                    }

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btndate.getText().toString().equals("Pick date")) {
                    btndate.setError("select a date first");
                    btndate.requestFocus();
                    return;
                } else if (btntime.getText().toString().equals("Pick time")) {
                    btntime.setError("select a time first");
                    btntime.requestFocus();
                    return;
                } else {
                    Intent i = new Intent(getApplicationContext(), postbooking.class);
                    i.putExtra("book", book);
                    i.putExtra("event", event);
                    i.putExtra("subevent", subevent);
                    i.putExtra("guestcount", guestCount);
                    i.putExtra("distance", tv1.getText().toString());
                    i.putExtra("datetime", "Date : " + btndate.getText() + "\nTime : " + btntime.getText());
                    startActivity(i);
                }
            }
        });
        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        checkdistance.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setMinDate(now.getInstance());
                dpd.show(getFragmentManager(), "Datepickerdialog");

            }
        });
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar now = Calendar.getInstance();
                TimePickerDialog dpd = TimePickerDialog.newInstance(
                        checkdistance.this,
                        now.get(Calendar.HOUR),
                        now.get(Calendar.MINUTE),
                        false
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");

            }
        });

    }

    String getDistance() {
        Location loc1 = new Location("Source");
        loc1.setLatitude(srcLat);
        loc1.setLongitude(srcLng);
        Location loc2 = new Location("Destination");
        loc2.setLatitude(dstnLat);
        loc2.setLongitude(dstnLng);
        float distanceInMeters = loc1.distanceTo(loc2);
        float km = distanceInMeters / 1000f;
        return km + "";

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        btndate.setError(null);
        btndate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
    }

    @Override

    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String ampm = "";
        String time = "";
        String hour = "";
        String min = "";
        if (hourOfDay < 12) {
            ampm = "AM";
        } else {
            hourOfDay = hourOfDay - 12;
            ampm = "PM";
        }
        if (hourOfDay < 10)
            hour = "0" + hourOfDay;
        else
            hour = "" + hourOfDay;
        if (minute < 10)
            min = "0" + minute;
        else
            min = "" + minute;
        time = hour + ":" + min + " " + ampm;

        btntime.setError(null);
        btntime.setText(time);
    }


}
