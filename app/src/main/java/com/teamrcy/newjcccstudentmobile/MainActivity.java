package com.teamrcy.newjcccstudentmobile;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView; 
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;



public class MainActivity extends ActionBarActivity implements SearchView.OnQueryTextListener {
    //public final static String EXTRA_MESSAGE = "com.teamrcy.NewJCCCStudentMobileApp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("white")));
        getSupportActionBar().setIcon(R.mipmap.ic_jccc2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {// Inflate the menu; this adds items to the action bar if it is present.
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
        // int id = item.getItemId();

        switch(item.getItemId())
        {
            case R.id.searchButton:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void loadWebView(String title, String url){//function to load webViewLoader
        Intent intent = new Intent(this, WebViewLoader.class); //sets launch intent for webViewLoader
        intent.putExtra("title", title); //inserts title of site into extra of intent
        intent.putExtra("url", url); //inserts url into extra of intent
        startActivity(intent); //starts webViewLoader with intent
    }

    public void athleticsAct(View v)
    {
        startActivity(new Intent(this, AthleticsActivity.class));
    }

    public void wellnessAct(View v)
    {
        startActivity(new Intent(this, WellnessActivity.class));
    }

    public void newsAct(View v)
    {
        loadWebView("News", "http://www.jccc.edu/newsroom/");
    }

    public void discountAct(View v)
    {
        startActivity(new Intent(this, DiscountsActivity.class));
    }

    public void resourcesAct(View v){ startActivity(new Intent(this, resourcesActivity.class)); }

    public void diningAct(View v){ startActivity(new Intent(this, DiningActivity.class)); }

    public void campusAct(View v){ startActivity(new Intent(this, CampusActivity.class)); }

    public void clubsNav(View view)//Load web view: Club meetings
    {
        loadWebView("Clubs", "http://www.jccc.edu/student-resources/campus-life/student-activities-organizations/student-organization-descriptions.html");
    }

    public void eventsNav(View view)//Load web view: Club meetings
    {
        startActivity(new Intent(this, EventsActivity.class));
        //loadWebView("Events", "http://www.jccc.edu/student-resources/campus-life/student-activities-organizations/student-events-meetings-calendar.html");
    }
    public void myJCCCNav(View view)//Open JCCC mobile app
    {
        Intent intent = getPackageManager().getLaunchIntentForPackage("edu.jccc.jcccmobile"); //gets launch intent for JCCC Mobile app
        try { //checks to see if app is installed on device
            startActivity(intent); //opens app if installed
        }
        catch (Exception e) { //exception if app is not installed
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=edu.jccc.jcccmobile&hl=en")));//opens app store to JCCC mobile app page
        }
    }

    public void contactNav(View view)
    {
        loadWebView("Cav Index", "http://www.jccc.edu/az-index.html");
    }

    public void facebookNav(View view)
    {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/14080742201")));
        }
        catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.facebook.com/JCCC411")));
        }
    }

    public void MapAct(View v)
    {

        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.google.com/maps/place/Johnson+County+Community+College/@38.923939,-94.730303,17z/data=!4m2!3m1!1s0x0:0x448b22c3a320464f?hl=en-US")));

    }

    public void twitterNav(View view)
    {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=jccctweet")));
        }
        catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://twitter.com/jccctweet")));
        }
    }

    public void linkedinNav(View view)
    {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/johnson-county-community-college")));
        }
        catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.linkedin.com/company/johnson-county-community-college")));
        }

    }

    public void youtubeNav(View view)
    {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://channel/JCCCvideo")));
        }
        catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/user/JCCCvideo")));
        }
    }


    public void callPolice(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9134692500"));
        startActivity(intent);
    }
}
