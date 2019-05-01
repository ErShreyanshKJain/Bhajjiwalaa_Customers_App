package com.shreyanshjain.bhajjiwalaa_customers_app;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.shreyanshjain.bhajjiwalaa_customers_app.cart.CartCountSetClass;
import com.shreyanshjain.bhajjiwalaa_customers_app.cart.CartListActivity;
import com.shreyanshjain.bhajjiwalaa_customers_app.fragment.ImageListFragment;
import com.shreyanshjain.bhajjiwalaa_customers_app.models.Items;
import com.shreyanshjain.bhajjiwalaa_customers_app.models.Orders;
import com.shreyanshjain.bhajjiwalaa_customers_app.models.Users;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static int notificationCountCart=0;
    static ViewPager viewPager;
    static TabLayout tabLayout;
    TextView headUserName;
//    FirebaseAuth.AuthStateListener mAuthStateListener;
    FirebaseAuth mAuth;
//    ArrayList<Items> itemList;
    DatabaseReference mDatabaseReference;
//    String phone;
//    ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent=getIntent();
//        phone=intent.getStringExtra("Phone");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        headUserName = findViewById(R.id.header_username);

        mAuth=FirebaseAuth.getInstance();
        mDatabaseReference=FirebaseDatabase.getInstance().getReference();

        if(!isNetworkAvailable())
        {
//            CoordinatorLayout coordinatorLayout = findViewById(R.id.main_coordinator_layout);
//            coordinatorLayout.setVisibility(View.GONE);
//            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            FragmentManager fm =getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_drawer_layout,new OfflineFragment());
            ft.commit();
        }

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);

        if(viewPager!=null)
        {
            setupViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);
        }

//        setUpUserDatabase();
    }

//    public void setUpUserDatabase()
//    {
//        String uid=mAuth.getUid();
//        String phone=mAuth.getCurrentUser();
//        String name=phone.charAt(0)+phone.charAt(1)+"xxxxxx"+phone.charAt(8)+phone.charAt(9);
//        String token= FirebaseInstanceId.getInstance().getToken();
//        String add=" ";
//        ArrayList<Items> cart=new ArrayList<>();
//        ArrayList<Orders> orders=new ArrayList<>();
//        Users users=new Users(uid,name,phone,token,add,cart,orders);
//
//        Log.d("Uid",mAuth.getUid());
//        Log.d("Name",mAuth.getCurrentUser().getDisplayName());
//        Log.d("Provider",mAuth.getCurrentUser().getProviderId());
//        Log.d("Phone",mAuth.getCurrentUser().getPhoneNumber());
//
//        mDatabaseReference.child("Users").child(uid).setValue(users);
//        /*
//         * TODO Add users data to firebase
//         */
//
//    }

    private void setupViewPager(ViewPager viewPager) {
        Toast.makeText(getApplicationContext(),"Setup View Pager",Toast.LENGTH_SHORT).show();
        Adapter adapter = new Adapter(getSupportFragmentManager());
        ImageListFragment fragment = new ImageListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", 1);
        fragment.setArguments(bundle);
        adapter.addFragment(fragment, getString(R.string.item_1));
        fragment = new ImageListFragment();
        bundle = new Bundle();
        bundle.putInt("type", 2);
        fragment.setArguments(bundle);
        adapter.addFragment(fragment, getString(R.string.item_2));
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        if (id == R.id.nav_item1) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.nav_item2) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.my_cart) {
            startActivity(new Intent(MainActivity.this,CartListActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Get the notifications MenuItem and
        // its LayerDrawable (layer-list)
        MenuItem item = menu.findItem(R.id.action_cart);
        CartCountSetClass.setAddToCart(MainActivity.this, item,notificationCountCart);
        // force the ActionBar to relayout its MenuItems.
        // onCreateOptionsMenu(Menu) will be called again.
        invalidateOptionsMenu();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.action_search) {
//            startActivity(new Intent(MainActivity.this, SearchActivity.class));
            return true;
        } else if(id==R.id.action_cart) {
            startActivity(new Intent(MainActivity.this, CartListActivity.class));
            return true;
        } else {
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
