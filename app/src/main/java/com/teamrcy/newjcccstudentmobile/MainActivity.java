package com.teamrcy.newjcccstudentmobile;

import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements SearchView.OnQueryTextListener {
    //public final static String EXTRA_MESSAGE = "com.teamrcy.NewJCCCStudentMobileApp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);// inflates action bar with menu elements from my menu
        MenuItem searchItem = menu.findItem(R.id.searchButton); // finds searchButton and assigns it to searchItem
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) MenuItemCompat.getActionView(searchItem);//typecasts searchItem to a SearchView
        searchView.setQueryHint("Search JCCC.edu:");//sets the query hint.
        searchView.setOnQueryTextListener(this);//activates the query text listener.
       return true;
    }
    @Override
    public boolean onQueryTextSubmit(String query)//
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.jccc.edu/search.html?q="+query)));
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) { //watches for changes in the text field, not used but necessary for implementation.
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        switch(item.getItemId())
        {
            case R.id.searchButton:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item); */
    }

    public void athleticAct(View v)
    {
        startActivity(new Intent(this, AthleticsActivity.class));
    }

    public void wellnessAct(View v)
    {
        startActivity(new Intent(this, Wellness_Activity.class));
    }

    public void newsAct(View v)
    {
        startActivity(new Intent(this, News_Activity.class));
    }

    public void discountAct(View v)
    {
        startActivity(new Intent(this, DiscountActivity.class));
    }

    public void resourcesAct(View v){ startActivity(new Intent(this, Resources_Activity.class)); }

    public void campusAct(View v){ startActivity(new Intent(this, Campus_Life_Activity.class)); }

    public void eventsNav(View view)//Open Browser Window and navigate to Club meetings
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.jccc.edu/student-resources/campus-life/student-activities-organizations/student-events-meetings-calendar.html")));
    }
    public void myJCCCNav(View view)//Open Browser Window and navigate to Club meetings
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://my.jccc.edu/cp/home/displaylogin")));
    }

    public void newsNav(View view)//Open Browser Window and navigate to Campus Ledger
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://blogs.jccc.edu/campusledger/")));
    }

    public void contactNav(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.jccc.edu/az-index.html")));
    }

    public void facebookNav(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.facebook.com/JCCC411")));
    }

    public void twitterNav(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://twitter.com/jccctweet")));
    }

    public void linkedinNav(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.linkedin.com/company/johnson-county-community-college")));
    }

    public void youtubeNav(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/user/JCCCvideo")));
    }


    public void callPolice(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9134692500"));
        startActivity(intent);
    }
}
