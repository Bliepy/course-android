package efile.com.efiles;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import efile.com.efiles.fragments.EvidenceFragment;
import efile.com.efiles.fragments.ReportsFragment;
import efile.com.efiles.fragments.TransferFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout =  findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new EvidenceFragment(),"Evidence");
        adapter.addFragment(new TransferFragment(), "Transfer");
        adapter.addFragment(new ReportsFragment(), "Reports");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
