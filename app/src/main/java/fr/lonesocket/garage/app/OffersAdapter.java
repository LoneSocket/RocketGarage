package fr.lonesocket.garage.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.lonesocket.garage.library.model.Offer;

public class OffersAdapter extends RecyclerView.Adapter<OfferViewHolder> {
    private List<Offer> mOffers;

    public OffersAdapter(List<Offer> offers) {
        update(offers);
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_row, parent, false);
        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        holder.setItem(mOffers.get(position));
    }

    @Override
    public int getItemCount() {
        return mOffers.size();
    }

    public void update(List<Offer> offers) {
        mOffers = offers;
        notifyDataSetChanged();
    }
}
