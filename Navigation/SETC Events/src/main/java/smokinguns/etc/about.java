package smokinguns.etc;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;
import smokinguns.etc.R;

public class about extends AppCompatActivity {
    Toolbar toolbar;
    TextView tvhead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvhead = (TextView) findViewById(R.id.tvhead);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.smgicon)
                .setDescription("We are specialized in\n" +
                        "Sound, Lights, Orchestra, Live Band, Pyrotechnics, Fabrication, Audiovisuals, Artiste Management,\n" +
                        "Venue Management, Movie Promotions, Catering.\n" +
                        "\n" +
                        "We organise events like\n" +
                        "Corporate parties, Corporate Games, Adventure Sports, Birthday Parties, Team Building activities, Theme Parties, Ring Ceremonies, Weddings, Anniversaries, Exhibitions, Conferences, Product launches, Road Shows,\n" +
                        "Fashion Shows, Picnics, Live Concerts, College Festivals,\n" +
                        "Dandiya Nites, Rain Dance.\n" +
                        "\n" +
                        "Address : \n" +
                        "301, Vikrant Industrial Estate, above Bharat Bank, Kach Wadi, Deonar PO Road, Govandi(E), Mumbai-400088.\n")
                .addGroup("Connect with us")
                .addEmail("mailto:smokingunsetc@gmail.com")
//                .addWebsite("http://medyo.github.io/")
                .addFacebook("https://www.facebook.com/Smokingunsetc/")
//                .addTwitter("medyo80")
                .addYoutube("https://www.youtube.com/user/smokingunsetc/videos?sort=dd&view=0&shelf_id=0")
//                .addPlayStore("com.ideashower.readitlater.pro")
//                .addGitHub("medyo")
//                .addInstagram("medyo80")
                .addGroup("Developed by")
                .addItem(createCopyright())
                .create();

        setContentView(aboutPage);
    }

    private Element createCopyright() {
        Element copyright = new Element();
        final String copyrightString = "Jayesh Lilani | Piyush Khanna";
        copyright.setTitle(copyrightString);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Developed by "+copyrightString, Toast.LENGTH_LONG).show();
            }
        });
        return copyright;
    }
}
