package com.example.nzse;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.HardwareRenderer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.nzse.databinding.ActivityMapsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

//usability test
//biniding
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    Profil profil = Profil.get();
    FloatingActionButton    UserOption, fabButton, RadiusFrame, fabTest_2, fabTest_3, CurrentPlace,
                            CloseUserLogFAB, CloseRadiusFrame, CloseRegistrationFrame, toFavList;
    RelativeLayout RadiusFrameLayout, FrameUserLog, RegistrationFrame;
    TextInputLayout Destination;
    View FragmentUserLog, Map, FragmentRegistration;
    Boolean isAllFabsVisible = false;
    Boolean Reg = profil.getIsReg();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.nzse.databinding.ActivityMapsBinding binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);





        //  ==================================== OpenAllFABs ===========================================================  //

        fabButton = findViewById(R.id.fab_open);
        RadiusFrame = findViewById(R.id.RadiusFrame);
        fabTest_2 = findViewById(R.id.test_2);
        fabTest_3 = findViewById(R.id.test_3);
        CurrentPlace = findViewById(R.id.CurrentPlace);
        Destination = findViewById(R.id.Destination);

        CloseFabs();

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isAllFabsVisible){
                    RadiusFrame.setVisibility(View.VISIBLE);
                    fabTest_2.setVisibility(View.VISIBLE);
                    fabTest_3.setVisibility(View.VISIBLE);
                    CurrentPlace.setVisibility(View.VISIBLE);

                    isAllFabsVisible = true;
                } else {
                    CloseFabs();
                }
            }
        });

        //  =================================== registerer =========================================================  //
        // log => if(reg (user or techniker) => can see logUser
        // https://developer.android.com/guide/navigation/navigation-getting-started

        Map = findViewById(R.id.map);
        UserOption = findViewById(R.id.UserOption);

        CloseRegistrationFrame = findViewById(R.id.CloseRegistrationFrame);
        FragmentRegistration = findViewById(R.id.FragmentRegistration);
        RegistrationFrame = findViewById(R.id.RegistrationFrame);
        RegistrationFrame.setVisibility(View.GONE);

        CloseUserLogFAB = findViewById(R.id.CloseUserLogFAB);
        FragmentUserLog = findViewById(R.id.FragmentUserLog);
        FrameUserLog = findViewById(R.id.FrameUserLog);
        FrameUserLog.setVisibility(View.GONE);


        UserOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Reg){
                    Registration Fragment = new Registration();
                    setNewFragment(Fragment);
                    RegistrationFrame.setVisibility(View.VISIBLE);
                    toFavList.setVisibility(View.GONE);

                    CloseRegistrationFrame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Reg = profil.getIsReg();
                            RegistrationFrame.setVisibility(View.GONE);
                            Map.setAlpha(1.f);
                            // how to finish this fragment ??

                            OpenMainFABs();
                        }
                    });
                } else {
                    //  =================================== userOption (logged) =========================================================  //
                    UserLog Fragment = new UserLog();
                    setNewFragment(Fragment);
                    FrameUserLog.setVisibility(View.VISIBLE);
                    toFavList.setVisibility(View.VISIBLE);

                    CloseUserLogFAB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            FrameUserLog.setVisibility(View.GONE);
                            Map.setAlpha(1.f);
                            // how to finish this fragment ??

                            OpenMainFABs();
                        }
                    });
                }


                Map.setAlpha(.5f);
                CloseMainFABs();
            }
        });

        toFavList = findViewById(R.id.toFavList);
        toFavList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, FavoriteList.class);
                startActivity(intent);
            }
        });


        //  ========================================== RadiusFrame =====================================================  //



        RadiusFrameLayout = findViewById(R.id.RadiusFrameLayout);
        RadiusFrameLayout.setVisibility(View.GONE);
        CloseRadiusFrame = findViewById(R.id.CloseRadiusFrame);
        RadiusFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadiusFrameLayout.setVisibility(View.VISIBLE);
                Map.setAlpha(.5f);
                CloseMainFABs();
            }
        });
        CloseRadiusFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadiusFrameLayout.setVisibility(View.GONE);
                Map.setAlpha(1.f);

                OpenMainFABs();
            }
        });


        //  ========================================== current place =====================================================  //


        CurrentPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Location currentLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                //fusedLocationClient.getLastLocation()
                //        .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                //            @Override
                //            public void onSuccess(Location location) {
                //                // Got last known location. In some rare situations this can be null.
                //                if (location != null) {
                //                    // Logic to handle location object
                //                }
                //            }
                //       });
            }
        });

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // maybe hear loop for mark in Radius
        LatLng department = new LatLng (49.86625273516996, 8.640257820411557);
        googleMap.addMarker(new MarkerOptions().position(department).title("Marker h_da, fbi"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(department));
    }

    private void closefragment() {
        //UserLog.getFragmentManager().beginTransaction().remove(this).commit();
    }

    public void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FragmentUserLog, fragment);
        ft.addToBackStack(null);
        ft.commit();

        //Fragment yoursFragment=new YoursFragment();
        //FragmentTransaction trans=getFragmentManager().beginTransaction();
        //trans.add(R.id.yours_id, yoursFragment);
        //trans.commit();
    }


    private void CloseFabs(){
        RadiusFrame.setVisibility(View.GONE);
        fabTest_2.setVisibility(View.GONE);
        fabTest_3.setVisibility(View.GONE);
        CurrentPlace.setVisibility(View.GONE);

        isAllFabsVisible = false;
    }

    private void CloseMainFABs(){
        UserOption.setVisibility(View.GONE);
        fabButton.setVisibility(View.GONE);
        Destination.setVisibility(View.GONE);
        CloseFabs();
    }

    private void OpenMainFABs(){
        UserOption.setVisibility(View.VISIBLE);
        fabButton.setVisibility(View.VISIBLE);
        Destination.setVisibility(View.VISIBLE);
    }

    //@Override
    //public void onMapReady(GoogleMap googleMap) {
    //    mMap = googleMap;
    // maybe hear loop for mark in Radius
    //    LatLng department = new LatLng (49.86625273516996, 8.640257820411557);
    //    mMap.addMarker(new MarkerOptions().position(department).title("Marker h_da, fbi"));
    //    mMap.moveCamera(CameraUpdateFactory.newLatLng(department));
    //}
/*
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap map) {
        // TODO: Before enabling the My Location layer, you must request
        // location permission from the user. This sample does not include
        // a request for location permission.
        map.setMyLocationEnabled(true);
        map.setOnMyLocationButtonClickListener((GoogleMap.OnMyLocationButtonClickListener) this);
        map.setOnMyLocationClickListener((GoogleMap.OnMyLocationClickListener) this);
    }
    //@Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG)
                .show();
    }
    //@Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT)
                .show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

*/
}

/*
Как сделать так, чтобы по нажатии на кнопку картинка поползла по оси чуть немного вверх и исчезла?
btn.setOnClickListener(new View.OnClickListener()
{

    @Override
    public void onClick(View v)
    {

        imageView.animate().translationYBy(100).alpha(0).setDuration(1000);

    }

}
 */

