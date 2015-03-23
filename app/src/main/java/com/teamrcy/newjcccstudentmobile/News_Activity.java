package com.teamrcy.newjcccstudentmobile;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;


public class News_Activity extends ActionBarActivity
    implements NewsHeadlinesFragment.OnNewsHeadlineSelectedListener {

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.news_articles);

            // Check whether the activity is using the layout version with
            // the fragment_container FrameLayout. If so, we must add the first fragment
            if (findViewById(R.id.fragment_container) != null) {

                // However, if we're being restored from a previous state,
                // then we don't need to do anything and should return
                if (savedInstanceState != null) {
                    return;
                }

                // Create an instance of NewsHeadlinesFragment
                NewsHeadlinesFragment headline = new NewsHeadlinesFragment();

                // If this activity was started with special instructions from an Intent,
                // pass the Intent's extras to the fragment as arguments
                headline.setArguments(getIntent().getExtras());

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                        headline).commit();
            }
        }


    public void onArticleSelected(int position) {
        //The user selects and article
        NewsArticleFragment article = (NewsArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if (article != null) {
            // If article is available, go to two-pane layout...

            // Call a method in the ArticleFragment to update its content
            article.updateArticleView(position);

        } else {
             // If the article is not available, use the one-pane layout and swap fragments

            // Create fragment and give it an argument for the selected article
            NewsArticleFragment newFragment = new NewsArticleFragment();
            Bundle args = new Bundle();
            args.putInt(NewsArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);

            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
}