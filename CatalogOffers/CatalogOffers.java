package com.example.asus.pantallas_hotelspa;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CatalogOffers extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Offers[] offer = {
            new Offers(R.drawable.spa1, "Caricia Facial", "Costo: $800", "Descuento: $300"),
            new Offers(R.drawable.spa2, "Rejuvenecedor de Ojos","Costo: $350", "Oferta 2x1"),
            new Offers(R.drawable.spa3, "Baños termales","Costo: $650", "Descuento dia de la Madre: $300"),
            new Offers(R.drawable.spa4, "Masaje","Costo: $600", "Descuento amor y amistad: $300")
    };
    private ListView lsvOffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lsvOffer = findViewById(R.id.lsv_offers);
        RestaurantAdapter adapter = new RestaurantAdapter(
                this,offer);
        lsvOffer.setAdapter(adapter);

        lsvOffer.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedOption = ((Offers)adapterView.getItemAtPosition(i)).getName();
        // String selectedOption1 = ((TextView)view.findViewById(R.id.txv_name)).getText().toString();
        Toast.makeText(this, "You selected :" + selectedOption, Toast.LENGTH_SHORT).show();
    }

    public class ViewHolder{
        TextView txvName;
        TextView txvPrice;
        TextView txvOffers;
        ImageView imvPhoto;
    }

    class RestaurantAdapter extends ArrayAdapter<Offers>{
        public RestaurantAdapter(@NonNull Context context, Offers[] data){
            super(context, R.layout.cell_layout, data);
        }
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if (cell==null){
                LayoutInflater inflater =
                        LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.cell_layout,null);
                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txvPrice = cell.findViewById(R.id.txv_location);
                holder.txvOffers = cell.findViewById(R.id.txv_type);
                cell.setTag(holder);
            }else{
                holder = (ViewHolder) cell.getTag();
            }
            holder.imvPhoto.setImageResource(offer[position].getImageId());
            holder.txvName.setText(offer[position].getName());
            holder.txvPrice.setText(offer[position].getLocation());
            holder.txvOffers.setText(offer[position].getType());
            return cell;
        }
    }
}
