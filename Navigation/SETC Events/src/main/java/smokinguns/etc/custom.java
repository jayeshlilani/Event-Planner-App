package smokinguns.etc;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import smokinguns.etc.R;

public class custom extends AppCompatActivity {

    TextView tvhead;
    Button btn1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        tvhead= (TextView) findViewById(R.id.tvhead);
        btn1= (Button) findViewById(R.id.btn1);
        et1= (EditText) findViewById(R.id.et1);

        Typeface custom2 = Typeface.createFromAsset(getAssets(),"fonts/exosemibold.otf");
        tvhead.setTypeface(custom2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et1.getText().toString()=="")
                {
                    et1.setError("give a name first!");
                    et1.requestFocus();
                    return;
                }
                if(et1.getText().toString().length()<3)
                {
                    et1.setError("name should be minimum 3 characters!");
                    et1.requestFocus();
                    et1.setText("");
                    return;
                }
                Intent i=new Intent(getApplicationContext(),services.class);
                i.putExtra("event","Custom");
                i.putExtra("subevent",et1.getText().toString());
                startActivity(i);
            }
        });

    }
}
