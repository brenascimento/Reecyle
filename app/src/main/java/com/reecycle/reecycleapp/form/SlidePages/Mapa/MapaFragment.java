package com.reecycle.reecycleapp.form.SlidePages.Mapa;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.reecycle.reecycleapp.R;
import com.reecycle.reecycleapp.form.SlidePages.InAppActivity;

import java.security.InvalidAlgorithmParameterException;
import java.util.Locale;

public class MapaFragment extends Fragment
                    implements OnMapReadyCallback,
                                GoogleMap.OnPolylineClickListener,
                                GoogleMap.OnPolygonClickListener,
                                GoogleMap.OnMarkerClickListener {

    private GoogleMap mGoogleMap;
    private MapView mMapView;
    private View view;
    private Context context;
    private Application application;
    private LocationRequest mLocationRequest;
    private Activity activity;
    private static final int COLOR_BLACK_ARGB = 0xff000000;
    private static final int POLYLINE_STROKE_WIDTH_PX = 12;
    private Marker marker1;
    private Marker marker2;
    private Marker marker3;
    private Marker marker4;
    private ImageView imgEmpresa;
    private TextView tituloEmpresa;
    private TextView subtituloEmpresa;
    private View bottomSheet;
    private BottomSheetBehavior bottomSheetBehavior;
    private MaterialButton comoChegar;
    private MaterialButton chamar;



    public MapaFragment() {

    }

    public static MapaFragment newInstance(){
        return new MapaFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mapa, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = view.findViewById(R.id.map);
        imgEmpresa = view.findViewById(R.id.imageEmpresa);
        tituloEmpresa = view.findViewById(R.id.Titulo);
        subtituloEmpresa = view.findViewById(R.id.Subtitulo);
        activity = new InAppActivity();
        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
        context = this.getContext();
        bottomSheet = view.findViewById(R.id.bottomsheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setHideable(false);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Locale.setDefault(new Locale("pt-BR"));
        MapsInitializer.initialize(context);

        LatLng etecJorgeStreet = new LatLng(-23.634508, -46.579717);
        LatLng ecoipirangaScs = new LatLng(-23.634385, -46.584368);
        LatLng institutoTrianguloSA = new LatLng(-23.616863, -46.533652);
        LatLng comercioDeAparasSBC = new LatLng(-23.654575, -46.564989);

        /*Polyline polyline = googleMap.addPolyline(new PolylineOptions().clickable(true).add(
                ecoipirangaScs,
                new LatLng(-23.605766, -46.574573),
                new LatLng(-23.613202, -46.577455),
                new LatLng(-23.637478, -46.577874)
        ));
        polyline.setTag("A");*/



        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        MarkerOptions markerETEC = new MarkerOptions().position(etecJorgeStreet);
        MarkerOptions markerSCS = new MarkerOptions().position(ecoipirangaScs);
        MarkerOptions markerSA = new MarkerOptions().position(institutoTrianguloSA);
        MarkerOptions markerSBC = new MarkerOptions().position(comercioDeAparasSBC);
        //MarkerOptions marker2 = new MarkerOptions().position()

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(etecJorgeStreet, 4));
        marker1 = googleMap.addMarker(markerSA);
        marker2 = googleMap.addMarker(markerSCS);
        marker3 = googleMap.addMarker(markerSBC);
        googleMap.addMarker(markerSA);
        googleMap.addMarker(markerSCS);
        googleMap.addMarker(markerSBC);
        googleMap.setOnMarkerClickListener(this);

        CameraPosition positionSA = CameraPosition.builder().target(institutoTrianguloSA).zoom(16).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(institutoTrianguloSA));

        //MarkerOptions marcador = new MarkerOptions().position(ecoipirangaScs).title("ECOIPIRANGA SÃO CAETANO DO SUL").snippet("Colaborador teste");
        //googleMap.addMarker(marcador);

        //CameraPosition EcoPonto = CameraPosition.builder().target(ecoipirangaScs).zoom(16).bearing(0).tilt(45).build();
        //googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(EcoPonto));
    }

    @Override
    public void onPolygonClick(Polygon polygon) {

    }

    @Override
    public void onPolylineClick(Polyline polyline) {

    }


    private void createLocationRequest(){
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker1.equals(marker)){
            bottomSheetBehavior.setHideable(true);
            imgEmpresa.setImageResource(R.drawable.factory);
            tituloEmpresa.setText("Instituto Triângulo");
            subtituloEmpresa.setText("Santo André");
        } else if(marker2.equals(marker)){
            bottomSheetBehavior.setHideable(true);
            imgEmpresa.setImageResource(R.drawable.factory);
            tituloEmpresa.setText("Ecoipiranga Reciclagens");
            subtituloEmpresa.setText("São Caetano do Sul");
        } else if(marker3.equals(marker)){
            bottomSheetBehavior.setHideable(true);
            imgEmpresa.setImageResource(R.drawable.factory);
            tituloEmpresa.setText("Comércio de Aparas");
            subtituloEmpresa.setText("São Bernardo do Campo");
        } else {
            bottomSheetBehavior.setHideable(false);
        }
        return true;
    }
}