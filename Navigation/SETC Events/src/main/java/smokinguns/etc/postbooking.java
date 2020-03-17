package smokinguns.etc;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import smokinguns.etc.R;

public class postbooking extends AppCompatActivity {

    TextView tv_details,tvhead;
    EditText et_name,et_phone,et_city;
    Button btn_confirm;
    String guestCount="";
    String book="",event="",subevent="",distance="";
String datetime="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postbooking);

        tv_details = (TextView) findViewById(R.id.tv_details);
        tvhead = (TextView) findViewById(R.id.tvhead);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_city = (EditText) findViewById(R.id.et_city);
        btn_confirm = (Button) findViewById(R.id.btn_confirm);

        Typeface custom2 = Typeface.createFromAsset(getAssets(), "fonts/exosemibold.otf");
        tvhead.setTypeface(custom2);
        btn_confirm.setTypeface(custom2);


        Intent j = getIntent();
        book = j.getStringExtra("book");
        event = j.getStringExtra("event");
        subevent = j.getStringExtra("subevent");
        guestCount = j.getStringExtra("guestcount");
        distance = j.getStringExtra("distance");
        datetime=j.getStringExtra("datetime");
        final String edetails = "Event : " + event + " - " + subevent +"\n"+datetime+"\n"+"Estimated guests : "+guestCount+"\n\nServices : "+book;
        tv_details.setText(edetails);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_name.getText().toString().equals("")) {
                    et_name.setError("Name empty");
                    et_name.requestFocus();
                    return;
                    
                }
                if ((!Patterns.PHONE.matcher(et_phone.getText().toString()).matches()) || (et_phone.getText().toString().length() < 10)) {
                    et_phone.setError("Invalid Phone");
                    et_phone.requestFocus();
                    return;
                }
                if (et_city.getText().toString().equals("")) {
                    et_city.setError("Subject empty");
                    et_city.requestFocus();
                    return;
                }

                String pdetails = "\n Name : " + et_name.getText().toString() + "\n Contact : " + et_phone.getText().toString() + "\n City : " + et_city.getText().toString();
                Intent email = new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse("mailto:smokingunsetc@gmail.com"));
                email.putExtra(Intent.EXTRA_SUBJECT, "Event Booking");
                email.putExtra(Intent.EXTRA_TEXT, pdetails + "\n" + distance+"\n\n"+ edetails);
                startActivity(email);
            }
        });


    }
}
