package com.example.BusTimeTable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import com.google.android.maps.*;

import java.util.List;


public class ShowMap extends MapActivity {

    MapView mapView;
    MapController mc;
    GeoPoint point;
    String longitude;
    String latitude;
    private Long mRowId;


    class MapOverlay extends com.google.android.maps.Overlay
    {
        @Override
        public boolean draw(Canvas canvas, MapView mapView,
                            boolean shadow, long when)
        {
            super.draw(canvas, mapView, shadow);

          
            Point screenPts = new Point();
            mapView.getProjection().toPixels(point, screenPts);

            Bitmap bmp = BitmapFactory.decodeResource(
                    getResources(), R.drawable.flag_blue);
            canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);
            return true;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);

        mapView = (MapView)findViewById(R.id.mapview);

        mapView.setBuiltInZoomControls(true);
        mc = mapView.getController();

        mRowId = null;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            longitude = extras.getString(DbAdapter.KEY_LONGITUDE);
            latitude = extras.getString(DbAdapter.KEY_LATITUDE);
            mRowId = extras.getLong(DbAdapter.BUS_ROWID);
        }
        double longitud = Double.parseDouble(longitude);
        double latitud = Double.parseDouble(latitude);

        Log.i("latitud",latitud+"");
        Log.i("longitud", longitud + "");

        point = new GeoPoint((int)(latitud * 1e6),
                (int)(longitud * 1e6));

        mc.animateTo(point);
        mc.setZoom(15);
        mapView.invalidate();



        MapOverlay mapOverlay = new MapOverlay();
        List<Overlay> listOfOverlays = mapView.getOverlays();
        listOfOverlays.clear();
        listOfOverlays.add(mapOverlay);

        mapView.invalidate();
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }

}
