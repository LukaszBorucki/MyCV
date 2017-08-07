package co.borucki.mycv.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.mycv.R;
import co.borucki.mycv.repository.PersonalDataRepository;
import co.borucki.mycv.repository.PersonalDataRepositoryImpl;
import co.borucki.mycv.view.fragments.ContactFragment;
import co.borucki.mycv.view.fragments.EducationFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private PersonalDataRepository mRepository = PersonalDataRepositoryImpl.getInstance();
    @BindView(R.id.navigationToolBar)
    Toolbar navigationToolBar;
    @BindView(R.id.navigationView)
    NavigationView navigationMenu;
    @BindView(R.id.mainActivityDrawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.main_activity_name_and_surname)
    TextView nameAndSurname;
    @BindView(R.id.main_activity_photo)
    ImageView myPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        nameAndSurname.setText(mRepository.getName() + " " + mRepository.getSurname());
        navigationMenu.setNavigationItemSelectedListener(this);
        navigationToolBar.setTitle("Curriculum Vitae");
        navigationMenu.setCheckedItem(R.id.navigationMenuContact);
        navigationMenu.getMenu().performIdentifierAction(R.id.navigationMenuContact, 0);
        setSupportActionBar(navigationToolBar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, navigationToolBar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        View header = navigationMenu.getHeaderView(0);
        TextView navigation_view_holder_name_surname_phone = (TextView) header.findViewById(R.id.navigation_view_header_name_surname_phone);
        ImageView navigation_view_holder_image = (ImageView) header.findViewById(R.id.navigation_view_holder_image);
        navigation_view_holder_name_surname_phone.setText(mRepository.getName()
                + " "
                + mRepository.getSurname()
                + " "
                + mRepository.getPhone());
        byte[] decodedByte = Base64.decode(mRepository.getPhoto(), 0);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
        myPhoto.setImageBitmap(bitmap);
        navigation_view_holder_image.setImageBitmap(bitmap);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.infoMenu:
//                infoFragment.newInstance().show(getSupportFragmentManager(), "");
//                break;
//
//
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.info_menu, menu);
        return super.onCreateOptionsMenu(menu);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(Gravity.LEFT);

        uncheckedMenuItem();
        navigationToolBar.setTitle(item.getTitle());
        item.setChecked(true);

        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigationMenuContact:
                item.setIcon(R.drawable.ic_contact_black_24dp);
                fragment = ContactFragment.newInstance();
//                Toast.makeText(this, getString(R.string.contact), Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationMenuExperience:
//                fragment = ExperienceFragment.newInstance();
                break;
            case R.id.navigationMenuEducation:
                fragment = EducationFragment.newInstance();
                break;
            case R.id.navigationMenuSkills:
//                fragment = SkillsFragment.newInstance();
                break;
            case R.id.navigationMenuHobby:
//                fragment = HobbyFragment.newInstance();
                break;
            case R.id.navigationMenuSendMail:
//                fragment = FormFragment.newInstance();
                break;

        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivityContainer, fragment)
                .commit();
        return false;
    }

    private void uncheckedMenuItem() {
        for (int i = 0; i < navigationMenu.getMenu().size(); i++) {
            if (navigationMenu.getMenu().getItem(i).isChecked()) {
                navigationMenu.getMenu().getItem(i).setChecked(false);
            }
        }
    }
}
