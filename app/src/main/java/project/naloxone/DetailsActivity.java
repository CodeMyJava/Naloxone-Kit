package project.naloxone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    HashMap<String, List<String>> categories;
    List<String> naloxone_list;
    ExpandableListView exp_list;
    CategoriesAdapter adapter;

    ArrayList<Naloxone> list;
    /*
    private String Name;
    private String Description;
    private String Category;
    private String Hours;
    private String Location;
    private String PC;
    private String Phone;
    private String Email;
    private String Website;
    private String X;
    private String Y;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_details);
        list = (ArrayList<Naloxone>) getIntent().getSerializableExtra("locations");

        categories = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> free = new ArrayList<String>();
            free.add("Description: " + list.get(i).getDescription());
            free.add("Category: " + list.get(i).getCategory());
            free.add("Hours: " + list.get(i).getHours());
            free.add("Location: " + list.get(i).getLocation());
            free.add("Phone: " + list.get(i).getPhone());
            free.add("Email: " + list.get(i).getEmail());
            free.add("Website: " + list.get(i).getWebsite());
            categories.put(list.get(i).getName(), free);
        }

        //ExpandableList :: activity_details
        exp_list = findViewById(R.id.expandableList);

        naloxone_list = new ArrayList<String>(categories.keySet());

        adapter = new CategoriesAdapter(this, categories, naloxone_list);
        exp_list.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_get_directions:
                Intent i = new Intent(this, MapsActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu. This adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
