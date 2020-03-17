package smokinguns.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class postbooking extends AppCompatActivity {

    TextView tv1;
    String book="",event="",subevent="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postbooking);
        tv1= (TextView) findViewById(R.id.tv1);


        Intent j=getIntent();
         book=j.getStringExtra("book");
         event=j.getStringExtra("event");
         subevent=j.getStringExtra("subevent");
        Toast.makeText(getApplicationContext(),event+subevent+book,Toast.LENGTH_SHORT).show();
        tv1.setText("Event : "+event+" - "+subevent+"\n\nServices : \n"+book);
    }
}
