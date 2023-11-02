package com.example.v14_bazar;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//Mapas
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;
//


public class mapa_proveedores extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_proveedores);

        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

        MapView mapView = findViewById(R.id.mapView);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        //Coordenadas de Bazar Nancy, Puente Alto, Chile
        double bNancyLatitude = -33.5862752;
        double bNancyLongitude = -70.5895852;

        //Coordenadas de CFT Santo tomas, Santiago, Chile
        double cftSantiagoLatitude = -33.5862524;
        double cftSantiagoLongitude = 70.59731;

        //Crear objetos GeoPoint para los marcadores
        GeoPoint bNancyPoint = new GeoPoint(bNancyLatitude, bNancyLongitude);
        GeoPoint cftSantiagoPoint = new GeoPoint(cftSantiagoLatitude, cftSantiagoLongitude);

        //Crear marcadores con títulos y descripciones
        Marker bNancyMarker = new Marker(mapView);
        bNancyMarker.setPosition(bNancyPoint);
        bNancyMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        bNancyMarker.setTitle("Santiago, Chile");
        bNancyMarker.setSnippet("Capital de Chile");

        Marker cftSantiagoMarker = new Marker(mapView);
        cftSantiagoMarker.setPosition(cftSantiagoPoint);
        cftSantiagoMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        cftSantiagoMarker.setTitle("Valparaíso, Chile");
        cftSantiagoMarker.setSnippet("Puerto principal de Chile");

        //Agregar marcadores al mapa
        mapView.getOverlays().add(bNancyMarker);
        mapView.getOverlays().add(cftSantiagoMarker);

        //Crear y agregar la línea entre Santiago y Valparaíso
        Polyline polyline = new Polyline();
        polyline.addPoint(bNancyPoint);
        polyline.addPoint(cftSantiagoPoint);
        polyline.setColor(0xFF0000FF);  // Color de la línea (azul en formato ARGB)
        polyline.setWidth(5);  // Ancho de la línea en píxeles
        //Agrega la Linea al Mapa
        mapView.getOverlayManager().add(polyline);

        //Calcular la distancia entre Bazar Nancy y Cft Santo tomas
        double distance = CalcularDistancia.CalcularDistancia(bNancyPoint, cftSantiagoPoint);
        TextView distanceTextView = findViewById(R.id.distanceTextView);
        distanceTextView.setText("Distancia entre Bazar Nancy y Cft Santiago centro: " + String.format("%.2f", distance) + " km");

        // Centrar el mapa en Santiago, Chile
        IMapController mapController = mapView.getController();
        mapController.setCenter(bNancyPoint);
        mapController.setZoom(14);  // Puedes ajustar el nivel de zoom según sea necesario

    }

    public void onClickbuttonMapa(View view){
        Toast.makeText(this, "Opción no implementada.. aún", Toast.LENGTH_SHORT).show();
    }
}
